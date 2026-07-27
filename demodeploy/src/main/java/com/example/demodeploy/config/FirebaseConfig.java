package com.example.demodeploy.config;

import java.io.FileInputStream;
import java.io.InputStream;

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
                // Render mounts secret files in /etc/secrets/ or the root directory
                String filePath = "/etc/secrets/firebase-service-account.json";
                
                InputStream serviceAccount;
                try {
                    serviceAccount = new FileInputStream(filePath);
                } catch (Exception e) {
                    // Fallback to local root if testing on your local computer
                    serviceAccount = new FileInputStream("firebase-service-account.json");
                }

                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                FirebaseApp.initializeApp(options);

                System.out.println("======================================");
                System.out.println(" Firebase Initialized Successfully from Secret File!");
                System.out.println("======================================");
            }
        } catch (Exception e) {
            System.err.println("CRITICAL ERROR: Exception thrown during Firebase initialization!");
            e.printStackTrace();
        }
    }
}