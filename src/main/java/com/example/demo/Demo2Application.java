package com.example.demo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class Demo2Application {
    ClassLoader classLoader = Demo2Application.class.getClassLoader();
    File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccount.json")).getFile());


    FileInputStream serviceAccount;

    {
        try {
            serviceAccount = new FileInputStream(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    FirebaseOptions options;

    {
        try {
            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FirebaseApp.initializeApp(options);
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

}
