package com.prodius.module3.lesson16;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MyAnnotation {
    String additional() default "default";
}

public class Main {

    public static void main(String[] args) {
//        reflectionExample();
        myAnnotationExample();
    }

    private static void myAnnotationExample() {
        final Reflections reflections = new Reflections("com.prodius.module3.lesson16");
        final List<A> list = new ArrayList<>();

        reflections.getTypesAnnotatedWith(Deprecated.class)
                .forEach(aClass -> {
                    System.out.println(aClass.getSimpleName());
                    Arrays.stream(aClass.getDeclaredConstructors())
                            .filter(constructor -> constructor.getParameterCount() == 0)
                            .findAny()
                            .ifPresent(constructor -> {
                                try {
                                    list.add((A) constructor.newInstance());
                                } catch (InstantiationException | IllegalAccessException |
                                         InvocationTargetException e) {
                                    throw new RuntimeException(e);
                                }
                            });

                    final A objectA = list.get(list.size() - 1);
                    System.out.println("Before: " + objectA);

                    Arrays.stream(aClass.getDeclaredFields())
                            .filter(objectField -> objectField.getAnnotation(MyAnnotation.class) != null)
                            .forEach(objectField -> {
                                final MyAnnotation annotation = objectField.getAnnotation(MyAnnotation.class);
                                final String additional = annotation.additional();
                                if (StringUtils.isEmpty(additional)) {
                                    return;
                                }
                                try {
                                    objectField.setAccessible(true);
                                    final String objectFieldValue = (String) objectField.get(objectA);

                                    if (StringUtils.isEmpty(objectFieldValue)) {
                                        objectField.set(objectA, additional);
                                    } else {
                                        objectField.set(objectA, objectFieldValue + " " + additional);
                                    }

                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                }
                            });

                    System.out.println("After: " + objectA);
                });
    }

    @SneakyThrows
    private static void reflectionExample() {
        final Class<B> bClass = B.class;
        Arrays.stream(bClass.getFields())
                .map(Field::getName)
                .forEach(System.out::println);

        System.out.println("~".repeat(10));

        Arrays.stream(bClass.getDeclaredFields())
                .map(Field::getName)
                .forEach(System.out::println);

        System.out.println("~".repeat(10));
        final Field publicB = bClass.getField("publicB");
        System.out.println(publicB.getName());

        final B objectB = new B();
        System.out.println(publicB.get(objectB));

        final Class<A> aClass = A.class;
        final Field publicA = aClass.getField("publicA");
        System.out.println(publicA.get(objectB));

        System.out.println("~".repeat(10));
        final Field privateB = bClass.getDeclaredField("privateB");
        System.out.println(objectB);
        privateB.setAccessible(true);

        privateB.set(objectB, "testing");
        System.out.println(objectB);

        final int modifiers = privateB.getModifiers();
        System.out.println("Modifiers: " + modifiers);
        System.out.println("Modifiers is private: " + Modifier.isPrivate(modifiers));
        System.out.println("Modifiers is static: " + Modifier.isStatic(modifiers));
        Arrays.stream(privateB.getAnnotations())
                .map(Annotation::toString)
                .forEach(System.out::println);

        System.out.println(privateB.getAnnotation(Deprecated.class));


    }

    private static void classExample() {
        final Class<Main> mainClass = Main.class;
        final Class<? extends String> aClass = "qwerty".getClass();
        final Class<Integer> integerClass = int.class;
        final Class<Void> voidClass = void.class;

        final A a1 = new A();
        final Class<? extends A> aClass1 = a1.getClass();

        final A a2 = new B();
        final Class<? extends A> aClass2 = a2.getClass();

        final Class<A> aClass3 = A.class;
        final Class<B> bClass = B.class;
    }
}

@Deprecated
class A {
    public String publicA;

    protected String protectedA;

    String defaultA;

    private String privateA;
}

@Deprecated
@ToString
class B extends A {
    public String publicB = "TESTING";

    protected String protectedB;

    @MyAnnotation(additional = "Additional information")
    String defaultB;

    @Getter
    @Deprecated
    @MyAnnotation
    private final String privateB = "TESTING";

    @MyAnnotation(additional = "Additional information")
    private final String privateB2 = "TESTING";

}