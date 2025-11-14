package com.letstacoboutit.models;

public class Drink extends MenuItem {

    private String size; // Small, Medium, Large

    public Drink(String name, String size, double price) {
        super(name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f", getName(), size, getPrice());
    }
}