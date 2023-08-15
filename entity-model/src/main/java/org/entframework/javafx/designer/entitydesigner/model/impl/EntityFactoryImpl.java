/**
 */
package org.entframework.javafx.designer.entitydesigner.model.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.entframework.javafx.designer.entitydesigner.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EntityFactoryImpl extends EFactoryImpl implements EntityFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntityFactory init() {
		try {
			EntityFactory theEntityFactory = (EntityFactory)EPackage.Registry.INSTANCE.getEFactory(EntityPackage.eNS_URI);
			if (theEntityFactory != null) {
				return theEntityFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EntityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EntityPackage.EENTITY_OBJECT: return createEEntityObject();
			case EntityPackage.EFIELD_OBJECT: return createEFieldObject();
			case EntityPackage.EPERSISTENCE_OBJECT: return createEPersistenceObject();
			case EntityPackage.EMODULE_OBJECT: return createEModuleObject();
			case EntityPackage.EENUM_OBJECT: return createEEnumObject();
			case EntityPackage.EENUM_LITERAL_OBJECT: return createEEnumLiteralObject();
			case EntityPackage.EPROPERTY_MAP_ENTRY: return (EObject)createEPropertyMapEntry();
			case EntityPackage.ERELATIONSHIP: return createERelationship();
			case EntityPackage.ECOLUMN: return createEColumn();
			case EntityPackage.ETABLE: return createETable();
			case EntityPackage.ESUPPORTED_LANGUAGES: return createESupportedLanguages();
			case EntityPackage.ELANGUAGE_SETTINGS: return createELanguageSettings();
			case EntityPackage.ELANGUAGE_SPECIFICATION: return createELanguageSpecification();
			case EntityPackage.ESUPPORTED_JDBC_TYPES: return createESupportedJdbcTypes();
			case EntityPackage.ELANGUAGE_MAP_ENTRY: return (EObject)createELanguageMapEntry();
			case EntityPackage.ELANGUAGE_BINDING: return createELanguageBinding();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EntityPackage.ELANGUAGE:
				return createELanguageFromString(eDataType, initialValue);
			case EntityPackage.ERELATION_TYPE:
				return createERelationTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EntityPackage.ELANGUAGE:
				return convertELanguageToString(eDataType, instanceValue);
			case EntityPackage.ERELATION_TYPE:
				return convertERelationTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEntityObject createEEntityObject() {
		EEntityObjectImpl eEntityObject = new EEntityObjectImpl();
		return eEntityObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFieldObject createEFieldObject() {
		EFieldObjectImpl eFieldObject = new EFieldObjectImpl();
		return eFieldObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPersistenceObject createEPersistenceObject() {
		EPersistenceObjectImpl ePersistenceObject = new EPersistenceObjectImpl();
		return ePersistenceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EModuleObject createEModuleObject() {
		EModuleObjectImpl eModuleObject = new EModuleObjectImpl();
		return eModuleObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnumObject createEEnumObject() {
		EEnumObjectImpl eEnumObject = new EEnumObjectImpl();
		return eEnumObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnumLiteralObject createEEnumLiteralObject() {
		EEnumLiteralObjectImpl eEnumLiteralObject = new EEnumLiteralObjectImpl();
		return eEnumLiteralObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createEPropertyMapEntry() {
		EPropertyMapEntryImpl ePropertyMapEntry = new EPropertyMapEntryImpl();
		return ePropertyMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ERelationship createERelationship() {
		ERelationshipImpl eRelationship = new ERelationshipImpl();
		return eRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EColumn createEColumn() {
		EColumnImpl eColumn = new EColumnImpl();
		return eColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ETable createETable() {
		ETableImpl eTable = new ETableImpl();
		return eTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ESupportedLanguages createESupportedLanguages() {
		ESupportedLanguagesImpl eSupportedLanguages = new ESupportedLanguagesImpl();
		return eSupportedLanguages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ELanguageSettings createELanguageSettings() {
		ELanguageSettingsImpl eLanguageSettings = new ELanguageSettingsImpl();
		return eLanguageSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ELanguageSpecification createELanguageSpecification() {
		ELanguageSpecificationImpl eLanguageSpecification = new ELanguageSpecificationImpl();
		return eLanguageSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ESupportedJdbcTypes createESupportedJdbcTypes() {
		ESupportedJdbcTypesImpl eSupportedJdbcTypes = new ESupportedJdbcTypesImpl();
		return eSupportedJdbcTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<ELanguage, ELanguageSpecification> createELanguageMapEntry() {
		ELanguageMapEntryImpl eLanguageMapEntry = new ELanguageMapEntryImpl();
		return eLanguageMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ELanguageBinding createELanguageBinding() {
		ELanguageBindingImpl eLanguageBinding = new ELanguageBindingImpl();
		return eLanguageBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELanguage createELanguageFromString(EDataType eDataType, String initialValue) {
		ELanguage result = ELanguage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertELanguageToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ERelationType createERelationTypeFromString(EDataType eDataType, String initialValue) {
		ERelationType result = ERelationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertERelationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntityPackage getEntityPackage() {
		return (EntityPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EntityPackage getPackage() {
		return EntityPackage.eINSTANCE;
	}

} //EntityFactoryImpl
