package com.pluralsight;

/**
 * Represents a book in the neighborhood library.
 */
public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructor with all necessary book details
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Method to check out the book to a person
    public void checkOut(String name) {
        isCheckedOut = true;
        checkedOutTo = name;
    }

    // Method to return the book
    public void checkIn() {
        isCheckedOut = false;
        checkedOutTo = "";
    }

    // Getters
    public int getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isCheckedOut() { return isCheckedOut; }
    public String getCheckedOutTo() { return checkedOutTo; }

    // Output format for available books
    public String getDisplayInfo() {
        return String.format("ID: %-2d | ISBN: %-15s | Title: %-30s", id, isbn, title);
    }

    // Output format for checked out books
    public String getCheckedOutInfo() {
        return String.format("ID: %-2d | ISBN: %-15s | Title: %-30s | Checked out to: %s",
                id, isbn, title, checkedOutTo);
    }
}

