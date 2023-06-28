package com.prodius.module3.lesson26hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
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

    @Override
    public Group clone() throws CloneNotSupportedException {
        final Group clone = (Group) super.clone();
        clone.users = new ArrayList<>(this.users.size());
        this.users.forEach(user -> {
            try {
                clone.users.add(user.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        });

        return clone;
    }
}