package com.prodius.module3.lesson20hw.model;

public enum OffsetGrade {
    COMPLETED("completed"), PROCESS("process");

    private final String status;

    OffsetGrade(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
