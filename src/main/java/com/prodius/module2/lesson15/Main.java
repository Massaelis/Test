package com.prodius.module2.lesson15;

import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String FILE_PATH = "src/main/java/com/prodius/module2/lesson15/test.txt";

    @SneakyThrows
    public static void main(String[] args) {
//        fileSystem(new File("src/main/java/com/prodius"));
//        serDes();

        final Pattern pattern = Pattern.compile("(.*?)/");
        final Matcher matcher = pattern.matcher(FILE_PATH);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }

    @SneakyThrows
    private static void serDes() {
        final Cat cat = new Cat();
        cat.setDog(new Dog());
        cat.setAge(10);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            objectOutputStream.writeObject(cat);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            final Object object = objectInputStream.readObject();
            if (object instanceof final Cat readCat) {
                System.out.println(readCat);
            }
        }
    }

    private static void fileSystem(final File file) {
//        final Path path = file.toPath();
//        final File file1 = path.toFile();

        if (file.isFile()) {
            System.out.println("\tFile: " + file.getName());
        } else if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());
            final File[] files = file.listFiles();
            if (files == null) {
                return;
            }
            Arrays.stream(files).forEach(Main::fileSystem);
        } else {
            throw new IllegalStateException("File " + file + " is unknown");
        }
    }

    @SneakyThrows
    private static void inputOutput() {
        try (final FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH)) {
            fileOutputStream.write(1);
            fileOutputStream.write(1);
            fileOutputStream.write(0);
            fileOutputStream.write(1);
        }

        try (final FileInputStream fileInputStream = new FileInputStream(FILE_PATH)) {
            int temp;
            while ((temp = fileInputStream.read()) > -1) {
                System.out.println(temp);
            }
        }
    }

    private static void dontCloseConsole() {
        Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        System.out.println(next);
//        scanner.close(); ERROR in feature

        Scanner scanner2 = new Scanner(System.in);
        final String next2 = scanner2.next();
        System.out.println(next2);
    }
}

@Setter
@ToString
class Cat implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    private int age;

    private String name;

    private transient Dog dog;
}

class Dog {
    private int age;
}
