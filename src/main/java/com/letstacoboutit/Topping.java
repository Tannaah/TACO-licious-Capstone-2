package com.letstacoboutit;

public class Topping {
    private String name;
    private ToppingCategory category; // uses your enum instead of a String
    private boolean isExtra;
    private double price;

    public Topping(String name, ToppingCategory category, boolean isExtra, double price) {
        this.name = name;
        this.category = category;
        this.isExtra = isExtra;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ToppingCategory getCategory() {
        return category;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public double getPrice() {
        return price;
    }

    // Optional: price can increase if it's marked as extra
    public double getFinalPrice() {
        return isExtra ? price * 1.5 : price; // example: 50% extra charge
    }

    @Override
    public String toString() {
        return name + (isExtra ? " (extra)" : "");
    }
}