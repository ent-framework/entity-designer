/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESupported Jdbc Types</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes#getJdbcType <em>Jdbc Type</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getESupportedJdbcTypes()
 * @model
 * @generated
 */
public interface ESupportedJdbcTypes extends EObject {
	/**
	 * Returns the value of the '<em><b>Jdbc Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Type</em>' attribute.
	 * @see #setJdbcType(int)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getESupportedJdbcTypes_JdbcType()
	 * @model
	 * @generated
	 */
	int getJdbcType();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes#getJdbcType <em>Jdbc Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Type</em>' attribute.
	 * @see #getJdbcType()
	 * @generated
	 */
	void setJdbcType(int value);

} // ESupportedJdbcTypes
