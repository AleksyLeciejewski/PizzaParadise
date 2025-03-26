package com.example.pizzaparadise.InfraStructure;

import com.example.pizzaparadise.Domain.Pizza;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PizzaRepository implements PizzaRepoInt{

    private JdbcTemplate jdbcTemplate;

    public PizzaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Pizza savePizza(Pizza pizza){
        String sql = "INSERT INTO pizza (name, description, toppings, price) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, pizza.getDescription(),pizza.getName(), pizza.getPrice(), pizza.getTopping());
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

    public void update(Pizza pizza){
        String sql = "UPDATE pizza SET name = ?, description = ?, toppings = ? WHERE name = ?";
        jdbcTemplate.update(sql, pizza.getName(), pizza.getDescription(), pizza.getName(), pizza.getName());
    }

    public void deletePizza(String name){
        String sql = "DELETE FROM pizza WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }
}
