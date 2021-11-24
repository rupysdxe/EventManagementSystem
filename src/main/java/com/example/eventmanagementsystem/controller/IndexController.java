package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.repo.EventRepo;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private EventRepo eventRepo;
    @GetMapping(value = "/")
    public String index(Model model){
        List<Event> eventList=eventRepo.findAll();
        model.addAttribute("eventList",eventList);
        return "index";
    }
    @GetMapping(value = "/pages/login")
    public String PagesLogin(){
        return "login";
    }
}
