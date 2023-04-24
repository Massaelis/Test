package com.prodius.module2.module.vehicle;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Transport {
    private final Type type;
    private final int numberOfWheels;

    protected Transport(final Type type, final int numberOfWheels) {
        this.type = type;
        this.numberOfWheels = numberOfWheels;
    }


    public abstract void calculateSpeed();
}