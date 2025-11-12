package com.letstacoboutit;

public class Main {
    public static void main(String[] args) {

        // Create a taco
        Taco taco1 = new Taco("Single Taco", "flour");
        taco1.addMeat("chicken");
        taco1.addCheese("cheddar");
        taco1.addTopping("lettuce");
        taco1.addSauce("chipotle mayo");
        taco1.setDeepFried(false);

        Taco taco2 = new Taco("Burrito", "flour");
        taco2.addMeat("steak");
        taco2.addCheese("queso");
        taco2.addTopping("onions");
        taco2.addSauce("salsa verde");

        // Create an order for a customer
        Order order = new Order("Tanner");
        order.addTaco(taco1);
        order.addTaco(taco2);

        // Print out the full order summary
        System.out.println(order.getOrderSummary());
    }
}