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

    private void createNewOrder() {
        String name = console.readString("Enter customer name");
        currentOrder = new Order(name);

        boolean addingTacos = true;
        while (addingTacos) {
            console.printHeader("Create a Taco");

            String size = console.readString("Enter size (Single Taco, 3-Taco Plate, Burrito)");
            String shell = console.readString("Enter shell type (corn, flour, hard shell, bowl)");

            Taco taco = new Taco(size, shell);

            // toppings
            String meat = console.readString("Add a meat (or leave blank to skip)");
            if (!meat.isBlank()) taco.addMeat(meat);

            String cheese = console.readString("Add a cheese (or leave blank to skip)");
            if (!cheese.isBlank()) taco.addCheese(cheese);

            String topping = console.readString("Add a topping (or leave blank to skip)");
            if (!topping.isBlank()) taco.addTopping(topping);

            String sauce = console.readString("Add a sauce (or leave blank to skip)");
            if (!sauce.isBlank()) taco.addSauce(sauce);

            boolean fry = console.readYesNo("Would you like it deep fried?");
            taco.setDeepFried(fry);

            currentOrder.addTaco(taco);
            console.printMessage("Taco added to your order!");

            addingTacos = console.readYesNo("Would you like to add another taco?");
        }

        console.printMessage("\nOrder created successfully!");
        displayCurrentOrder();
    }

    private void displayCurrentOrder() {
        if (currentOrder == null) {
            console.printMessage("No current order. Please create one first.");
            return;
        }
        currentOrder.printOrderSummary();
    }

    private void exitProgram() {
        console.printMessage("Thank you for visiting Let's Taco 'Bout It! Have a Nice Day!");
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