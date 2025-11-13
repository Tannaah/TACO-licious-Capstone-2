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
                case 2 -> displayCurrentOrder(); //todo
                case 3 -> running = false;
                default -> console.printMessage("Invalid option. Please try again.");
            }
        }
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
            boolean fry = console.readYesNo("Would you like it deep fried?");

            Taco taco = new Taco(size, shell, fry);

            // Add Meat
            String meat = console.readString("Add a meat (or leave blank to skip)");
            if (!meat.isBlank()) {
                boolean extra = console.readYesNo("Would you like extra meat?");
                taco.addTopping(new Topping(meat, ToppingCategory.MEAT, extra, extra ? 1.00 : 0.75));
            }

            // Add Cheese
            String cheese = console.readString("Add a cheese (or leave blank to skip)");
            if (!cheese.isBlank()) {
                boolean extra = console.readYesNo("Would you like extra cheese?");
                taco.addTopping(new Topping(cheese, ToppingCategory.CHEESE, extra, extra ? 0.75 : 0.50));
            }

            // Add Veggie
            String veggie = console.readString("Add a topping (or leave blank to skip)");
            if (!veggie.isBlank()) {
                boolean extra = console.readYesNo("Would you like extra of this topping?");
                taco.addTopping(new Topping(veggie, ToppingCategory.VEGGIE, extra, extra ? 0.50 : 0.25));
            }

            // Add Sauce
            String sauce = console.readString("Add a sauce (or leave blank to skip)");
            if (!sauce.isBlank()) {
                boolean extra = console.readYesNo("Would you like extra sauce?");
                taco.addTopping(new Topping(sauce, ToppingCategory.SAUCE, extra, extra ? 0.40 : 0.25));
            }

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