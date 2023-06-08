package com.prodius.module3.lesson25hw.action;

import com.prodius.module3.lesson25hw.controller.StudentController;

public class PrintCommand implements Command {
    private final StudentController controller = StudentController.getInstance();

    @Override
    public void execute() {
        controller.printAll();
    }
}