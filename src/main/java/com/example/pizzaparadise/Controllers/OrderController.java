package com.example.pizzaparadise.Controllers;

import com.example.pizzaparadise.Domain.Order;
import com.example.pizzaparadise.Domain.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @GetMapping("/profile")
    public String getProfile(Model model) {
        List<Order> orders = List.of();
        model.addAttribute("username");
        model.addAttribute("orders", orders);
        model.addAttribute("bonusPoints", 0);
        return "profile";
    }


}
