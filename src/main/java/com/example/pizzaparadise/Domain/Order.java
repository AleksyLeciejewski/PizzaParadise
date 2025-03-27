package com.example.pizzaparadise.Domain;

import java.util.Date;

public class Order {
    private Date date;
    private Pizza pizza;

    public Order() {
        this.date = date;
        this.pizza = pizza;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Pizza getPizza() {
        return pizza;
    }
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

}
