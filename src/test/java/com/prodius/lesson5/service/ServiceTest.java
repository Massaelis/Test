package com.prodius.lesson5.service;

import com.prodius.lesson5.message.Massage;
import com.prodius.lesson5.repository.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServiceTest {

    private Service target;

    private Repository repository;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(Repository.class);
        target = new Service(repository);
    }

    @Test
    void checkMassageCountNotZero() {
        final int count = 10;

        target.checkMassage(count);

        Mockito.verify(repository, Mockito.times(count)).getAll();
    }

    @Test
    void checkMassageCountZero() {
        final int count = 0;

        target.checkMassage(count);

        Mockito.verify(repository, Mockito.times(count)).getAll();
    }

    @Test
    void checkMassageCountNegative() {
        final int count = -5;

        target.checkMassage(count);

        Mockito.verify(repository, Mockito.never()).getAll();
    }

    @Test
    void checkSenderMassage() {
        final int expected = 0;

        final int actual = target.checkSenderMassage("qwerty");

        Assertions.assertEquals(expected, actual);
        Mockito.verify(repository).getAll();
    }

    @Test
    void changeMassageSender() {
        final Massage massage = new Massage("qwerty", "ytrewq");

        target.changeMassageSender(massage);
    }

    @Test
    void getByRandomIdAndChangeSender() {
        final Massage actual = target.getByRandomIdAndChangeSender();

        Assertions.assertEquals("test", actual.getSender());
        Assertions.assertEquals("test-1", actual.getReceiver());
    }
}