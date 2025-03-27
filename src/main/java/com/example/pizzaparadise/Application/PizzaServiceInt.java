package com.example.pizzaparadise.Application;

import com.example.pizzaparadise.Domain.Pizza;

import java.util.List;

public interface PizzaServiceInt {

    Pizza createPizza(String name, String description, int price, List<Integer> toppingIds);

    List<Pizza> showPizzaMenu();

    void updatePizza(Pizza pizza);

}
