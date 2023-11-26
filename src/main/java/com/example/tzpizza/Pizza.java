package com.example.tzpizza;

import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings;
    protected Size size;
    protected Sauce sauce;
    protected boolean extraSauce;
    protected boolean extraCheese;

    public abstract double price();
    protected double priceHelper(double price) {
        if(size.equals(Size.MEDIUM)) price += 2;
        else if(size.equals(Size.LARGE)) price += 4;
        return price;
    }
}
