package com.letstacoboutit;

public abstract class MenuItem {
}

/*
 * MenuItem Overview/Framework (abstract)
 *
 * Purpose:
 *  - Provide a common abstraction for anything that can be added to an order
 *    (Taco, Drink, ChipsAndSalsa).
 *  - Demonstrates abstraction + polymorphism: code can treat all items as MenuItem.
 *
 * Fields:
 *  - name: human-friendly name of the item
 *  - basePrice: a base price used by subclasses (optional)
 *
 * Abstract methods:
 *  - calculateTotalPrice(): subclass must compute its price (includes premiums/extras)
 *  - getDescription(): subclass provides descriptive text for receipts/display
 */