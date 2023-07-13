package com.prodius.module3.module3.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExitCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(ExitCommand.class);

    @Override
    public void execute() {
        logger.info("User leave program");
        System.exit(0);
    }
}