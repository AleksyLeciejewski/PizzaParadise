package com.example.pizzaparadise.InfraStructure;

import com.example.pizzaparadise.Domain.Toppings;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToppingRepo {

    private final JdbcTemplate jdbcTemplate;

    public ToppingRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Toppings> getToppingsByIds(List<Integer> toppingIds) {
        String sql = "SELECT * FROM toppings WHERE id IN (" +
                String.join(",", toppingIds.stream().map(id -> "?").toArray(String[]::new)) + ")";
        return jdbcTemplate.query(sql, toppingIds.toArray(), new BeanPropertyRowMapper<>(Toppings.class));
    }
}