package com.prodius.lesson5.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

class ServiceTest {

    private Service target;

    private Random random;

    //private Scanner scanner;

    @BeforeEach
    void setUp() {
        //scanner = Mockito.mock(Scanner.class);
        random = Mockito.mock(Random.class);
        target = new Service();
    }
    @Nested
    class checkOfEmpty{
        @Test
        void firstMethod(){
            Mockito.when(random.nextInt(10)).thenReturn(1);
            final int expected = 1;

            final String actual = String.valueOf(target.checkOfEmpty("s","r"));

            Assertions.assertEquals(expected, actual);
        }
        
    }

}