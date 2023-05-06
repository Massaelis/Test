package com.prodius.module3.lesson16Additional.components;

import com.prodius.module3.lesson16Additional.annotations.Init;
import com.prodius.module3.lesson16Additional.annotations.Initializer;
import lombok.ToString;

@Initializer(description = "Initial value TEST")
@ToString
public class StringComponent {
    private String id;

    @Init(stringValue = "TEST")
    private String value;
}
