package com.prodius.module3.lesson26hw.model;

import lombok.Getter;

@Getter
public class TelephoneNumber {
    private static final int NUMBER_LENGTH = 8;

    private final String phoneNumber;

    public TelephoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null
                || phoneNumber.length() != NUMBER_LENGTH
                || !phoneNumber.startsWith("+")
        ) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}