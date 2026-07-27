package com.example.demodeploy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demodeploy.Service.FirebaseNotificationService;



@RestController
@RequestMapping("/notification")
@CrossOrigin(origins = "*")
public class FirebaseController {


    @Autowired
    private FirebaseNotificationService service;



    @PostMapping("/send")
    public String sendNotification(
            @RequestParam String token,
            @RequestParam String message
    ){

        return service.sendNotification(
                token,
                "Notification from RS jewellers",
                message
        );

    }

}