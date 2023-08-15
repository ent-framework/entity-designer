/**
 */
package org.entframework.javafx.designer.entitydesigner.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ELanguage</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.entframework.javafx.designer.entitydesigner.model.EntityPackage#getELanguage()
 * @model
 * @generated
 */
public enum ELanguage implements Enumerator {
	/**
	 * The '<em><b>Java</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JAVA_VALUE
	 * @generated
	 * @ordered
	 */
	JAVA(0, "Java", "JAVA"), /**
	 * The '<em><b>Kotlin</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KOTLIN_VALUE
	 * @generated
	 * @ordered
	 */
	KOTLIN(1, "Kotlin", "KOTLIN"),

	/**
	 * The '<em><b>Dot Net</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOT_NET_VALUE
	 * @generated
	 * @ordered
	 */
	DOT_NET(2, "DotNet", "DotNet");

	/**
	 * The '<em><b>Java</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JAVA
	 * @model name="Java" literal="JAVA"
	 * @generated
	 * @ordered
	 */
	public static final int JAVA_VALUE = 0;

	/**
	 * The '<em><b>Kotlin</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KOTLIN
	 * @model name="Kotlin" literal="KOTLIN"
	 * @generated
	 * @ordered
	 */
	public static final int KOTLIN_VALUE = 1;

	/**
	 * The '<em><b>Dot Net</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOT_NET
	 * @model name="DotNet"
	 * @generated
	 * @ordered
	 */
	public static final int DOT_NET_VALUE = 2;

	/**
	 * An array of all the '<em><b>ELanguage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ELanguage[] VALUES_ARRAY =
		new ELanguage[] {
			JAVA,
			KOTLIN,
			DOT_NET,
		};

	/**
	 * A public read-only list of all the '<em><b>ELanguage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ELanguage> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ELanguage</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ELanguage get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ELanguage result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ELanguage</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ELanguage getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ELanguage result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ELanguage</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ELanguage get(int value) {
		switch (value) {
			case JAVA_VALUE: return JAVA;
			case KOTLIN_VALUE: return KOTLIN;
			case DOT_NET_VALUE: return DOT_NET;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ELanguage(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ELanguage
