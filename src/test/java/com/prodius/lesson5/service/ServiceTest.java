package com.prodius.lesson5.service;

import com.prodius.lesson5.message.Massage;
import com.prodius.lesson5.repository.Repository;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class ServiceTest {

    private Service target;

    private Repository repository;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(Repository.class);
        target = new Service(repository);
    }

    @Nested
    class TestFirstMethod {
        @Test
        @DisplayName("Sender and Receiver Null ")
        void checkSenderAndReceiverNull() {
            final String sender = null;
            final String receiver = null;

            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> target.checkOfEmpty(sender, receiver),
                    "null"
            );
        }

        @Test
        @DisplayName("Sender Null ")
        void checkSenderNull() {
            final String sender = null;
            final String receiver = "qwerty";

            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> target.checkOfEmpty(sender, receiver),
                    "null"
            );
        }

        @Test
        @DisplayName("Receiver Null ")
        void checkReceiverNull() {
            final String sender = "qwerty";
            final String receiver = null;

            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> target.checkOfEmpty(sender, receiver),
                    "null"
            );
        }

        @Test
        @DisplayName("Save in repository ")
        void checkSaveInRepository() {
            final String sender = "qwerty";
            final String receiver = "zxc";

            final Massage massage = target.checkOfEmpty(sender, receiver);
            Mockito.verify(repository).save(massage);
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

    //Если вызывать тест через тестовый класс выдает ошибку, а если отдельно то проходит
    @Test
    @DisplayName("TestThirdMethod")
    void checkSenderMassage() {
        final int expected = 0;

        final int actual = target.checkSenderMassage("qwerty");

        Assertions.assertEquals(expected, actual);
        Mockito.verify(repository).getAll("qwerty");
    }

    @Nested
    class TestFourMethod {
        @Test
        void saveReceiver() {
            final String receiver = "qwerty";

            final Massage massage = target.checkReceiverCharacter(receiver);
            Mockito.verify(repository).save(massage);
        }

        @RepeatedTest(1)
        void notSaveReceiver() {
            final String receiver = "zxc";

            final Massage massage = target.checkReceiverCharacter(receiver);
            Mockito.verify(repository, Mockito.never()).save(massage);
        }
    }

    //5
    //не могу понять почму мокито.any равен нулю
    @Test
    void getByRandomIdAndChangeSender() {
        Massage massage = new Massage("zxc", "incognito");
//        Mockito.when(repository.getById(Mockito.any())).thenCallRealMethod();
        //Mockito.verify(repository).getById(Mockito.any());


        final Massage actual = target.getByRandomIdAndChangeSender();

        Assertions.assertEquals("test", actual.getSender());
        Assertions.assertEquals("test-1", actual.getReceiver());
    }

    //6
    //а тут не могу понять как пользоваться кастомным матчером. Пробовал и через аргумент, но не вышло
    @Test
    void changeMassageSender() {
        final Massage massage = new Massage("qwerty", "ytrewq");

        target.changeMassageSender(massage);


        ArgumentCaptor<Massage> massageArgumentCaptor = ArgumentCaptor.forClass(Massage.class);
        Mockito.verify(target, Mockito.times(1)).changeMassageSender(massageArgumentCaptor.capture());
        Massage argument = massageArgumentCaptor.getValue();
    }

    //6 exception
    @Test
    void checkException() {
        final Massage massage = null;

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> target.changeMassageSender(massage),
                "null"
        );
    }
}