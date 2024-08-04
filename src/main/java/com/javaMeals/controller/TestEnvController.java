package com.javaMeals.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestEnvController {
    
    @GetMapping("/env")
    public String getTestEnv() {
        String danger = System.getenv("MONGO_PASSWORD");
        if (!danger.isEmpty()) {
            return "TEST ENV: " + danger;
        } else {
            return "TEST ENV NOT WORKING!! :(";
        }
    }
}
