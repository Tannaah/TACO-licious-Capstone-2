package com.letstacoboutit;

import java.util.ArrayList;
import java.util.List;

public class Taco {

    // -- Fields --
    private String size;            // Single, 3-Taco Plate, or Burrito.
    private String shellType;       // corn, flour, hard shell, or bowl.
    private List<String> meats;     // list to hold chosen meats.
    private List<String> cheeses;   // list to hold chosen cheeses.
    private List<String> toppings;  // list to hold other toppings. (lettuce, onion, etc.)
    private List<String> sauces;    // list for sauces.
    private boolean deepFried;      // true if taco is deep-fried.

    // -- Constructor --
    public Taco(String size, String shellType) {
        this.size = size;
        this.shellType = shellType;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.deepFried = false; // default to not fried
    }

    // -- Getters and Setters --
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getShellType() {
        return shellType;
    }

    public void setShellType(String shellType) {
        this.shellType = shellType;
    }

    public List<String> getMeats() {
        return meats;
    }

    public List<String> getCheeses() {
        return cheeses;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public boolean isDeepFried() {
        return deepFried;
    }

    public void setDeepFried(boolean deepFried) {
        this.deepFried = deepFried;
    }


    // Determines the base price based on the taco size!
    public double calculateBasePrice() {
        return switch (size.toLowerCase()) {
            case "single taco" -> 3.50;
            case "3-taco plate" -> 9.00;
            case "burrito" -> 8.50;
            default -> 0;
        };
    }

    // Calculates additional cost from meats and cheeses
    public double calculateToppingsPrice() {
        double total = 0;

        // Each meat adds to the cost
        for (String meat : meats) {
            total += switch (size.toLowerCase()) {
                case "single taco" -> 1.00;
                case "3-taco plate" -> 2.00;
                case "burrito" -> 3.00;
                default -> 0;
            };
        }

        // Each cheese adds to the cost
        for (String cheese : cheeses) {
            total += switch (size.toLowerCase()) {
                case "single taco" -> 0.75;
                case "3-taco plate" -> 1.50;
                case "burrito" -> 2.25;
                default -> 0;
            };
        }
        return total;
    }


    /*
     * Pricing Coding Plan
     * ---------------------------
     * - Add method: calculateTotalPrice()
     *   Adds base price + toppings + extras (like deep-fry cost)
     */


    // -- Helper Methods --
    public void addMeat(String meat) {
        meats.add(meat);
    }

    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }


    @Override
    public String toString() {
        return size + " Taco (" + shellType + ")" +
                (deepFried ? " [Deep Fried]" : "") +
                "\nMeats: " + meats +
                "\nCheeses: " + cheeses +
                "\nToppings: " + toppings +
                "\nSauces: " + sauces;
    }
}