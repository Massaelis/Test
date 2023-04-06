package com.prodius.lesson5.service;

import com.prodius.module2.lesson5.message.Massage;
import org.mockito.ArgumentMatcher;

public class CustomMatcher implements ArgumentMatcher<Massage> {
    @Override
    public boolean matches(final Massage massage) {
        return massage.getSender().equals("ytrewq");
    }
}
