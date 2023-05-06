package com.prodius.module3.lesson16hw.annotation;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Annotation {
    public static final List<Object> CACHE = new ArrayList<>();
    final Reflections reflections = new Reflections("com.prodius.module3.lesson16hw");

    public void annotationHandler() {
        //1. Найти все классы с аннотацией Синглтон
        reflections.getTypesAnnotatedWith(Singleton.class).stream()
                .peek(this::log)
                .forEach(aClass -> {
//                    System.out.println(aClass.getSimpleName());
                    System.out.println("");
                });
        System.out.println(CACHE.size());
    }

    private void log(final Class<?> aClass) {
        //2. Найти его в кеше, если есть - ничего не делать
        if (CACHE.contains(aClass)) {
            System.out.println(aClass.getSimpleName() + " есть в кеше");
            return;
            //, если нет:
        } else {
            System.out.println(aClass.getSimpleName() + " нет в кеше");
            //2. Взять конструктор
            Arrays.stream(aClass.getDeclaredConstructors())
                    .filter(constructor -> constructor.getParameterCount() == 0)
                    .findAny()
                    .ifPresentOrElse(
                            //2.1 Если конструктор без параметров - создать и положить в кеш
                            constructor -> CACHE.add(create(aClass)),
                            //2.2.1 Если конструктор с параметрами
                            () -> System.out.println("есть конструктор")
                    );
        }
    }

    //методы для создания конструктора без анотаций
    private Object create(final Class<?> aClass) {
        return Arrays.stream(aClass.getConstructors())
                .filter(c -> c.getParameterCount() == 0)
                .findAny()
                .map(this::createObject)
                .orElseThrow(() -> new IllegalStateException("Class should have default constructor"));
    }

    private Object createObject(final Constructor<?> constructor) {
        try {
            System.out.println("создаем обект " + (CACHE.size() + 1));
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }
}