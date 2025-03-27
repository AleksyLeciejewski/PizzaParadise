package com.example.pizzaparadise.InfraStructure;

import com.example.pizzaparadise.Domain.Pizza;
import com.example.pizzaparadise.Domain.Toppings;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PizzaRepository implements PizzaRepoInt{

    private JdbcTemplate jdbcTemplate;

    public PizzaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Pizza savePizza(Pizza pizza){
        String sql = "INSERT INTO pizza (name, description, price) VALUES (?,?,?)";
        jdbcTemplate.update(sql, pizza.getDescription(),pizza.getName(), pizza.getPrice());

        int pizzaId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        for(Toppings toppings : pizza.getToppings()){
            addToppingToPizza(pizzaId, toppings);
        }

        return pizza;
    }

    public Pizza getPizzaByName(String name){
        String sql = "SELECT * FROM pizza WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Pizza.class));
    }

    public List<Pizza> getPizzas(){
        String sql = "SELECT * FROM pizza";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pizza.class));
    }

    public void updatePizza(Pizza pizza){
        String sql = "UPDATE pizza SET name = ?, description = ?, toppings = ? WHERE name = ?";
        jdbcTemplate.update(sql, pizza.getName(), pizza.getDescription(), pizza.getName(), pizza.getName());
    }

    public void deletePizza(String name){
        String sql = "DELETE FROM pizza WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }

    public void addToppingToPizza(int pizzaId, Toppings topping) {
        String sql = "INSERT INTO pizza_toppings (pizza_id, topping_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, pizzaId, topping.getId()); 
    }

    public void removeToppingFromPizza(int pizzaId, Toppings topping) {
        String sql = "DELETE FROM pizza_toppings WHERE pizza_id = ? AND topping_id = ?";
        jdbcTemplate.update(sql, pizzaId, topping.getId());
    }
}
