package com.prodius.module2.lesson5.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Massage {
    private String receiver;
    private String sender;

    public Massage(String receiver, String sender){
        this.receiver = receiver;
        this.sender = sender;
    }
}
