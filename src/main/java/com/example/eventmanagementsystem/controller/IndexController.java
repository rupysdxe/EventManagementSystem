package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.repo.EventRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class IndexController {

    private final EventRepo eventRepo;

    public IndexController(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @GetMapping(value = "/")

    public String index(Model model){

        List<Event> eventList=eventRepo.findAll();

        StaticClass.addTimeValue(eventList);

        model.addAttribute("eventList",eventList);

        return "index";

    }

}
