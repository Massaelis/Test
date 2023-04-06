package com.prodius.module1.lesson1.service;

import java.util.Arrays;
import java.util.Random;

public class StringService {

    private static final Random RANDOM = new Random();

    public void duplicateCharacters(final String line) {
        final char[] inputChars = line.toCharArray();
        final char[] outputChars = new char[inputChars.length * 2];
        for (
                int inputCharsIndex = 0, outputCharsIndex = 0;
                inputCharsIndex < inputChars.length;
                inputCharsIndex++, outputCharsIndex += 2
        ) {
            final char aChar = inputChars[inputCharsIndex];
            outputChars[outputCharsIndex] = aChar;
            outputChars[outputCharsIndex + 1] = aChar;
        }
        System.out.println("Output array: " + Arrays.toString(outputChars));
        testString(new String(outputChars));
    }

    private void testString(final String line) {
        if (line.length() > 20) {
            System.out.printf("Line '%s' bigger than 20 characters%n", line);
        } else {
            System.out.println("Test failed, length: " + line.length());
            increaseLine(line);
        }
    }

    private void increaseLine(final String line) {
        System.out.println("increaseLine, input string: " + line);
        final int centralIndex = line.length() / 2;
        System.out.println("centralIndex: " + centralIndex);
        final char centralCharacter = line.charAt(centralIndex);
        System.out.println("centralCharacter: " + centralCharacter);
        final String firstPartLine = line.substring(0, centralIndex);
        System.out.println("firstPartLine: " + firstPartLine);
        final String secondPartLine = line.substring(centralIndex + 1);
        System.out.println("secondPartLine: " + secondPartLine);

        final int randomNumber = 1 + RANDOM.nextInt(5);
        System.out.println("randomNumber: " + randomNumber);
        final String duplicatedPart = String.valueOf(centralCharacter).repeat(randomNumber);
        System.out.println("duplicatedPart: " + duplicatedPart);

        final String result = firstPartLine + duplicatedPart + secondPartLine;
        System.out.println("Result: " + result);
        testString(result);
    }
}
