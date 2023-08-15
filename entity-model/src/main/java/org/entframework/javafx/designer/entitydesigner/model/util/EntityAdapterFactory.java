/**
 */
package org.entframework.javafx.designer.entitydesigner.model.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.entframework.javafx.designer.entitydesigner.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage
 * @generated
 */
public class EntityAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EntityPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EntityPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntitySwitch<Adapter> modelSwitch =
		new EntitySwitch<Adapter>() {
			@Override
			public Adapter caseEEntityObject(EEntityObject object) {
				return createEEntityObjectAdapter();
			}
			@Override
			public Adapter caseEFieldObject(EFieldObject object) {
				return createEFieldObjectAdapter();
			}
			@Override
			public Adapter caseEPersistenceObject(EPersistenceObject object) {
				return createEPersistenceObjectAdapter();
			}
			@Override
			public Adapter caseEModelObject(EModelObject object) {
				return createEModelObjectAdapter();
			}
			@Override
			public Adapter caseEModuleObject(EModuleObject object) {
				return createEModuleObjectAdapter();
			}
			@Override
			public Adapter caseEEnumObject(EEnumObject object) {
				return createEEnumObjectAdapter();
			}
			@Override
			public Adapter caseEEnumLiteralObject(EEnumLiteralObject object) {
				return createEEnumLiteralObjectAdapter();
			}
			@Override
			public Adapter caseEPropertyMapEntry(Map.Entry<String, String> object) {
				return createEPropertyMapEntryAdapter();
			}
			@Override
			public Adapter caseERelationship(ERelationship object) {
				return createERelationshipAdapter();
			}
			@Override
			public Adapter caseEColumn(EColumn object) {
				return createEColumnAdapter();
			}
			@Override
			public Adapter caseETable(ETable object) {
				return createETableAdapter();
			}
			@Override
			public Adapter caseESupportedLanguages(ESupportedLanguages object) {
				return createESupportedLanguagesAdapter();
			}
			@Override
			public Adapter caseELanguageSettings(ELanguageSettings object) {
				return createELanguageSettingsAdapter();
			}
			@Override
			public Adapter caseELanguageSpecification(ELanguageSpecification object) {
				return createELanguageSpecificationAdapter();
			}
			@Override
			public Adapter caseESupportedJdbcTypes(ESupportedJdbcTypes object) {
				return createESupportedJdbcTypesAdapter();
			}
			@Override
			public Adapter caseELanguageMapEntry(Map.Entry<ELanguage, ELanguageSpecification> object) {
				return createELanguageMapEntryAdapter();
			}
			@Override
			public Adapter caseELanguageBinding(ELanguageBinding object) {
				return createELanguageBindingAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.EEntityObject <em>EEntity Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEntityObject
	 * @generated
	 */
	public Adapter createEEntityObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.EFieldObject <em>EField Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EFieldObject
	 * @generated
	 */
	public Adapter createEFieldObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject <em>EPersistence Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject
	 * @generated
	 */
	public Adapter createEPersistenceObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.EModelObject <em>EModel Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModelObject
	 * @generated
	 */
	public Adapter createEModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.EModuleObject <em>EModule Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EModuleObject
	 * @generated
	 */
	public Adapter createEModuleObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumObject <em>EEnum Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumObject
	 * @generated
	 */
	public Adapter createEEnumObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject <em>EEnum Literal Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EEnumLiteralObject
	 * @generated
	 */
	public Adapter createEEnumLiteralObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EProperty Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEPropertyMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.ERelationship <em>ERelationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ERelationship
	 * @generated
	 */
	public Adapter createERelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.EColumn <em>EColumn</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.EColumn
	 * @generated
	 */
	public Adapter createEColumnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.ETable <em>ETable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ETable
	 * @generated
	 */
	public Adapter createETableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.ESupportedLanguages <em>ESupported Languages</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ESupportedLanguages
	 * @generated
	 */
	public Adapter createESupportedLanguagesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSettings <em>ELanguage Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageSettings
	 * @generated
	 */
	public Adapter createELanguageSettingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification <em>ELanguage Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification
	 * @generated
	 */
	public Adapter createELanguageSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes <em>ESupported Jdbc Types</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes
	 * @generated
	 */
	public Adapter createESupportedJdbcTypesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>ELanguage Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createELanguageMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding <em>ELanguage Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding
	 * @generated
	 */
	public Adapter createELanguageBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EntityAdapterFactory
