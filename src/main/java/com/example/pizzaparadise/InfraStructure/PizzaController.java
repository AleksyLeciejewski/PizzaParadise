package com.example.pizzaparadise.InfraStructure;

import com.example.pizzaparadise.Application.PizzaService;
import com.example.pizzaparadise.Application.ToppingHandler;
import com.example.pizzaparadise.Domain.Pizza;
import com.example.pizzaparadise.Domain.Toppings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaService pizzaService;
    private final ToppingHandler toppingHandler;

    public PizzaController(PizzaService pizzaService, ToppingHandler toppingHandler) {
        this.pizzaService = pizzaService;
        this.toppingHandler = toppingHandler;
    }

    @GetMapping("/menu")
    public String getPizzaMenu(Model model) {
        List<Pizza> pizzas = pizzaService.showPizzaMenu();
        List<Toppings> toppings = pizzaService.getAllToppings();
        model.addAttribute("pizzas", pizzas);
        model.addAttribute("toppings", toppings);
        return "menu";
    }

    @GetMapping("/create")
    public String showCreatePizzaForm(Model model) {
        List<Toppings> toppings = pizzaService.getAllToppings();
        model.addAttribute("toppings", toppings);
        return "createPizza";
    }

    @PostMapping("/create")
    public String createPizza(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") int price,
            @RequestParam(value = "toppingIds", required = false) List<Integer> toppingIds)
    {
        List<Toppings> toppings = pizzaService.getToppingsByIds(toppingIds);
        Pizza pizza = new Pizza(name, description, price, toppings);
        pizzaService.createCustomPizza(pizza);

        return "redirect:/pizza/menu";
    }

    @GetMapping("/view/{id}")
    public String getPizzaById(@PathVariable("id") int id, Model model) {
        Pizza pizza = pizzaService.getPizzaById(id);
        model.addAttribute("pizza", pizza);
        return "viewPizza";
    }

    @PostMapping("/addTopping")
    public String addToppingToPizza(@RequestParam("pizzaId") int pizzaId, @RequestParam("toppingId") int toppingId) {
        Pizza pizza = pizzaService.getPizzaById(pizzaId);
        Toppings topping = pizzaService.getToppingById(toppingId);
        toppingHandler.addTopping(pizza, topping);
        return "redirect:/pizza/menu";
    }
}
