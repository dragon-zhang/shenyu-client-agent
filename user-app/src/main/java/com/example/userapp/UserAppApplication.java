package com.example.userapp;

import org.apache.shenyu.jvmti.JVMTI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserAppApplication {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext[] contexts = JVMTI.getInstances(ConfigurableApplicationContext.class);
        System.out.println("before run->" + contexts.length);
        SpringApplication.run(UserAppApplication.class, args);
        contexts = JVMTI.getInstances(ConfigurableApplicationContext.class);
        System.out.println("after run->" + contexts.length);
    }
    
}
