package com.prodius.module3.module3.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Commands {
    SEARCH_GROUPS("Search Groups", new SearchGroups()),
    COUNT_STUDENT("Count Students", new CountStudent()),
    MIDDLE_GRADE("Middle Grade Group", new MiddleGroupsGrade()),
    SEARCH_TEACHER("Search Teacher", new SearchTeacher()),
//    CLAZZ_WITH_GRADE(),
    STUDENT_GRADE("Middle Grade Student", new MiddleStudentGrade()),
    EXIT("Finish program", new ExitCommand());

    static final Logger logger = LoggerFactory.getLogger(Commands.class);

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