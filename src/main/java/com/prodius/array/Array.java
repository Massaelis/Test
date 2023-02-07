package com.prodius.array;

import java.util.Scanner;

public class Array {
    private Scanner SCANNER = new Scanner(System.in);
    //failed to associate check with "getChar"
    private int createString() {
        System.out.println("Enter some letter: ");
        String string = SCANNER.nextLine();

        while (string.length() >= 3) {
            break;
        }
        return string.length();
    }

    private char[] getChar(){
        System.out.println("Enter some letter: ");
        String str = SCANNER.nextLine();
        char[] result = str.toCharArray();

        System.out.println("Char array: ");
        for (int i = 0; i < result.length; i++)
            System.out.println("Element [" + i + "]: " + result[i]);
        return result;
    }
    private String getString(){
        char[] chars = getChar();
        String string = new String(chars);
        System.out.println("Return string: " + string);
        return string;
    }
    public int checkStringLength() {
        String string = getString();
        int stringLength = string.length();
        System.out.println("String length: " + stringLength);
        if (stringLength > 20){
            System.out.println("Test is done");
        } else {
            int number = (int) (Math.random()*(1+4)) + 1;
            System.out.println("Random number: " + number);
            var index = string.charAt(stringLength/2);
            System.out.println("Middle letter: " + index);
            String s = String.valueOf(index);
            var repeat = s.repeat(number);
            System.out.print("Reapeat letter: " + repeat);
        }
        return stringLength;
    }
}