package com.prodius.lesson2.util;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StringUtil {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private int length = 0;

    //create a string bigger than 5 characters
    public int getUserString() {
        System.out.print("Write 6 or bigger: ");
        if (SCANNER.hasNextInt()) {
            length = SCANNER.nextInt();
        }

        return length >= 6 ? length : getUserString();
    }

    //create random string
    public String getRandomString(final int length) {
        String myString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = RANDOM.nextInt(myString.length());
            sb.append(myString.charAt(number));
        }
        System.out.println("New random string: " + sb);

        return sb.toString();
    }

    //swap the first and last character in an array
    public void changeCharacters(final char[] chars) {
        char c = chars[0];
        chars[0] = chars[chars.length - 1];
        chars[chars.length - 1] = c;
        System.out.println("Change position in new string: " + Arrays.toString(chars));
    }

    //divide the string by the number of the user
    //and
    //check for the remainder of the division
    public void stringCheck(final String line) {
        final int divider = line.length() % length;
        if (divider == 0) {
            System.out.printf("Test completed. Remainder of division is: '%s' %n", divider);
        } else {
            System.out.printf("Test failed. Remainder of division is: '%s' %n", divider);
            deletingCharacter(line);
        }
    }

    //remove one random character
    private void deletingCharacter(final String line) {
        StringBuilder sb = new StringBuilder();
        sb.append(line);
        sb.deleteCharAt(RANDOM.nextInt(length));
        System.out.println("String after character remove: " + sb);
        stringCheck(sb.toString());
    }

    public char[] addCharacters(final String line) {
        final char[] chars = line.toCharArray();
        // 0123456789 - 0 2 4 6 8 // 5 штук // 10 длина
        // 012345678 - 0 2 4 6 8 // 5 штук // 9 длина
        final int delta = chars.length % 2 == 0 ? chars.length / 2 : chars.length / 2 + 1;
        final char[] chars1 = new char[chars.length + delta];
        for (int i = 0, y = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                chars1[y] = chars[i];
                chars1[y + 1] = chars[i];
                y += 2;
            } else {
                chars1[y] = chars[i];
                y += 1;
            }
        }
        System.out.println("String before adding characters: " + Arrays.toString(chars));
        System.out.println("String after adding characters: " + Arrays.toString(chars1));
        return chars1;
    }
}
