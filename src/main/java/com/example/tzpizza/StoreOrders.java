package com.example.tzpizza;

import java.util.ArrayList;

public class StoreOrders {
    private static int nextOrderNumber;
    private ArrayList<Order> orders;
    public StoreOrders() {
        nextOrderNumber = 1;
        orders = new ArrayList<Order>();
    }
    public void newOrder() {
        Order order = new Order(nextOrderNumber);
        nextOrderNumber++;
        orders.add(order);
    }
}
