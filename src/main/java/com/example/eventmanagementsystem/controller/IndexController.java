package com.example.eventmanagementsystem.controller;

import lombok.experimental.PackagePrivate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String index(){
        return "index";
    }
    @GetMapping(value = "/pages/login")
    public String PagesLogin(){
        return "login";
    }
}
