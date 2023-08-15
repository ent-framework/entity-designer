/**
 */
package org.entframework.javafx.designer.entitydesigner.model.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.entframework.javafx.designer.entitydesigner.model.EModuleObject;
import org.entframework.javafx.designer.entitydesigner.model.EPersistenceObject;
import org.entframework.javafx.designer.entitydesigner.model.ESupportedLanguages;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EPersistence Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.EPersistenceObjectImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.EPersistenceObjectImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.EPersistenceObjectImpl#getSupportedLanguages <em>Supported Languages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EPersistenceObjectImpl extends MinimalEObjectImpl.Container implements EPersistenceObject {
	/**
	 * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModules()
	 * @generated
	 * @ordered
	 */
	protected EList<EModuleObject> modules;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> properties;

	/**
	 * The cached value of the '{@link #getSupportedLanguages() <em>Supported Languages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedLanguages()
	 * @generated
	 * @ordered
	 */
	protected EList<ESupportedLanguages> supportedLanguages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPersistenceObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.EPERSISTENCE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EModuleObject> getModules() {
		if (modules == null) {
			modules = new EObjectContainmentEList<EModuleObject>(EModuleObject.class, this, EntityPackage.EPERSISTENCE_OBJECT__MODULES);
		}
		return modules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, String> getProperties() {
		if (properties == null) {
			properties = new EcoreEMap<String,String>(EntityPackage.Literals.EPROPERTY_MAP_ENTRY, EPropertyMapEntryImpl.class, this, EntityPackage.EPERSISTENCE_OBJECT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ESupportedLanguages> getSupportedLanguages() {
		if (supportedLanguages == null) {
			supportedLanguages = new EObjectContainmentEList<ESupportedLanguages>(ESupportedLanguages.class, this, EntityPackage.EPERSISTENCE_OBJECT__SUPPORTED_LANGUAGES);
		}
		return supportedLanguages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EntityPackage.EPERSISTENCE_OBJECT__MODULES:
				return ((InternalEList<?>)getModules()).basicRemove(otherEnd, msgs);
			case EntityPackage.EPERSISTENCE_OBJECT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case EntityPackage.EPERSISTENCE_OBJECT__SUPPORTED_LANGUAGES:
				return ((InternalEList<?>)getSupportedLanguages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EntityPackage.EPERSISTENCE_OBJECT__MODULES:
				return getModules();
			case EntityPackage.EPERSISTENCE_OBJECT__PROPERTIES:
				if (coreType) return getProperties();
				else return getProperties().map();
			case EntityPackage.EPERSISTENCE_OBJECT__SUPPORTED_LANGUAGES:
				return getSupportedLanguages();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EntityPackage.EPERSISTENCE_OBJECT__MODULES:
				getModules().clear();
				getModules().addAll((Collection<? extends EModuleObject>)newValue);
				return;
			case EntityPackage.EPERSISTENCE_OBJECT__PROPERTIES:
				((EStructuralFeature.Setting)getProperties()).set(newValue);
				return;
			case EntityPackage.EPERSISTENCE_OBJECT__SUPPORTED_LANGUAGES:
				getSupportedLanguages().clear();
				getSupportedLanguages().addAll((Collection<? extends ESupportedLanguages>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EntityPackage.EPERSISTENCE_OBJECT__MODULES:
				getModules().clear();
				return;
			case EntityPackage.EPERSISTENCE_OBJECT__PROPERTIES:
				getProperties().clear();
				return;
			case EntityPackage.EPERSISTENCE_OBJECT__SUPPORTED_LANGUAGES:
				getSupportedLanguages().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EntityPackage.EPERSISTENCE_OBJECT__MODULES:
				return modules != null && !modules.isEmpty();
			case EntityPackage.EPERSISTENCE_OBJECT__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case EntityPackage.EPERSISTENCE_OBJECT__SUPPORTED_LANGUAGES:
				return supportedLanguages != null && !supportedLanguages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EntityPackage.EPERSISTENCE_OBJECT___GET_NAME:
				return getName();
			case EntityPackage.EPERSISTENCE_OBJECT___SET_NAME__STRING:
				setName((String)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //EPersistenceObjectImpl
