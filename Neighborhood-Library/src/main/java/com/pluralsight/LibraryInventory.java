package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the library's book collection.
 */
public class LibraryInventory {
    private List<Book> books;

    // Constructor initializes and populates the book list
    public LibraryInventory() {
        books = new ArrayList<>();
        populateBooks();
    }

    // Adds 20 books to the library inventory
    private void populateBooks() {
        books.add(new Book(1, "9780143127550", "To Kill a Mockingbird"));
        books.add(new Book(2, "9780385472579", "The Catcher in the Rye"));
        books.add(new Book(3, "9780743273565", "The Great Gatsby"));
        books.add(new Book(4, "9780451524935", "1984"));
        books.add(new Book(5, "9780141439600", "Pride and Prejudice"));
        books.add(new Book(6, "9780140449136", "Crime and Punishment"));
        books.add(new Book(7, "9780061120084", "Brave New World"));
        books.add(new Book(8, "9780307476463", "The Road"));
        books.add(new Book(9, "9780141439556", "Wuthering Heights"));
        books.add(new Book(10, "9780451526342", "Animal Farm"));
        books.add(new Book(11, "9780316769174", "Franny and Zooey"));
        books.add(new Book(12, "9780143039433", "The Brothers Karamazov"));
        books.add(new Book(13, "9780142437230", "Moby-Dick"));
        books.add(new Book(14, "9780140186398", "A Tale of Two Cities"));
        books.add(new Book(15, "9780060850524", "Of Mice and Men"));
        books.add(new Book(16, "9780553212419", "Dracula"));
        books.add(new Book(17, "9780141441144", "Jane Eyre"));
        books.add(new Book(18, "9780140186395", "Les Misérables"));
        books.add(new Book(19, "9780140449266", "The Idiot"));
        books.add(new Book(20, "9780140449273", "Notes from Underground"));
    }

    // Returns all books that are not checked out
    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book b : books) {
            if (!b.isCheckedOut()) {
                available.add(b);
            }
        }
        return available;
    }

    // Returns all books that are currently checked out
    public List<Book> getCheckedOutBooks() {
        List<Book> checkedOut = new ArrayList<>();
        for (Book b : books) {
            if (b.isCheckedOut()) {
                checkedOut.add(b);
            }
        }
        return checkedOut;
    }

    // Find a book by its unique ID
    public Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }
}

