
package com.example.pizzaparadise.Domain;

public class Pizza {

    private String name;
    private String description;
    private String topping;
    private int price;

    public Pizza( String name, String description, String topping, int price) {
        this.name = name;
        this.description = description;
        this.topping = topping;
        this.price = price;
    }

    public Pizza(){

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

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


