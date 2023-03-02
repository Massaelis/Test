package com.prodius.lesson5.service;

import com.prodius.lesson5.message.Massage;
import com.prodius.lesson5.repository.Repository;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Service {
    Random random = new Random();
    Massage massage = new Massage(RandomStringUtils.random(6), RandomStringUtils.random(6));

    //1
    public Massage checkOfEmpty(String sender, String receiver){
        if(sender != ""){
            if(receiver != ""){
                Repository.save(massage);
            }else{
                System.out.println("You not write message to sender: " + new IllegalArgumentException());
            }
        } else {
            System.out.println("You not write message to receiver: " + new IllegalArgumentException());
        }
        return massage;
    }

    //2
    public String checkMassage(int times){
        for (int i = 0; i < times; i++){
            Repository.showMassage();
        }
        return Repository.showMassage();
    }

    //3
    public String checkSenderMassage(){
        return (String) Repository.getAll(massage.sender);
    }

    //4
    public Massage checkReceiverCharacter() {
        if(massage.receiver.length() >= 5 )  {
            Repository.save(massage);
        }else {
            System.out.println("Length massage is small: " + massage.receiver);
        }
        return massage;
    }

}