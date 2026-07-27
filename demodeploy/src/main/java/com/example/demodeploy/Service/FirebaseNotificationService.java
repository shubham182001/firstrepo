package com.example.demodeploy.Service;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class FirebaseNotificationService {


    public String sendNotification(
            String token,
            String title,
            String body
    ) {


        Notification notification = Notification.builder()
                .setTitle(title)
                .setBody(body)
                .build();


        Message message = Message.builder()
                .setToken(token)
                .setNotification(notification)
                .build();


        try {

            String response = FirebaseMessaging.getInstance()
                    .send(message);

            return response;

        } catch (Exception e) {

            e.printStackTrace();

            return "Notification Failed";

        }

    }

}