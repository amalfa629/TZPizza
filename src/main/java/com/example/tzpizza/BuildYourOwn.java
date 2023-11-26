package com.example.tzpizza;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza{
    public BuildYourOwn(ArrayList<Topping> toppings, Sauce sauce, Size size, boolean extraSauce, boolean extraCheese) {
        this.toppings = toppings;
        this.sauce = sauce;
        this.size = size;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }
    public double price() {
        double price = 8.99 + 1.49*(toppings.size()-3);
        return super.priceHelper(price);
    }
}
