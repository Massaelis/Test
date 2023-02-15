package com.prodius.lesson2.util;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StringUtil {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    static int length = 0;

    //create a string bigger than 5 characters
    public static int getUserString() {
        //length = 0;
        System.out.print("Write 6 or bigger: ");
        if (scanner.hasNextInt()) {
            length = scanner.nextInt();
        }
        scanner.nextLine();

        return length >= 6 ? length : getUserString();
    }
    //create random string
    public static String getRandomString(final int length){
        String myString="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        //Random random=new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(myString.charAt(number));
        }
        System.out.println("New random string: " + sb);

        return sb.toString();
    }
    //swap the first and last character in an array
    public static String changeCharacters(final String line) {
        char[] chars = line.toCharArray();
        char c = chars[0];
        chars[0] = chars[line.length()-1];
        chars[line.length()-1] = c;
        System.out.println("Change position in new string: " + Arrays.toString(chars));

        return String.valueOf(chars);
    }
    //divide the string by the number of the user
    //and
    //check for the remainder of the division
    public static int stringCheck(final String line){
        int lengthString = length;
        String myString = line;
        int newLength = myString.length() / lengthString;
        System.out.println("Length divided by user number: " + newLength);

        if (newLength%2==0) {
            System.out.printf("Test completed. Remainder of division is: '%s' %n", newLength);
        } else {
            System.out.printf("Test failed. Remainder of division is: '%s' %n", newLength);
            deletingCharacter(line);
        }

        return newLength;
    }
    //remove one random character
    private static void deletingCharacter(final String line) {
        String myString = line;
        char[] charArray = myString.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(myString);
        sb.deleteCharAt(random.nextInt(length));
        charArray = sb.toString().toCharArray();
        System.out.print("String after character remove: ");
        System.out.println(charArray);
        final char[] result = charArray;

        stringCheck(String.valueOf(result));
    }
}
