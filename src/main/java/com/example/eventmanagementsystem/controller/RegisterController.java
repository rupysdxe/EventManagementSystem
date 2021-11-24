package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.Admin;
import com.example.eventmanagementsystem.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private AdminRepo adminRepo;
    @PostMapping(value = "/register")
    public String register(@ModelAttribute Admin admin, Model model){
        Admin admin1=adminRepo.findAdminByUsernameAndPassword(admin.getUsername(),admin.getPassword());
        if(admin1!=null){
            model.addAttribute("adminerror","Admin Already Exist !");
            return "register";
        }
        Admin admin2=new Admin(admin.getUsername(),admin.getPassword());
        adminRepo.save(admin2);
        return "adminDashboard";

    }
}
