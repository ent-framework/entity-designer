/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEnum Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getName <em>Name</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getDescription <em>Description</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEEnumObject()
 * @model
 * @generated
 */
public interface EEnumObject extends EModelObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEEnumObject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getName <em>Name</em>}' attribute.
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
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEEnumObject_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
	 * The list contents are of type {@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constants</em>' containment reference list.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEEnumObject_Constants()
	 * @model containment="true"
	 * @generated
	 */
	EList<EEnumLiteralObject> getConstants();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEEnumObject_Properties()
	 * @model mapType="org.entframework.javafx.designer.entitydesigner.model.EPropertyMapEntry&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	EMap<String, String> getProperties();

} // EEnumObject
