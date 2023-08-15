/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EField Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getId <em>Id</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getName <em>Name</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getDescription <em>Description</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getComment <em>Comment</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getColumn <em>Column</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#isVersion <em>Version</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getLanguages <em>Languages</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEFieldObject()
 * @model
 * @generated
 */
public interface EFieldObject extends EModelObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEFieldObject_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getId <em>Id</em>}' attribute.
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
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEFieldObject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getName <em>Name</em>}' attribute.
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
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEFieldObject_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getDescription <em>Description</em>}' attribute.
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
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEFieldObject_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEFieldObject_Properties()
	 * @model mapType="org.entframework.javafx.designer.entitydesigner.model.EPropertyMapEntry&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	EMap<String, String> getProperties();

	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference.
	 * @see #setColumn(EColumn)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEFieldObject_Column()
	 * @model
	 * @generated
	 */
	EColumn getColumn();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getColumn <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' reference.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(EColumn value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(boolean)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEFieldObject_Version()
	 * @model default="false"
	 * @generated
	 */
	boolean isVersion();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#isVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #isVersion()
	 * @generated
	 */
	void setVersion(boolean value);

	/**
	 * Returns the value of the '<em><b>Languages</b></em>' map.
	 * The key is of type {@link org.entframework.javafx.designer.entitydesigner.model.ELanguage},
	 * and the value is of type {@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Languages</em>' map.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEFieldObject_Languages()
	 * @model mapType="org.entframework.javafx.designer.entitydesigner.model.ELanguageMapEntry&lt;org.entframework.javafx.designer.entitydesigner.model.ELanguage, org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification&gt;"
	 * @generated
	 */
	EMap<ELanguage, ELanguageSpecification> getLanguages();

} // EFieldObject
