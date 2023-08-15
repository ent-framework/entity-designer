/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ELanguage Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding#getLanguageSpecification <em>Language Specification</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding#getJdbcTypes <em>Jdbc Types</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getELanguageBinding()
 * @model
 * @generated
 */
public interface ELanguageBinding extends EObject {
	/**
	 * Returns the value of the '<em><b>Language Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Specification</em>' containment reference.
	 * @see #setLanguageSpecification(ELanguageSpecification)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getELanguageBinding_LanguageSpecification()
	 * @model containment="true"
	 * @generated
	 */
	ELanguageSpecification getLanguageSpecification();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding#getLanguageSpecification <em>Language Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language Specification</em>' containment reference.
	 * @see #getLanguageSpecification()
	 * @generated
	 */
	void setLanguageSpecification(ELanguageSpecification value);

	/**
	 * Returns the value of the '<em><b>Jdbc Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Types</em>' containment reference list.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getELanguageBinding_JdbcTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ESupportedJdbcTypes> getJdbcTypes();

} // ELanguageBinding
