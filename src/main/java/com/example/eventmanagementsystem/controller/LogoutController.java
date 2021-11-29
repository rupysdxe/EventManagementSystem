package com.example.eventmanagementsystem.controller;
import com.example.eventmanagementsystem.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;
@Controller
public class LogoutController {
    @Autowired
    private EventRepo eventRepo;
    @GetMapping(value = "/logout")
    public String Logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:";
    }
}
