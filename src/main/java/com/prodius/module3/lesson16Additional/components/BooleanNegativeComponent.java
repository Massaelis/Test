package com.prodius.module3.lesson16Additional.components;

import com.prodius.module3.lesson16Additional.annotations.Init;
import com.prodius.module3.lesson16Additional.annotations.Initializer;
import lombok.ToString;

@Initializer
@ToString
public class BooleanNegativeComponent {
    private String id;

    @Init
    private boolean value;
}
