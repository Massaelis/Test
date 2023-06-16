package com.prodius.module3.lesson25hw.action;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}