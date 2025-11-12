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

    // Returns the total number of tacos in this order.
    public int getTacoCount() {
        return tacos.size();
    }

    // Returns a formatted summary string of the full order.
    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("\n--- Order Summary ---\n");
        summary.append("Order #").append(orderId)
                .append(" for ").append(customerName)
                .append("\nCompleted: ").append(completed ? "Yes" : "No")
                .append("\n----------------------\n");

        for (int i = 0; i < tacos.size(); i++) {
            summary.append("Taco #").append(i + 1).append(":\n");
            summary.append(tacos.get(i).toString()).append("\n");
            summary.append(String.format("Price: $%.2f%n", tacos.get(i).calculateTotalPrice()));
            summary.append("----------------------\n");ffff

        }

        summary.append(String.format("TOTAL: $%.2f%n", calculateTotal()));
        summary.append("----------------------\n");
        return summary.toString();
    }

    @Override
    public String toString() {
        return "Order #" + orderId + " for " + customerName +
                " (" + getTacoCount() + " tacos, " +
                (completed ? "Completed" : "In Progress") + ")";
    }
}
