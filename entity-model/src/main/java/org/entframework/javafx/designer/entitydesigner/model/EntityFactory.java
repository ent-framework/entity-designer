/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage
 * @generated
 */
public interface EntityFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EntityFactory eINSTANCE = org.entframework.javafx.designer.entitydesigner.model.impl.EntityFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EEntity Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EEntity Object</em>'.
	 * @generated
	 */
	EEntityObject createEEntityObject();

	/**
	 * Returns a new object of class '<em>EField Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EField Object</em>'.
	 * @generated
	 */
	EFieldObject createEFieldObject();

	/**
	 * Returns a new object of class '<em>EPersistence Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EPersistence Object</em>'.
	 * @generated
	 */
	EPersistenceObject createEPersistenceObject();

	/**
	 * Returns a new object of class '<em>EModule Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EModule Object</em>'.
	 * @generated
	 */
	EModuleObject createEModuleObject();

	/**
	 * Returns a new object of class '<em>EEnum Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EEnum Object</em>'.
	 * @generated
	 */
	EEnumObject createEEnumObject();

	/**
	 * Returns a new object of class '<em>EEnum Literal Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EEnum Literal Object</em>'.
	 * @generated
	 */
	EEnumLiteralObject createEEnumLiteralObject();

	/**
	 * Returns a new object of class '<em>ERelationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ERelationship</em>'.
	 * @generated
	 */
	ERelationship createERelationship();

	/**
	 * Returns a new object of class '<em>EColumn</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EColumn</em>'.
	 * @generated
	 */
	EColumn createEColumn();

	/**
	 * Returns a new object of class '<em>ETable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ETable</em>'.
	 * @generated
	 */
	ETable createETable();

	/**
	 * Returns a new object of class '<em>ESupported Languages</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESupported Languages</em>'.
	 * @generated
	 */
	ESupportedLanguages createESupportedLanguages();

	/**
	 * Returns a new object of class '<em>ELanguage Settings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ELanguage Settings</em>'.
	 * @generated
	 */
	ELanguageSettings createELanguageSettings();

	/**
	 * Returns a new object of class '<em>ELanguage Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ELanguage Specification</em>'.
	 * @generated
	 */
	ELanguageSpecification createELanguageSpecification();

	/**
	 * Returns a new object of class '<em>ESupported Jdbc Types</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESupported Jdbc Types</em>'.
	 * @generated
	 */
	ESupportedJdbcTypes createESupportedJdbcTypes();

	/**
	 * Returns a new object of class '<em>ELanguage Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ELanguage Binding</em>'.
	 * @generated
	 */
	ELanguageBinding createELanguageBinding();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EntityPackage getEntityPackage();

} //EntityFactory
