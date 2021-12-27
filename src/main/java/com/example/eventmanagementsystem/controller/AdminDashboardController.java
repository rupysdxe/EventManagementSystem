package com.example.eventmanagementsystem.controller;
import com.example.eventmanagementsystem.model.Admin;
import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class AdminDashboardController {
    @Autowired
    private EventRepo eventRepo;

  @GetMapping(value = "/adminPanel")
    public String adminDashboard(Model model,HttpSession httpSession){
        List<Event> eventList=eventRepo.findAll();
        StaticClass.addTimeValue(eventList);
        model.addAttribute("eventList",eventList);
        Admin temp=(Admin) httpSession.getAttribute("admin");
        model.addAttribute("admin",temp.getFirstName());
        return "adminDashboard";
    }

    @GetMapping(value = "/register")
    public String register(HttpSession httpSession, Model model){
       if(httpSession.getAttribute("admin")==null){
           return "redirect:";
       }
        return "register";
    }

   @GetMapping(value = "/delete")
  public String delete(@RequestParam int eid){
      eventRepo.deleteById(eid);
      return "redirect:adminPanel";
  }

  @GetMapping(value = "/edit")
    public String edit(@RequestParam int eid,Model model){
      Event event=eventRepo.getById(eid);
      model.addAttribute("event",event);
      return "edit";

  }


}
