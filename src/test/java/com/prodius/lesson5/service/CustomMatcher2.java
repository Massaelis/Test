package com.prodius.lesson5.service;

import org.mockito.ArgumentMatcher;

public class CustomMatcher2 implements ArgumentMatcher<String> {
    @Override
    public boolean matches(final String line) {
        return line.equals("qwerty");
    }
}
