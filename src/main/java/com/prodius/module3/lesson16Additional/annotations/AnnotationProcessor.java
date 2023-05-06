package com.prodius.module3.lesson16Additional.annotations;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AnnotationProcessor {

    private static final List<Object> CACHE = new ArrayList<>();

    private static final Predicate<Class<?>> HAS_INIT_FIELD = aClass -> Arrays.stream(aClass.getDeclaredFields())
            .anyMatch(field -> field.getAnnotation(Init.class) != null);

    public void handle(final String path) {
        final Reflections reflections = new Reflections(path);

        reflections.getTypesAnnotatedWith(Initializer.class).stream()
                .filter(HAS_INIT_FIELD)
                .peek(this::logClass)
                .forEach(this::processAnnotation);
    }

    private void logClass(final Class<?> aClass) {
        final String description = aClass.getAnnotation(Initializer.class).description();
        final String className = aClass.getName();
        System.out.printf("Find class %s | Description: %s%n", className, description);
    }

    private void processAnnotation(final Class<?> aClass) {
        final Object object = create(aClass);
        initFields(aClass, object);
        CACHE.add(object);
        System.out.println("Object after initialization: " + object);
    }

    private void initFields(final Class<?> aClass, final Object object) {
        Arrays.stream(aClass.getDeclaredFields())
                .filter(field -> field.getAnnotation(Init.class) != null)
                .forEach(field -> {
                    final String typeName = field.getType().getSimpleName();
                    final Init init = field.getAnnotation(Init.class);
                    field.setAccessible(true);

                    switch (typeName) {
                        case "boolean" -> {
                            final Boolean initValue = init.booleanValue();
                            setValue(field, object, initValue);
                        }
                        case "String" -> {
                            final String initValue = init.stringValue();
                            setValue(field, object, initValue);
                        }
                        case "int" -> {
                            final Integer initValue = init.intValue();
                            setValue(field, object, initValue);
                        }
                        default -> throw new UnsupportedOperationException("Unsupported type " + typeName);
                    }
                });
    }

    private void setValue(final Field field, final Object object, final Object value) {
        try {
            field.set(object, value);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    private Object create(final Class<?> aClass) {
        return Arrays.stream(aClass.getConstructors())
                .filter(c -> c.getParameterCount() == 0)
                .findAny()
                .map(this::createObject)
                .orElseThrow(() -> new IllegalStateException("Class should have default constructor"));
    }

    private Object createObject(final Constructor<?> constructor) {
        try {
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }
}
