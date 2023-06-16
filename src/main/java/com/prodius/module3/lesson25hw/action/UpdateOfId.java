package com.prodius.module3.lesson25hw.action;

import com.prodius.module3.lesson25hw.controller.StudentController;
import com.prodius.module3.lesson25hw.util.UserInputUtil;

public class UpdateOfId implements Command {
    private final StudentController controller = StudentController.getInstance();

    @Override
    public void execute() {
        final String value = UserInputUtil.getUserString("Print id students: ");
        controller.updateOfId(value);
    }

}