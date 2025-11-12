package com.letstacoboutit;

import java.util.ArrayList;
import java.util.List;

public class Order {

    // -- Fields --
    private static int nextOrderId = 1; // Static counter for unique IDs.
    private int orderId;
    private String customerName;
    private List<Taco> tacos;
    private boolean completed; // Marks whether the order is done.

    // -- Constructor --
    public Order(String customerName) {
        this.orderId = nextOrderId++;
        this.customerName = customerName;
        this.tacos = new ArrayList<>();
        this.completed = false;
    }

    // -- Getters and Setters --
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Taco> getTacos() {
        return tacos;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // -- Core Methods --

    // Adds a taco to the order list.
    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

    // Calculates total cost of all tacos in this order.
    public double calculateTotal() {
        double total = 0;
        for (Taco taco : tacos) {
            total += taco.calculateTotalPrice();
        }
        return total;
    }

    // Returns the total number of tacos in this order
    public int getTacoCount() {
        return tacos.size();
    }

    // todo: add getOrderSummary
    // getOrderSummary(): Returns a formatted summary of the entire order.

    }

    // todo: Add toString Override
    // Provides a readable output of the order details.