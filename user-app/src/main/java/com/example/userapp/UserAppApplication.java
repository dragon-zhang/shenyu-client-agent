package com.example.userapp;

import org.apache.shenyu.client.ShenyuClientEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserAppApplication {
    
    @Bean
    public ShenyuClientEventListener shenyuClientEventListener() {
        return new ShenyuClientEventListener();
    }
    
    /**
     * run with jvm arg:
     * -javaagent:/Users/admin/Desktop/shenyu-client-agent/shenyu-agent-use-jvmti/target/shenyu-agent-use-jvmti-1.0.0-SNAPSHOT.jar
     * or
     * -javaagent:/Users/admin/Desktop/shenyu-client-agent/shenyu-agent-unuse-jvmti/target/shenyu-agent-unuse-jvmti-1.0.0-SNAPSHOT.jar
     */
    public static void main(String[] args) {
        SpringApplication.run(UserAppApplication.class, args);
    }
    
}
