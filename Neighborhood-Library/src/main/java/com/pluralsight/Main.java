package com.pluralsight;

import java.util.Scanner;

/**
 * Entry point for the Neighborhood Library application.
 * Provides a console interface to check in/out books using an honor system.
 */
public class Main {
    // Create a single instance of LibraryInventory to manage all book operations
    private static LibraryInventory inventory = new LibraryInventory();
    // Scanner to read user input from the console
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Controls the main program loop
        boolean keepRunning = true;

        // Loop until user chooses to exit
        while (keepRunning) {
            // Display the main menu options
            printMainMenu();

            // Read user input
            String choice = input.nextLine().trim();

            // Respond to user selection
            switch (choice) {
                case "1" -> displayAvailableBooks();     // Option 1: Show books that can be checked out
                case "2" -> displayCheckedOutBooks();    // Option 2: Show books currently checked out
                case "3" -> {
                    System.out.println("Exiting... Have a great day!");
                    keepRunning = false;                 // End the loop to exit the program
                }
                default -> System.out.println("❌ Invalid option. Please choose 1, 2, or 3.");
            }
        }
    }

    /**
     * Displays the main menu to the user.
     */
    private static void printMainMenu() {
        System.out.println("\n=== Neighborhood Library ===");
        System.out.println("1. Show Available Books");
        System.out.println("2. Show Checked Out Books");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Shows books that are currently available.
     * Allows the user to check out a book by ID.
     */
    private static void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");

        // Loop through and display all available books
        for (Book book : inventory.getAvailableBooks()) {
            System.out.println(book.getDisplayInfo());
        }

        // Prompt the user to check out or return to main menu
        System.out.print("\nEnter Book ID to check out or X to return: ");
        String choice = input.nextLine().trim();

        // Return to main menu if user chooses "X"
        if (choice.equalsIgnoreCase("X")) return;

        try {
            int bookId = Integer.parseInt(choice);
            Book book = inventory.findBookById(bookId);

            // If the book exists and is not already checked out
            if (book != null && !book.isCheckedOut()) {
                System.out.print("Enter your name: ");
                String userName = input.nextLine().trim();
                book.checkOut(userName);
                System.out.println("✅ Successfully checked out!");
            } else {
                System.out.println("❌ Book not available or not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Please enter a valid number.");
        }
    }

    /**
     * Shows books that are currently checked out.
     * Allows the user to check a book back in.
     */
    private static void displayCheckedOutBooks() {
        System.out.println("\n--- Checked Out Books ---");

        // Loop through and display all checked out books
        for (Book book : inventory.getCheckedOutBooks()) {
            System.out.println(book.getCheckedOutInfo());
        }

        // Prompt user for next action
        System.out.print("\nC - Check In a book | X - Main Menu\nYour choice: ");
        String response = input.nextLine().trim();

        if (response.equalsIgnoreCase("C")) {
            System.out.print("Enter the ID of the book to check in: ");

            try {
                int bookId = Integer.parseInt(input.nextLine());
                Book book = inventory.findBookById(bookId);

                // Check in if valid and currently checked out
                if (book != null && book.isCheckedOut()) {
                    book.checkIn();
                    System.out.println("✅ Book checked in!");
                } else {
                    System.out.println("❌ Invalid ID or book not checked out.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }
    }
}


