package com.prodius.module3.lesson25.action;

public enum Commands {
    CREATE("Create cats", new CreateCommand()),
    PRINT("Print cats", new PrintCommand()),
    EXIT("Finish program", new ExitCommand());

    private final String name;

    private final Command command;

    Commands(final String name, final Command command) {
        this.name = name;
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

    @Override
    public String toString() {
        return name;
    }
}
