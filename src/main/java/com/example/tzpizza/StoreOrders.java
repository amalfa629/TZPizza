package com.example.tzpizza;

import java.util.ArrayList;

public class StoreOrders {
    private static int currentOrderNumber;
    private ArrayList<Order> orders;
    public StoreOrders() {
        orders = new ArrayList<Order>();
        currentOrderNumber = 0;
        newOrder();
    }
    public void newOrder() {
        currentOrderNumber++;
        Order order = new Order(currentOrderNumber);
        orders.add(order);
    }
    public void addPizza(Pizza pizza) {
        orders.get(currentOrderNumber-1).addPizza(pizza);
    }
    public int getCurrentOrderNumber() {
        return currentOrderNumber;
    }
}
