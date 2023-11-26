package com.example.tzpizza;

import java.util.ArrayList;
import java.util.Arrays;

public class Pepperoni extends Pizza{
    public Pepperoni(Size size, boolean extraSauce, boolean extraCheese) {
        toppings = new ArrayList<Topping>(Arrays.asList(new Topping[]{Topping.PEPPERONI}));
        sauce = Sauce.TOMATO;
        this.size = size;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }
    public double price() {
        double price = 10.99;
        return super.priceHelper(price);
    }
}
s