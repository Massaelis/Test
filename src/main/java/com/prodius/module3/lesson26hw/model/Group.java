package com.prodius.module3.lesson26hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Group implements Cloneable {
    private String name;

    private List<User> users;

    public Group(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    private Group(Group group) {
        this.name = group.name;
        this.users = group.users;
    }

    @Override
    public Group clone() {
        return new Group(this);
    }
}