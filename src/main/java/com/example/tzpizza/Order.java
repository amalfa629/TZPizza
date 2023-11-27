package com.example.tzpizza;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> pizzas;
    private double subtotal;
    private double NJStateTax;
    private double total;
    private static double NJTaxRate = 0.06625;
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        pizzas = new ArrayList<Pizza>();
        subtotal = 0;
        NJStateTax = 0;
        total = 0;
    }
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
        subtotal += pizza.price();
        NJStateTax = NJTaxRate*subtotal;
        total = subtotal + NJStateTax;
    }
    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
        subtotal -= pizza.price();
        NJStateTax = NJTaxRate*subtotal;
        total = subtotal + NJStateTax;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public ArrayList<Pizza> getPizzaList() {
        return pizzas;
    }
    public ArrayList<String> getPizzaStringList() {
        ArrayList<String> output = new ArrayList<String >();
        for(Pizza pizza: pizzas) {
            String pizzaType = getTypeString(pizza);
            StringBuilder toppings = new StringBuilder();
            for(Topping topping: pizza.getToppings()) {
                toppings.append(topping.getName()).append(',');
            }
            String sauce = pizza.getSauce().name().toLowerCase();
            toppings.append(sauce.substring(0, 1).toUpperCase()).append(sauce.substring(1)).append(',');
            if(pizza.isExtraSauce()) {
                toppings.append("Extra Sauce,");
            }
            if(pizza.isExtraCheese()) {
                toppings.append("Extra Cheese,");
            }
            String size = pizza.getSize().name().toLowerCase();
            size = size.substring(0,1).toUpperCase() + size.substring(1);
            output.add("[" + size + " " + pizzaType + "] " + toppings + "$" + String.format("%.2f", pizza.price()));
        }
        return output;
    }
    private static String getTypeString(Pizza pizza) {
        String pizzaType = "BuildYourOwn";
        if(pizza instanceof Deluxe) {
            pizzaType = "Deluxe";
        }
        else if(pizza instanceof Supreme) {
            pizzaType = "Supreme";
        }
        else if(pizza instanceof Meatzza) {
            pizzaType = "Meatzza";
        }
        else if(pizza instanceof Seafood) {
            pizzaType = "Seafood";
        }
        else if(pizza instanceof Pepperoni) {
            pizzaType = "Pepperoni";
        }
        return pizzaType;
    }
    public double getSubtotal() {
        return subtotal;
    }

    public double getNJStateTax() {
        return NJStateTax;
    }
    public double getTotal() {
        return total;
    }
}
