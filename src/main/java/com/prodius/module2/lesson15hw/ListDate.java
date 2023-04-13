package com.prodius.module2.lesson15hw;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListDate {
    private static final String FILE_PATH = "src/main/java/com/prodius/module2/lesson15hw/file.txt";

    public static void createFile() {
        try (final FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write("10-04-2023 \n");
            fileWriter.write("2023-04-10 \n");
            fileWriter.write("04/10/2023 \n");
            fileWriter.write("10 april 2023 \n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> createList() throws IOException {
        final List<String> listString = new ArrayList<>();

        final File file = new File(FILE_PATH);
        final FileReader fr = new FileReader(file);
        final BufferedReader br = new BufferedReader(fr);
        String line = null;
        while ((line = br.readLine()) != null) {
            listString.add(line);
        }
        System.out.println(listString);
        return listString;
    }

    public static <T extends CharSequence> void checkList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            final Matcher matcher = Pattern.compile("^\\d{2}-\\d{2}").matcher(list.get(i));
            while (matcher.find()) {
                System.out.println("Date in format \"dd-mm-yyyy\": " + list.get(i));
            }
            final Matcher matcher2 = Pattern.compile("^\\d{4}-\\d{2}").matcher(list.get(i));
            while (matcher2.find()) {
                System.out.println("Date in format \"yyyy-mm-dd\": " + list.get(i));
            }
            final Matcher matcher3 = Pattern.compile("^\\d{2}/\\d{2}").matcher(list.get(i));
            while (matcher3.find()) {
                System.out.println("Date in format \"mm/dd/yyyy\": " + list.get(i));
            }
            final Matcher matcher4 = Pattern.compile("(a.+?l)(.*?)").matcher(list.get(i));
            while (matcher4.find()) {
                System.out.println("Date in format \"dd~month~yyyy\": " + list.get(i));
            }
        }
    }
}
