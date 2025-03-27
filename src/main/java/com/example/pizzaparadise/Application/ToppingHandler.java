package com.example.pizzaparadise.Application;

import com.example.pizzaparadise.Domain.Pizza;
import com.example.pizzaparadise.Domain.Toppings;

public interface ToppingHandler {

    void addTopping(Pizza pizza, Toppings topping);

    void removeTopping(Pizza pizza, Toppings topping);
}
