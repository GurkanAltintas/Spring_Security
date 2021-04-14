package net.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){

        return "Welcome";
    }
    @GetMapping("/user")
    public String user(){

        return "Welcome to user";
    }
    @GetMapping("/admin")
    public String admin(){

        return "Welcome to admin";
    }
}
