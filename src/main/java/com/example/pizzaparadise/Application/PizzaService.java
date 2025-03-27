package com.example.pizzaparadise.Application;

import com.example.pizzaparadise.Domain.Pizza;
import com.example.pizzaparadise.Domain.Toppings;
import com.example.pizzaparadise.InfraStructure.PizzaRepository;

import java.util.List;

public class PizzaService implements PizzaServiceInt, ToppingHandler {

    private PizzaRepository pizzaRepo;

    public PizzaService(PizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    public Pizza createPizza(Pizza pizza){
        return pizzaRepo.savePizza(pizza);
    }

    public List<Pizza> showPizzaMenu(){
        return pizzaRepo.getPizzas();
    }

    public void updatePizza(Pizza pizza){
        pizzaRepo.updatePizza(pizza);
    }
    @Override
    public void addTopping(Pizza pizza, Toppings topping) {
        pizzaRepo.addToppingToPizza(pizza.getId(), topping);
        pizza.getToppings().add(topping);
    }

    @Override
    public void removeTopping(Pizza pizza, Toppings topping) {
        pizzaRepo.removeToppingFromPizza(pizza.getId(), topping);
        pizza.getToppings().remove(topping);
    }
}

