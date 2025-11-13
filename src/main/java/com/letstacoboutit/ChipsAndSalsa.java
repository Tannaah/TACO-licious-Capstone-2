package com.letstacoboutit;

public class ChipsAndSalsa extends MenuItem {

    private String salsaType;  // mild, spicy, verde, roja, etc.

    public ChipsAndSalsa(String salsaType, double price) {
        super("Chips & Salsa", price);
        this.salsaType = salsaType;
    }

    public String getSalsaType() {
        return salsaType;
    }

    @Override
    public String toString() {
        return String.format("Chips & Salsa (%s) - $%.2f", salsaType, getPrice());
    }
}