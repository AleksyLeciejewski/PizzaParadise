package com.example.pizzaparadise.Application;

import com.example.pizzaparadise.Domain.Pizza;

import java.util.List;

public interface PizzaServiceInt {

    Pizza createPizza(Pizza pizza);

    List<Pizza> showPizzaMenu();

    void updatePizza(Pizza pizza);

}
