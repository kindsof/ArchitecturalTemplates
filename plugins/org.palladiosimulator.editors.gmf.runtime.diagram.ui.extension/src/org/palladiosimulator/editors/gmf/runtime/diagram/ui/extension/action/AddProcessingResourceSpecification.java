package org.palladiosimulator.editors.gmf.runtime.diagram.ui.extension.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.editors.dialogs.selection.PalladioSelectEObjectDialog;
import org.palladiosimulator.editors.dialogs.stoex.StochasticExpressionEditDialog;
import org.palladiosimulator.pcm.core.CoreFactory;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;
import org.palladiosimulator.pcm.resourcetype.ProcessingResourceType;
import org.palladiosimulator.pcm.resourcetype.ResourceRepository;
import org.palladiosimulator.pcm.resourcetype.SchedulingPolicy;

import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * @author Edith
 */
public class AddProcessingResourceSpecification implements IExternalJavaAction {

    private static final String SET_PROCESSING_RATE = "Set Processing Rate";
    /**
     * Parameter name for the newly created communication linking resource. This name is used as a
     * key in the parameter key-value map.
     */
    private static final String NEW_PROCESSING_RESOURCE_SPECIFICATION = "newProcessingResourceSpecification";

    public AddProcessingResourceSpecification() {
        super();
    }

    @Override
    public boolean canExecute(final Collection<? extends EObject> selections) {
        return true;
    }

    @Override
    public void execute(final Collection<? extends EObject> selections, final Map<String, Object> parameters) {

        final Object parameter = parameters.get(NEW_PROCESSING_RESOURCE_SPECIFICATION);

        if (parameter == null || !(parameter instanceof ProcessingResourceSpecification)) {
            return;
        }

        final ProcessingResourceSpecification processingResourceSpecification = (ProcessingResourceSpecification) parameter;

        // 1. dialog
        processingResourceSpecification.setSchedulingPolicy(getSchedulingPolicy(processingResourceSpecification));

        // 2. dialog
        processingResourceSpecification.setProcessingRate_ProcessingResourceSpecification(getProcessingRate());

        // 3. dialog
        processingResourceSpecification
                .setActiveResourceType_ActiveResourceSpecification(getResourceType(processingResourceSpecification));

    }

    private ProcessingResourceType getResourceType(
            final ProcessingResourceSpecification processingResourceSpecification) {

        final ArrayList<Object> filterList = new ArrayList<Object>(); // positive filter
        // Set types to show and their super types
        filterList.add(ProcessingResourceType.class);
        filterList.add(ResourceRepository.class);
        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        // set EReference that should be set (in this case: active resource type)
        additionalReferences.add(ResourceenvironmentPackage.eINSTANCE
                .getProcessingResourceSpecification_ActiveResourceType_ActiveResourceSpecification());
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), filterList, additionalReferences,
                processingResourceSpecification.getResourceContainer_ProcessingResourceSpecification().eResource()
                        .getResourceSet());

        dialog.setProvidedService(ProcessingResourceType.class);
        dialog.open();

        return (ProcessingResourceType) dialog.getResult();
    }

    private SchedulingPolicy getSchedulingPolicy(
            final ProcessingResourceSpecification processingResourceSpecification) {
        final ResourceSet set = (processingResourceSpecification.getResourceContainer_ProcessingResourceSpecification())
                .eResource().getResourceSet();
        final ArrayList<Object> filterList = new ArrayList<Object>(); // positive filter
        // Set types to show and their super types
        filterList.add(SchedulingPolicy.class);
        filterList.add(ResourceRepository.class);
        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        // set EReference that should be set (in this case: SchedulingPolicy)
        additionalReferences
                .add(ResourceenvironmentPackage.eINSTANCE.getProcessingResourceSpecification_SchedulingPolicy());
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, set);
        dialog.setProvidedService(SchedulingPolicy.class);
        dialog.open();

        return (SchedulingPolicy) dialog.getResult();
    }

    private PCMRandomVariable getProcessingRate() {
        final PCMRandomVariable pcmRandomVariable = CoreFactory.eINSTANCE.createPCMRandomVariable();
        pcmRandomVariable.setSpecification("");

        final StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), TypeEnum.DOUBLE, pcmRandomVariable);
        dialog.setDisplayTitle(SET_PROCESSING_RATE);
        dialog.open();

        pcmRandomVariable.setSpecification(dialog.getResultText());

        return pcmRandomVariable;
    }

}
