package com.github.filiphr.mapstruct.accessor;

import javax.lang.model.element.ExecutableElement;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;

/**
 * An extension of the {@link DefaultAccessorNamingStrategy} that supports builder setters.
 * When a method is a builder setter method then the name of the property is the same as the method name.
 */
public class BuilderAccessorNamingStrategy extends DefaultAccessorNamingStrategy {

    @Override
    public String getPropertyName(ExecutableElement getterOrSetterMethod) {

        String methodName = getterOrSetterMethod.getSimpleName().toString();
        if ( methodName.startsWith( "is" ) || methodName.startsWith( "get" ) || methodName.startsWith( "set" ) ) {
            return super.getPropertyName( getterOrSetterMethod );
        }
        else if ( isBuilderSetter( getterOrSetterMethod ) ) {
            return methodName;
        }
        return super.getPropertyName( getterOrSetterMethod );
    }

    @Override
    public boolean isSetterMethod(ExecutableElement method) {
        return super.isSetterMethod( method ) || isBuilderSetter( method );
    }

    /**
     * Checks if the getter or setter method is a builder setter method. A builder setter method is a method
     * that has exactly one parameter and the return type of the method is same as the enclosing type of the method.
     *
     * @param getterOrSetterMethod that needs to be checked
     *
     * @return {@code true} if the {@code getterOrSetterMethod} is a builder setter method
     */
    protected boolean isBuilderSetter(ExecutableElement getterOrSetterMethod) {
        return getterOrSetterMethod.getParameters().size() == 1 &&
            getterOrSetterMethod.getReturnType()
                .toString()
                .equals( getterOrSetterMethod.getEnclosingElement().asType().toString() );
    }
}
