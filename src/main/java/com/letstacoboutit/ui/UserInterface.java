package com.letstacoboutit.ui;

import com.letstacoboutit.models.*;
import com.letstacoboutit.models.signatures.StreetTaco;
import com.letstacoboutit.models.signatures.SuperBurrito;


public class UserInterface {

    private final ConsoleHelper console = new ConsoleHelper();
    private Order currentOrder;

    // Valid taco options
    private final String[] validSizes = {"single taco", "3-taco plate", "burrito"};
    private final String[] validShells = {"corn", "flour", "hard shell", "bowl"};

    private final String[] validMeats = {"carne asada", "al pastor", "carnitas", "pollo", "chorizo", "pescado"};

    private final String[] validCheeses = {"queso fresco", "oaxaca", "cotija", "cheddar"};

    private final String[] validVeggies = {"lettuce", "cilantro", "onions", "tomatoes", "jalapeños", "radishes", "pico de gallo", "guacamole", "corn"};

    private final String[] validSauces = {"salsa verde", "salsa roja", "chipotle", "habanero", "mild", "extra hot"};

    private final String[] validDrinkSizes = {"small", "medium", "large"};
    private final String[] validSalsaTypes = {"mild", "spicy", "verde", "roja"};


    // ===========================
    //       START PROGRAM
    // ===========================
    public void start() {
        console.printMessage("\n" + ConsoleHelper.BRIGHT_RED + "🌮 Welcome to Let's Taco 'Bout It! 🌮" + ConsoleHelper.RESET);


        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = console.readInt("Enter your choice");

            switch (choice) {
                case 1 -> createNewOrder();
                case 0 -> {
                    running = false;
                    console.printMessage("\n" + ConsoleHelper.BRIGHT_YELLOW + "🌮 Thanks So Much for Visiting Let's Taco 'Bout It Restaurant! Have a Nice Day. 🌮" + ConsoleHelper.RESET);
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
        String name = console.readString(ConsoleHelper.BRIGHT_GREEN + "Enter customer name" + ConsoleHelper.RESET);
        currentOrder = new Order(name);

        console.printMessage("New order started for " + name + "!");

        boolean ordering = true;
        try {
            while (ordering) {
                showOrderScreen();
                int choice = console.readInt("Choose an option");

                switch (choice) {
                    case 1 -> addTaco();
                    case 2 -> addDrink();
                    case 3 -> addChipsAndSalsa();
                    case 4 -> checkout();
                    case 5 -> addSignatureTaco();
                    case 0 -> {
                        cancelOrder();
                        ordering = false;
                    }
                    default -> console.printMessage("Invalid choice.");
                }
            }

        } catch (RuntimeException e) {
            if (!"Order Complete".equals(e.getMessage())) {
                throw e;
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
        console.printMessage("5. Add Signature Taco");
        console.printMessage("0. Cancel Order");
    }

    // ===========================
    //          ADD TACO
    // ===========================
    private void addTaco() {
        console.printHeader("Create a Taco");

        console.printMessage(ConsoleHelper.BRIGHT_RED + "Valid sizes: Single Taco, 3-Taco Plate, Burrito" + ConsoleHelper.RESET);
        String size = console.readOption(ConsoleHelper.BRIGHT_GREEN + "Enter size" + ConsoleHelper.RESET, validSizes );

        console.printMessage(ConsoleHelper.BRIGHT_RED + "Valid shells: corn, flour, hard shell, bowl" + ConsoleHelper.RESET);
        String shell = console.readOption(ConsoleHelper.BRIGHT_GREEN + "Enter shell type" + ConsoleHelper.RESET, validShells);

        boolean fry = console.readYesNo(ConsoleHelper.BRIGHT_YELLOW + "Would you like it Deep-Fried" + ConsoleHelper.RESET);

        Taco taco = new Taco(size, shell, fry);

        addToppingsToTaco(taco);

        currentOrder.addTaco(taco);
        console.printMessage("\n🌮Taco added!🌮");
    }


    private void addToppingsToTaco(Taco taco) {
        console.printHeader("Toppings Menu");

        // ---- MEAT ----
        console.printMessage(ConsoleHelper.BRIGHT_RED + "Meats: carne asada, al pastor, carnitas, pollo, chorizo, pescado" +  ConsoleHelper.RESET);
        String meat = console.readString(ConsoleHelper.BRIGHT_GREEN + "Add a meat (blank to skip)" +  ConsoleHelper.RESET);
        if (!meat.isBlank()) {
            meat = console.readOption("Confirm meat", validMeats);
            boolean extra = console.readYesNo("Extra meat? (Will Cost Extra)");
            taco.addTopping(new Topping(meat, ToppingCategory.MEAT, extra, 1.00));
        }

        // ---- CHEESE ----
        console.printMessage(ConsoleHelper.BRIGHT_RED + "Cheeses: queso fresco, oaxaca, cotija, cheddar" + ConsoleHelper.RESET);
        String cheese = console.readString(ConsoleHelper.BRIGHT_GREEN + "Add a cheese (blank to skip)" + ConsoleHelper.RESET);
        if (!cheese.isBlank()) {
            cheese = console.readOption("Confirm cheese", validCheeses);
            boolean extra = console.readYesNo("Extra cheese? (Will Cost Extra)");
            taco.addTopping(new Topping(cheese, ToppingCategory.CHEESE, extra, 0.75));
        }

        // ---- VEGGIES ----
        console.printMessage(ConsoleHelper.BRIGHT_RED + "Veggies: lettuce, cilantro, onions, tomatoes, jalapeños, radishes, pico de gallo, guacamole, corn" + ConsoleHelper.RESET);
        String veggie = console.readString(ConsoleHelper.BRIGHT_GREEN + "Add a veggie (blank to skip)" + ConsoleHelper.RESET);
        if (!veggie.isBlank()) {
            veggie = console.readOption("Confirm veggie", validVeggies);
            taco.addTopping(new Topping(veggie, ToppingCategory.VEGGIE, false, 0));
        }

        // ---- SAUCE ----
        console.printMessage(ConsoleHelper.BRIGHT_RED + "Sauces: salsa verde, salsa roja, chipotle, habanero, mild, extra hot" + ConsoleHelper.RESET);
        String sauce = console.readString(ConsoleHelper.BRIGHT_GREEN + "Add a sauce (blank to skip)" + ConsoleHelper.RESET);
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

        console.printMessage(ConsoleHelper.BRIGHT_GREEN + "Drink Sizes: Small, Medium, Large" + ConsoleHelper.RESET);
        String size = console.readOption("Enter drink size", validDrinkSizes);

        String flavor = console.readString(ConsoleHelper.BRIGHT_YELLOW + "Enter drink flavor: Fruit Punch, Pineapple, or Guava" + ConsoleHelper.RESET);

        double price = switch (size.toLowerCase()) {
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 2.00;
        };

        Drink drink = new Drink(flavor, size, price);
        currentOrder.addItem(drink);

        console.printMessage("\n🥤Drink added!🥤");
    }


    // ===========================
    //     ADD CHIPS & SALSA
    // ===========================
    private void addChipsAndSalsa() {
        console.printHeader("Add Chips & Salsa");

        console.printMessage(ConsoleHelper.BRIGHT_RED + "Valid salsa types: mild, spicy, verde, roja" + ConsoleHelper.RESET);
        String salsa = console.readOption("Enter salsa type", validSalsaTypes);

        ChipsAndSalsa cs = new ChipsAndSalsa(salsa, 1.50);
        currentOrder.addItem(cs);

        console.printMessage("\n🥫Chips & Salsa added!🥫");
    }

    private void addSignatureTaco() {
        console.printHeader("Signature Tacos");
        console.printMessage("1. Street Taco");
        console.printMessage("2. Super Burrito");
        console.printMessage("0. Back");

        int choice = console.readInt("Choose a signature taco");

        switch (choice) {
            case 1 -> {
                Taco taco = new StreetTaco();
                console.printMessage("Street Taco selected!");
                modifyTacoOptions(taco);
                currentOrder.addTaco(taco);
            }
            case 2 -> {
                Taco taco = new SuperBurrito();
                console.printMessage("Super Burrito selected!");
                modifyTacoOptions(taco);
                currentOrder.addTaco(taco);
            }
            case 0 -> {
                console.printMessage("Returning...");
                return;
            }
            default -> console.printMessage("Invalid option.");
        }
    }

    private void modifyTacoOptions(Taco taco) {
        console.printHeader("Customize Your Signature Taco");

        boolean editing = true;
        boolean modified = false; // track if the user makes ANY changes

        while (editing) {
            console.printMessage("1. Add toppings");
            console.printMessage("2. Remove toppings");
            console.printMessage("0. Done customizing");

            int choice = console.readInt("Choose");

            switch (choice) {
                case 1 -> {
                    addToppingsToTaco(taco);
                    modified = true;
                }
                case 2 -> {
                    removeToppingFromTaco(taco);
                    modified = true;
                }
                case 0 -> editing = false;
                default -> console.printMessage("Invalid option.");
            }
        }

        if (!modified) {
            console.printMessage("\n" + ConsoleHelper.BRIGHT_RED + "Signature added!" + ConsoleHelper.RESET);
        } else {
            console.printMessage("\n" + ConsoleHelper.BRIGHT_RED + "Signature customized & added!" +  ConsoleHelper.RESET);
        }
    }


    private void removeToppingFromTaco(Taco taco) {
        if (taco.getToppings().isEmpty()) {
            console.printMessage("No toppings to remove.");
            return;
        }

        console.printMessage("Current Toppings:");
        for (int i = 0; i < taco.getToppings().size(); i++) {
            console.printMessage((i + 1) + ". " + taco.getToppings().get(i));
        }

        int choice = console.readInt("Which topping to remove (0 to cancel)");

        if (choice == 0) return;

        if (choice < 1 || choice > taco.getToppings().size()) {
            console.printMessage("Invalid topping index.");
            return;
        }

        taco.getToppings().remove(choice - 1);
        console.printMessage("Topping removed!");
    }



    // ===========================
    //          CHECKOUT
    // ===========================
    private void checkout() {
        console.printHeader("CHECKOUT");

        currentOrder.printOrderSummary();

        boolean confirm = console.readYesNo(ConsoleHelper.BRIGHT_YELLOW + "Confirm order" + ConsoleHelper.RESET);
        if (confirm) {
            currentOrder.setCompleted(true);
            currentOrder.saveReceipt();

            console.printMessage(ConsoleHelper.BRIGHT_GREEN + "Order completed! Returning to Main Menu.\n" + ConsoleHelper.RESET);

            currentOrder = null;

            throw new RuntimeException("Order Complete");

        } else {
            console.printMessage("\n" + ConsoleHelper.BRIGHT_GREEN + "Checkout Canceled." + ConsoleHelper.RESET);
        }
    }


    // ===========================
    //        CANCEL ORDER
    // ===========================
    private void cancelOrder() {
        console.printMessage("\n" + ConsoleHelper.BRIGHT_GREEN + "Order canceled. Returning to Home Screen." +  ConsoleHelper.RESET);
        currentOrder = null;
    }
}