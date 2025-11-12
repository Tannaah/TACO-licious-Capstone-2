package com.letstacoboutit;

import java.util.Scanner;

public class ConsoleHelper {

    private static final Scanner scanner = new Scanner(System.in);

    // Prints a header with divider lines for readability.
    public static void printHeader(String text) {
        System.out.println("\n==============================");
        System.out.println(text.toUpperCase());
        System.out.println("==============================");
    }

    // Prompts the user for a String input.
    public static String promptString(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine().trim();
    }

    // Prompts for an integer, ensuring valid input.
    public static int promptInt(String message) {
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
    public static boolean promptYesNo(String message) {
        while (true) {
            System.out.print(message + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes"))
                return true;
            if (input.equals("n") || input.equals("no"))
                return false;
            System.out.println("Please enter 'y' or 'n'");
        }
    }

    // Simple pause to allow user to read screen before proceeding.
    public static void pause() {
        System.out.println("\nPress Enter to continue.");
        scanner.nextLine();
    }
}