package com.prodius.module3.lesson16Additional.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Init {
    int intValue() default 0;

    String stringValue() default "";

    boolean booleanValue() default false;
}
