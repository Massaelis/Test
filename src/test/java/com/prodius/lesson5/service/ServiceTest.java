package com.prodius.lesson5.service;

import com.prodius.module2.lesson5.message.Massage;
import com.prodius.module2.lesson5.repository.Repository;
import com.prodius.module2.lesson5.service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ServiceTest {

    private Service target;

    private Repository repository;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(Repository.class);
        target = new Service(repository);
    }

    //Если вызывать тест через тестовый класс выдает ошибку, а если отдельно то проходит
    @Test
    @DisplayName("TestThirdMethod")
    void checkSenderMassage() {
        final int expected = 3;
        final String sender = "qwerty";
        final List<Massage> massages = new ArrayList<>();
        massages.add(new Massage(null, null));
        massages.add(new Massage(null, null));
        massages.add(new Massage(null, null));
        Mockito.when(repository.getAll(sender)).thenReturn(massages);

        final int actual = target.checkSenderMassage(sender);

        Assertions.assertEquals(expected, actual);
        Mockito.verify(repository).getAll(sender);
    }

    //5
    @Test
    void getByRandomIdAndChangeSender() {
        Massage massage = new Massage("zxc", "qwerty");
        Mockito.when(repository.getById(Mockito.any())).thenReturn(massage);

        final Massage actual = target.getByRandomIdAndChangeSender();

        Assertions.assertEquals("incognito", actual.getSender());
        Assertions.assertEquals("zxc", actual.getReceiver());
    }

    //6
    //а тут не могу понять как пользоваться кастомным матчером. Пробовал и через аргумент, но не вышло
    @Test
    void changeMassageSender() {
        final Massage massage = new Massage("qwerty", "ytrewq");

        Mockito.when(
                repository.getByMessage(
                        Mockito.argThat(new CustomMatcher())
                )
        ).thenReturn(Optional.of(massage));

        Assertions.assertNotEquals("qwerty", massage.getSender());

        target.changeMassageSender(massage);

        Assertions.assertEquals("qwerty", massage.getSender());
    }

    //6 exception
    @Test
    void checkException() {
        final Massage massage = new Massage("qwerty", "ytrewq");

        Mockito.when(
                repository.getByMessage(
                        Mockito.argThat(new CustomMatcher())
                )
        ).thenReturn(Optional.empty());

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> target.changeMassageSender(massage),
                "null"
        );
    }

    @Nested
    class TestFirstMethod {
        @Test
        @DisplayName("Sender and Receiver Null ")
        void checkSenderAndReceiverNull() {
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> target.checkOfEmpty(null, null),
                    "null"
            );
        }

        @Test
        @DisplayName("Sender Null ")
        void checkSenderNull() {
            final String receiver = "qwerty";

            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> target.checkOfEmpty(null, receiver),
                    "null"
            );
        }

        @Test
        @DisplayName("Receiver Null ")
        void checkReceiverNull() {
            final String sender = "qwerty";

            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> target.checkOfEmpty(sender, null),
                    "null"
            );
        }

        @Test
        @DisplayName("Save in repository ")
        void checkSaveInRepository() {
            final String sender = "qwerty";
            final String receiver = "zxc";

            ArgumentCaptor<Massage> argumentCaptor = ArgumentCaptor.forClass(Massage.class);

            target.checkOfEmpty(sender, receiver);
            Mockito.verify(repository).save(argumentCaptor.capture());
            final Massage actual = argumentCaptor.getValue();
            Assertions.assertEquals(sender, actual.getSender());
            Assertions.assertEquals(receiver, actual.getReceiver());
        }
    }

    @Nested
    class TestSecondMethod {
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
    }

    @Nested
    class TestFourMethod {
        @Test
        void saveReceiver() {
            final String receiver = "qwerty";

            target.checkReceiverCharacter(receiver);
            Mockito.verify(repository).save(Mockito.isA(Massage.class));
        }

        @RepeatedTest(1)
        void notSaveReceiver() {
            final String receiver = "zxc";

            target.checkReceiverCharacter(receiver);
            Mockito.verify(repository, Mockito.never()).save(Mockito.isA(Massage.class));
        }
    }
}