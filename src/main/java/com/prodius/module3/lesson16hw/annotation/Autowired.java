package com.prodius.module3.lesson16hw.annotation;

import com.prodius.module3.lesson16hw.repository.Repository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
public @interface Autowired {
    Class<? extends Repository> aClass();
}

