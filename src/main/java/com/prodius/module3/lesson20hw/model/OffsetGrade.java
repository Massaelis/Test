package com.prodius.module3.lesson20hw.model;

import lombok.Getter;

@Getter
public enum OffsetGrade {
    COMPLETED("completed"), PROCESS("process");

    private final String status;

    OffsetGrade(final String status) {
        this.status = status;
    }
}
