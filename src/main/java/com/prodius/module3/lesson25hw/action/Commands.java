package com.prodius.module3.lesson25hw.action;

public enum Commands {
    CREATE("Create students", new CreateCommand()),
    PRINT("Print students", new PrintCommand()),
    SEARCH("Search students", new SearchStudentByName()),
    UPDATE("Update students", new UpdateOfId()),
    DELETE("Delete students", new DeleteOfId()),
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