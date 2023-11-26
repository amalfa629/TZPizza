package com.example.tzpizza;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BuildYourOwnTest {

    @Test
    @DisplayName("Minimum Price - 3 toppings, Small")
    void minimumPrice() {
        Pizza pizza = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(new Topping[]{Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF})), Sauce.TOMATO, Size.SMALL, false, false);
        assertEquals(pizza.price(), 8.99);
    }
    @Test
    @DisplayName("Maximum Price - 7 toppings, Small")
    void maximumPrice() {
        Pizza pizza = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(new Topping[]{Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.PINEAPPLE, Topping.ONION, Topping.MUSHROOM, Topping.GREEN_PEPPER})), Sauce.TOMATO, Size.SMALL, false, false);
        assertEquals(pizza.price(), 14.95);
    }
    @Test
    @DisplayName("5 toppings - Small")
    void small() {
        Pizza pizza = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(new Topping[]{Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.PINEAPPLE, Topping.ONION})), Sauce.TOMATO, Size.SMALL, false, false);
        assertEquals(pizza.price(), 11.97);
    }
    @Test
    @DisplayName("5 toppings - Medium")
    void medium() {
        Pizza pizza = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(new Topping[]{Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.PINEAPPLE, Topping.ONION})), Sauce.TOMATO, Size.MEDIUM, false, false);
        assertEquals(pizza.price(), 13.97);
    }
    @Test
    @DisplayName("5 toppings - Large")
    void large() {
        Pizza pizza = new BuildYourOwn(new ArrayList<Topping>(Arrays.asList(new Topping[]{Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.PINEAPPLE, Topping.ONION})), Sauce.TOMATO, Size.LARGE, false, false);
        assertEquals(pizza.price(), 15.97);
    }
}