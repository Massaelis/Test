package com.prodius.module3.lesson25hw;

import com.prodius.module3.lesson25hw.action.Commands;
import com.prodius.module3.lesson25hw.util.UserInputUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

        final Commands[] values = Commands.values();

        final List<String> menuItems = Arrays.stream(values)
                .map(Objects::toString)
                .collect(Collectors.toList());

        while (true) {
            final int userChoice = UserInputUtil.getUserChoice("What you want to do?", menuItems);
            values[userChoice].execute();
            values[userChoice].execute(READER.readLine());
        }
    }
}