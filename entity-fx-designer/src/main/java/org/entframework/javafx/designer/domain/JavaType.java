/*
 * Copyright (c) 2023. Licensed under the Apache License, Version 2.0.
 */

package org.entframework.javafx.designer.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class JavaType implements Comparable<JavaType> {

    private static final String JAVA_LANG = "java.lang"; //$NON-NLS-1$

    private static JavaType intInstance = null;

    private static JavaType stringInstance = null;

    private static JavaType booleanPrimitiveInstance = null;

    private static JavaType objectInstance = null;

    private static JavaType dateInstance = null;

    private static JavaType criteriaInstance = null;

    private static JavaType generatedCriteriaInstance = null;
    private final List<JavaType> typeArguments;
    /**
     * The short name without any generic arguments.
     */
    private String baseShortName;
    /**
     * The fully qualified name without any generic arguments.
     */
    private String baseQualifiedName;
    private boolean explicitlyImported;
    private String packageName;
    private boolean primitive;
    private boolean isArray;
    private PrimitiveTypeImplWrapper primitiveTypeWrapper;
    // the following three values are used for dealing with wildcard types
    private boolean wildcardType;

    private boolean boundedWildcard;

    private boolean extendsBoundedWildcard;

    /**
     * Use this constructor to construct a generic type with the specified type
     * parameters.
     *
     * @param fullTypeSpecification the full type specification
     */
    public JavaType(String fullTypeSpecification) {
        super();
        typeArguments = new ArrayList<>();
        parse(fullTypeSpecification);
    }

    /**
     * Returns the package name of a fully qualified type.
     *
     * <p>
     * This method calculates the package as the part of the fully qualified name up to,
     * but not including, the last element. Therefore, it does not support fully qualified
     * inner classes. Not totally fool proof, but correct in most instances.
     *
     * @param baseQualifiedName the base qualified name
     * @return the package
     */
    private static String getPackage(String baseQualifiedName) {
        int index = baseQualifiedName.lastIndexOf('.');
        return baseQualifiedName.substring(0, index);
    }

    public boolean isExplicitlyImported() {
        return explicitlyImported;
    }

    /**
     * Returns the fully qualified name - including any generic type parameters.
     *
     * @return Returns the fullyQualifiedName.
     */

    public String getFullyQualifiedName() {
        StringBuilder sb = new StringBuilder();
        if (wildcardType) {
            sb.append('?');
            if (boundedWildcard) {
                if (extendsBoundedWildcard) {
                    sb.append(" extends "); //$NON-NLS-1$
                } else {
                    sb.append(" super "); //$NON-NLS-1$
                }

                sb.append(baseQualifiedName);
            }
        } else {
            sb.append(baseQualifiedName);
        }

        if (!typeArguments.isEmpty()) {
            boolean first = true;
            sb.append('<');
            for (JavaType fqjt : typeArguments) {
                if (first) {
                    first = false;
                } else {
                    sb.append(", "); //$NON-NLS-1$
                }
                sb.append(fqjt.getFullyQualifiedName());

            }
            sb.append('>');
        }

        return sb.toString();
    }

    public String getFullyQualifiedNameWithoutTypeParameters() {
        return baseQualifiedName;
    }

    /**
     * Returns a list of Strings that are the fully qualified names of this type, and any
     * generic type argument associated with this type.
     *
     * @return the import list
     */

    public List<String> getImportList() {
        List<String> answer = new ArrayList<>();
        if (isExplicitlyImported()) {
            int index = baseShortName.indexOf('.');
            if (index == -1) {
                answer.add(calculateActualImport(baseQualifiedName));
            } else {
                // an inner class is specified, only import the top
                // level class
                String sb = packageName + '.' + calculateActualImport(baseShortName.substring(0, index));
                answer.add(sb);
            }
        }

        for (JavaType fqjt : typeArguments) {
            answer.addAll(fqjt.getImportList());
        }

        return answer;
    }

    private String calculateActualImport(String name) {
        String answer = name;
        if (this.isArray()) {
            int index = name.indexOf('[');
            if (index != -1) {
                answer = name.substring(0, index);
            }
        }
        return answer;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getShortName() {
        StringBuilder sb = new StringBuilder();
        if (wildcardType) {
            sb.append('?');
            if (boundedWildcard) {
                if (extendsBoundedWildcard) {
                    sb.append(" extends "); //$NON-NLS-1$
                } else {
                    sb.append(" super "); //$NON-NLS-1$
                }

                sb.append(baseShortName);
            }
        } else {
            sb.append(baseShortName);
        }

        if (!typeArguments.isEmpty()) {
            boolean first = true;
            sb.append('<');
            for (JavaType fqjt : typeArguments) {
                if (first) {
                    first = false;
                } else {
                    sb.append(", "); //$NON-NLS-1$
                }
                sb.append(fqjt.getShortName());

            }
            sb.append('>');
        }

        return sb.toString();
    }

    public String getShortNameWithoutTypeArguments() {
        return baseShortName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof JavaType)) {
            return false;
        }

        JavaType other = (JavaType) obj;

        return getFullyQualifiedName().equals(other.getFullyQualifiedName());
    }

    public int hashCode() {
        return getFullyQualifiedName().hashCode();
    }

    public String toString() {
        return getFullyQualifiedName();
    }

    public boolean isPrimitive() {
        return primitive;
    }

    public PrimitiveTypeImplWrapper getPrimitiveTypeWrapper() {
        return primitiveTypeWrapper;
    }

    public int compareTo(JavaType other) {
        return getFullyQualifiedName().compareTo(other.getFullyQualifiedName());
    }

    public void addTypeArgument(JavaType type) {
        typeArguments.add(type);
    }

    private void parse(String fullTypeSpecification) {
        String spec = fullTypeSpecification.trim();

        if (spec.startsWith("?")) { //$NON-NLS-1$
            wildcardType = true;
            spec = spec.substring(1).trim();
            if (spec.startsWith("extends ")) { //$NON-NLS-1$
                boundedWildcard = true;
                extendsBoundedWildcard = true;
                spec = spec.substring(8); // "extends ".length()
            } else if (spec.startsWith("super ")) { //$NON-NLS-1$
                boundedWildcard = true;
                extendsBoundedWildcard = false;
                spec = spec.substring(6); // "super ".length()
            } else {
                boundedWildcard = false;
            }
            parse(spec);
        } else {
            int index = fullTypeSpecification.indexOf('<');
            if (index == -1) {
                simpleParse(fullTypeSpecification);
            } else {
                simpleParse(fullTypeSpecification.substring(0, index));
                int endIndex = fullTypeSpecification.lastIndexOf('>');
                if (endIndex == -1) {
                    throw new RuntimeException("错误的类型"); //$NON-NLS-1$
                }
                genericParse(fullTypeSpecification.substring(index, endIndex + 1));
            }

            // this is far from a perfect test for detecting arrays, but is close
            // enough for most cases. It will not detect an improperly specified
            // array type like byte], but it will detect byte[] and byte[ ]
            // which are both valid
            isArray = fullTypeSpecification.endsWith("]"); //$NON-NLS-1$
        }
    }

    private void simpleParse(String typeSpecification) {
        baseQualifiedName = typeSpecification.trim();
        if (baseQualifiedName.contains(".")) { //$NON-NLS-1$
            packageName = getPackage(baseQualifiedName);
            baseShortName = baseQualifiedName.substring(packageName.length() + 1);
            int index = baseShortName.lastIndexOf('.');
            if (index != -1) {
                baseShortName = baseShortName.substring(index + 1);
            }

            // $NON-NLS-1$
            explicitlyImported = !JAVA_LANG.equals(packageName);
        } else {
            baseShortName = baseQualifiedName;
            explicitlyImported = false;
            packageName = ""; //$NON-NLS-1$

            switch (baseQualifiedName) {
                case "byte": //$NON-NLS-1$
                    primitive = true;
                    primitiveTypeWrapper = PrimitiveTypeImplWrapper.getByteInstance();
                    break;
                case "short": //$NON-NLS-1$
                    primitive = true;
                    primitiveTypeWrapper = PrimitiveTypeImplWrapper.getShortInstance();
                    break;
                case "int": //$NON-NLS-1$
                    primitive = true;
                    primitiveTypeWrapper = PrimitiveTypeImplWrapper.getIntegerInstance();
                    break;
                case "long": //$NON-NLS-1$
                    primitive = true;
                    primitiveTypeWrapper = PrimitiveTypeImplWrapper.getLongInstance();
                    break;
                case "char": //$NON-NLS-1$
                    primitive = true;
                    primitiveTypeWrapper = PrimitiveTypeImplWrapper.getCharacterInstance();
                    break;
                case "float": //$NON-NLS-1$
                    primitive = true;
                    primitiveTypeWrapper = PrimitiveTypeImplWrapper.getFloatInstance();
                    break;
                case "double": //$NON-NLS-1$
                    primitive = true;
                    primitiveTypeWrapper = PrimitiveTypeImplWrapper.getDoubleInstance();
                    break;
                case "boolean": //$NON-NLS-1$
                    primitive = true;
                    primitiveTypeWrapper = PrimitiveTypeImplWrapper.getBooleanInstance();
                    break;
                default:
                    primitive = false;
                    primitiveTypeWrapper = null;
                    break;
            }
        }
    }

    private void genericParse(String genericSpecification) {
        int lastIndex = genericSpecification.lastIndexOf('>');
        if (lastIndex == -1) {
            // shouldn't happen - should be caught already, but just in case...
            throw new RuntimeException("错误的类型"); //$NON-NLS-1$
        }
        String argumentString = genericSpecification.substring(1, lastIndex);
        // need to find "," outside of a <> bounds
        StringTokenizer st = new StringTokenizer(argumentString, ",<>", true); //$NON-NLS-1$
        int openCount = 0;
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if ("<".equals(token)) { //$NON-NLS-1$
                sb.append(token);
                openCount++;
            } else if (">".equals(token)) { //$NON-NLS-1$
                sb.append(token);
                openCount--;
            } else if (",".equals(token)) { //$NON-NLS-1$
                if (openCount == 0) {
                    typeArguments.add(new JavaType(sb.toString()));
                    sb.setLength(0);
                } else {
                    sb.append(token);
                }
            } else {
                sb.append(token);
            }
        }

        if (openCount != 0) {
            throw new RuntimeException("错误的类型"); //$NON-NLS-1$
        }

        String finalType = sb.toString();
        if (!StringUtils.isEmpty(finalType)) {
            typeArguments.add(new JavaType(finalType));
        }
    }

    public boolean isArray() {
        return isArray;
    }


    public List<JavaType> getTypeArguments() {
        return typeArguments;
    }

    public JavaType create(JavaType type) {
        return new JavaType(type.getFullyQualifiedName());
    }

    public JavaType create(String type) {
        return new JavaType(type);
    }
}
