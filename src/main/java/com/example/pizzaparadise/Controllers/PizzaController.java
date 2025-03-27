package com.example.pizzaparadise.Controllers;


import com.example.pizzaparadise.Domain.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.pizzaparadise.InfraStructure.PizzaRepoInt;
import com.example.pizzaparadise.InfraStructure.PizzaRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PizzaController {
    @GetMapping("/pizzas")
    public String pizzas(Model model) {
        List<Pizza> pizzas = List.of(
                new Pizza("Margarita", "Standard pizza", "Tomatsovs & ost", 40),
                new Pizza("CheeseMeister", "Varierende oste pizza", "Tomatsovs & 5 forskellige oste", 60)
        );
        return "pizzaMenu";
    }
}
