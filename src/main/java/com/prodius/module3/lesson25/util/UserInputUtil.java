package com.prodius.module3.lesson25.util;

import lombok.SneakyThrows;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class UserInputUtil {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    @SneakyThrows
    public static int getUserChoice(final String initialState, final List<String> menuItems) {
        int commandNumber = -1;

        do {
            printMenu(initialState, menuItems);
            final String userInput = READER.readLine();
            final boolean isNumber = NumberUtils.isParsable(userInput);
            if (isNumber) {
                commandNumber = Integer.parseInt(userInput);
            }
        } while (commandNumber < 0 || commandNumber > menuItems.size());

        return commandNumber;
    }

    private static void printMenu(final String initialState, final List<String> menuItems) {
        System.out.println(initialState);
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d. %s%n", i, menuItems.get(i));
        }
    }
}
