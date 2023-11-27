package com.example.tzpizza;

public enum Topping {
    BACON("Bacon"),
    BEEF("Beef"),
    BLACK_OLIVE("Black Olive"),
    CRAB_MEAT("Crab Meat"),
    GREEN_PEPPER("Green Pepper"),
    HAM("Ham"),
    MUSHROOM("Mushroom"),
    ONION("Onions"),
    PEPPERONI("Pepperoni"),
    PINEAPPLE("Pineapple"),
    SAUSAGE("Sausage"),
    SHRIMP("Shrimp"),
    SQUID("Squid");
    private String name;
    Topping(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
