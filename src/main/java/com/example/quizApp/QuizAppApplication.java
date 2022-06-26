package com.example.quizApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan("com.example.quizApp.filter")
@SpringBootApplication
public class QuizAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizAppApplication.class, args);
    }

}
