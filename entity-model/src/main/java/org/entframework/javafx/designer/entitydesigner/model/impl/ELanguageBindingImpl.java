/**
 */
package org.entframework.javafx.designer.entitydesigner.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.entframework.javafx.designer.entitydesigner.model.ELanguageBinding;
import org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification;
import org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ELanguage Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageBindingImpl#getLanguageSpecification <em>Language Specification</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageBindingImpl#getJdbcTypes <em>Jdbc Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ELanguageBindingImpl extends MinimalEObjectImpl.Container implements ELanguageBinding {
	/**
	 * The cached value of the '{@link #getLanguageSpecification() <em>Language Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageSpecification()
	 * @generated
	 * @ordered
	 */
	protected ELanguageSpecification languageSpecification;

	/**
	 * The cached value of the '{@link #getJdbcTypes() <em>Jdbc Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJdbcTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ESupportedJdbcTypes> jdbcTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ELanguageBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.ELANGUAGE_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ELanguageSpecification getLanguageSpecification() {
		return languageSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLanguageSpecification(ELanguageSpecification newLanguageSpecification, NotificationChain msgs) {
		ELanguageSpecification oldLanguageSpecification = languageSpecification;
		languageSpecification = newLanguageSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EntityPackage.ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION, oldLanguageSpecification, newLanguageSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLanguageSpecification(ELanguageSpecification newLanguageSpecification) {
		if (newLanguageSpecification != languageSpecification) {
			NotificationChain msgs = null;
			if (languageSpecification != null)
				msgs = ((InternalEObject)languageSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EntityPackage.ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION, null, msgs);
			if (newLanguageSpecification != null)
				msgs = ((InternalEObject)newLanguageSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EntityPackage.ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION, null, msgs);
			msgs = basicSetLanguageSpecification(newLanguageSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION, newLanguageSpecification, newLanguageSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ESupportedJdbcTypes> getJdbcTypes() {
		if (jdbcTypes == null) {
			jdbcTypes = new EObjectContainmentEList<ESupportedJdbcTypes>(ESupportedJdbcTypes.class, this, EntityPackage.ELANGUAGE_BINDING__JDBC_TYPES);
		}
		return jdbcTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EntityPackage.ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION:
				return basicSetLanguageSpecification(null, msgs);
			case EntityPackage.ELANGUAGE_BINDING__JDBC_TYPES:
				return ((InternalEList<?>)getJdbcTypes()).basicRemove(otherEnd, msgs);
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
			case EntityPackage.ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION:
				return getLanguageSpecification();
			case EntityPackage.ELANGUAGE_BINDING__JDBC_TYPES:
				return getJdbcTypes();
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
			case EntityPackage.ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION:
				setLanguageSpecification((ELanguageSpecification)newValue);
				return;
			case EntityPackage.ELANGUAGE_BINDING__JDBC_TYPES:
				getJdbcTypes().clear();
				getJdbcTypes().addAll((Collection<? extends ESupportedJdbcTypes>)newValue);
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
			case EntityPackage.ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION:
				setLanguageSpecification((ELanguageSpecification)null);
				return;
			case EntityPackage.ELANGUAGE_BINDING__JDBC_TYPES:
				getJdbcTypes().clear();
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
			case EntityPackage.ELANGUAGE_BINDING__LANGUAGE_SPECIFICATION:
				return languageSpecification != null;
			case EntityPackage.ELANGUAGE_BINDING__JDBC_TYPES:
				return jdbcTypes != null && !jdbcTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ELanguageBindingImpl
