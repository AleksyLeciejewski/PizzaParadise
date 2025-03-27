
package com.example.pizzaparadise.InfraStructure;

import com.example.pizzaparadise.Domain.Pizza;

import java.util.List;

public interface PizzaRepoInt {

    Pizza savePizza(Pizza pizza);
    Pizza getPizzaByName(String name);
    List<Pizza> getPizzas();
    void updatePizza(Pizza pizza);
    void deletePizza(String name);
}


