package com.letstacoboutit.models;

import java.util.ArrayList;
import java.util.List;

public class Taco {
    private String size;  // single taco, 3-taco plate, burrito
    private String shell; // corn, flour, hard shell, bowl
    private boolean isDeepFried;
    private List<Topping> toppings;

    public Taco(String size, String shell, boolean isDeepFried) {
        this.size = size;
        this.shell = shell;
        this.isDeepFried = isDeepFried;
        this.toppings = new ArrayList<>();
    }

    public String getSize() { return size; }
    public String getShell() { return shell; }
    public boolean isDeepFried() { return isDeepFried; }
    public List<Topping> getToppings() { return toppings; }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Calculates total price of this taco
    public double calculatePrice() {
        double basePrice = getBasePrice();
        double toppingTotal = 0;

        for (Topping t : toppings) {
            toppingTotal += t.getFinalPrice(size);
        }

        if (isDeepFried) {
            basePrice += 1.00; // $1 surcharge for deep-frying
        }

        return basePrice + toppingTotal;
    }

    // Gets base price based on size & shell type
    private double getBasePrice() {
        switch (size.toLowerCase()) {
            case "burrito": return 8.50;
            case "3-taco plate": return 9.00;
            default: return 3.50; // single taco
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append(" ").append(shell).append(" ");
        if (isDeepFried) sb.append(" (deep-fried)");
        sb.append("\nToppings:");
        for (Topping t : toppings) {
            sb.append("\n - ").append(t);
        }
        sb.append(String.format("\nTotal Taco Price: $%.2f", calculatePrice()));
        return sb.toString();
    }
}
