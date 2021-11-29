package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.Admin;
import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.repo.AdminRepo;
import com.example.eventmanagementsystem.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RegisterController {
    private final AdminRepo adminRepo;
    private final EventRepo eventRepo;

    public RegisterController(AdminRepo adminRepo, EventRepo eventRepo) {
        this.adminRepo = adminRepo;
        this.eventRepo = eventRepo;
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute Admin admin, Model model, HttpSession httpSession){
        if(httpSession.getAttribute("admin")==null){
            return "redirect:";
        }
        if(adminRepo.findAdminByUsernameAndPassword(admin.getUsername(), admin.getPassword())!=null){
            model.addAttribute("adminerror","Admin Already Exist !");
            return "redirect:register";
        }
        adminRepo.save(new Admin(admin.getFirstName(),admin.getLastName(),admin.getUsername(), admin.getPassword(),admin.getPosition()));
        return "redirect:adminPanel";
    }

}
