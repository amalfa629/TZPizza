package com.example.tzpizza;

import java.util.ArrayList;
import java.util.Arrays;

public class Seafood extends Pizza{
    public Seafood(Size size, boolean extraSauce, boolean extraCheese) {
        toppings = new ArrayList<Topping>(Arrays.asList(new Topping[]{Topping.SHRIMP, Topping.SQUID, Topping.CRAB_MEAT}));
        sauce = Sauce.ALFREDO;
        this.size = size;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }
    public double price() {
        double price = 17.99;
        return super.priceHelper(price);
    }
}
