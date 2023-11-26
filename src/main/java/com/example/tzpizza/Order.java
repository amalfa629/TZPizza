package com.example.tzpizza;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> pizzas;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        pizzas = new ArrayList<Pizza>();
    }
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }
}
