package com.example.pizzaparadise.Domain;

import java.util.List;

public class Pizza {

    private int id;
    private String name;
    private String description;
    private List<Toppings> topping;
    private int price;

    public Pizza(String name, String description, int price, List<Toppings> topping) {
        this.name = name;
        this.description = description;
        this.topping = topping;
        this.price = price;
    }

    public Pizza(){}

    public List<Toppings> getToppings() {
        return topping;
    }
    public void setToppings(List<Toppings> toppings) {
        this.topping = toppings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
