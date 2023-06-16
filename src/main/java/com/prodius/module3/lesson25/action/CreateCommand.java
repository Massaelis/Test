package com.prodius.module3.lesson25.action;

import com.prodius.module3.lesson25.controller.CatController;

public class CreateCommand implements Command {

    private final CatController controller = CatController.getInstance();

    @Override
    public void execute() {
        controller.create(5);
    }
}
