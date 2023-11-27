package com.example.tzpizza;

import java.util.ArrayList;
import java.util.Arrays;

/**
 Seafood class that is a subclass of the abstract pizza class
 */
public class Seafood extends Pizza{
    public Seafood(Size size, boolean extraSauce, boolean extraCheese) {
        toppings = new ArrayList<Topping>(Arrays.asList(new Topping[]{Topping.SHRIMP, Topping.SQUID, Topping.CRAB_MEAT}));
        sauce = Sauce.ALFREDO;
        this.size = size;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }

    /**
     determines the price for a seafood pizza
     @return returns a double with the price
     */
    public double price() {
        double price = 17.99;
        return super.priceHelper(price);
    }
}
