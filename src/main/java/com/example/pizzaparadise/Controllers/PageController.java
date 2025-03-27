package com.example.pizzaparadise.Controllers;


import ch.qos.logback.core.model.Model;
import com.example.pizzaparadise.Application.PizzaService;
import com.example.pizzaparadise.Domain.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @GetMapping
    public String index() {
        return "index";
    }

}
