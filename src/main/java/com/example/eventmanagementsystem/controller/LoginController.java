package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.Admin;
import com.example.eventmanagementsystem.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private AdminRepo adminRepo;
    @PostMapping(value = "/pages/login/adminpanel")
    public String login(@ModelAttribute Admin admin, Model model){
        Admin admin1=adminRepo.findAdminByUsernameAndPassword(admin.getUsername(),admin.getPassword());
        if(admin1!=null){
            model.addAttribute("admin",admin1.getUsername());
            return "adminDashboard";
        }
        model.addAttribute("error","Login Failed ! Try Again ");
        return "login";
    }
}
