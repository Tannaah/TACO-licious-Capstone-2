package com.letstacoboutit;

import java.util.Scanner;

public class ConsoleHelper {

    private final Scanner scanner;

    // -- Constructor --
    public ConsoleHelper() {
        this.scanner = new Scanner(System.in);
    }

    // Prints a header with divider lines for readability.
    public void printHeader(String text) {
        System.out.println("\n==============================");
        System.out.println(text.toUpperCase());
        System.out.println("==============================");
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
            System.out.print(message + "(Yes or No): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes"))
                return true;
            if (input.equals("n") || input.equals("no"))
                return false;
            System.out.println("Please enter 'Yes' or 'No'");
        }
    }

    // Simple pause to allow user to read screen before proceeding.
    public void pause() {
        System.out.println("\nPress Enter to continue.");
        scanner.nextLine();
    }
}