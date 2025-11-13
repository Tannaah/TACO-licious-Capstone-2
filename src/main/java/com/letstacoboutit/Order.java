package com.letstacoboutit;

import java.util.ArrayList;
import java.util.List;

public class Order {

    // -- Fields --
    private static int nextOrderId = 1;
    private int orderId;
    private String customerName;
    private List<Taco> tacos;
    private List<MenuItem> sidesAndDrinks; // chips, salsa, drinks, etc.
    private boolean completed;

    // -- Constructor --
    public Order(String customerName) {
        this.orderId = nextOrderId++;
        this.customerName = customerName;
        this.tacos = new ArrayList<>();
        this.sidesAndDrinks = new ArrayList<>();
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

    public List<MenuItem> getSidesAndDrinks() {
        return sidesAndDrinks;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // -- Core Methods --

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

    public void addItem(MenuItem item) {
        sidesAndDrinks.add(item);
    }

    public int getTacoCount() {
        return tacos.size();
    }

    // Calculate total for tacos + sides/drinks
    public double calculateTotal() {
        double total = 0.0;

        for (Taco taco : tacos) {
            total += taco.calculatePrice();
        }

        for (MenuItem item : sidesAndDrinks) {
            total += item.getPrice();
        }

        return total;
    }

    // Summary builder (returns as string)
    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("\n===== ORDER SUMMARY =====\n");
        summary.append("Order #").append(orderId).append(" for ").append(customerName).append("\n");
        summary.append("Completed: ").append(completed ? "Yes" : "No").append("\n");
        summary.append("--------------------------\n");

        if (tacos.isEmpty() && sidesAndDrinks.isEmpty()) {
            summary.append("No items in this order.\n");
        } else {
            if (!tacos.isEmpty()) {
                summary.append("🌮TACOS:\n");
                for (int i = 0; i < tacos.size(); i++) {
                    summary.append(String.format("%d) %s\n", (i + 1), tacos.get(i).toString()));
                    summary.append(String.format("   Price: $%.2f\n", tacos.get(i).calculatePrice()));
                }
            }

            if (!sidesAndDrinks.isEmpty()) {
                summary.append("\nSIDES & DRINKS:\n");
                for (MenuItem m : sidesAndDrinks) {
                    summary.append(String.format("- %s ($%.2f)\n", m.getName(), m.getPrice()));
                }
            }
        }

        summary.append("--------------------------\n");
        summary.append(String.format("💰 TOTAL: $%.2f%n", calculateTotal()));
        summary.append("==========================\n");
        return summary.toString();
    }

    public void printOrderSummary() {
        System.out.println(getOrderSummary());
    }

    public void saveReceipt() {
        try {
            // Create receipts folder if it doesn't exist
            java.io.File folder = new java.io.File("receipts");
            if (!folder.exists()) {
                folder.mkdir();
            }

            // Generate timestamp-based filename
            java.time.LocalDateTime now = java.time.LocalDateTime.now();
            String timestamp = now.format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String fileName = "receipts/" + timestamp + ".txt";

            // Write the file
            java.io.FileWriter writer = new java.io.FileWriter(fileName);
            writer.write(getOrderSummary());
            writer.close();

            System.out.println("\nReceipt saved as: " + fileName);

        } catch (Exception e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }


    @Override
    public String toString() {
        return "Order #" + orderId + " for " + customerName +
                " (" + getTacoCount() + " tacos, " +
                (completed ? "Completed" : "In Progress") + ")";
    }
}