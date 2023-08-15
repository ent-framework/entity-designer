/**
 */
package org.entframework.javafx.designer.entitydesigner.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ETable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ETable#getId <em>Id</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ETable#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getETable()
 * @model
 * @generated
 */
public interface ETable extends EModelObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getETable_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ETable#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getETable_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ETable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ETable
