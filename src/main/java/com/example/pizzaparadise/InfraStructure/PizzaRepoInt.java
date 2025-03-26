package com.example.pizzaparadise.InfraStructure;

import com.example.pizzaparadise.Domain.Pizza;
import com.example.pizzaparadise.Domain.Toppings;

import java.util.List;

public interface PizzaRepoInt {

    Pizza savePizza(Pizza pizza);
    Pizza getPizzaByName(String name);
    List<Pizza> getPizzas();
    void update(Pizza pizza);
    void deletePizza(String name);
}
