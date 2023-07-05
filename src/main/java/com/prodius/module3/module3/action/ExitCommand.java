package com.prodius.module3.module3.action;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        Commands.logger.info("User leave program");
        System.exit(0);
    }
}