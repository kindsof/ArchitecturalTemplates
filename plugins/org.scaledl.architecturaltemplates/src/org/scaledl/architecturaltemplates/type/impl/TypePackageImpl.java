/**
 */
package org.scaledl.architecturaltemplates.type.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.modelversioning.emfprofile.EMFProfilePackage;
import org.palladiosimulator.pcm.PcmPackage;
import org.palladiosimulator.pcm.core.entity.EntityPackage;
import org.scaledl.architecturaltemplates.instance.InstancePackage;
import org.scaledl.architecturaltemplates.instance.impl.InstancePackageImpl;
import org.scaledl.architecturaltemplates.type.Catalog;
import org.scaledl.architecturaltemplates.type.Completion;
import org.scaledl.architecturaltemplates.type.CompletionParameter;
import org.scaledl.architecturaltemplates.type.Constraint;
import org.scaledl.architecturaltemplates.type.GenericBlackboardCompletionParameter;
import org.scaledl.architecturaltemplates.type.GenericOutputCompletionParameter;
import org.scaledl.architecturaltemplates.type.GenericTemplateCompletionParameter;
import org.scaledl.architecturaltemplates.type.IsolatedPCMTemplateCompletionParameter;
import org.scaledl.architecturaltemplates.type.OCLConstraint;
import org.scaledl.architecturaltemplates.type.PCMBlackboardCompletionParameter;
import org.scaledl.architecturaltemplates.type.PCMFileExtensions;
import org.scaledl.architecturaltemplates.type.PCMOutputCompletionParameter;
import org.scaledl.architecturaltemplates.type.PCMTemplateCompletionParameter;
import org.scaledl.architecturaltemplates.type.Parameter;
import org.scaledl.architecturaltemplates.type.QVTOCompletion;
import org.scaledl.architecturaltemplates.type.ReconfigurationFolder;
import org.scaledl.architecturaltemplates.type.Role;
import org.scaledl.architecturaltemplates.type.TemplateProvidingEntity;
import org.scaledl.architecturaltemplates.type.TypeFactory;
import org.scaledl.architecturaltemplates.type.TypePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class TypePackageImpl extends EPackageImpl implements TypePackage {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass atEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass constraintEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass parameterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass catalogEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass roleEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass oclConstraintEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass qvtoCompletionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass completionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass completionParameterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass genericTemplateCompletionParameterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass genericBlackboardCompletionParameterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmBlackboardCompletionParameterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmTemplateCompletionParameterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass templateProvidingEntityEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmOutputCompletionParameterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass genericOutputCompletionParameterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass reconfigurationFolderEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass isolatedPCMTemplateCompletionParameterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum pcmFileExtensionsEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
     * value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init
     * init()}, which also performs initialization of the package, or returns the registered
     * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.scaledl.architecturaltemplates.type.TypePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private TypePackageImpl() {
        super(eNS_URI, TypeFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
     * upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link TypePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to
     * obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static TypePackage init() {
        if (isInited) {
            return (TypePackage) EPackage.Registry.INSTANCE.getEPackage(TypePackage.eNS_URI);
        }

        // Obtain or create and register package
        final TypePackageImpl theTypePackage = (TypePackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof TypePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new TypePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        EMFProfilePackage.eINSTANCE.eClass();
        TypesPackage.eINSTANCE.eClass();
        UtilitiesPackage.eINSTANCE.eClass();
        ExpressionsPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        final InstancePackageImpl theInstancePackage = (InstancePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(InstancePackage.eNS_URI) instanceof InstancePackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI) : InstancePackage.eINSTANCE);

        // Create package meta-data objects
        theTypePackage.createPackageContents();
        theInstancePackage.createPackageContents();

        // Initialize created meta-data
        theTypePackage.initializePackageContents();
        theInstancePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theTypePackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(TypePackage.eNS_URI, theTypePackage);
        return theTypePackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAT() {
        return this.atEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAT_Catalog() {
        return (EReference) this.atEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAT_Roles() {
        return (EReference) this.atEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAT_Constraints() {
        return (EReference) this.atEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAT_ReconfigurationRuleFolder() {
        return (EReference) this.atEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getConstraint() {
        return this.constraintEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getConstraint_AT() {
        return (EReference) this.constraintEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getConstraint_Roles() {
        return (EReference) this.constraintEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getParameter() {
        return this.parameterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getParameter_Role() {
        return (EReference) this.parameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getParameter_DataType() {
        return (EReference) this.parameterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCatalog() {
        return this.catalogEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCatalog_ATs() {
        return (EReference) this.catalogEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRole() {
        return this.roleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRole_Parameters() {
        return (EReference) this.roleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRole_AT() {
        return (EReference) this.roleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRole_Constraints() {
        return (EReference) this.roleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRole_Stereotype() {
        return (EReference) this.roleEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRole_Completion() {
        return (EReference) this.roleEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getOCLConstraint() {
        return this.oclConstraintEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getOCLConstraint_Constraint() {
        return (EAttribute) this.oclConstraintEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getQVTOCompletion() {
        return this.qvtoCompletionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getQVTOCompletion_QvtoFileURI() {
        return (EAttribute) this.qvtoCompletionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCompletion() {
        return this.completionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCompletion_Parameters() {
        return (EReference) this.completionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCompletion_Role() {
        return (EReference) this.completionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCompletionParameter() {
        return this.completionParameterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCompletionParameter_Completion() {
        return (EReference) this.completionParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getGenericTemplateCompletionParameter() {
        return this.genericTemplateCompletionParameterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getGenericBlackboardCompletionParameter() {
        return this.genericBlackboardCompletionParameterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getGenericBlackboardCompletionParameter_FileExtension() {
        return (EAttribute) this.genericBlackboardCompletionParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMBlackboardCompletionParameter() {
        return this.pcmBlackboardCompletionParameterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getPCMBlackboardCompletionParameter_FileExtension() {
        return (EAttribute) this.pcmBlackboardCompletionParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMTemplateCompletionParameter() {
        return this.pcmTemplateCompletionParameterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getTemplateProvidingEntity() {
        return this.templateProvidingEntityEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTemplateProvidingEntity_TemplateFileURI() {
        return (EAttribute) this.templateProvidingEntityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMOutputCompletionParameter() {
        return this.pcmOutputCompletionParameterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getPCMOutputCompletionParameter_FileExtension() {
        return (EAttribute) this.pcmOutputCompletionParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getGenericOutputCompletionParameter() {
        return this.genericOutputCompletionParameterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getGenericOutputCompletionParameter_FileExtension() {
        return (EAttribute) this.genericOutputCompletionParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getReconfigurationFolder() {
        return this.reconfigurationFolderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getReconfigurationFolder_FolderURI() {
        return (EAttribute) this.reconfigurationFolderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getIsolatedPCMTemplateCompletionParameter() {
        return this.isolatedPCMTemplateCompletionParameterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getPCMFileExtensions() {
        return this.pcmFileExtensionsEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public TypeFactory getTypeFactory() {
        return (TypeFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on
     * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.atEClass = this.createEClass(AT);
        this.createEReference(this.atEClass, AT__CATALOG);
        this.createEReference(this.atEClass, AT__ROLES);
        this.createEReference(this.atEClass, AT__CONSTRAINTS);
        this.createEReference(this.atEClass, AT__RECONFIGURATION_RULE_FOLDER);

        this.constraintEClass = this.createEClass(CONSTRAINT);
        this.createEReference(this.constraintEClass, CONSTRAINT__AT);
        this.createEReference(this.constraintEClass, CONSTRAINT__ROLES);

        this.parameterEClass = this.createEClass(PARAMETER);
        this.createEReference(this.parameterEClass, PARAMETER__ROLE);
        this.createEReference(this.parameterEClass, PARAMETER__DATA_TYPE);

        this.catalogEClass = this.createEClass(CATALOG);
        this.createEReference(this.catalogEClass, CATALOG__ATS);

        this.roleEClass = this.createEClass(ROLE);
        this.createEReference(this.roleEClass, ROLE__PARAMETERS);
        this.createEReference(this.roleEClass, ROLE__AT);
        this.createEReference(this.roleEClass, ROLE__CONSTRAINTS);
        this.createEReference(this.roleEClass, ROLE__STEREOTYPE);
        this.createEReference(this.roleEClass, ROLE__COMPLETION);

        this.oclConstraintEClass = this.createEClass(OCL_CONSTRAINT);
        this.createEAttribute(this.oclConstraintEClass, OCL_CONSTRAINT__CONSTRAINT);

        this.qvtoCompletionEClass = this.createEClass(QVTO_COMPLETION);
        this.createEAttribute(this.qvtoCompletionEClass, QVTO_COMPLETION__QVTO_FILE_URI);

        this.completionEClass = this.createEClass(COMPLETION);
        this.createEReference(this.completionEClass, COMPLETION__PARAMETERS);
        this.createEReference(this.completionEClass, COMPLETION__ROLE);

        this.completionParameterEClass = this.createEClass(COMPLETION_PARAMETER);
        this.createEReference(this.completionParameterEClass, COMPLETION_PARAMETER__COMPLETION);

        this.genericTemplateCompletionParameterEClass = this.createEClass(GENERIC_TEMPLATE_COMPLETION_PARAMETER);

        this.genericBlackboardCompletionParameterEClass = this.createEClass(GENERIC_BLACKBOARD_COMPLETION_PARAMETER);
        this.createEAttribute(this.genericBlackboardCompletionParameterEClass,
                GENERIC_BLACKBOARD_COMPLETION_PARAMETER__FILE_EXTENSION);

        this.pcmBlackboardCompletionParameterEClass = this.createEClass(PCM_BLACKBOARD_COMPLETION_PARAMETER);
        this.createEAttribute(this.pcmBlackboardCompletionParameterEClass,
                PCM_BLACKBOARD_COMPLETION_PARAMETER__FILE_EXTENSION);

        this.pcmTemplateCompletionParameterEClass = this.createEClass(PCM_TEMPLATE_COMPLETION_PARAMETER);

        this.templateProvidingEntityEClass = this.createEClass(TEMPLATE_PROVIDING_ENTITY);
        this.createEAttribute(this.templateProvidingEntityEClass, TEMPLATE_PROVIDING_ENTITY__TEMPLATE_FILE_URI);

        this.pcmOutputCompletionParameterEClass = this.createEClass(PCM_OUTPUT_COMPLETION_PARAMETER);
        this.createEAttribute(this.pcmOutputCompletionParameterEClass, PCM_OUTPUT_COMPLETION_PARAMETER__FILE_EXTENSION);

        this.genericOutputCompletionParameterEClass = this.createEClass(GENERIC_OUTPUT_COMPLETION_PARAMETER);
        this.createEAttribute(this.genericOutputCompletionParameterEClass,
                GENERIC_OUTPUT_COMPLETION_PARAMETER__FILE_EXTENSION);

        this.reconfigurationFolderEClass = this.createEClass(RECONFIGURATION_FOLDER);
        this.createEAttribute(this.reconfigurationFolderEClass, RECONFIGURATION_FOLDER__FOLDER_URI);

        this.isolatedPCMTemplateCompletionParameterEClass = this
                .createEClass(ISOLATED_PCM_TEMPLATE_COMPLETION_PARAMETER);

        // Create enums
        this.pcmFileExtensionsEEnum = this.createEEnum(PCM_FILE_EXTENSIONS);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have
     * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        final EntityPackage theEntityPackage = (EntityPackage) EPackage.Registry.INSTANCE
                .getEPackage(EntityPackage.eNS_URI);
        final EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
                .getEPackage(EcorePackage.eNS_URI);
        final EMFProfilePackage theEMFProfilePackage = (EMFProfilePackage) EPackage.Registry.INSTANCE
                .getEPackage(EMFProfilePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.atEClass.getESuperTypes().add(theEntityPackage.getEntity());
        this.constraintEClass.getESuperTypes().add(theEntityPackage.getEntity());
        this.parameterEClass.getESuperTypes().add(theEntityPackage.getEntity());
        this.catalogEClass.getESuperTypes().add(theEntityPackage.getEntity());
        this.roleEClass.getESuperTypes().add(theEntityPackage.getEntity());
        this.oclConstraintEClass.getESuperTypes().add(this.getConstraint());
        this.qvtoCompletionEClass.getESuperTypes().add(this.getCompletion());
        this.genericTemplateCompletionParameterEClass.getESuperTypes()
                .add(this.getGenericBlackboardCompletionParameter());
        this.genericTemplateCompletionParameterEClass.getESuperTypes().add(this.getTemplateProvidingEntity());
        this.genericBlackboardCompletionParameterEClass.getESuperTypes().add(this.getCompletionParameter());
        this.pcmBlackboardCompletionParameterEClass.getESuperTypes().add(this.getCompletionParameter());
        this.pcmTemplateCompletionParameterEClass.getESuperTypes().add(this.getPCMBlackboardCompletionParameter());
        this.pcmTemplateCompletionParameterEClass.getESuperTypes().add(this.getTemplateProvidingEntity());
        this.pcmOutputCompletionParameterEClass.getESuperTypes().add(this.getCompletionParameter());
        this.genericOutputCompletionParameterEClass.getESuperTypes().add(this.getCompletionParameter());
        this.isolatedPCMTemplateCompletionParameterEClass.getESuperTypes()
                .add(this.getPCMBlackboardCompletionParameter());
        this.isolatedPCMTemplateCompletionParameterEClass.getESuperTypes().add(this.getTemplateProvidingEntity());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.atEClass, org.scaledl.architecturaltemplates.type.AT.class, "AT", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getAT_Catalog(), this.getCatalog(), this.getCatalog_ATs(), "catalog", null, 1, 1,
                org.scaledl.architecturaltemplates.type.AT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getAT_Roles(), this.getRole(), this.getRole_AT(), "roles", null, 0, -1,
                org.scaledl.architecturaltemplates.type.AT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getAT_Constraints(), this.getConstraint(), this.getConstraint_AT(), "constraints",
                null, 0, -1, org.scaledl.architecturaltemplates.type.AT.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getAT_ReconfigurationRuleFolder(), this.getReconfigurationFolder(), null,
                "reconfigurationRuleFolder", null, 0, 1, org.scaledl.architecturaltemplates.type.AT.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.constraintEClass, Constraint.class, "Constraint", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getConstraint_AT(), this.getAT(), this.getAT_Constraints(), "AT", null, 1, 1,
                Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getConstraint_Roles(), this.getRole(), this.getRole_Constraints(), "roles", null, 0,
                -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getParameter_Role(), this.getRole(), this.getRole_Parameters(), "role", null, 1, 1,
                Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getParameter_DataType(), theEcorePackage.getEDataType(), null, "dataType", null, 1, 1,
                Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.catalogEClass, Catalog.class, "Catalog", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getCatalog_ATs(), this.getAT(), this.getAT_Catalog(), "ATs", null, 0, -1,
                Catalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getRole_Parameters(), this.getParameter(), this.getParameter_Role(), "parameters",
                null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getRole_AT(), this.getAT(), this.getAT_Roles(), "AT", null, 1, 1, Role.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getRole_Constraints(), this.getConstraint(), this.getConstraint_Roles(), "constraints",
                null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getRole_Stereotype(), theEMFProfilePackage.getStereotype(), null, "stereotype", null,
                1, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getRole_Completion(), this.getCompletion(), this.getCompletion_Role(), "completion",
                null, 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.oclConstraintEClass, OCLConstraint.class, "OCLConstraint", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getOCLConstraint_Constraint(), theEcorePackage.getEString(), "constraint", null, 1, 1,
                OCLConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.qvtoCompletionEClass, QVTOCompletion.class, "QVTOCompletion", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getQVTOCompletion_QvtoFileURI(), theEcorePackage.getEString(), "qvtoFileURI", null, 1,
                1, QVTOCompletion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.completionEClass, Completion.class, "Completion", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getCompletion_Parameters(), this.getCompletionParameter(),
                this.getCompletionParameter_Completion(), "parameters", null, 1, -1, Completion.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        this.initEReference(this.getCompletion_Role(), this.getRole(), this.getRole_Completion(), "role", null, 0, 1,
                Completion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.completionParameterEClass, CompletionParameter.class, "CompletionParameter", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getCompletionParameter_Completion(), this.getCompletion(),
                this.getCompletion_Parameters(), "completion", null, 1, 1, CompletionParameter.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);

        this.initEClass(this.genericTemplateCompletionParameterEClass, GenericTemplateCompletionParameter.class,
                "GenericTemplateCompletionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.genericBlackboardCompletionParameterEClass, GenericBlackboardCompletionParameter.class,
                "GenericBlackboardCompletionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getGenericBlackboardCompletionParameter_FileExtension(), theEcorePackage.getEString(),
                "fileExtension", null, 1, 1, GenericBlackboardCompletionParameter.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.pcmBlackboardCompletionParameterEClass, PCMBlackboardCompletionParameter.class,
                "PCMBlackboardCompletionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getPCMBlackboardCompletionParameter_FileExtension(), this.getPCMFileExtensions(),
                "fileExtension", null, 1, 1, PCMBlackboardCompletionParameter.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.pcmTemplateCompletionParameterEClass, PCMTemplateCompletionParameter.class,
                "PCMTemplateCompletionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.templateProvidingEntityEClass, TemplateProvidingEntity.class, "TemplateProvidingEntity",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getTemplateProvidingEntity_TemplateFileURI(), theEcorePackage.getEString(),
                "templateFileURI", null, 1, 1, TemplateProvidingEntity.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.pcmOutputCompletionParameterEClass, PCMOutputCompletionParameter.class,
                "PCMOutputCompletionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getPCMOutputCompletionParameter_FileExtension(), this.getPCMFileExtensions(),
                "fileExtension", null, 1, 1, PCMOutputCompletionParameter.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.genericOutputCompletionParameterEClass, GenericOutputCompletionParameter.class,
                "GenericOutputCompletionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getGenericOutputCompletionParameter_FileExtension(), theEcorePackage.getEString(),
                "fileExtension", null, 1, 1, GenericOutputCompletionParameter.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.reconfigurationFolderEClass, ReconfigurationFolder.class, "ReconfigurationFolder",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getReconfigurationFolder_FolderURI(), theEcorePackage.getEString(), "folderURI", null,
                1, 1, ReconfigurationFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.isolatedPCMTemplateCompletionParameterEClass, IsolatedPCMTemplateCompletionParameter.class,
                "IsolatedPCMTemplateCompletionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Initialize enums and add enum literals
        this.initEEnum(this.pcmFileExtensionsEEnum, PCMFileExtensions.class, "PCMFileExtensions");
        this.addEEnumLiteral(this.pcmFileExtensionsEEnum, PCMFileExtensions.SYSTEM);
        this.addEEnumLiteral(this.pcmFileExtensionsEEnum, PCMFileExtensions.ALLOCATION);
        this.addEEnumLiteral(this.pcmFileExtensionsEEnum, PCMFileExtensions.RESOURCEENVIRONMENT);
        this.addEEnumLiteral(this.pcmFileExtensionsEEnum, PCMFileExtensions.REPOSITORY);
        this.addEEnumLiteral(this.pcmFileExtensionsEEnum, PCMFileExtensions.USAGEMODEL);
        this.addEEnumLiteral(this.pcmFileExtensionsEEnum, PCMFileExtensions.RESOURCETYPE);
        this.addEEnumLiteral(this.pcmFileExtensionsEEnum, PCMFileExtensions.MONITORREPOSITORY);
        this.addEEnumLiteral(this.pcmFileExtensionsEEnum, PCMFileExtensions.PCMMEASURINGPOINT);
        this.addEEnumLiteral(this.pcmFileExtensionsEEnum, PCMFileExtensions.SERVICELEVELOBJECTIVE);

        // Create resource
        this.createResource(eNS_URI);
    }

} // TypePackageImpl
