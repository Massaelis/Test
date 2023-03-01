package com.prodius.lesson4;

import org.mockito.ArgumentMatcher;

public class CustomMatcher implements ArgumentMatcher<String> {
    @Override
    public boolean matches(final String line) {
        return line.equals("test");
    }
}
