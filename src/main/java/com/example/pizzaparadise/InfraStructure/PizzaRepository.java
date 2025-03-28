package com.example.pizzaparadise.InfraStructure;

import com.example.pizzaparadise.Domain.Pizza;
import com.example.pizzaparadise.Domain.Toppings;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaRepository implements PizzaRepoInt{

    private JdbcTemplate jdbcTemplate;
    private final ToppingRepo toppingsRepository;

    public PizzaRepository(JdbcTemplate jdbcTemplate, ToppingRepo toppingsRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.toppingsRepository = toppingsRepository;
    }

    public Pizza savePizza(Pizza pizza) {
        String sql = "INSERT INTO pizza (name, description, price) VALUES (?,?,?)";
        jdbcTemplate.update(sql, pizza.getName(), pizza.getDescription(), pizza.getPrice());
        int pizzaId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        for (Toppings topping : pizza.getToppings()) {
            addToppingToPizza(pizzaId, topping);
        }
        return pizza;
    }

    public Pizza getPizzaByName(String name){
        String sql = "SELECT * FROM pizza WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Pizza.class));
    }

    public List<Pizza> getPizzas() {
        String sql = "SELECT * FROM pizza";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pizza.class));
    }

    public List<Toppings> getToppingsByIds(List<Integer> toppingIds) {
        return toppingsRepository.getToppingsByIds(toppingIds);
    }

    public void updatePizza(Pizza pizza){
        String sql = "UPDATE pizza SET name = ?, description = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, pizza.getName(), pizza.getDescription(), pizza.getPrice(), pizza.getId());
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

    public Pizza getPizzaById(int id) {
        String sql = "SELECT * FROM pizza WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Pizza.class));
    }

    public Toppings getToppingById(int id) {
        String sql = "SELECT * FROM toppings WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Toppings.class));
    }

    public List<Toppings> getAllToppings() {
        String sql = "SELECT * FROM toppings";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Toppings.class));
    }
}
