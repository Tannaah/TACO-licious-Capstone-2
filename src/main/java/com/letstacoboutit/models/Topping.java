package com.letstacoboutit.models;

public class Topping {
    private String name;
    private ToppingCategory category;
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


    public double getFinalPrice(String tacoSize) {
        double finalPrice = price;

        if (isExtra) {
            switch (category) {
                case MEAT -> {
                    switch (tacoSize.toLowerCase()) {
                        case "burrito" -> finalPrice += 1.50;
                        case "3-taco plate" -> finalPrice += 1.00;
                        default -> finalPrice += 0.50;
                    }
                }
                case CHEESE -> {
                    switch (tacoSize.toLowerCase()) {
                        case "burrito" -> finalPrice += 0.90;
                        case "3-taco plate" -> finalPrice += 0.60;
                        default -> finalPrice += 0.30;
                    }
                }
                default -> {} // Veggies, Sauces, others: no extra charge.
            }
        }

        return finalPrice;
    }

    @Override
    public String toString() {
        return name + (isExtra ? " (extra)" : "");
    }
}
