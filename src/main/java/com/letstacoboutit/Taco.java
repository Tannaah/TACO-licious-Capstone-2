package com.letstacoboutit;

public class Taco {

    /* Taco Class Outline:
     *
     * Purpose:
     *   Represents a single customizable taco in the Let's Taco 'Bout It ordering system.
     *   Each taco can vary in size, shell type, and toppings.
     *
     * Fields (instance variables):
     *   - String size: the size of the taco ("Single", "3-Taco Plate", "Burrito")
     *   - String shellType: type of tortilla ("corn", "flour", "hard shell", "bowl")
     *   - List<String> regularToppings: holds all standard toppings
     *   - List<String> premiumToppings: holds premium toppings like meats and cheeses
     *   - boolean deepFried: determines if the taco is deep fried
     *   - double price: total price of the taco
     *
     * Constructor:
     *   - Takes in size and shellType
     *   - Initializes lists and sets default values
     *
     * Methods:
     *   - addRegularTopping(String topping): adds a topping from the regular list
     *   - addPremiumTopping(String topping): adds a topping from premium list
     *   - setDeepFried(boolean deepFried): sets if the taco is fried
     *   - calculatePrice(): calculates total based on size, toppings, and extras
     *   - toString(): returns a summary of the taco’s configuration for display
     *
     * Notes:
     *   - This class will be used by the Order class to build the customer’s order.
     *   - Future idea: possibly add a method for “duplicate taco” to re-order quickly.

}
