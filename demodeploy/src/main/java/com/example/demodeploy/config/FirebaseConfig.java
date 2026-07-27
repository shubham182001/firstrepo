package com.example.demodeploy.config;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
                String base64Config = System.getenv("FIREBASE_CONFIG_BASE64");

                if (base64Config == null || base64Config.isEmpty()) {
                    System.err.println("CRITICAL ERROR: FIREBASE_CONFIG_BASE64 environment variable is MISSING or EMPTY!");
                    return;
                }

                byte[] decodedBytes = Base64.getDecoder().decode(base64Config.trim());
                InputStream serviceAccount = new ByteArrayInputStream(decodedBytes);

                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                FirebaseApp.initializeApp(options);

                System.out.println("======================================");
                System.out.println(" Firebase Initialized Successfully via Base64!");
                System.out.println("======================================");
            }
        } catch (Exception e) {
            System.err.println("CRITICAL ERROR: Exception thrown during Firebase initialization!");
            e.printStackTrace();
        }
    }
}