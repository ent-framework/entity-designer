/**
 */
package org.entframework.javafx.designer.entitydesigner.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.entframework.javafx.designer.entitydesigner.model.EColumn;
import org.entframework.javafx.designer.entitydesigner.model.EFieldObject;
import org.entframework.javafx.designer.entitydesigner.model.ELanguage;
import org.entframework.javafx.designer.entitydesigner.model.ELanguageSpecification;
import org.entframework.javafx.designer.entitydesigner.model.EntityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EField Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl#isVersion <em>Version</em>}</li>
 *   <li>{@link org.entframework.javafx.designer.entitydesigner.model.impl.EFieldObjectImpl#getLanguages <em>Languages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EFieldObjectImpl extends MinimalEObjectImpl.Container implements EFieldObject {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

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
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected EColumn column;

	/**
	 * The default value of the '{@link #isVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVersion()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VERSION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVersion()
	 * @generated
	 * @ordered
	 */
	protected boolean version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLanguages() <em>Languages</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguages()
	 * @generated
	 * @ordered
	 */
	protected EMap<ELanguage, ELanguageSpecification> languages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFieldObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.EFIELD_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.EFIELD_OBJECT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.EFIELD_OBJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.EFIELD_OBJECT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.EFIELD_OBJECT__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, String> getProperties() {
		if (properties == null) {
			properties = new EcoreEMap<String,String>(EntityPackage.Literals.EPROPERTY_MAP_ENTRY, EPropertyMapEntryImpl.class, this, EntityPackage.EFIELD_OBJECT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EColumn getColumn() {
		if (column != null && column.eIsProxy()) {
			InternalEObject oldColumn = (InternalEObject)column;
			column = (EColumn)eResolveProxy(oldColumn);
			if (column != oldColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EntityPackage.EFIELD_OBJECT__COLUMN, oldColumn, column));
			}
		}
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EColumn basicGetColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColumn(EColumn newColumn) {
		EColumn oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.EFIELD_OBJECT__COLUMN, oldColumn, column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(boolean newVersion) {
		boolean oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.EFIELD_OBJECT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<ELanguage, ELanguageSpecification> getLanguages() {
		if (languages == null) {
			languages = new EcoreEMap<ELanguage,ELanguageSpecification>(EntityPackage.Literals.ELANGUAGE_MAP_ENTRY, ELanguageMapEntryImpl.class, this, EntityPackage.EFIELD_OBJECT__LANGUAGES);
		}
		return languages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EntityPackage.EFIELD_OBJECT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case EntityPackage.EFIELD_OBJECT__LANGUAGES:
				return ((InternalEList<?>)getLanguages()).basicRemove(otherEnd, msgs);
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
			case EntityPackage.EFIELD_OBJECT__ID:
				return getId();
			case EntityPackage.EFIELD_OBJECT__NAME:
				return getName();
			case EntityPackage.EFIELD_OBJECT__DESCRIPTION:
				return getDescription();
			case EntityPackage.EFIELD_OBJECT__COMMENT:
				return getComment();
			case EntityPackage.EFIELD_OBJECT__PROPERTIES:
				if (coreType) return getProperties();
				else return getProperties().map();
			case EntityPackage.EFIELD_OBJECT__COLUMN:
				if (resolve) return getColumn();
				return basicGetColumn();
			case EntityPackage.EFIELD_OBJECT__VERSION:
				return isVersion();
			case EntityPackage.EFIELD_OBJECT__LANGUAGES:
				if (coreType) return getLanguages();
				else return getLanguages().map();
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
			case EntityPackage.EFIELD_OBJECT__ID:
				setId((String)newValue);
				return;
			case EntityPackage.EFIELD_OBJECT__NAME:
				setName((String)newValue);
				return;
			case EntityPackage.EFIELD_OBJECT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case EntityPackage.EFIELD_OBJECT__COMMENT:
				setComment((String)newValue);
				return;
			case EntityPackage.EFIELD_OBJECT__PROPERTIES:
				((EStructuralFeature.Setting)getProperties()).set(newValue);
				return;
			case EntityPackage.EFIELD_OBJECT__COLUMN:
				setColumn((EColumn)newValue);
				return;
			case EntityPackage.EFIELD_OBJECT__VERSION:
				setVersion((Boolean)newValue);
				return;
			case EntityPackage.EFIELD_OBJECT__LANGUAGES:
				((EStructuralFeature.Setting)getLanguages()).set(newValue);
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
			case EntityPackage.EFIELD_OBJECT__ID:
				setId(ID_EDEFAULT);
				return;
			case EntityPackage.EFIELD_OBJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EntityPackage.EFIELD_OBJECT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case EntityPackage.EFIELD_OBJECT__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case EntityPackage.EFIELD_OBJECT__PROPERTIES:
				getProperties().clear();
				return;
			case EntityPackage.EFIELD_OBJECT__COLUMN:
				setColumn((EColumn)null);
				return;
			case EntityPackage.EFIELD_OBJECT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case EntityPackage.EFIELD_OBJECT__LANGUAGES:
				getLanguages().clear();
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
			case EntityPackage.EFIELD_OBJECT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case EntityPackage.EFIELD_OBJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EntityPackage.EFIELD_OBJECT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case EntityPackage.EFIELD_OBJECT__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case EntityPackage.EFIELD_OBJECT__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case EntityPackage.EFIELD_OBJECT__COLUMN:
				return column != null;
			case EntityPackage.EFIELD_OBJECT__VERSION:
				return version != VERSION_EDEFAULT;
			case EntityPackage.EFIELD_OBJECT__LANGUAGES:
				return languages != null && !languages.isEmpty();
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
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", comment: ");
		result.append(comment);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //EFieldObjectImpl
