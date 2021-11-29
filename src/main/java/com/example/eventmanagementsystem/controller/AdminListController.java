package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.Admin;
import com.example.eventmanagementsystem.repo.AdminRepo;
import com.example.eventmanagementsystem.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminListController {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private EventRepo eventRepo;
    @GetMapping(value = "/adminList")
    public String adminList(Model model){
        List<Admin> adminList=adminRepo.findAll();
        model.addAttribute("adminList",adminList);
        return "adminList";
    }


}
