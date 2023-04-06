package com.prodius.lesson4;

import com.prodius.module2.lesson4.Holder;
import com.prodius.module2.lesson4.UserCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Random;

class UserCalculatorTest {

    private UserCalculator target;

    private Random random;

    private Holder holder;

    @BeforeEach
    void setUp() {
        random = Mockito.mock(Random.class);
        holder = Mockito.mock(Holder.class);

        target = new UserCalculator(random, holder);
    }

    @Test
    void sum1() {
        Mockito.when(random.nextInt(100)).thenReturn(1);
        final int expected = 2;

        final int actual = target.sumReturn(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sum2() {
        Mockito.doReturn(5).when(random).nextInt(100);
        final int expected = 10;

        final int actual = target.sumReturn(5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sum3() {
        Mockito.when(random.nextInt(100)).thenReturn(5);

        target.sumVerify(5);

        Mockito.verify(random).nextInt(100);
        Mockito.verify(random, Mockito.never()).nextInt(1000);
    }

    @Test
    void sum4() {
        Mockito.when(random.nextInt(100)).thenReturn(5);

        target.sumVerify(-5);

        Mockito.verify(random).nextInt(1000);
        Mockito.verify(random, Mockito.never()).nextInt(100);
    }

    @Test
    void sum5() {
        Mockito.when(random.nextInt(100)).thenThrow(IllegalArgumentException.class);

        Assertions.assertDoesNotThrow(() -> target.sumVerify(-5));
    }

    @Test
    void sum6() {
        Mockito.when(random.nextInt(100)).thenReturn(5);
        final int expected = 15;
        final int count = 2;

        final int actual = target.sumTimes(5, count);

        Assertions.assertEquals(expected, actual);
        Mockito.verify(random, Mockito.times(count)).nextInt(100);
    }

    @Test
    void sum7() {
        Mockito.when(random.nextInt(1)).thenCallRealMethod();
        final int expected = 0;

        final int actual = target.sumReal(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sum8() {
        Mockito.when(random.nextInt(Mockito.anyInt())).thenReturn(5);
        final int expected = 5;

        final int actual = target.sumRandomFromRandom(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sum9() {
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        final int expected = 0;

        final int actual = target.sumReturn(0);

        Assertions.assertEquals(expected, actual);

        Mockito.verify(random).nextInt(argumentCaptor.capture());
        final Integer value = argumentCaptor.getValue();
        Assertions.assertEquals(100, value);
    }

    @Test
    void sum10() {
        final int expected = 0;

        Mockito.when(holder.hold(Mockito.argThat(new CustomMatcher()))).thenReturn(0);

        final int actual = target.sumReturn(0);

        Assertions.assertEquals(expected, actual);
        Mockito.verify(holder).hold(Mockito.argThat(new CustomMatcher()));


    }
}