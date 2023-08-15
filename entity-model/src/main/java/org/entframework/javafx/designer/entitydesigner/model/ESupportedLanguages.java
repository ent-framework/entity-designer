/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESupported Languages</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ESupportedLanguages#getLanguage <em>Language</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getESupportedLanguages()
 * @model
 * @generated
 */
public interface ESupportedLanguages extends EObject {
	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The literals are from the enumeration {@link org.entframework.javafx.designer.entitydesigner.model.ELanguage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguage
	 * @see #setLanguage(ELanguage)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getESupportedLanguages_Language()
	 * @model
	 * @generated
	 */
	ELanguage getLanguage();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ESupportedLanguages#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguage
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(ELanguage value);

} // ESupportedLanguages
