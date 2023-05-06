package com.prodius.module3.lesson16hw.annotation;

import com.prodius.module3.lesson16hw.repository.Repository;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Annotation {
    private static final Reflections reflections = new Reflections("com.prodius.module3.lesson16hw");

    private final Map<Class<?>, Object> cache = new HashMap<>();

    public Map<Class<?>, Object> getCache() {
        return cache;
    }

    public void annotationHandler() {
        // 1. Найти все классы с аннотацией Синглтон
        reflections.getTypesAnnotatedWith(Singleton.class).forEach(this::handle);
        System.out.println(cache.size());
    }

    private void handle(final Class<?> aClass) {
        if (cache.containsKey(aClass)) {
            // 2. Найти его в кеше, если есть - ничего не делать
            System.out.println(aClass.getSimpleName() + " есть в кеше");
            return;
        }

        System.out.println(aClass.getSimpleName() + " нет в кеше");
        // 3. Взять конструктор
        final Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        if (declaredConstructors.length != 1) {
            throw new IllegalStateException("Class must have only one constructor");
        }

        final Constructor<?> constructor = declaredConstructors[0];
        if (constructor.getParameterCount() == 0) {
            // 3.1 Если конструктор без параметров - создать и положить в кеш
            create(aClass, constructor);
        } else {
            // 3.2.1 Если конструктор с параметрами
            createAutowired(aClass, constructor);
        }
    }

    private void createAutowired(final Class<?> aClass, final Constructor<?> constructor) {
        try {
            // 3.2.2 Взять аннотацию Автовайред
            final Autowired annotation = constructor.getAnnotation(Autowired.class);
            // 3.2.3 Достать какой класс нужен из аннотации
            final Class<? extends Repository> parametrClass = annotation.aClass();

            // 3.2.4 Смотрим пункт 2
            if (!cache.containsKey(parametrClass)) {
                handle(parametrClass);
            }

            final Object o = cache.get(parametrClass);
            System.out.println("создаем сервис " + aClass.getSimpleName());
            // 3.2.5 Создаем изначальный класс и кладем в кеш
            final Object newInstance = constructor.newInstance(o);
            cache.put(aClass, newInstance);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }

    private void create(final Class<?> aClass, final Constructor<?> constructor) {
        try {
            System.out.println("создаем репозиторий " + aClass.getSimpleName());
            final Object newInstance = constructor.newInstance();
            cache.put(aClass, newInstance);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }
}