package com.prodius.module3.module3.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Commands {
    SEARCH_GROUPS("Search group ...", new SearchGroups()),
    COUNT_STUDENT("Count students in groups", new CountStudent()),
    MIDDLE_GRADE("Middle grade in groups", new MiddleGroupsGrade()),
    SEARCH_TEACHER("Search teacher ...", new SearchTeacher()),
    CLAZZ_MIN_GRADE("Min middle class grade", new MinClazzGrade()),
    CLAZZ_MAX_GRADE("Max middle class grade",new MaxClazzGrade() ),
    STUDENT_GRADE("Grade student upper ...", new MiddleStudentGrade()),
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