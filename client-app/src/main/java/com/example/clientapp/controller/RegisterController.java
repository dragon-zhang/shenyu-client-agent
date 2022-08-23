package com.example.clientapp.controller;

import net.bytebuddy.agent.ByteBuddyAgent;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @author HaiLang
 * @date 2022/8/20 18:14
 */
@RestController
public class RegisterController {
    
    /**
     * hello.
     *
     * @return result
     */
    @RequestMapping("/register")
    public String hello(@RequestBody String pid) {
        File agentJar = new File("");
        ByteBuddyAgent.attach(agentJar, pid);
        
        return "register";
    }
}
