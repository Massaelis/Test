package com.prodius.lesson5.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Massage {
    public String receiver;
    public String sender;

    public Massage(){

    }

    public Massage(String receiver, String sender){
        this.receiver = receiver;
        this.sender = sender;
    }

//    public String receiver() {
//        System.out.print("Write message to sender: ");
//        String line = null;
//        if (SCANNER.hasNextLine()) {
//            line = SCANNER.nextLine();
//            System.out.println("You write message to sender: " + line);
//        }
//        return line;
//    }
//    public String sender() {
//        System.out.print("Write message to receiver: ");
//        String line = null;
//        if (SCANNER.hasNextLine()) {
//            line = SCANNER.nextLine();
//            System.out.println("You write message to receiver: " + line);
//        }
//        return line;
//    }

}
