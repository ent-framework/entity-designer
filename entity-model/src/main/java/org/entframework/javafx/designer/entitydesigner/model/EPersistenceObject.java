/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EPersistence Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject#getModules <em>Modules</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject#getSupportedLanguages <em>Supported Languages</em>}</li>
 * </ul>
 *
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEPersistenceObject()
 * @model
 * @generated
 */
public interface EPersistenceObject extends EModelObject {
	/**
	 * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
	 * The list contents are of type {@link org.entframework.javafx.designer.entitydesigner.model.EModuleObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modules</em>' containment reference list.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEPersistenceObject_Modules()
	 * @model containment="true"
	 * @generated
	 */
	EList<EModuleObject> getModules();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEPersistenceObject_Properties()
	 * @model mapType="org.entframework.javafx.designer.entitydesigner.model.EPropertyMapEntry&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	EMap<String, String> getProperties();

	/**
	 * Returns the value of the '<em><b>Supported Languages</b></em>' containment reference list.
	 * The list contents are of type {@link org.entframework.javafx.designer.entitydesigner.model.ESupportedLanguages}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported Languages</em>' containment reference list.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getEPersistenceObject_SupportedLanguages()
	 * @model containment="true"
	 * @generated
	 */
	EList<ESupportedLanguages> getSupportedLanguages();

} // EPersistenceObject
