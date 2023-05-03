package com.dev.services;

public class MailService {

    public void sendEmail(String receiver, String message){
        System.out.println(message + " is being sent to "+ receiver);
    }
}
