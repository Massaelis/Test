package com.prodius.module3.lesson16Additional.components;

import com.prodius.module3.lesson16Additional.annotations.Init;
import com.prodius.module3.lesson16Additional.annotations.Initializer;
import lombok.ToString;

@Initializer
@ToString
public class BooleanComponent {
    private String id;

    @Init(booleanValue = true)
    private boolean value;
}
