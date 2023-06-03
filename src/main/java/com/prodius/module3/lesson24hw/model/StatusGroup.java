package com.prodius.module3.lesson24hw.model;

public enum StatusGroup {
    ACTIVE("Active"),
    INACTIVE("Inactive");
    private final String status;

    StatusGroup(final String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return status;
    }
}
