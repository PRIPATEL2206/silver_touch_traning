package com.example.jwt_blog_app.Contoler;

import org.springframework.web.bind.annotation.RestController;

import com.example.jwt_blog_app.models.User;
import com.example.jwt_blog_app.services.CustomUserDetailsService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AddUserControler {
    @Autowired
    CustomUserDetailsService userDetailsService;

    // @GetMapping("/adduser")
    // public String addUseString() {
    // List<String> roles = new ArrayList<>();
    // roles.add("USER");
    // userDetailsService.registerUser("user1", "user1@gmail.com", "1234", roles);
    // return "done";
    // }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/register")
    public String register(@RequestBody User request) {
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        userDetailsService.registerUser(request.getUsername(), request.getEmail(), request.getPassword(), roles);
        return "registered sucsess";
    }

}
