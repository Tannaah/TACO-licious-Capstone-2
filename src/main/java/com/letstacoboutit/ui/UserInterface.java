package com.letstacoboutit.ui;

import com.letstacoboutit.models.*;

public class UserInterface {

    private final ConsoleHelper console = new ConsoleHelper();
    private Order currentOrder;

    // Valid taco options
    private final String[] validSizes = { "single taco", "3-taco plate", "burrito" };
    private final String[] validShells = { "corn", "flour", "hard shell", "bowl" };

    private final String[] validMeats = {"carne asada", "al pastor", "carnitas", "pollo", "chorizo", "pescado"};

    private final String[] validCheeses = {"queso fresco", "oaxaca", "cotija", "cheddar"};

    private final String[] validVeggies = {"lettuce", "cilantro", "onions", "tomatoes", "jalapeños", "radishes", "pico de gallo", "guacamole", "corn"};

    private final String[] validSauces = {"salsa verde", "salsa roja", "chipotle", "habanero", "mild", "extra hot"};

    private final String[] validDrinkSizes = { "small", "medium", "large" };
    private final String[] validSalsaTypes = { "mild", "spicy", "verde", "roja" };


    // ===========================
    //       START PROGRAM
    // ===========================
    public void start() {
        console.printMessage("🌮Welcome to Let's Taco 'Bout It!🌮");

        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = console.readInt("Enter your choice");

            switch (choice) {
                case 1 -> createNewOrder();
                case 0 -> {
                    running = false;
                    console.printMessage("Thank you for stopping by!");
                }
                default -> console.printMessage("Invalid option. Please try again.");
            }
        }
    }

    // ===========================
    //        HOME SCREEN
    // ===========================
    private void showMainMenu() {
        console.printHeader("Main Menu");
        console.printMessage("1. New Order");
        console.printMessage("0. Exit");
    }

    // ===========================
    //      CREATE NEW ORDER
    // ===========================
    private void createNewOrder() {
        String name = console.readString("Enter customer name");
        currentOrder = new Order(name);

        console.printMessage("New order started for " + name + "!");

        boolean ordering = true;
        while (ordering) {
            showOrderScreen();
            int choice = console.readInt("Choose an option");

            switch (choice) {
                case 1 -> addTaco();
                case 2 -> addDrink();
                case 3 -> addChipsAndSalsa();
                case 4 -> checkout();
                case 0 -> {
                    cancelOrder();
                    ordering = false;
                }
                default -> console.printMessage("Invalid choice.");
            }
        }
    }

    // ===========================
    //        ORDER SCREEN
    // ===========================
    private void showOrderScreen() {
        console.printHeader("Order Screen");
        console.printMessage("1. Add Taco");
        console.printMessage("2. Add Drink");
        console.printMessage("3. Add Chips & Salsa");
        console.printMessage("4. Checkout");
        console.printMessage("0. Cancel Order");
    }

    // ===========================
    //          ADD TACO
    // ===========================
    private void addTaco() {
        console.printHeader("Create a Taco");

        console.printMessage("Valid sizes: Single Taco, 3-Taco Plate, Burrito");
        String size = console.readOption("Enter size", validSizes);

        console.printMessage("Valid shells: corn, flour, hard shell, bowl");
        String shell = console.readOption("Enter shell type", validShells);

        boolean fry = console.readYesNo("Would you like it deep fried");

        Taco taco = new Taco(size, shell, fry);

        addToppingsToTaco(taco);

        currentOrder.addTaco(taco);
        console.printMessage("🌮Taco added!\n");
    }


    private void addToppingsToTaco(Taco taco) {
        console.printHeader("Toppings Menu");

        // ---- MEAT ----
        console.printMessage("Meats: carne asada, al pastor, carnitas, pollo, chorizo, pescado");
        String meat = console.readString("Add a meat (blank to skip)");
        if (!meat.isBlank()) {
            meat = console.readOption("Confirm meat", validMeats);
            boolean extra = console.readYesNo("Extra meat");
            taco.addTopping(new Topping(meat, ToppingCategory.MEAT, extra, 1.00));
        }

        // ---- CHEESE ----
        console.printMessage("Cheeses: queso fresco, oaxaca, cotija, cheddar");
        String cheese = console.readString("Add a cheese (blank to skip)");
        if (!cheese.isBlank()) {
            cheese = console.readOption("Confirm cheese", validCheeses);
            boolean extra = console.readYesNo("Extra cheese");
            taco.addTopping(new Topping(cheese, ToppingCategory.CHEESE, extra, 0.75));
        }

        // ---- VEGGIES ----
        console.printMessage("Veggies: lettuce, cilantro, onions, tomatoes, jalapeños, radishes, pico de gallo, guacamole, corn");
        String veggie = console.readString("Add a veggie (blank to skip)");
        if (!veggie.isBlank()) {
            veggie = console.readOption("Confirm veggie", validVeggies);
            taco.addTopping(new Topping(veggie, ToppingCategory.VEGGIE, false, 0));
        }

        // ---- SAUCE ----
        console.printMessage("Sauces: salsa verde, salsa roja, chipotle, habanero, mild, extra hot");
        String sauce = console.readString("Add a sauce (blank to skip)");
        if (!sauce.isBlank()) {
            sauce = console.readOption("Confirm sauce", validSauces);
            taco.addTopping(new Topping(sauce, ToppingCategory.SAUCE, false, 0));
        }
    }


    // ===========================
    //         ADD DRINK
    // ===========================
    private void addDrink() {
        console.printHeader("Add a Drink");

        console.printMessage("Drink Sizes: small, medium, large");
        String size = console.readString("Enter drink size");

        String flavor = console.readString("Enter drink flavor");

        double price = switch (size.toLowerCase()) {
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 2.00;
        };

        Drink drink = new Drink(flavor, size, price);
        currentOrder.addItem(drink);

        console.printMessage("🥤Drink added!\n");
    }

    // ===========================
    //     ADD CHIPS & SALSA
    // ===========================
    private void addChipsAndSalsa() {
        console.printHeader("Add Chips & Salsa");

        String salsa = console.readString("Enter salsa type (mild, spicy, verde, roja)");

        ChipsAndSalsa cs = new ChipsAndSalsa(salsa, 1.50);
        currentOrder.addItem(cs);

        console.printMessage("Chips & Salsa added!\n");
    }

    // ===========================
    //          CHECKOUT
    // ===========================
    private void checkout() {
        console.printHeader("CHECKOUT");

        currentOrder.printOrderSummary();

        boolean confirm = console.readYesNo("Confirm order");
        if (confirm) {
            currentOrder.setCompleted(true);
            currentOrder.saveReceipt(); // call real method inside Order.java
            console.printMessage("Order completed! Returning to main menu.\n");
            currentOrder = null;
        } else {
            console.printMessage("Checkout canceled.\n");
        }
    }

    // ===========================
    //        CANCEL ORDER
    // ===========================
    private void cancelOrder() {
        console.printMessage("Order canceled. Returning to home screen.\n");
        currentOrder = null;
    }
}