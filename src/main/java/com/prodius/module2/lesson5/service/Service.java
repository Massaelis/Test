package com.prodius.module2.lesson5.service;

import com.prodius.module2.lesson5.message.Massage;
import com.prodius.module2.lesson5.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Service {
    private final Repository repository;

    private final Random random = new Random();

    public Service(final Repository repository) {
        this.repository = repository;
    }

    //1
    public void checkOfEmpty(final String sender, final String receiver) {
        if (sender == null || receiver == null) {
            throw new IllegalArgumentException();
        }
        final Massage massage = new Massage(receiver, sender);
        repository.save(massage);
    }

    //2
    public void checkMassage(final int times) {
        for (int i = 0; i < times; i++) {
            repository.getAll();
        }
    }

    //3
    public int checkSenderMassage(final String sender) {
        final List<Massage> messages = repository.getAll(sender);
        return messages.size();
    }

    //4
    public void checkReceiverCharacter(final String receiver) {
        Massage massage = null;
        if (receiver.length() >= 5) {
            massage = new Massage(receiver, null);
            repository.save(massage);
        }
    }

    //5
    public Massage getByRandomIdAndChangeSender() {
        final int number = random.nextInt();
        final Massage massage = repository.getById(number);
        massage.setSender("incognito");
        return massage;
    }

    //6
    public void changeMassageSender(final Massage massage) {
        final Optional<Massage> optionalMassage = repository.getByMessage(massage);
        if (optionalMassage.isPresent()) {
            optionalMassage.get().setSender("qwerty");
        } else {
            throw new IllegalArgumentException();
        }
    }

}