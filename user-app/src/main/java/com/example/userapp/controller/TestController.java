package com.example.userapp.controller;

import org.apache.shenyu.client.springmvc.annotation.ShenyuSpringMvcClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HaiLang
 * @date 2022/8/20 18:14
 */
@RestController
public class TestController {
    
    /**
     * hello.
     *
     * @return result
     */
    @RequestMapping("/shenyu/client/hello")
    @ShenyuSpringMvcClient("/shenyu/client/hello")
    public String hello() {
        return "hello";
    }
}
