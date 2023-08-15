/**
 */
package org.entframework.javafx.designer.entitydesigner.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EColumn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getId <em>Id</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getName <em>Name</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#isUnique <em>Unique</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#isNullable <em>Nullable</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getLength <em>Length</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getPrecision <em>Precision</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getScale <em>Scale</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getJdbcType <em>Jdbc Type</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEColumn()
 * @model
 * @generated
 */
public interface EColumn extends EModelObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEColumn_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getId <em>Id</em>}' attribute.
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
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEColumn_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Unique</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique</em>' attribute.
	 * @see #setUnique(boolean)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEColumn_Unique()
	 * @model default="false"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#isUnique <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique</em>' attribute.
	 * @see #isUnique()
	 * @generated
	 */
	void setUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Nullable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nullable</em>' attribute.
	 * @see #setNullable(boolean)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEColumn_Nullable()
	 * @model default="true"
	 * @generated
	 */
	boolean isNullable();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#isNullable <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nullable</em>' attribute.
	 * @see #isNullable()
	 * @generated
	 */
	void setNullable(boolean value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(Integer)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEColumn_Length()
	 * @model
	 * @generated
	 */
	Integer getLength();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(Integer value);

	/**
	 * Returns the value of the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precision</em>' attribute.
	 * @see #setPrecision(Integer)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEColumn_Precision()
	 * @model
	 * @generated
	 */
	Integer getPrecision();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getPrecision <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precision</em>' attribute.
	 * @see #getPrecision()
	 * @generated
	 */
	void setPrecision(Integer value);

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #setScale(Integer)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEColumn_Scale()
	 * @model
	 * @generated
	 */
	Integer getScale();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(Integer value);

	/**
	 * Returns the value of the '<em><b>Jdbc Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Type</em>' attribute.
	 * @see #setJdbcType(Integer)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEColumn_JdbcType()
	 * @model
	 * @generated
	 */
	Integer getJdbcType();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getJdbcType <em>Jdbc Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Type</em>' attribute.
	 * @see #getJdbcType()
	 * @generated
	 */
	void setJdbcType(Integer value);

} // EColumn
