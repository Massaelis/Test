package com.prodius.module3.lesson16hw.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

public class SaveFile {
    private static final String NOTES_FILE = "src/main/resources/save.txt";

    public static void saveToFile(List<Object> objectList) {
        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(NOTES_FILE))) {
            for (Object note : objectList) {
                final String type = note.getClass().getSimpleName();

                final Method[] methods = note.getClass().getDeclaredMethods();
                List methodsList = new ArrayList<>();
                for (int i = 0; i < methods.length; i++) {
                    methodsList.add(methods[i]);
                }
                final TypeVariable<? extends Class<?>>[] parameters = note.getClass().getTypeParameters();
                List parametersList = new ArrayList<>();
                for (int i = 0; i < parameters.length; i++) {
                    parametersList.add(parameters[i]);
                }

                writer.write(String.format("Class: %s, %nMethod: %s, %nParameters: %s%n%n",
                        type, methodsList, parametersList));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showMethods(List<Object> objectList) {
        try {
            for (Object note : objectList) {
                System.out.println("Methods =");
                Method m[] = note.getClass().getDeclaredMethods();
                for (int i = 0; i < m.length; i++) {
                    System.out.println(m[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}