package com.example.demodeploy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demodeploy.Service.FirebaseNotificationService;



@RestController
@RequestMapping("/notification")
public class FirebaseController {


    @Autowired
    private FirebaseNotificationService service;



    @PostMapping("/send")
    public String sendNotification(
            @RequestParam String token
    ){

        return service.sendNotification(
                token,
                "Test Notification",
                "Hello from Spring Boot"
        );

    }

}