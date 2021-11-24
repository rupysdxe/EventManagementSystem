package com.example.eventmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminDashboardController {


    @GetMapping(value = "/register")
    public String register(){
        return "register";
    }

}
