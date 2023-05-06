package com.prodius.module3.lesson16Additional.components;

import com.prodius.module3.lesson16Additional.annotations.Init;
import com.prodius.module3.lesson16Additional.annotations.Initializer;
import lombok.ToString;

@Initializer(description = "Initial value 100")
@ToString
public class IntComponent {
    private String id;

    @Init(intValue = 100)
    private int value;
}
