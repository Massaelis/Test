package com.prodius.module3.lesson25hw.action;

import com.prodius.module3.lesson25hw.controller.StudentController;

public class UpdateOfId implements Command<String> {
    private final StudentController controller = StudentController.getInstance();

    @Override
    public void execute() {

    }

    @Override
    public void execute(String value) {
        controller.updateOfId(value);
    }
}