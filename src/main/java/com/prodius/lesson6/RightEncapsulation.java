package com.prodius.lesson6;

public class RightEncapsulation {
    private String name;

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }
}

// Encapsulation
class Cat1 {
    public String name;

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }
}

// Non Encapsulation
class Cat2 {
    public String name;
}

class Cat22 {
    String getName(final Cat2 cat) {
        return cat.name;
    }

    void setName(final Cat2 cat, final String name) {
        cat.name = name;
    }
}

// Сокрытие данных
class Cat3 {
    private String name;
}

