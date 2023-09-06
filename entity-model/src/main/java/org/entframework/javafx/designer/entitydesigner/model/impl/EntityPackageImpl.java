/**
 */
package org.entframework.javafx.designer.entitydesigner.model.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.entframework.javafx.designer.entitydesigner.model.EColumn;
import org.entframework.javafx.designer.entitydesigner.model.EEntityObject;
import org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject;
import org.entframework.javafx.designer.entitydesigner.model.EEnumObject;
import org.entframework.javafx.designer.entitydesigner.model.EFieldObject;
import org.entframework.javafx.designer.entitydesigner.model.ELanguage;
import org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding;
import org.entframework.javafx.designer.entitydesigner.model.ELanguageSettings;
import org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification;
import org.entframework.javafx.designer.entitydesigner.model.EModelObject;
import org.entframework.javafx.designer.entitydesigner.model.EModuleObject;
import org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject;
import org.entframework.javafx.designer.entitydesigner.model.ERelationType;
import org.entframework.javafx.designer.entitydesigner.model.ERelationship;
import org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes;
import org.entframework.javafx.designer.entitydesigner.model.ESupportedLanguages;
import org.entframework.javafx.designer.entitydesigner.model.ETable;
import org.entframework.javafx.designer.entitydesigner.model.EntityFactory;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EntityPackageImpl extends EPackageImpl implements EntityPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eEntityObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eFieldObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePersistenceObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eModelObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eModuleObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eEnumObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eEnumLiteralObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePropertyMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSupportedLanguagesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLanguageSettingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLanguageSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSupportedJdbcTypesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLanguageMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLanguageBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eLanguageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eRelationTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EntityPackageImpl() {
		super(eNS_URI, EntityFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link EntityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EntityPackage init() {
		if (isInited) return (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredEntityPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EntityPackageImpl theEntityPackage = registeredEntityPackage instanceof EntityPackageImpl ? (EntityPackageImpl)registeredEntityPackage : new EntityPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theEntityPackage.createPackageContents();

		// Initialize created meta-data
		theEntityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEntityPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EntityPackage.eNS_URI, theEntityPackage);
		return theEntityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEEntityObject() {
		return eEntityObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEEntityObject_Id() {
		return (EAttribute)eEntityObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEEntityObject_Name() {
		return (EAttribute)eEntityObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEEntityObject_Description() {
		return (EAttribute)eEntityObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEEntityObject_Comment() {
		return (EAttribute)eEntityObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEEntityObject_PrimaryKey() {
		return (EReference)eEntityObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEEntityObject_Table() {
		return (EReference)eEntityObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEEntityObject_Fields() {
		return (EReference)eEntityObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEEntityObject_Properties() {
		return (EReference)eEntityObjectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEFieldObject() {
		return eFieldObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEFieldObject_Id() {
		return (EAttribute)eFieldObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEFieldObject_Name() {
		return (EAttribute)eFieldObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEFieldObject_Description() {
		return (EAttribute)eFieldObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEFieldObject_Comment() {
		return (EAttribute)eFieldObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEFieldObject_Properties() {
		return (EReference)eFieldObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEFieldObject_Column() {
		return (EReference)eFieldObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEFieldObject_Version() {
		return (EAttribute)eFieldObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEFieldObject_Languages() {
		return (EReference)eFieldObjectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEPersistenceObject() {
		return ePersistenceObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEPersistenceObject_Modules() {
		return (EReference)ePersistenceObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEPersistenceObject_Properties() {
		return (EReference)ePersistenceObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEPersistenceObject_SupportedLanguages() {
		return (EReference)ePersistenceObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEModelObject() {
		return eModelObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEModelObject__GetName() {
		return eModelObjectEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEModelObject__SetName__String() {
		return eModelObjectEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEModuleObject() {
		return eModuleObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEModuleObject_Id() {
		return (EAttribute)eModuleObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEModuleObject_Name() {
		return (EAttribute)eModuleObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEModuleObject_Namespace() {
		return (EAttribute)eModuleObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEModuleObject_Description() {
		return (EAttribute)eModuleObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEModuleObject_Entities() {
		return (EReference)eModuleObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEModuleObject_Properties() {
		return (EReference)eModuleObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEEnumObject() {
		return eEnumObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEEnumObject_Name() {
		return (EAttribute)eEnumObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEEnumObject_Description() {
		return (EAttribute)eEnumObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEEnumObject_Constants() {
		return (EReference)eEnumObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEEnumObject_Properties() {
		return (EReference)eEnumObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEEnumLiteralObject() {
		return eEnumLiteralObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEEnumLiteralObject_Literal() {
		return (EAttribute)eEnumLiteralObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEEnumLiteralObject_Name() {
		return (EAttribute)eEnumLiteralObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEEnumLiteralObject_Value() {
		return (EAttribute)eEnumLiteralObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEEnumLiteralObject_Properties() {
		return (EReference)eEnumLiteralObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEPropertyMapEntry() {
		return ePropertyMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEPropertyMapEntry_Key() {
		return (EAttribute)ePropertyMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEPropertyMapEntry_Value() {
		return (EAttribute)ePropertyMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getERelationship() {
		return eRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getERelationship_Id() {
		return (EAttribute)eRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getERelationship_Name() {
		return (EAttribute)eRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getERelationship_Description() {
		return (EAttribute)eRelationshipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getERelationship_Comment() {
		return (EAttribute)eRelationshipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getERelationship_TargetEntity() {
		return (EReference)eRelationshipEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getERelationship_TargetField() {
		return (EReference)eRelationshipEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEColumn() {
		return eColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEColumn_Id() {
		return (EAttribute)eColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEColumn_Name() {
		return (EAttribute)eColumnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEColumn_Unique() {
		return (EAttribute)eColumnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEColumn_Nullable() {
		return (EAttribute)eColumnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEColumn_Length() {
		return (EAttribute)eColumnEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEColumn_Precision() {
		return (EAttribute)eColumnEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEColumn_Scale() {
		return (EAttribute)eColumnEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEColumn_JdbcType() {
		return (EAttribute)eColumnEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getETable() {
		return eTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getETable_Id() {
		return (EAttribute)eTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getETable_Name() {
		return (EAttribute)eTableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getESupportedLanguages() {
		return eSupportedLanguagesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getESupportedLanguages_Language() {
		return (EAttribute)eSupportedLanguagesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getELanguageSettings() {
		return eLanguageSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getELanguageSettings_Bindings() {
		return (EReference)eLanguageSettingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getELanguageSpecification() {
		return eLanguageSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getELanguageSpecification_ShortName() {
		return (EAttribute)eLanguageSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getELanguageSpecification_Primitive() {
		return (EAttribute)eLanguageSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getELanguageSpecification_QualifiedName() {
		return (EAttribute)eLanguageSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getELanguageSpecification_Language() {
		return (EAttribute)eLanguageSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getESupportedJdbcTypes() {
		return eSupportedJdbcTypesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getESupportedJdbcTypes_JdbcType() {
		return (EAttribute)eSupportedJdbcTypesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getELanguageMapEntry() {
		return eLanguageMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getELanguageMapEntry_Key() {
		return (EAttribute)eLanguageMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getELanguageMapEntry_Value() {
		return (EReference)eLanguageMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getELanguageBinding() {
		return eLanguageBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getELanguageBinding_LanguageSpecification() {
		return (EReference)eLanguageBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getELanguageBinding_JdbcTypes() {
		return (EReference)eLanguageBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getELanguage() {
		return eLanguageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getERelationType() {
		return eRelationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntityFactory getEntityFactory() {
		return (EntityFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		eEntityObjectEClass = createEClass(EENTITY_OBJECT);
		createEAttribute(eEntityObjectEClass, EENTITY_OBJECT__ID);
		createEAttribute(eEntityObjectEClass, EENTITY_OBJECT__NAME);
		createEAttribute(eEntityObjectEClass, EENTITY_OBJECT__DESCRIPTION);
		createEAttribute(eEntityObjectEClass, EENTITY_OBJECT__COMMENT);
		createEReference(eEntityObjectEClass, EENTITY_OBJECT__PRIMARY_KEY);
		createEReference(eEntityObjectEClass, EENTITY_OBJECT__TABLE);
		createEReference(eEntityObjectEClass, EENTITY_OBJECT__FIELDS);
		createEReference(eEntityObjectEClass, EENTITY_OBJECT__PROPERTIES);

		eFieldObjectEClass = createEClass(EFIELD_OBJECT);
		createEAttribute(eFieldObjectEClass, EFIELD_OBJECT__ID);
		createEAttribute(eFieldObjectEClass, EFIELD_OBJECT__NAME);
		createEAttribute(eFieldObjectEClass, EFIELD_OBJECT__DESCRIPTION);
		createEAttribute(eFieldObjectEClass, EFIELD_OBJECT__COMMENT);
		createEReference(eFieldObjectEClass, EFIELD_OBJECT__PROPERTIES);
		createEReference(eFieldObjectEClass, EFIELD_OBJECT__COLUMN);
		createEAttribute(eFieldObjectEClass, EFIELD_OBJECT__VERSION);
		createEReference(eFieldObjectEClass, EFIELD_OBJECT__LANGUAGES);

		ePersistenceObjectEClass = createEClass(EPERSISTENCE_OBJECT);
		createEReference(ePersistenceObjectEClass, EPERSISTENCE_OBJECT__MODULES);
		createEReference(ePersistenceObjectEClass, EPERSISTENCE_OBJECT__PROPERTIES);
		createEReference(ePersistenceObjectEClass, EPERSISTENCE_OBJECT__SUPPORTED_LANGUAGES);

		eModelObjectEClass = createEClass(EMODEL_OBJECT);
		createEOperation(eModelObjectEClass, EMODEL_OBJECT___GET_NAME);
		createEOperation(eModelObjectEClass, EMODEL_OBJECT___SET_NAME__STRING);

		eModuleObjectEClass = createEClass(EMODULE_OBJECT);
		createEAttribute(eModuleObjectEClass, EMODULE_OBJECT__ID);
		createEAttribute(eModuleObjectEClass, EMODULE_OBJECT__NAME);
		createEAttribute(eModuleObjectEClass, EMODULE_OBJECT__NAMESPACE);
		createEAttribute(eModuleObjectEClass, EMODULE_OBJECT__DESCRIPTION);
		createEReference(eModuleObjectEClass, EMODULE_OBJECT__ENTITIES);
		createEReference(eModuleObjectEClass, EMODULE_OBJECT__PROPERTIES);

		eEnumObjectEClass = createEClass(EENUM_OBJECT);
		createEAttribute(eEnumObjectEClass, EENUM_OBJECT__NAME);
		createEAttribute(eEnumObjectEClass, EENUM_OBJECT__DESCRIPTION);
		createEReference(eEnumObjectEClass, EENUM_OBJECT__CONSTANTS);
		createEReference(eEnumObjectEClass, EENUM_OBJECT__PROPERTIES);

		eEnumLiteralObjectEClass = createEClass(EENUM_LITERAL_OBJECT);
		createEAttribute(eEnumLiteralObjectEClass, EENUM_LITERAL_OBJECT__LITERAL);
		createEAttribute(eEnumLiteralObjectEClass, EENUM_LITERAL_OBJECT__NAME);
		createEAttribute(eEnumLiteralObjectEClass, EENUM_LITERAL_OBJECT__VALUE);
		createEReference(eEnumLiteralObjectEClass, EENUM_LITERAL_OBJECT__PROPERTIES);

		ePropertyMapEntryEClass = createEClass(EPROPERTY_MAP_ENTRY);
		createEAttribute(ePropertyMapEntryEClass, EPROPERTY_MAP_ENTRY__KEY);
		createEAttribute(ePropertyMapEntryEClass, EPROPERTY_MAP_ENTRY__VALUE);

		eRelationshipEClass = createEClass(ERELATIONSHIP);
		createEAttribute(eRelationshipEClass, ERELATIONSHIP__ID);
		createEAttribute(eRelationshipEClass, ERELATIONSHIP__NAME);
		createEAttribute(eRelationshipEClass, ERELATIONSHIP__DESCRIPTION);
		createEAttribute(eRelationshipEClass, ERELATIONSHIP__COMMENT);
		createEReference(eRelationshipEClass, ERELATIONSHIP__TARGET_ENTITY);
		createEReference(eRelationshipEClass, ERELATIONSHIP__TARGET_FIELD);

		eColumnEClass = createEClass(ECOLUMN);
		createEAttribute(eColumnEClass, ECOLUMN__ID);
		createEAttribute(eColumnEClass, ECOLUMN__NAME);
		createEAttribute(eColumnEClass, ECOLUMN__UNIQUE);
		createEAttribute(eColumnEClass, ECOLUMN__NULLABLE);
		createEAttribute(eColumnEClass, ECOLUMN__LENGTH);
		createEAttribute(eColumnEClass, ECOLUMN__PRECISION);
		createEAttribute(eColumnEClass, ECOLUMN__SCALE);
		createEAttribute(eColumnEClass, ECOLUMN__JDBC_TYPE);

		eTableEClass = createEClass(ETABLE);
		createEAttribute(eTableEClass, ETABLE__ID);
		createEAttribute(eTableEClass, ETABLE__NAME);

		eSupportedLanguagesEClass = createEClass(ESUPPORTED_LANGUAGES);
		createEAttribute(eSupportedLanguagesEClass, ESUPPORTED_LANGUAGES__LANGUAGE);

		eLanguageSettingsEClass = createEClass(ELANGUAGE_SETTINGS);
		createEReference(eLanguageSettingsEClass, ELANGUAGE_SETTINGS__BINDINGS);

		eLanguageSpecificationEClass = createEClass(ELANGUAGE_SPECIFICATION);
		createEAttribute(eLanguageSpecificationEClass, ELANGUAGE_SPECIFICATION__SHORT_NAME);
		createEAttribute(eLanguageSpecificationEClass, ELANGUAGE_SPECIFICATION__PRIMITIVE);
		createEAttribute(eLanguageSpecificationEClass, ELANGUAGE_SPECIFICATION__QUALIFIED_NAME);
		createEAttribute(eLanguageSpecificationEClass, ELANGUAGE_SPECIFICATION__LANGUAGE);

		eSupportedJdbcTypesEClass = createEClass(ESUPPORTED_JDBC_TYPES);
		createEAttribute(eSupportedJdbcTypesEClass, ESUPPORTED_JDBC_TYPES__JDBC_TYPE);

		eLanguageMapEntryEClass = createEClass(ELANGUAGE_MAP_ENTRY);
		createEAttribute(eLanguageMapEntryEClass, ELANGUAGE_MAP_ENTRY__KEY);
		createEReference(eLanguageMapEntryEClass, ELANGUAGE_MAP_ENTRY__VALUE);

		eLanguageBindingEClass = createEClass(ELANGUAGE_BINDING);
		createEReference(eLanguageBindingEClass, ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION);
		createEReference(eLanguageBindingEClass, ELANGUAGE_BINDING__JDBC_TYPES);

		// Create enums
		eLanguageEEnum = createEEnum(ELANGUAGE);
		eRelationTypeEEnum = createEEnum(ERELATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eEntityObjectEClass.getESuperTypes().add(this.getEModelObject());
		eFieldObjectEClass.getESuperTypes().add(this.getEModelObject());
		ePersistenceObjectEClass.getESuperTypes().add(this.getEModelObject());
		eModuleObjectEClass.getESuperTypes().add(this.getEModelObject());
		eEnumObjectEClass.getESuperTypes().add(this.getEModelObject());
		eEnumLiteralObjectEClass.getESuperTypes().add(this.getEModelObject());
		eRelationshipEClass.getESuperTypes().add(this.getEModelObject());
		eColumnEClass.getESuperTypes().add(this.getEModelObject());
		eTableEClass.getESuperTypes().add(this.getEModelObject());

		// Initialize classes, features, and operations; add parameters
		initEClass(eEntityObjectEClass, EEntityObject.class, "EEntityObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEEntityObject_Id(), ecorePackage.getEString(), "id", null, 0, 1, EEntityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEEntityObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, EEntityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEEntityObject_Description(), ecorePackage.getEString(), "description", null, 0, 1, EEntityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEEntityObject_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, EEntityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEntityObject_PrimaryKey(), this.getEFieldObject(), null, "primaryKey", null, 0, 1, EEntityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEntityObject_Table(), this.getETable(), null, "table", null, 0, 1, EEntityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEntityObject_Fields(), this.getEFieldObject(), null, "fields", null, 0, -1, EEntityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEntityObject_Properties(), this.getEPropertyMapEntry(), null, "properties", null, 0, -1, EEntityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eFieldObjectEClass, EFieldObject.class, "EFieldObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEFieldObject_Id(), ecorePackage.getEString(), "id", null, 0, 1, EFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFieldObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, EFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFieldObject_Description(), ecorePackage.getEString(), "description", null, 0, 1, EFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFieldObject_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, EFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEFieldObject_Properties(), this.getEPropertyMapEntry(), null, "properties", null, 0, -1, EFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEFieldObject_Column(), this.getEColumn(), null, "column", null, 0, 1, EFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFieldObject_Version(), ecorePackage.getEBoolean(), "version", "false", 0, 1, EFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEFieldObject_Languages(), this.getELanguageMapEntry(), null, "languages", null, 0, -1, EFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ePersistenceObjectEClass, EPersistenceObject.class, "EPersistenceObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEPersistenceObject_Modules(), this.getEModuleObject(), null, "modules", null, 0, -1, EPersistenceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEPersistenceObject_Properties(), this.getEPropertyMapEntry(), null, "properties", null, 0, -1, EPersistenceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEPersistenceObject_SupportedLanguages(), this.getESupportedLanguages(), null, "supportedLanguages", null, 0, -1, EPersistenceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eModelObjectEClass, EModelObject.class, "EModelObject", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEModelObject__GetName(), ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getEModelObject__SetName__String(), null, "setName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eModuleObjectEClass, EModuleObject.class, "EModuleObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEModuleObject_Id(), ecorePackage.getEString(), "id", null, 0, 1, EModuleObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEModuleObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, EModuleObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEModuleObject_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, EModuleObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEModuleObject_Description(), ecorePackage.getEString(), "description", null, 0, 1, EModuleObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEModuleObject_Entities(), this.getEEntityObject(), null, "entities", null, 0, -1, EModuleObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEModuleObject_Properties(), this.getEPropertyMapEntry(), null, "properties", null, 0, -1, EModuleObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eEnumObjectEClass, EEnumObject.class, "EEnumObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEEnumObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, EEnumObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEEnumObject_Description(), ecorePackage.getEString(), "description", null, 0, 1, EEnumObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEnumObject_Constants(), this.getEEnumLiteralObject(), null, "constants", null, 0, -1, EEnumObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEnumObject_Properties(), this.getEPropertyMapEntry(), null, "properties", null, 0, -1, EEnumObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eEnumLiteralObjectEClass, EEnumLiteralObject.class, "EEnumLiteralObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEEnumLiteralObject_Literal(), ecorePackage.getEString(), "literal", null, 0, 1, EEnumLiteralObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEEnumLiteralObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, EEnumLiteralObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEEnumLiteralObject_Value(), ecorePackage.getEInt(), "value", null, 0, 1, EEnumLiteralObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEnumLiteralObject_Properties(), this.getEPropertyMapEntry(), null, "properties", null, 0, 1, EEnumLiteralObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ePropertyMapEntryEClass, Map.Entry.class, "EPropertyMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEPropertyMapEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPropertyMapEntry_Value(), ecorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eRelationshipEClass, ERelationship.class, "ERelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getERelationship_Id(), ecorePackage.getEString(), "id", null, 0, 1, ERelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERelationship_Name(), ecorePackage.getEString(), "name", null, 0, 1, ERelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERelationship_Description(), ecorePackage.getEString(), "description", null, 0, 1, ERelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getERelationship_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, ERelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getERelationship_TargetEntity(), this.getEEntityObject(), null, "targetEntity", null, 0, 1, ERelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getERelationship_TargetField(), this.getEFieldObject(), null, "targetField", null, 0, 1, ERelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eColumnEClass, EColumn.class, "EColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEColumn_Id(), ecorePackage.getEString(), "id", null, 0, 1, EColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEColumn_Name(), ecorePackage.getEString(), "name", null, 0, 1, EColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEColumn_Unique(), ecorePackage.getEBoolean(), "unique", "false", 0, 1, EColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEColumn_Nullable(), ecorePackage.getEBoolean(), "nullable", "true", 0, 1, EColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEColumn_Length(), ecorePackage.getEIntegerObject(), "length", null, 0, 1, EColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEColumn_Precision(), ecorePackage.getEIntegerObject(), "precision", null, 0, 1, EColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEColumn_Scale(), ecorePackage.getEIntegerObject(), "scale", null, 0, 1, EColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEColumn_JdbcType(), ecorePackage.getEIntegerObject(), "jdbcType", null, 0, 1, EColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eTableEClass, ETable.class, "ETable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getETable_Id(), ecorePackage.getEString(), "id", null, 0, 1, ETable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETable_Name(), ecorePackage.getEString(), "name", null, 0, 1, ETable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSupportedLanguagesEClass, ESupportedLanguages.class, "ESupportedLanguages", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESupportedLanguages_Language(), this.getELanguage(), "language", null, 0, 1, ESupportedLanguages.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eLanguageSettingsEClass, ELanguageSettings.class, "ELanguageSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getELanguageSettings_Bindings(), this.getELanguageBinding(), null, "bindings", null, 0, -1, ELanguageSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eLanguageSpecificationEClass, ELanguageSpecification.class, "ELanguageSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getELanguageSpecification_ShortName(), ecorePackage.getEString(), "shortName", null, 0, 1, ELanguageSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELanguageSpecification_Primitive(), ecorePackage.getEBoolean(), "primitive", null, 0, 1, ELanguageSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELanguageSpecification_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, ELanguageSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELanguageSpecification_Language(), this.getELanguage(), "language", null, 0, 1, ELanguageSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSupportedJdbcTypesEClass, ESupportedJdbcTypes.class, "ESupportedJdbcTypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESupportedJdbcTypes_JdbcType(), ecorePackage.getEInt(), "jdbcType", null, 0, 1, ESupportedJdbcTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eLanguageMapEntryEClass, Map.Entry.class, "ELanguageMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getELanguageMapEntry_Key(), this.getELanguage(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getELanguageMapEntry_Value(), this.getELanguageSpecification(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eLanguageBindingEClass, ELanguageBinding.class, "ELanguageBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getELanguageBinding_LanguageSpecification(), this.getELanguageSpecification(), null, "languageSpecification", null, 0, 1, ELanguageBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getELanguageBinding_JdbcTypes(), this.getESupportedJdbcTypes(), null, "jdbcTypes", null, 0, -1, ELanguageBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eLanguageEEnum, ELanguage.class, "ELanguage");
		addEEnumLiteral(eLanguageEEnum, ELanguage.JAVA);
		addEEnumLiteral(eLanguageEEnum, ELanguage.KOTLIN);
		addEEnumLiteral(eLanguageEEnum, ELanguage.DOT_NET);

		initEEnum(eRelationTypeEEnum, ERelationType.class, "ERelationType");
		addEEnumLiteral(eRelationTypeEEnum, ERelationType.MANY_TO_ONE);
		addEEnumLiteral(eRelationTypeEEnum, ERelationType.ONE_TO_MANY);

		// Create resource
		createResource(eNS_URI);
	}

} //EntityPackageImpl
