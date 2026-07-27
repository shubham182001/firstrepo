package com.example.demodeploy.config;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initialize() {
        try {
            if (FirebaseApp.getApps().isEmpty()) {
                // Read the JSON string from the Render Environment Variable
                String firebaseConfig = System.getenv("FIREBASE_CONFIG_JSON");

                if (firebaseConfig == null || firebaseConfig.isEmpty()) {
                    throw new RuntimeException("FIREBASE_CONFIG_JSON environment variable is missing!");
                }

                InputStream serviceAccount = new ByteArrayInputStream(firebaseConfig.getBytes(StandardCharsets.UTF_8));

                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                FirebaseApp.initializeApp(options);

                System.out.println("======================================");
                System.out.println(" Firebase Initialized Successfully from Env");
                System.out.println("======================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}