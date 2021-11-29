package com.example.eventmanagementsystem.controller;
import com.example.eventmanagementsystem.model.Admin;
import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

@Controller
public class CreateEventController {
    @Autowired
    private EventRepo eventRepo;

    @GetMapping(value = "/create")
    public String eventController(HttpSession httpSession){
        if(httpSession.getAttribute("admin")==null){
            return "redirect:";
        }
        return "event";
    }

    @PostMapping(value = "/createEvent")
    public String createEvent(@ModelAttribute Event event, Model model, HttpSession httpSession){
        if(httpSession.getAttribute("admin")==null){
            return "redirect:";
        }
        Event event1=new Event();

        event1.setAdmin((Admin)httpSession.getAttribute("admin"));
        event1.setEid(event.getEid());
        event1.setNotice(event.getNotice());
        event1.setTopic(event.getTopic());
        event1.setHourDifference("");
        eventRepo.save(event1);
        return "redirect:adminPanel";
    }

}
