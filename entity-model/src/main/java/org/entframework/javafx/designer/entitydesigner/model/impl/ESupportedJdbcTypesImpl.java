/**
 */
package org.entframework.javafx.designer.entitydesigner.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.entframework.javafx.designer.entitydesigner.model.ESupportedJdbcTypes;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESupported Jdbc Types</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.ESupportedJdbcTypesImpl#getJdbcType <em>Jdbc Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ESupportedJdbcTypesImpl extends MinimalEObjectImpl.Container implements ESupportedJdbcTypes {
	/**
	 * The default value of the '{@link #getJdbcType() <em>Jdbc Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJdbcType()
	 * @generated
	 * @ordered
	 */
	protected static final int JDBC_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getJdbcType() <em>Jdbc Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJdbcType()
	 * @generated
	 * @ordered
	 */
	protected int jdbcType = JDBC_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESupportedJdbcTypesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.ESUPPORTED_JDBC_TYPES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getJdbcType() {
		return jdbcType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJdbcType(int newJdbcType) {
		int oldJdbcType = jdbcType;
		jdbcType = newJdbcType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.ESUPPORTED_JDBC_TYPES__JDBC_TYPE, oldJdbcType, jdbcType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EntityPackage.ESUPPORTED_JDBC_TYPES__JDBC_TYPE:
				return getJdbcType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EntityPackage.ESUPPORTED_JDBC_TYPES__JDBC_TYPE:
				setJdbcType((Integer)newValue);
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
			case EntityPackage.ESUPPORTED_JDBC_TYPES__JDBC_TYPE:
				setJdbcType(JDBC_TYPE_EDEFAULT);
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
			case EntityPackage.ESUPPORTED_JDBC_TYPES__JDBC_TYPE:
				return jdbcType != JDBC_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (jdbcType: ");
		result.append(jdbcType);
		result.append(')');
		return result.toString();
	}

} //ESupportedJdbcTypesImpl
