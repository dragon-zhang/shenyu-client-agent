package com.example.userapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserAppApplication {
    
    /**
     * run with jvm arg: -javaagent:/Users/admin/Desktop/shenyu-client-agent/shenyu-agent/target/shenyu-agent-1.0.0-SNAPSHOT.jar
     */
    public static void main(String[] args) {
        SpringApplication.run(UserAppApplication.class, args);
    }
    
}
