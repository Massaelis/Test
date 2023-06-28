package com.prodius.module3.lesson26hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Group implements Cloneable {
    private String name;

    private List<User> users;

    private Map<String, List<User>> map;

    public Group(String name, List<User> users) {
        this.name = name;
        this.users = users;
        map = new HashMap<String, List<User>>() {{
            put(name, users);
        }};

    }

    @Override
    public Group clone() throws CloneNotSupportedException {
       final Group clone = (Group) super.clone();
       clone.users = new ArrayList<>(this.users);
       clone.map = new HashMap<>(this.map);
       return clone;
    }
}