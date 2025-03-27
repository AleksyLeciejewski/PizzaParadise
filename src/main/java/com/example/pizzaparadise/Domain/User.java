package com.example.pizzaparadise.Domain;

import java.util.List;

public class User {
    private String username;
    private String password;
    private String email;
    private List<Order> orderHistory;

    public User(String username, String password, String email, List<Order> orderHistory) {
        this.username = username;
        this.password = password;
        this.orderHistory = orderHistory;

    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }
    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }
}
