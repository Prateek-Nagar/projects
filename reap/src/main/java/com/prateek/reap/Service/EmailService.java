package com.prateek.reap.Service;


import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendEmailToSingleRecipient(String recipient, String Body);

}
