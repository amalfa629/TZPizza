package com.example.tzpizza;

import java.util.ArrayList;
import java.util.Arrays;

/**
 creates a Supreme pizza that is a subclass of the abstract pizza class
 */
public class Supreme extends Pizza{
    public Supreme(Size size, boolean extraSauce, boolean extraCheese) {
        toppings = new ArrayList<Topping>(Arrays.asList(new Topping[]{Topping.SAUSAGE, Topping.PEPPERONI, Topping.HAM, Topping.GREEN_PEPPER, Topping.ONION, Topping.BLACK_OLIVE, Topping.MUSHROOM}));
        sauce = Sauce.TOMATO;
        this.size = size;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }

    /**
     calculates the price of the supreme pizza
     @return the price of the pizza as a double
     */
    public double price() {
        double price = 15.99;
        return super.priceHelper(price);
    }
}
