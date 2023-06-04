package com.prodius.module3.lesson25;

import com.prodius.module3.lesson25.action.Commands;
import com.prodius.module3.lesson25.util.UserInputUtil;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        final Commands[] values = Commands.values();

        final List<String> menuItems = Arrays.stream(values)
                .map(Objects::toString)
                .collect(Collectors.toList());

        while (true) {
            final int userChoice = UserInputUtil.getUserChoice("What you want to do?", menuItems);
            values[userChoice].execute();
        }
    }

}
