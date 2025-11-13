package com.letstacoboutit;

import java.util.ArrayList;
import java.util.List;

public class Taco {
    private String size; // single taco, 3-taco plate, burrito
    private String shell; // corn, flour, hard shell, bowl
    private boolean isDeepFried;
    private List<Topping> toppings;

    public Taco(String size, String shell, boolean isDeepFried) {
        this.size = size;
        this.shell = shell;
        this.isDeepFried = isDeepFried;
        this.toppings = new ArrayList<>();
    }

    public String getSize() {
        return size;
    }

    public String getShell() {
        return shell;
    }

    public boolean isDeepFried() {
        return isDeepFried;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Calculates total price of this taco
    public double calculatePrice() {
        double basePrice;

        switch (size.toLowerCase()) {
            case "burrito":
                basePrice = 6.50;
                break;
            case "3-taco plate":
                basePrice = 5.00;
                break;
            default:
                basePrice = 2.50; // single taco
        }

        double toppingTotal = 0;
        for (Topping t : toppings) {
            toppingTotal += t.getFinalPrice();
        }

        if (isDeepFried) {
            basePrice += 1.00; // surcharge for deep-frying
        }

        return basePrice + toppingTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append(" (").append(shell).append(" shell)");
        if (isDeepFried) sb.append(" [deep fried]");
        sb.append("\nToppings:");
        for (Topping t : toppings) {
            sb.append("\n - ").append(t.toString());
        }
        sb.append(String.format("\nTotal Taco Price: $%.2f", calculatePrice()));
        return sb.toString();
    }
}