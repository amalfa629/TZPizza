package com.example.tzpizza;

import java.util.ArrayList;
import java.util.Arrays;

public class Deluxe extends Pizza{
    public Deluxe(Size size, boolean extraSauce, boolean extraCheese) {
        toppings = new ArrayList<Topping>(Arrays.asList(new Topping[]{Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM}));
        sauce = Sauce.TOMATO;
        this.size = size;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }
    public double price() {
        double price = 14.99;
        return super.priceHelper(price);
    }
}
