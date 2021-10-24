package com.example.spring.controller;

import com.example.spring.service.abstraction.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final IAuthService authService;

    @Autowired
    public LoginController(IAuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(String login, String password, HttpSession httpSession) {
        if (authService.loginAdmin(login, password)) {
            httpSession.setAttribute("role", "admin");
            return "redirect:/";
        }
        return "redirect:/login";
    }
}
