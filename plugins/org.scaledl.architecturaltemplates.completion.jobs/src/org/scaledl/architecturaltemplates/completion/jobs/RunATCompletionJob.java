package org.scaledl.architecturaltemplates.completion.jobs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.palladiosimulator.analyzer.workflow.blackboard.PCMResourceSetPartition;
import org.palladiosimulator.monitorrepository.MonitorRepository;
import org.palladiosimulator.monitorrepository.impl.MonitorRepositoryFactoryImpl;
import org.palladiosimulator.monitorrepository.util.MonitorRepositoryResourceImpl;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationFactory;
import org.palladiosimulator.pcm.allocation.util.AllocationResourceImpl;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentFactory;
import org.palladiosimulator.pcm.resourceenvironment.util.ResourceenvironmentResourceImpl;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.impl.PcmmeasuringpointFactoryImpl;
import org.palladiosimulator.pcmmeasuringpoint.util.PcmmeasuringpointResourceImpl;
import org.palladiosimulator.servicelevelobjective.ServiceLevelObjectiveRepository;
import org.palladiosimulator.servicelevelobjective.ServicelevelObjectiveFactory;
import org.palladiosimulator.servicelevelobjective.util.ServicelevelObjectiveResourceImpl;
import org.scaledl.architecturaltemplates.api.ArchitecturalTemplateAPI;
import org.scaledl.architecturaltemplates.completion.config.ATExtensionJobConfiguration;
import org.scaledl.architecturaltemplates.completion.constants.ATPartitionConstants;
import org.scaledl.architecturaltemplates.type.AT;
import org.scaledl.architecturaltemplates.type.CompletionParameter;
import org.scaledl.architecturaltemplates.type.PCMBlackboardCompletionParameter;
import org.scaledl.architecturaltemplates.type.PCMOutputCompletionParameter;
import org.scaledl.architecturaltemplates.type.QVTOCompletion;
import org.scaledl.architecturaltemplates.type.Role;
import org.scaledl.architecturaltemplates.type.util.TypeSwitch;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJobConfiguration;

/**
 * Recursively applies AT completions until no AT completion is left anymore. Therefore, AT
 * completions have to remove stereotype applications that reference these. Results are directly
 * stored within the blackboard.
 * 
 * @author Sebastian Lehrig
 */
public class RunATCompletionJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> {

    /** An AT catalog stores templates in this folder. */
    private static final String TEMPLATES_FOLDER = "templates";

    /** An AT catalog stores completions in this folder. */
    private static final String COMPLETIONS_FOLDER = "completions";

    /** Options for QVT-O job. */
    private static final HashMap<String, Object> QVTO_OPTIONS = new HashMap<String, Object>();

    /** Folder with traces as created by the QVT-O engine. */
    private static final String TRACESFOLDER = "traces";

    public RunATCompletionJob(final ATExtensionJobConfiguration configuration) {
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        super.execute(monitor);

        for (final AT architecturalTemplate : this.getATsFromSystem()) {
            for (final QVTOCompletion completion : getCompletions(architecturalTemplate)) {
                executeCompletion(completion);
            }
        }
    }

    private void executeCompletion(final QVTOCompletion completion) throws UserCanceledException {
        final QVTOTransformationJob job = createQvtoTransformationJob(completion);

        try {
            job.execute(new NullProgressMonitor());
        } catch (final JobFailedException e) {
            if (this.logger.isEnabledFor(Level.ERROR)) {
                this.logger.error("Failed to perform Architectural Template completion: " + e.getMessage());
            }
            if (this.logger.isEnabledFor(Level.INFO)) {
                this.logger.info(
                        "Trying to continue Architectural Template completion even though an internal failure occured");
            }
        }
    }

    private QVTOTransformationJob createQvtoTransformationJob(final QVTOCompletion completion) {
        final QVTOTransformationJob job = new QVTOTransformationJob(createQvtoConfiguration(completion));
        job.setBlackboard(this.getBlackboard());
        return job;
    }

    private QVTOTransformationJobConfiguration createQvtoConfiguration(final QVTOCompletion completion) {
        final QVTOTransformationJobConfiguration qvtoConfig = new QVTOTransformationJobConfiguration();
        qvtoConfig.setInoutModels(getModelLocations(completion));
        qvtoConfig.setTraceFileURI(URI.createURI(TRACESFOLDER));
        qvtoConfig.setScriptFileURI(
                getRootURI(completion).appendSegment(COMPLETIONS_FOLDER).appendSegment(completion.getQvtoFileURI()));
        qvtoConfig.setOptions(QVTO_OPTIONS);
        return qvtoConfig;
    }

    /**
     * Initialize ModelLocation object for QVTo's in- and out-parameters.
     * 
     * @param architecturalTemplate
     * @return
     */
    private ModelLocation[] getModelLocations(final QVTOCompletion completion) {
        final List<ModelLocation> modelLocations = new ArrayList<ModelLocation>(completion.getParameters().size());
        for (final CompletionParameter parameter : completion.getParameters()) {
            modelLocations.add(getModelLocation(parameter));
        }
        return modelLocations.toArray(new ModelLocation[modelLocations.size()]);
    }

    /**
     * Root folder of the eObject.
     * 
     * @param eObject
     *            the eObject where the root folder shall be found for.
     * @return the root folder.
     */
    private URI getRootURI(final EObject eObject) {
        return eObject.eResource().getURI().trimFragment().trimSegments(1);
    }

    private List<QVTOCompletion> getCompletions(final AT architecturalTemplate) {
        final List<QVTOCompletion> completions = new LinkedList<QVTOCompletion>();

        for (final Role role : architecturalTemplate.getRoles()) {
            if (role.getCompletion() != null) {
                if (!(role.getCompletion() instanceof QVTOCompletion)) {
                    throw new RuntimeException("This jobs assumes a QVTOCompletion");
                }
                completions.add((QVTOCompletion) role.getCompletion());
            }
        }

        return Collections.unmodifiableList(completions);
    }

    private ModelLocation getModelLocation(final CompletionParameter parameter) {
        final ResourceSetPartition pcmPartition = this.getBlackboard()
                .getPartition(ATPartitionConstants.Partition.PCM.getPartitionId());

        final URI templateFolderURI = getRootURI(parameter).appendSegment(TEMPLATES_FOLDER);
        final URI systemModelFolderURI = getSystemModelFolderURI();

        return new TypeSwitch<ModelLocation>() {

            /**
             * Load models from template
             */
            @Override
            public ModelLocation casePCMTemplateCompletionParameter(
                    final org.scaledl.architecturaltemplates.type.PCMTemplateCompletionParameter object) {

                final String[] segments = URI.createURI(object.getTemplateFileURI()).segments();
                final URI templateURI = templateFolderURI.appendSegments(segments);
                final String lastSegment = templateURI.lastSegment();

                for (final String fileName : ATPartitionConstants.PCM_FILES) {
                    if (lastSegment.endsWith(fileName)) {
                        final ResourceSetPartition resourceSetPartition = getBlackboard()
                                .getPartition(ATPartitionConstants.Partition.PCM.getPartitionId());
                        resourceSetPartition.loadModel(templateURI);
                        resourceSetPartition.resolveAllProxies();
                        return new ModelLocation(ATPartitionConstants.Partition.PCM.getPartitionId(), templateURI);
                    }
                }

                throw new IllegalArgumentException(
                        "PCM Template Completion Parameter \"" + templateURI + "\" not found");
            };

            @Override
            public ModelLocation caseIsolatedPCMTemplateCompletionParameter(
                    final org.scaledl.architecturaltemplates.type.IsolatedPCMTemplateCompletionParameter object) {
                final String[] segments = URI.createURI(object.getTemplateFileURI()).segments();
                final URI templateURI = templateFolderURI.appendSegments(segments);
                final String lastSegment = templateURI.lastSegment();

                for (final String fileName : ATPartitionConstants.PCM_FILES) {
                    if (lastSegment.endsWith(fileName)) {
                        final ResourceSetPartition resourceSetPartition = getBlackboard()
                                .getPartition(ATPartitionConstants.Partition.ISOLATED_TEMPLATE.getPartitionId());
                        resourceSetPartition.loadModel(templateURI);
                        resourceSetPartition.resolveAllProxies();
                        return new ModelLocation(ATPartitionConstants.Partition.ISOLATED_TEMPLATE.getPartitionId(),
                                templateURI);
                    }
                }

                throw new IllegalArgumentException(
                        "PCM Template Completion Parameter \"" + templateURI + "\" not found");
            };

            /**
             * Find the models in blackboard
             */
            @Override
            public ModelLocation casePCMBlackboardCompletionParameter(final PCMBlackboardCompletionParameter object) {
                final String parameterFileExtension = object.getFileExtension().getLiteral();

                final ResourceSetPartition resourceSetPartition = getBlackboard()
                        .getPartition(ATPartitionConstants.Partition.PCM.getPartitionId());

                for (final Resource r : resourceSetPartition.getResourceSet().getResources()) {
                    final URI modelURI = r.getURI();
                    final String fileExtension = modelURI.fileExtension();

                    if (fileExtension.equals(parameterFileExtension) && !modelURI.toString().startsWith("pathmap://")
                            && !modelURI.toString().contains("PrimitiveTypes.repository")) {
                        return new ModelLocation(ATPartitionConstants.Partition.PCM.getPartitionId(), modelURI);
                    }
                }

                return null;
            };

            /**
             * Create new output model from QVTo transformation
             */
            @Override
            public ModelLocation casePCMOutputCompletionParameter(final PCMOutputCompletionParameter object) {
                final String parameterFileExtension = object.getFileExtension().getLiteral();
                final PCMResourceSetPartition pcmRepositoryPartition = (PCMResourceSetPartition) pcmPartition;
                final ResourceSet resourceSet = new ResourceSetImpl();
                final Resource outResource = resourceSet.createResource(URI.createURI(systemModelFolderURI
                        + "/GeneratedOut" + parameterFileExtension + "." + parameterFileExtension));
                final URI uri = outResource.getURI();

                if (outResource instanceof AllocationResourceImpl) {
                    try {
                        final Allocation allocation = AllocationFactory.eINSTANCE.createAllocation();
                        outResource.getContents().add(allocation);
                    } catch (final IndexOutOfBoundsException e) {
                    }
                } else if (outResource instanceof ResourceenvironmentResourceImpl) {
                    try {
                        final ResourceEnvironment resourceEnvironment = ResourceenvironmentFactory.eINSTANCE
                                .createResourceEnvironment();
                        outResource.getContents().add(resourceEnvironment);
                    } catch (final IndexOutOfBoundsException e) {
                    }
                } else if (outResource instanceof PcmmeasuringpointResourceImpl) {
                    UsageModel usageModel = null;
                    try {
                        usageModel = pcmRepositoryPartition.getUsageModel();
                        final EList<UsageScenario> usageScenarios = usageModel.getUsageScenario_UsageModel();
                        final UsageScenarioMeasuringPoint usageScenarioMeasuringPoint = PcmmeasuringpointFactoryImpl.eINSTANCE
                                .createUsageScenarioMeasuringPoint();
                        usageScenarioMeasuringPoint.setUsageScenario(usageScenarios.get(0));
                        outResource.getContents().add(usageScenarioMeasuringPoint);
                    } catch (final IndexOutOfBoundsException e) {
                    }
                } else if (outResource instanceof ServicelevelObjectiveResourceImpl) {
                    final ServicelevelObjectiveFactory sloFactory = ServicelevelObjectiveFactory.eINSTANCE;
                    final ServiceLevelObjectiveRepository sloRepo = sloFactory.createServiceLevelObjectiveRepository();
                    outResource.getContents().add(sloRepo);
                } else if (outResource instanceof MonitorRepositoryResourceImpl) {
                    final MonitorRepositoryFactoryImpl monitorRepositoryFactory = (MonitorRepositoryFactoryImpl) MonitorRepositoryFactoryImpl
                            .init();
                    final MonitorRepository monitorRepository = monitorRepositoryFactory.createMonitorRepository();
                    outResource.getContents().add(monitorRepository);
                }

                pcmPartition.setContents(uri, outResource.getContents());
                pcmPartition.resolveAllProxies();
                return new ModelLocation(ATPartitionConstants.Partition.PCM.getPartitionId(), uri);
            };

        }.doSwitch(parameter);
    }

    /**
     * Receives the architectural templates attached to a system. Such an attachment is realized via
     * a stereotype with "roleURI" as a tagged value. The tagged value references the concrete AT
     * role the system acts. If no such tagged value can be found, an empty <code>List</code> is
     * returned.
     * 
     * @return the architectural template applied to this system; an empty <code>List</code> if no
     *         such template can be found.
     */
    private Collection<AT> getATsFromSystem() {
        final PCMResourceSetPartition pcmRepositoryPartition = (PCMResourceSetPartition) this.myBlackboard
                .getPartition(ATPartitionConstants.Partition.PCM.getPartitionId());

        org.palladiosimulator.pcm.system.System system = null;
        try {
            system = pcmRepositoryPartition.getSystem();
        } catch (final IndexOutOfBoundsException e) {
        }

        return ArchitecturalTemplateAPI.getATsFromSystem(system);
    }

    private URI getSystemModelFolderURI() {
        final PCMResourceSetPartition pcmRepositoryPartition = (PCMResourceSetPartition) this.myBlackboard
                .getPartition(ATPartitionConstants.Partition.PCM.getPartitionId());

        org.palladiosimulator.pcm.system.System system = null;
        try {
            system = pcmRepositoryPartition.getSystem();
        } catch (final IndexOutOfBoundsException e) {
        }

        return system.eResource().getURI().trimFragment().trimSegments(1);
    }
}
