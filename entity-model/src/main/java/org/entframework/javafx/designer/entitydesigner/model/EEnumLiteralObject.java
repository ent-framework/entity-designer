/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEnum Literal Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getName <em>Name</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getValue <em>Value</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEEnumLiteralObject()
 * @model
 * @generated
 */
public interface EEnumLiteralObject extends EModelObject {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' attribute.
	 * @see #setLiteral(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEEnumLiteralObject_Literal()
	 * @model
	 * @generated
	 */
	String getLiteral();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' attribute.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEEnumLiteralObject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEEnumLiteralObject_Value()
	 * @model
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see #setProperties(Map.Entry)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEEnumLiteralObject_Properties()
	 * @model mapType="org.entframework.javafx.designer.entitydesigner.model.EPropertyMapEntry&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	Map.Entry<String, String> getProperties();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getProperties <em>Properties</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' map.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(Map.Entry<String, String> value);

} // EEnumLiteralObject
