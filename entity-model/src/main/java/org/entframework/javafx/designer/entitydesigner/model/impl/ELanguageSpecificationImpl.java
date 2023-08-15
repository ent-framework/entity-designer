/**
 */
package org.entframework.javafx.designer.entitydesigner.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.entframework.javafx.designer.entitydesigner.model.ELanguage;
import org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ELanguage Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSpecificationImpl#getShortName <em>Short Name</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSpecificationImpl#isPrimitive <em>Primitive</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSpecificationImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.ELanguageSpecificationImpl#getLanguage <em>Language</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ELanguageSpecificationImpl extends MinimalEObjectImpl.Container implements ELanguageSpecification {
	/**
	 * The default value of the '{@link #getShortName() <em>Short Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortName()
	 * @generated
	 * @ordered
	 */
	protected static final String SHORT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShortName() <em>Short Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortName()
	 * @generated
	 * @ordered
	 */
	protected String shortName = SHORT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isPrimitive() <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIMITIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrimitive() <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimitive()
	 * @generated
	 * @ordered
	 */
	protected boolean primitive = PRIMITIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final ELanguage LANGUAGE_EDEFAULT = ELanguage.JAVA;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected ELanguage language = LANGUAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ELanguageSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.ELANGUAGE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getShortName() {
		return shortName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShortName(String newShortName) {
		String oldShortName = shortName;
		shortName = newShortName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.ELANGUAGE_SPECIFICATION__SHORT_NAME, oldShortName, shortName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPrimitive() {
		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitive(boolean newPrimitive) {
		boolean oldPrimitive = primitive;
		primitive = newPrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.ELANGUAGE_SPECIFICATION__PRIMITIVE, oldPrimitive, primitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.ELANGUAGE_SPECIFICATION__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ELanguage getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLanguage(ELanguage newLanguage) {
		ELanguage oldLanguage = language;
		language = newLanguage == null ? LANGUAGE_EDEFAULT : newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.ELANGUAGE_SPECIFICATION__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EntityPackage.ELANGUAGE_SPECIFICATION__SHORT_NAME:
				return getShortName();
			case EntityPackage.ELANGUAGE_SPECIFICATION__PRIMITIVE:
				return isPrimitive();
			case EntityPackage.ELANGUAGE_SPECIFICATION__QUALIFIED_NAME:
				return getQualifiedName();
			case EntityPackage.ELANGUAGE_SPECIFICATION__LANGUAGE:
				return getLanguage();
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
			case EntityPackage.ELANGUAGE_SPECIFICATION__SHORT_NAME:
				setShortName((String)newValue);
				return;
			case EntityPackage.ELANGUAGE_SPECIFICATION__PRIMITIVE:
				setPrimitive((Boolean)newValue);
				return;
			case EntityPackage.ELANGUAGE_SPECIFICATION__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case EntityPackage.ELANGUAGE_SPECIFICATION__LANGUAGE:
				setLanguage((ELanguage)newValue);
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
			case EntityPackage.ELANGUAGE_SPECIFICATION__SHORT_NAME:
				setShortName(SHORT_NAME_EDEFAULT);
				return;
			case EntityPackage.ELANGUAGE_SPECIFICATION__PRIMITIVE:
				setPrimitive(PRIMITIVE_EDEFAULT);
				return;
			case EntityPackage.ELANGUAGE_SPECIFICATION__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case EntityPackage.ELANGUAGE_SPECIFICATION__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
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
			case EntityPackage.ELANGUAGE_SPECIFICATION__SHORT_NAME:
				return SHORT_NAME_EDEFAULT == null ? shortName != null : !SHORT_NAME_EDEFAULT.equals(shortName);
			case EntityPackage.ELANGUAGE_SPECIFICATION__PRIMITIVE:
				return primitive != PRIMITIVE_EDEFAULT;
			case EntityPackage.ELANGUAGE_SPECIFICATION__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case EntityPackage.ELANGUAGE_SPECIFICATION__LANGUAGE:
				return language != LANGUAGE_EDEFAULT;
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
		result.append(" (shortName: ");
		result.append(shortName);
		result.append(", primitive: ");
		result.append(primitive);
		result.append(", qualifiedName: ");
		result.append(qualifiedName);
		result.append(", language: ");
		result.append(language);
		result.append(')');
		return result.toString();
	}

} //ELanguageSpecificationImpl
