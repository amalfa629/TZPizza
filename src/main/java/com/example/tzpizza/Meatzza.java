package com.example.tzpizza;

import java.util.ArrayList;
import java.util.Arrays;

public class Meatzza extends Pizza{
    public Meatzza(Size size, boolean extraSauce, boolean extraCheese) {
        toppings = new ArrayList<Topping>(Arrays.asList(new Topping[]{Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM}));
        sauce = Sauce.TOMATO;
        this.size = size;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }
    public double price() {
        double price = 16.99;
        return super.priceHelper(price);
    }
}
