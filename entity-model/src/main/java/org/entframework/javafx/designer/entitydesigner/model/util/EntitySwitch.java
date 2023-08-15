/**
 */
package org.entframework.javafx.designer.entitydesigner.model.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.entframework.javafx.designer.entitydesigner.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage
 * @generated
 */
public class EntitySwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EntityPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitySwitch() {
		if (modelPackage == null) {
			modelPackage = EntityPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EntityPackage.EENTITY_OBJECT: {
				EEntityObject eEntityObject = (EEntityObject)theEObject;
				T result = caseEEntityObject(eEntityObject);
				if (result == null) result = caseEModelObject(eEntityObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.EFIELD_OBJECT: {
				EFieldObject eFieldObject = (EFieldObject)theEObject;
				T result = caseEFieldObject(eFieldObject);
				if (result == null) result = caseEModelObject(eFieldObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.EPERSISTENCE_OBJECT: {
				EPersistenceObject ePersistenceObject = (EPersistenceObject)theEObject;
				T result = caseEPersistenceObject(ePersistenceObject);
				if (result == null) result = caseEModelObject(ePersistenceObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.EMODEL_OBJECT: {
				EModelObject eModelObject = (EModelObject)theEObject;
				T result = caseEModelObject(eModelObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.EMODULE_OBJECT: {
				EModuleObject eModuleObject = (EModuleObject)theEObject;
				T result = caseEModuleObject(eModuleObject);
				if (result == null) result = caseEModelObject(eModuleObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.EENUM_OBJECT: {
				EEnumObject eEnumObject = (EEnumObject)theEObject;
				T result = caseEEnumObject(eEnumObject);
				if (result == null) result = caseEModelObject(eEnumObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.EENUM_LITERAL_OBJECT: {
				EEnumLiteralObject eEnumLiteralObject = (EEnumLiteralObject)theEObject;
				T result = caseEEnumLiteralObject(eEnumLiteralObject);
				if (result == null) result = caseEModelObject(eEnumLiteralObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.EPROPERTY_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, String> ePropertyMapEntry = (Map.Entry<String, String>)theEObject;
				T result = caseEPropertyMapEntry(ePropertyMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.ERELATIONSHIP: {
				ERelationship eRelationship = (ERelationship)theEObject;
				T result = caseERelationship(eRelationship);
				if (result == null) result = caseEModelObject(eRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.ECOLUMN: {
				EColumn eColumn = (EColumn)theEObject;
				T result = caseEColumn(eColumn);
				if (result == null) result = caseEModelObject(eColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.ETABLE: {
				ETable eTable = (ETable)theEObject;
				T result = caseETable(eTable);
				if (result == null) result = caseEModelObject(eTable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.ESUPPORTED_LANGUAGES: {
				ESupportedLanguages eSupportedLanguages = (ESupportedLanguages)theEObject;
				T result = caseESupportedLanguages(eSupportedLanguages);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.ELANGUAGE_SETTINGS: {
				ELanguageSettings eLanguageSettings = (ELanguageSettings)theEObject;
				T result = caseELanguageSettings(eLanguageSettings);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.ELANGUAGE_SPECIFICATION: {
				ELanguageSpecification eLanguageSpecification = (ELanguageSpecification)theEObject;
				T result = caseELanguageSpecification(eLanguageSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.ESUPPORTED_JDBC_TYPES: {
				ESupportedJdbcTypes eSupportedJdbcTypes = (ESupportedJdbcTypes)theEObject;
				T result = caseESupportedJdbcTypes(eSupportedJdbcTypes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.ELANGUAGE_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<ELanguage, ELanguageSpecification> eLanguageMapEntry = (Map.Entry<ELanguage, ELanguageSpecification>)theEObject;
				T result = caseELanguageMapEntry(eLanguageMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EntityPackage.ELANGUAGE_BINDING: {
				ELanguageBinding eLanguageBinding = (ELanguageBinding)theEObject;
				T result = caseELanguageBinding(eLanguageBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EEntity Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EEntity Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEEntityObject(EEntityObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EField Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EField Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFieldObject(EFieldObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPersistence Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPersistence Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEPersistenceObject(EPersistenceObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelObject(EModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModule Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModule Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModuleObject(EModuleObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EEnum Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EEnum Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEEnumObject(EEnumObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EEnum Literal Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EEnum Literal Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEEnumLiteralObject(EEnumLiteralObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EProperty Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EProperty Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEPropertyMapEntry(Map.Entry<String, String> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ERelationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ERelationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseERelationship(ERelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EColumn</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EColumn</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEColumn(EColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseETable(ETable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESupported Languages</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESupported Languages</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESupportedLanguages(ESupportedLanguages object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELanguage Settings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELanguage Settings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELanguageSettings(ELanguageSettings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELanguage Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELanguage Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELanguageSpecification(ELanguageSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESupported Jdbc Types</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESupported Jdbc Types</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESupportedJdbcTypes(ESupportedJdbcTypes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELanguage Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELanguage Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELanguageMapEntry(Map.Entry<ELanguage, ELanguageSpecification> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELanguage Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELanguage Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELanguageBinding(ELanguageBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EntitySwitch
