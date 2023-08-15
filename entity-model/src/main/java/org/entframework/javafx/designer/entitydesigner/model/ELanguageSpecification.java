/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ELanguage Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getShortName <em>Short Name</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#isPrimitive <em>Primitive</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getLanguage <em>Language</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getELanguageSpecification()
 * @model
 * @generated
 */
public interface ELanguageSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Short Name</em>' attribute.
	 * @see #setShortName(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getELanguageSpecification_ShortName()
	 * @model
	 * @generated
	 */
	String getShortName();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getShortName <em>Short Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short Name</em>' attribute.
	 * @see #getShortName()
	 * @generated
	 */
	void setShortName(String value);

	/**
	 * Returns the value of the '<em><b>Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive</em>' attribute.
	 * @see #setPrimitive(boolean)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getELanguageSpecification_Primitive()
	 * @model
	 * @generated
	 */
	boolean isPrimitive();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#isPrimitive <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive</em>' attribute.
	 * @see #isPrimitive()
	 * @generated
	 */
	void setPrimitive(boolean value);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getELanguageSpecification_QualifiedName()
	 * @model
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The literals are from the enumeration {@link org.entframework.javafx.designer.entitydesigner.model.ELanguage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguage
	 * @see #setLanguage(ELanguage)
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getELanguageSpecification_Language()
	 * @model
	 * @generated
	 */
	ELanguage getLanguage();

	/**
	 * Sets the value of the '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguage
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(ELanguage value);

} // ELanguageSpecification
