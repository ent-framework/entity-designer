/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityFactory
 * @model kind="package"
 * @generated
 */
public interface EntityPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.entframework.designer.entitydesigner.model/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EntityPackage eINSTANCE = org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.EModelObject <em>EModel Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModelObject
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEModelObject()
	 * @generated
	 */
	int EMODEL_OBJECT = 3;

	/**
	 * The number of structural features of the '<em>EModel Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODEL_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODEL_OBJECT___GET_NAME = 0;

	/**
	 * The operation id for the '<em>Set Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODEL_OBJECT___SET_NAME__STRING = 1;

	/**
	 * The number of operations of the '<em>EModel Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODEL_OBJECT_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EEntityObjectImpl <em>EEntity Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EEntityObjectImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEEntityObject()
	 * @generated
	 */
	int EENTITY_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT__ID = EMODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT__NAME = EMODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT__DESCRIPTION = EMODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT__COMMENT = EMODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT__PRIMARY_KEY = EMODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT__TABLE = EMODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT__FIELDS = EMODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT__PROPERTIES = EMODEL_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>EEntity Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT_FEATURE_COUNT = EMODEL_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT___GET_NAME = EMODEL_OBJECT___GET_NAME;

	/**
	 * The operation id for the '<em>Set Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT___SET_NAME__STRING = EMODEL_OBJECT___SET_NAME__STRING;

	/**
	 * The number of operations of the '<em>EEntity Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_OBJECT_OPERATION_COUNT = EMODEL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl <em>EField Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEFieldObject()
	 * @generated
	 */
	int EFIELD_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT__ID = EMODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT__NAME = EMODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT__DESCRIPTION = EMODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT__COMMENT = EMODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT__PROPERTIES = EMODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT__COLUMN = EMODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT__VERSION = EMODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Languages</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT__LANGUAGES = EMODEL_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>EField Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT_FEATURE_COUNT = EMODEL_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT___GET_NAME = EMODEL_OBJECT___GET_NAME;

	/**
	 * The operation id for the '<em>Set Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT___SET_NAME__STRING = EMODEL_OBJECT___SET_NAME__STRING;

	/**
	 * The number of operations of the '<em>EField Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFIELD_OBJECT_OPERATION_COUNT = EMODEL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EPersistenceObjectImpl <em>EPersistence Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EPersistenceObjectImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEPersistenceObject()
	 * @generated
	 */
	int EPERSISTENCE_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSISTENCE_OBJECT__MODULES = EMODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSISTENCE_OBJECT__PROPERTIES = EMODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Supported Languages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSISTENCE_OBJECT__SUPPORTED_LANGUAGES = EMODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EPersistence Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSISTENCE_OBJECT_FEATURE_COUNT = EMODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSISTENCE_OBJECT___GET_NAME = EMODEL_OBJECT___GET_NAME;

	/**
	 * The operation id for the '<em>Set Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSISTENCE_OBJECT___SET_NAME__STRING = EMODEL_OBJECT___SET_NAME__STRING;

	/**
	 * The number of operations of the '<em>EPersistence Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSISTENCE_OBJECT_OPERATION_COUNT = EMODEL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EModuleObjectImpl <em>EModule Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EModuleObjectImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEModuleObject()
	 * @generated
	 */
	int EMODULE_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODULE_OBJECT__ID = EMODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODULE_OBJECT__NAME = EMODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODULE_OBJECT__NAMESPACE = EMODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODULE_OBJECT__DESCRIPTION = EMODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODULE_OBJECT__ENTITIES = EMODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODULE_OBJECT__PROPERTIES = EMODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>EModule Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODULE_OBJECT_FEATURE_COUNT = EMODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODULE_OBJECT___GET_NAME = EMODEL_OBJECT___GET_NAME;

	/**
	 * The operation id for the '<em>Set Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODULE_OBJECT___SET_NAME__STRING = EMODEL_OBJECT___SET_NAME__STRING;

	/**
	 * The number of operations of the '<em>EModule Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODULE_OBJECT_OPERATION_COUNT = EMODEL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EEnumObjectImpl <em>EEnum Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EEnumObjectImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEEnumObject()
	 * @generated
	 */
	int EENUM_OBJECT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_OBJECT__NAME = EMODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_OBJECT__DESCRIPTION = EMODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_OBJECT__CONSTANTS = EMODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_OBJECT__PROPERTIES = EMODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>EEnum Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_OBJECT_FEATURE_COUNT = EMODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_OBJECT___GET_NAME = EMODEL_OBJECT___GET_NAME;

	/**
	 * The operation id for the '<em>Set Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_OBJECT___SET_NAME__STRING = EMODEL_OBJECT___SET_NAME__STRING;

	/**
	 * The number of operations of the '<em>EEnum Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_OBJECT_OPERATION_COUNT = EMODEL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EEnumLiteralObjectImpl <em>EEnum Literal Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EEnumLiteralObjectImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEEnumLiteralObject()
	 * @generated
	 */
	int EENUM_LITERAL_OBJECT = 6;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_OBJECT__LITERAL = EMODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_OBJECT__NAME = EMODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_OBJECT__VALUE = EMODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_OBJECT__PROPERTIES = EMODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>EEnum Literal Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_OBJECT_FEATURE_COUNT = EMODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_OBJECT___GET_NAME = EMODEL_OBJECT___GET_NAME;

	/**
	 * The operation id for the '<em>Set Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_OBJECT___SET_NAME__STRING = EMODEL_OBJECT___SET_NAME__STRING;

	/**
	 * The number of operations of the '<em>EEnum Literal Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENUM_LITERAL_OBJECT_OPERATION_COUNT = EMODEL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EPropertyMapEntryImpl <em>EProperty Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EPropertyMapEntryImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEPropertyMapEntry()
	 * @generated
	 */
	int EPROPERTY_MAP_ENTRY = 7;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EProperty Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EProperty Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROPERTY_MAP_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ERelationshipImpl <em>ERelationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ERelationshipImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getERelationship()
	 * @generated
	 */
	int ERELATIONSHIP = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERELATIONSHIP__ID = EMODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERELATIONSHIP__NAME = EMODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERELATIONSHIP__DESCRIPTION = EMODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERELATIONSHIP__COMMENT = EMODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERELATIONSHIP__TARGET_ENTITY = EMODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Target Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERELATIONSHIP__TARGET_FIELD = EMODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>ERelationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERELATIONSHIP_FEATURE_COUNT = EMODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERELATIONSHIP___GET_NAME = EMODEL_OBJECT___GET_NAME;

	/**
	 * The operation id for the '<em>Set Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERELATIONSHIP___SET_NAME__STRING = EMODEL_OBJECT___SET_NAME__STRING;

	/**
	 * The number of operations of the '<em>ERelationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERELATIONSHIP_OPERATION_COUNT = EMODEL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EColumnImpl <em>EColumn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EColumnImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEColumn()
	 * @generated
	 */
	int ECOLUMN = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN__ID = EMODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN__NAME = EMODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN__UNIQUE = EMODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN__NULLABLE = EMODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN__LENGTH = EMODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN__PRECISION = EMODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN__SCALE = EMODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Jdbc Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN__JDBC_TYPE = EMODEL_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>EColumn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN_FEATURE_COUNT = EMODEL_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN___GET_NAME = EMODEL_OBJECT___GET_NAME;

	/**
	 * The operation id for the '<em>Set Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN___SET_NAME__STRING = EMODEL_OBJECT___SET_NAME__STRING;

	/**
	 * The number of operations of the '<em>EColumn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOLUMN_OPERATION_COUNT = EMODEL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ETableImpl <em>ETable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ETableImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getETable()
	 * @generated
	 */
	int ETABLE = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETABLE__ID = EMODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETABLE__NAME = EMODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>ETable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETABLE_FEATURE_COUNT = EMODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETABLE___GET_NAME = EMODEL_OBJECT___GET_NAME;

	/**
	 * The operation id for the '<em>Set Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETABLE___SET_NAME__STRING = EMODEL_OBJECT___SET_NAME__STRING;

	/**
	 * The number of operations of the '<em>ETable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETABLE_OPERATION_COUNT = EMODEL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ESupportedLanguagesImpl <em>ESupported Languages</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ESupportedLanguagesImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getESupportedLanguages()
	 * @generated
	 */
	int ESUPPORTED_LANGUAGES = 11;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESUPPORTED_LANGUAGES__LANGUAGE = 0;

	/**
	 * The number of structural features of the '<em>ESupported Languages</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESUPPORTED_LANGUAGES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>ESupported Languages</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESUPPORTED_LANGUAGES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSettingsImpl <em>ELanguage Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSettingsImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getELanguageSettings()
	 * @generated
	 */
	int ELANGUAGE_SETTINGS = 12;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_SETTINGS__BINDINGS = 0;

	/**
	 * The number of structural features of the '<em>ELanguage Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_SETTINGS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>ELanguage Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_SETTINGS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSpecificationImpl <em>ELanguage Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSpecificationImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getELanguageSpecification()
	 * @generated
	 */
	int ELANGUAGE_SPECIFICATION = 13;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_SPECIFICATION__SHORT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_SPECIFICATION__PRIMITIVE = 1;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_SPECIFICATION__QUALIFIED_NAME = 2;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_SPECIFICATION__LANGUAGE = 3;

	/**
	 * The number of structural features of the '<em>ELanguage Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_SPECIFICATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>ELanguage Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ESupportedJdbcTypesImpl <em>ESupported Jdbc Types</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ESupportedJdbcTypesImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getESupportedJdbcTypes()
	 * @generated
	 */
	int ESUPPORTED_JDBC_TYPES = 14;

	/**
	 * The feature id for the '<em><b>Jdbc Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESUPPORTED_JDBC_TYPES__JDBC_TYPE = 0;

	/**
	 * The number of structural features of the '<em>ESupported Jdbc Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESUPPORTED_JDBC_TYPES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>ESupported Jdbc Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESUPPORTED_JDBC_TYPES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageMapEntryImpl <em>ELanguage Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageMapEntryImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getELanguageMapEntry()
	 * @generated
	 */
	int ELANGUAGE_MAP_ENTRY = 15;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>ELanguage Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>ELanguage Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_MAP_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageBindingImpl <em>ELanguage Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageBindingImpl
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getELanguageBinding()
	 * @generated
	 */
	int ELANGUAGE_BINDING = 16;

	/**
	 * The feature id for the '<em><b>Language Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Jdbc Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_BINDING__JDBC_TYPES = 1;

	/**
	 * The number of structural features of the '<em>ELanguage Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_BINDING_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>ELanguage Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELANGUAGE_BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguage <em>ELanguage</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguage
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getELanguage()
	 * @generated
	 */
	int ELANGUAGE = 17;


	/**
	 * The meta object id for the '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationType <em>ERelation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.entframework.javafx.designer.entitydesigner.model.ERelationType
	 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getERelationType()
	 * @generated
	 */
	int ERELATION_TYPE = 18;


	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.EEntityObject <em>EEntity Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEntity Object</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEntityObject
	 * @generated
	 */
	EClass getEEntityObject();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getId()
	 * @see #getEEntityObject()
	 * @generated
	 */
	EAttribute getEEntityObject_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getName()
	 * @see #getEEntityObject()
	 * @generated
	 */
	EAttribute getEEntityObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getDescription()
	 * @see #getEEntityObject()
	 * @generated
	 */
	EAttribute getEEntityObject_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getComment()
	 * @see #getEEntityObject()
	 * @generated
	 */
	EAttribute getEEntityObject_Comment();

	/**
	 * Returns the meta object for the containment reference '{@link org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primary Key</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getPrimaryKey()
	 * @see #getEEntityObject()
	 * @generated
	 */
	EReference getEEntityObject_PrimaryKey();

	/**
	 * Returns the meta object for the reference '{@link org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getTable()
	 * @see #getEEntityObject()
	 * @generated
	 */
	EReference getEEntityObject_Table();

	/**
	 * Returns the meta object for the containment reference list '{@link org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getFields()
	 * @see #getEEntityObject()
	 * @generated
	 */
	EReference getEEntityObject_Fields();

	/**
	 * Returns the meta object for the map '{@link org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEntityObject#getProperties()
	 * @see #getEEntityObject()
	 * @generated
	 */
	EReference getEEntityObject_Properties();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject <em>EField Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EField Object</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EFieldObject
	 * @generated
	 */
	EClass getEFieldObject();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getId()
	 * @see #getEFieldObject()
	 * @generated
	 */
	EAttribute getEFieldObject_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getName()
	 * @see #getEFieldObject()
	 * @generated
	 */
	EAttribute getEFieldObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getDescription()
	 * @see #getEFieldObject()
	 * @generated
	 */
	EAttribute getEFieldObject_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getComment()
	 * @see #getEFieldObject()
	 * @generated
	 */
	EAttribute getEFieldObject_Comment();

	/**
	 * Returns the meta object for the map '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getProperties()
	 * @see #getEFieldObject()
	 * @generated
	 */
	EReference getEFieldObject_Properties();

	/**
	 * Returns the meta object for the reference '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getColumn()
	 * @see #getEFieldObject()
	 * @generated
	 */
	EReference getEFieldObject_Column();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#isVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EFieldObject#isVersion()
	 * @see #getEFieldObject()
	 * @generated
	 */
	EAttribute getEFieldObject_Version();

	/**
	 * Returns the meta object for the map '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getLanguages <em>Languages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Languages</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EFieldObject#getLanguages()
	 * @see #getEFieldObject()
	 * @generated
	 */
	EReference getEFieldObject_Languages();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject <em>EPersistence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EPersistence Object</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject
	 * @generated
	 */
	EClass getEPersistenceObject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modules</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject#getModules()
	 * @see #getEPersistenceObject()
	 * @generated
	 */
	EReference getEPersistenceObject_Modules();

	/**
	 * Returns the meta object for the map '{@link org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject#getProperties()
	 * @see #getEPersistenceObject()
	 * @generated
	 */
	EReference getEPersistenceObject_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject#getSupportedLanguages <em>Supported Languages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Supported Languages</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject#getSupportedLanguages()
	 * @see #getEPersistenceObject()
	 * @generated
	 */
	EReference getEPersistenceObject_SupportedLanguages();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.EModelObject <em>EModel Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EModel Object</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModelObject
	 * @generated
	 */
	EClass getEModelObject();

	/**
	 * Returns the meta object for the '{@link org.entframework.javafx.designer.entitydesigner.model.EModelObject#getName() <em>Get Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Name</em>' operation.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModelObject#getName()
	 * @generated
	 */
	EOperation getEModelObject__GetName();

	/**
	 * Returns the meta object for the '{@link org.entframework.javafx.designer.entitydesigner.model.EModelObject#setName(java.lang.String) <em>Set Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Name</em>' operation.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModelObject#setName(java.lang.String)
	 * @generated
	 */
	EOperation getEModelObject__SetName__String();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.EModuleObject <em>EModule Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EModule Object</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModuleObject
	 * @generated
	 */
	EClass getEModuleObject();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getId()
	 * @see #getEModuleObject()
	 * @generated
	 */
	EAttribute getEModuleObject_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getName()
	 * @see #getEModuleObject()
	 * @generated
	 */
	EAttribute getEModuleObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getNamespace()
	 * @see #getEModuleObject()
	 * @generated
	 */
	EAttribute getEModuleObject_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getDescription()
	 * @see #getEModuleObject()
	 * @generated
	 */
	EAttribute getEModuleObject_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getEntities()
	 * @see #getEModuleObject()
	 * @generated
	 */
	EReference getEModuleObject_Entities();

	/**
	 * Returns the meta object for the map '{@link org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModuleObject#getProperties()
	 * @see #getEModuleObject()
	 * @generated
	 */
	EReference getEModuleObject_Properties();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject <em>EEnum Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEnum Object</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumObject
	 * @generated
	 */
	EClass getEEnumObject();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getName()
	 * @see #getEEnumObject()
	 * @generated
	 */
	EAttribute getEEnumObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getDescription()
	 * @see #getEEnumObject()
	 * @generated
	 */
	EAttribute getEEnumObject_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getConstants <em>Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constants</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getConstants()
	 * @see #getEEnumObject()
	 * @generated
	 */
	EReference getEEnumObject_Constants();

	/**
	 * Returns the meta object for the map '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumObject#getProperties()
	 * @see #getEEnumObject()
	 * @generated
	 */
	EReference getEEnumObject_Properties();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject <em>EEnum Literal Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEnum Literal Object</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject
	 * @generated
	 */
	EClass getEEnumLiteralObject();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getLiteral()
	 * @see #getEEnumLiteralObject()
	 * @generated
	 */
	EAttribute getEEnumLiteralObject_Literal();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getName()
	 * @see #getEEnumLiteralObject()
	 * @generated
	 */
	EAttribute getEEnumLiteralObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getValue()
	 * @see #getEEnumLiteralObject()
	 * @generated
	 */
	EAttribute getEEnumLiteralObject_Value();

	/**
	 * Returns the meta object for the map '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject#getProperties()
	 * @see #getEEnumLiteralObject()
	 * @generated
	 */
	EReference getEEnumLiteralObject_Properties();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EProperty Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EProperty Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getEPropertyMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEPropertyMapEntry()
	 * @generated
	 */
	EAttribute getEPropertyMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEPropertyMapEntry()
	 * @generated
	 */
	EAttribute getEPropertyMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship <em>ERelationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ERelationship</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ERelationship
	 * @generated
	 */
	EClass getERelationship();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ERelationship#getId()
	 * @see #getERelationship()
	 * @generated
	 */
	EAttribute getERelationship_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ERelationship#getName()
	 * @see #getERelationship()
	 * @generated
	 */
	EAttribute getERelationship_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ERelationship#getDescription()
	 * @see #getERelationship()
	 * @generated
	 */
	EAttribute getERelationship_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ERelationship#getComment()
	 * @see #getERelationship()
	 * @generated
	 */
	EAttribute getERelationship_Comment();

	/**
	 * Returns the meta object for the reference '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getTargetEntity <em>Target Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Entity</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ERelationship#getTargetEntity()
	 * @see #getERelationship()
	 * @generated
	 */
	EReference getERelationship_TargetEntity();

	/**
	 * Returns the meta object for the reference '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship#getTargetField <em>Target Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Field</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ERelationship#getTargetField()
	 * @see #getERelationship()
	 * @generated
	 */
	EReference getERelationship_TargetField();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn <em>EColumn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EColumn</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EColumn
	 * @generated
	 */
	EClass getEColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EColumn#getId()
	 * @see #getEColumn()
	 * @generated
	 */
	EAttribute getEColumn_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EColumn#getName()
	 * @see #getEColumn()
	 * @generated
	 */
	EAttribute getEColumn_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#isUnique <em>Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EColumn#isUnique()
	 * @see #getEColumn()
	 * @generated
	 */
	EAttribute getEColumn_Unique();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#isNullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nullable</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EColumn#isNullable()
	 * @see #getEColumn()
	 * @generated
	 */
	EAttribute getEColumn_Nullable();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EColumn#getLength()
	 * @see #getEColumn()
	 * @generated
	 */
	EAttribute getEColumn_Length();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getPrecision <em>Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precision</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EColumn#getPrecision()
	 * @see #getEColumn()
	 * @generated
	 */
	EAttribute getEColumn_Precision();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EColumn#getScale()
	 * @see #getEColumn()
	 * @generated
	 */
	EAttribute getEColumn_Scale();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn#getJdbcType <em>Jdbc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jdbc Type</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EColumn#getJdbcType()
	 * @see #getEColumn()
	 * @generated
	 */
	EAttribute getEColumn_JdbcType();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.ETable <em>ETable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETable</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ETable
	 * @generated
	 */
	EClass getETable();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ETable#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ETable#getId()
	 * @see #getETable()
	 * @generated
	 */
	EAttribute getETable_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ETable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ETable#getName()
	 * @see #getETable()
	 * @generated
	 */
	EAttribute getETable_Name();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.ESupportedLanguages <em>ESupported Languages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESupported Languages</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ESupportedLanguages
	 * @generated
	 */
	EClass getESupportedLanguages();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ESupportedLanguages#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ESupportedLanguages#getLanguage()
	 * @see #getESupportedLanguages()
	 * @generated
	 */
	EAttribute getESupportedLanguages_Language();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSettings <em>ELanguage Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELanguage Settings</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageSettings
	 * @generated
	 */
	EClass getELanguageSettings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSettings#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageSettings#getBindings()
	 * @see #getELanguageSettings()
	 * @generated
	 */
	EReference getELanguageSettings_Bindings();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification <em>ELanguage Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELanguage Specification</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification
	 * @generated
	 */
	EClass getELanguageSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getShortName <em>Short Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short Name</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getShortName()
	 * @see #getELanguageSpecification()
	 * @generated
	 */
	EAttribute getELanguageSpecification_ShortName();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#isPrimitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#isPrimitive()
	 * @see #getELanguageSpecification()
	 * @generated
	 */
	EAttribute getELanguageSpecification_Primitive();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getQualifiedName()
	 * @see #getELanguageSpecification()
	 * @generated
	 */
	EAttribute getELanguageSpecification_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification#getLanguage()
	 * @see #getELanguageSpecification()
	 * @generated
	 */
	EAttribute getELanguageSpecification_Language();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes <em>ESupported Jdbc Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESupported Jdbc Types</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes
	 * @generated
	 */
	EClass getESupportedJdbcTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes#getJdbcType <em>Jdbc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jdbc Type</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes#getJdbcType()
	 * @see #getESupportedJdbcTypes()
	 * @generated
	 */
	EAttribute getESupportedJdbcTypes_JdbcType();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>ELanguage Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELanguage Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.entframework.javafx.designer.entitydesigner.model.ELanguage"
	 *        valueType="org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification"
	 * @generated
	 */
	EClass getELanguageMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getELanguageMapEntry()
	 * @generated
	 */
	EAttribute getELanguageMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getELanguageMapEntry()
	 * @generated
	 */
	EReference getELanguageMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding <em>ELanguage Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELanguage Binding</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding
	 * @generated
	 */
	EClass getELanguageBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding#getLanguageSpecification <em>Language Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Language Specification</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding#getLanguageSpecification()
	 * @see #getELanguageBinding()
	 * @generated
	 */
	EReference getELanguageBinding_LanguageSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding#getJdbcTypes <em>Jdbc Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Jdbc Types</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding#getJdbcTypes()
	 * @see #getELanguageBinding()
	 * @generated
	 */
	EReference getELanguageBinding_JdbcTypes();

	/**
	 * Returns the meta object for enum '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguage <em>ELanguage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ELanguage</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguage
	 * @generated
	 */
	EEnum getELanguage();

	/**
	 * Returns the meta object for enum '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationType <em>ERelation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ERelation Type</em>'.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ERelationType
	 * @generated
	 */
	EEnum getERelationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EntityFactory getEntityFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EEntityObjectImpl <em>EEntity Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EEntityObjectImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEEntityObject()
		 * @generated
		 */
		EClass EENTITY_OBJECT = eINSTANCE.getEEntityObject();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENTITY_OBJECT__ID = eINSTANCE.getEEntityObject_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENTITY_OBJECT__NAME = eINSTANCE.getEEntityObject_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENTITY_OBJECT__DESCRIPTION = eINSTANCE.getEEntityObject_Description();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENTITY_OBJECT__COMMENT = eINSTANCE.getEEntityObject_Comment();

		/**
		 * The meta object literal for the '<em><b>Primary Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENTITY_OBJECT__PRIMARY_KEY = eINSTANCE.getEEntityObject_PrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENTITY_OBJECT__TABLE = eINSTANCE.getEEntityObject_Table();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENTITY_OBJECT__FIELDS = eINSTANCE.getEEntityObject_Fields();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENTITY_OBJECT__PROPERTIES = eINSTANCE.getEEntityObject_Properties();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl <em>EField Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEFieldObject()
		 * @generated
		 */
		EClass EFIELD_OBJECT = eINSTANCE.getEFieldObject();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFIELD_OBJECT__ID = eINSTANCE.getEFieldObject_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFIELD_OBJECT__NAME = eINSTANCE.getEFieldObject_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFIELD_OBJECT__DESCRIPTION = eINSTANCE.getEFieldObject_Description();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFIELD_OBJECT__COMMENT = eINSTANCE.getEFieldObject_Comment();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFIELD_OBJECT__PROPERTIES = eINSTANCE.getEFieldObject_Properties();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFIELD_OBJECT__COLUMN = eINSTANCE.getEFieldObject_Column();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFIELD_OBJECT__VERSION = eINSTANCE.getEFieldObject_Version();

		/**
		 * The meta object literal for the '<em><b>Languages</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFIELD_OBJECT__LANGUAGES = eINSTANCE.getEFieldObject_Languages();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EPersistenceObjectImpl <em>EPersistence Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EPersistenceObjectImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEPersistenceObject()
		 * @generated
		 */
		EClass EPERSISTENCE_OBJECT = eINSTANCE.getEPersistenceObject();

		/**
		 * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPERSISTENCE_OBJECT__MODULES = eINSTANCE.getEPersistenceObject_Modules();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPERSISTENCE_OBJECT__PROPERTIES = eINSTANCE.getEPersistenceObject_Properties();

		/**
		 * The meta object literal for the '<em><b>Supported Languages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPERSISTENCE_OBJECT__SUPPORTED_LANGUAGES = eINSTANCE.getEPersistenceObject_SupportedLanguages();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.EModelObject <em>EModel Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.EModelObject
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEModelObject()
		 * @generated
		 */
		EClass EMODEL_OBJECT = eINSTANCE.getEModelObject();

		/**
		 * The meta object literal for the '<em><b>Get Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EMODEL_OBJECT___GET_NAME = eINSTANCE.getEModelObject__GetName();

		/**
		 * The meta object literal for the '<em><b>Set Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EMODEL_OBJECT___SET_NAME__STRING = eINSTANCE.getEModelObject__SetName__String();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EModuleObjectImpl <em>EModule Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EModuleObjectImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEModuleObject()
		 * @generated
		 */
		EClass EMODULE_OBJECT = eINSTANCE.getEModuleObject();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMODULE_OBJECT__ID = eINSTANCE.getEModuleObject_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMODULE_OBJECT__NAME = eINSTANCE.getEModuleObject_Name();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMODULE_OBJECT__NAMESPACE = eINSTANCE.getEModuleObject_Namespace();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMODULE_OBJECT__DESCRIPTION = eINSTANCE.getEModuleObject_Description();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMODULE_OBJECT__ENTITIES = eINSTANCE.getEModuleObject_Entities();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMODULE_OBJECT__PROPERTIES = eINSTANCE.getEModuleObject_Properties();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EEnumObjectImpl <em>EEnum Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EEnumObjectImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEEnumObject()
		 * @generated
		 */
		EClass EENUM_OBJECT = eINSTANCE.getEEnumObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENUM_OBJECT__NAME = eINSTANCE.getEEnumObject_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENUM_OBJECT__DESCRIPTION = eINSTANCE.getEEnumObject_Description();

		/**
		 * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENUM_OBJECT__CONSTANTS = eINSTANCE.getEEnumObject_Constants();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENUM_OBJECT__PROPERTIES = eINSTANCE.getEEnumObject_Properties();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EEnumLiteralObjectImpl <em>EEnum Literal Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EEnumLiteralObjectImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEEnumLiteralObject()
		 * @generated
		 */
		EClass EENUM_LITERAL_OBJECT = eINSTANCE.getEEnumLiteralObject();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENUM_LITERAL_OBJECT__LITERAL = eINSTANCE.getEEnumLiteralObject_Literal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENUM_LITERAL_OBJECT__NAME = eINSTANCE.getEEnumLiteralObject_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENUM_LITERAL_OBJECT__VALUE = eINSTANCE.getEEnumLiteralObject_Value();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENUM_LITERAL_OBJECT__PROPERTIES = eINSTANCE.getEEnumLiteralObject_Properties();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EPropertyMapEntryImpl <em>EProperty Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EPropertyMapEntryImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEPropertyMapEntry()
		 * @generated
		 */
		EClass EPROPERTY_MAP_ENTRY = eINSTANCE.getEPropertyMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROPERTY_MAP_ENTRY__KEY = eINSTANCE.getEPropertyMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROPERTY_MAP_ENTRY__VALUE = eINSTANCE.getEPropertyMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ERelationshipImpl <em>ERelationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ERelationshipImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getERelationship()
		 * @generated
		 */
		EClass ERELATIONSHIP = eINSTANCE.getERelationship();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERELATIONSHIP__ID = eINSTANCE.getERelationship_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERELATIONSHIP__NAME = eINSTANCE.getERelationship_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERELATIONSHIP__DESCRIPTION = eINSTANCE.getERelationship_Description();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERELATIONSHIP__COMMENT = eINSTANCE.getERelationship_Comment();

		/**
		 * The meta object literal for the '<em><b>Target Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERELATIONSHIP__TARGET_ENTITY = eINSTANCE.getERelationship_TargetEntity();

		/**
		 * The meta object literal for the '<em><b>Target Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERELATIONSHIP__TARGET_FIELD = eINSTANCE.getERelationship_TargetField();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.EColumnImpl <em>EColumn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EColumnImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getEColumn()
		 * @generated
		 */
		EClass ECOLUMN = eINSTANCE.getEColumn();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECOLUMN__ID = eINSTANCE.getEColumn_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECOLUMN__NAME = eINSTANCE.getEColumn_Name();

		/**
		 * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECOLUMN__UNIQUE = eINSTANCE.getEColumn_Unique();

		/**
		 * The meta object literal for the '<em><b>Nullable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECOLUMN__NULLABLE = eINSTANCE.getEColumn_Nullable();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECOLUMN__LENGTH = eINSTANCE.getEColumn_Length();

		/**
		 * The meta object literal for the '<em><b>Precision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECOLUMN__PRECISION = eINSTANCE.getEColumn_Precision();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECOLUMN__SCALE = eINSTANCE.getEColumn_Scale();

		/**
		 * The meta object literal for the '<em><b>Jdbc Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECOLUMN__JDBC_TYPE = eINSTANCE.getEColumn_JdbcType();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ETableImpl <em>ETable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ETableImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getETable()
		 * @generated
		 */
		EClass ETABLE = eINSTANCE.getETable();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETABLE__ID = eINSTANCE.getETable_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETABLE__NAME = eINSTANCE.getETable_Name();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ESupportedLanguagesImpl <em>ESupported Languages</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ESupportedLanguagesImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getESupportedLanguages()
		 * @generated
		 */
		EClass ESUPPORTED_LANGUAGES = eINSTANCE.getESupportedLanguages();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESUPPORTED_LANGUAGES__LANGUAGE = eINSTANCE.getESupportedLanguages_Language();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSettingsImpl <em>ELanguage Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSettingsImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getELanguageSettings()
		 * @generated
		 */
		EClass ELANGUAGE_SETTINGS = eINSTANCE.getELanguageSettings();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELANGUAGE_SETTINGS__BINDINGS = eINSTANCE.getELanguageSettings_Bindings();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSpecificationImpl <em>ELanguage Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSpecificationImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getELanguageSpecification()
		 * @generated
		 */
		EClass ELANGUAGE_SPECIFICATION = eINSTANCE.getELanguageSpecification();

		/**
		 * The meta object literal for the '<em><b>Short Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELANGUAGE_SPECIFICATION__SHORT_NAME = eINSTANCE.getELanguageSpecification_ShortName();

		/**
		 * The meta object literal for the '<em><b>Primitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELANGUAGE_SPECIFICATION__PRIMITIVE = eINSTANCE.getELanguageSpecification_Primitive();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELANGUAGE_SPECIFICATION__QUALIFIED_NAME = eINSTANCE.getELanguageSpecification_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELANGUAGE_SPECIFICATION__LANGUAGE = eINSTANCE.getELanguageSpecification_Language();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ESupportedJdbcTypesImpl <em>ESupported Jdbc Types</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ESupportedJdbcTypesImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getESupportedJdbcTypes()
		 * @generated
		 */
		EClass ESUPPORTED_JDBC_TYPES = eINSTANCE.getESupportedJdbcTypes();

		/**
		 * The meta object literal for the '<em><b>Jdbc Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESUPPORTED_JDBC_TYPES__JDBC_TYPE = eINSTANCE.getESupportedJdbcTypes_JdbcType();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageMapEntryImpl <em>ELanguage Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageMapEntryImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getELanguageMapEntry()
		 * @generated
		 */
		EClass ELANGUAGE_MAP_ENTRY = eINSTANCE.getELanguageMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELANGUAGE_MAP_ENTRY__KEY = eINSTANCE.getELanguageMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELANGUAGE_MAP_ENTRY__VALUE = eINSTANCE.getELanguageMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageBindingImpl <em>ELanguage Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageBindingImpl
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getELanguageBinding()
		 * @generated
		 */
		EClass ELANGUAGE_BINDING = eINSTANCE.getELanguageBinding();

		/**
		 * The meta object literal for the '<em><b>Language Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION = eINSTANCE.getELanguageBinding_LanguageSpecification();

		/**
		 * The meta object literal for the '<em><b>Jdbc Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELANGUAGE_BINDING__JDBC_TYPES = eINSTANCE.getELanguageBinding_JdbcTypes();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguage <em>ELanguage</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguage
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getELanguage()
		 * @generated
		 */
		EEnum ELANGUAGE = eINSTANCE.getELanguage();

		/**
		 * The meta object literal for the '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationType <em>ERelation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.entframework.javafx.designer.entitydesigner.model.ERelationType
		 * @see org.entframework.javafx.designer.entitydesigner.model.impl.EntityPackageImpl#getERelationType()
		 * @generated
		 */
		EEnum ERELATION_TYPE = eINSTANCE.getERelationType();

	}

} //EntityPackage
