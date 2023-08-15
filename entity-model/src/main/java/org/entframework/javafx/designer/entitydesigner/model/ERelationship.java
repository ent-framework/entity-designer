/**
 */
package org.entframework.javafx.designer.entitydesigner.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ERelationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getId <em>Id</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getName <em>Name</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getDescription <em>Description</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getComment <em>Comment</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getTargetEntity <em>Target Entity</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getTargetField <em>Target Field</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getERelationship()
 * @model
 * @generated
 */
public interface ERelationship extends EModelObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getERelationship_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getId <em>Id</em>}' attribute.
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
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getERelationship_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getERelationship_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getERelationship_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Target Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Entity</em>' reference.
	 * @see #setTargetEntity(EEntityObject)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getERelationship_TargetEntity()
	 * @model
	 * @generated
	 */
	EEntityObject getTargetEntity();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getTargetEntity <em>Target Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Entity</em>' reference.
	 * @see #getTargetEntity()
	 * @generated
	 */
	void setTargetEntity(EEntityObject value);

	/**
	 * Returns the value of the '<em><b>Target Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Field</em>' reference.
	 * @see #setTargetField(EFieldObject)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getERelationship_TargetField()
	 * @model
	 * @generated
	 */
	EFieldObject getTargetField();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getTargetField <em>Target Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Field</em>' reference.
	 * @see #getTargetField()
	 * @generated
	 */
	void setTargetField(EFieldObject value);

} // ERelationship
