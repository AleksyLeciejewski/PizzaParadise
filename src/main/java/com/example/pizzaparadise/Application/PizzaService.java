package com.example.pizzaparadise.Application;

import com.example.pizzaparadise.Domain.Pizza;
import com.example.pizzaparadise.Domain.Toppings;
import com.example.pizzaparadise.InfraStructure.PizzaRepository;
import com.example.pizzaparadise.InfraStructure.ToppingRepo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService implements PizzaServiceInt, ToppingHandler {

    private PizzaRepository pizzaRepo;
    private ToppingRepo toppingRepo;

    public PizzaService(PizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    public Pizza createPizza(String name, String description, int price, List<Integer> toppingIds) {
        List<Toppings> selectedToppings = toppingRepo.getToppingsByIds(toppingIds);
        Pizza pizza = new Pizza(name, description, price, selectedToppings);
        return pizzaRepo.savePizza(pizza);
    }

    public Pizza createCustomPizza(Pizza pizza) {
        return pizzaRepo.savePizza(pizza);
    }

    public List<Pizza> showPizzaMenu(){
        return pizzaRepo.getPizzas();
    }

//    public Pizza getPizzaById(int id){
//        //SKAL IMPLEMENTERES
//    }

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
    public List<Toppings> getAllToppings() {
        return pizzaRepo.getAllToppings();
    }
    public Toppings getToppingById(int id) {
        return pizzaRepo.getToppingById(id);
    }
    public Pizza getPizzaById(int id) {
        return pizzaRepo.getPizzaById(id);
    }
    public List<Toppings> getToppingsByIds(List<Integer> toppingIds) {
        return toppingRepo.getToppingsByIds(toppingIds);
    }
}


