package com.letstacoboutit;

public class UserInterface {

    private final ConsoleHelper console = new ConsoleHelper();
    private Order currentOrder;

    // Entry point for the program.
    public void start() {
        console.printMessage("🌮Welcome to Let's Taco 'Bout It!🌮");

        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = console.readInt("Enter your choice");

            switch (choice) {
                case 1 -> createNewOrder();
                case 2 -> displayCurrentOrder();
                case 3 -> running = false;
                default -> console.printMessage("Invalid option. Please try again.");
            }
        }

        exitProgram();
    }


    private void showMainMenu() {
        console.printHeader("Main Menu");
        console.printMessage("1. Create a new order");
        console.printMessage("2. View current order");
        console.printMessage("3. Exit");
    }
}

    /* UserInterface: The Control Center!
     * The UserInterface class serves as the main interaction layer.
     * between the user and the Taco Ordering System.
     * It uses ConsoleHelper for input/output and manages the ordering flow.
     *
     * -- Responsibilities --
     * - Display the main menu and handle user selections.
     * - Create Taco objects and add them to an Order.
     * - Display order summaries and totals.
     * - Allow users to complete or cancel orders.
     *
     * -- Methods to Implement --
     * - start(): Entry point for the program.
     * - showMainMenu(): Displays menu options.
     * - createNewOrder(): Handles taco customization and adds to Order.
     * - displayOrderSummary(): Prints order details and total.
     * - exitProgram(): Closes app gracefully.
     */