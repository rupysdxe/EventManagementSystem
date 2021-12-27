package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.Admin;
import com.example.eventmanagementsystem.repo.AdminRepo;
import com.example.eventmanagementsystem.repo.EventRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;


@Controller
public class LoginController {
    private final AdminRepo adminRepo;
    private final EventRepo eventRepo;

    public LoginController(AdminRepo adminRepo, EventRepo eventRepo) {
        this.adminRepo = adminRepo;
        this.eventRepo = eventRepo;
    }
    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }


    @PostMapping(value = "/login")
    public String login(@ModelAttribute Admin admin, Model model,HttpSession httpSession){

        Admin admin1=adminRepo.findAdminByUsernameAndPassword(admin.getUsername(),DigestUtils.md5DigestAsHex(admin.getPassword().getBytes(StandardCharsets.UTF_8)));

        if(admin1!=null){
            httpSession.setAttribute("admin",admin1);
            return "redirect:adminPanel";
        }
        model.addAttribute("error","Login Failed ! Try Again ");
        return "login";
    }
}
