/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ELanguage Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSettings#getBindings <em>Bindings</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getELanguageSettings()
 * @model
 * @generated
 */
public interface ELanguageSettings extends EObject {
	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getELanguageSettings_Bindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<ELanguageBinding> getBindings();

} // ELanguageSettings
