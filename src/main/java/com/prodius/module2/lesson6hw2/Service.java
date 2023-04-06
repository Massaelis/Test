package com.prodius.module2.lesson6hw2;

import com.prodius.module2.lesson6hw2.transport.Airplane;
import com.prodius.module2.lesson6hw2.transport.Hybrid;
import com.prodius.module2.lesson6hw2.transport.Transport;

public class Service {
    public void isTheSame(final Transport transport) {
        if(transport instanceof Airplane){
            System.out.println("Это самолет");
        }
        else if(transport instanceof Hybrid){
            System.out.println("Это гибридный автомобиль");
        }
        else{
            System.out.println("Это автомобиль");
        }
    }
}
