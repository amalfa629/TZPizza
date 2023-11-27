package com.example.tzpizza;

import java.io.FileWriter;
import java.io.IOException;
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
    public void cancelOrder(int orderNumber) {
        int index = -1;
        for(Order o: orders) {
            if(o.getOrderNumber() == orderNumber) index = orders.indexOf(o);
        }
        orders.remove(index);
    }
    public void addPizza(Pizza pizza) {
        orders.get(currentOrderNumber-1).addPizza(pizza);
    }
    public int getCurrentOrderNumber() {
        return currentOrderNumber;
    }
    public Order getOrder(int orderNumber) {
        return orders.get(orderNumber - 1);
    }
    public void export() {
        try {
            FileWriter output = new FileWriter("src/main/resources/com/tzpizza/orders.txt");
            for (Order o : orders) {
                output.write("Order #" + o.getOrderNumber() + "\n");
                for(String pizza: o.getPizzaStringList()) {
                    output.write(pizza + "\n");
                }
            }
            output.close();
        }
        catch(Exception ignored) {}
    }
}
