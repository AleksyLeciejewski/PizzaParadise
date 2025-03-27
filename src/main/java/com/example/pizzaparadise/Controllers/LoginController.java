package com.example.pizzaparadise.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, @RequestParam String email, Model model) {
        model.addAttribute("Username", username);
        model.addAttribute("Password", password);
        model.addAttribute("Email", email);
        return "pizzaparadise";
    }


    @PostMapping("/register")
    public String register(@RequestParam String newUsername, @RequestParam String newPassword, @RequestParam String newEmail, Model model) {
        model.addAttribute("newUsername", newUsername);
        model.addAttribute("newPassword", newPassword);
        model.addAttribute("newEmail", newEmail);
        return "pizzaparadise";
    }
}
