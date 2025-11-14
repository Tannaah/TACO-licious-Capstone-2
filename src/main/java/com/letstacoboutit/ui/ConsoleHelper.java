package com.letstacoboutit.ui;

import java.util.Scanner;

public class ConsoleHelper {

    private final Scanner scanner;

    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String RESET = "\u001B[0m";

    // -- Constructor --
    public ConsoleHelper() {
        this.scanner = new Scanner(System.in);
    }

    // Prints a header with divider lines for readability.
    public void printHeader(String text) {
        System.out.println("\n==============================" + ConsoleHelper.BRIGHT_YELLOW);
        System.out.println(text.toUpperCase());
        System.out.println(ConsoleHelper.RESET + "==============================");
    }

    // Prints a simple message.
    public void printMessage(String message) {
        System.out.println(message);
    }

    // Prompts the user for a String input.
    public String readString(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine().trim();
    }

    // Prompts for an integer, ensuring valid input.
    public int readInt(String message) {
        while (true) {
            System.out.print(message + ": ");
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    // Prompts for a yes or no response.
    public boolean readYesNo(String message) {
        while (true) {
            System.out.print(message + " (Yes or No): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes"))
                return true;
            if (input.equals("n") || input.equals("no"))
                return false;
            System.out.println("Please enter 'Yes' or 'No'");
        }
    }
    // Prompts the user for a valid option from a list
    public String readOption(String message, String[] validOptions) {
        while (true) {
            System.out.print(message + ": ");
            String input = scanner.nextLine().trim().toLowerCase();

            for (String option : validOptions) {
                if (input.equalsIgnoreCase(option)) {
                    return option; // Valid choice
                }
            }

            System.out.println("Invalid option. Please enter one of the listed choices.");
        }
    }
}
