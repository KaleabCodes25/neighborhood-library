package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    //private static int numOfBooks = 20;
    public static Book[] inventory = new Book[20];
    public static Scanner scanner;

    public static void main(String[] args) {
        // I created a books array that hold lines of books
        String[] books = {"1|9798581484234|The Great Gatsby by F. Scott Fitzgerald",
                "2|9798364017192|Moby-Dick by Herman Melville",
                "3|9798518317222|1984 by George Orwell",
                "4|9798721748271|Crime and Punishment by Fyodor Dostoevsky",
                "5|9798352776810|Pride and Prejudice by Jane Austen",
                "6|9781558630482|To Kill a Mockingbird by Harper Lee",
                "7|9789124095468|The Lord Of The Rings by J. R. R. Tolkien",
                "8|9780718097905|The Bible by Various writers",
                "9|798367932430|Adventures of Huckleberry Finn by Mark Twain",
                "10|9798705768813|The Odyssey by Homer",
                "11|9781614640950|Watchmen by Alan Moore",
                "12|9781586634506|Native Son by Richard Wright",
                "13|9786055114329|Animal Farm  by George Orwell",
                "14|9781402523809|Dune by Frank Herbert",
                "15|9780684102399|For Whom the Bell Tolls by Ernest Hemingway",
                "16|9781559273619|The Name of the Rose by Umberto Eco",
                "17|9781623306984|The Stand  by Stephen King",
                "18|9781906075415|Brave New World by Aldous Huxley",
                "19|9798500248923|The Count of Monte Cristo by Alexandre Dumas",
                "20|9798448482212|The Adventures of Huckleberry Finn  by Mark Twain"};
        //opened scanner
        Scanner scanner = new Scanner(System.in);
        // create array called inventory that holds book objects and the length is 20 because books holds 20 books.

        //for loop to split the the arrays
        for (int i = 0; i < books.length; i++) {

            String[] parts = books[i].split("\\|");

            int id = Integer.parseInt(parts[0]);
            String isbn = parts[1];
            String title = parts[2];

            Book book = new Book(id, isbn, title, false, "");

             // store each book object into the inventory[] we created
            inventory[i] = new Book(id, isbn, title, false, "");
        }

        // show the menu until exit
        boolean isDone = false;

        while (!isDone) {

            System.out.println("===== Library Menu ======");
            System.out.println("1 - Show available books");
            System.out.println("2 - Show checked-out books");
            System.out.println("3 - Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showAvailableBooks(inventory, scanner);
                case "2" -> showCheckedOutBooks(inventory, scanner);
                case "3" -> {
                    System.out.println("Goodbye!");
                    isDone = true;
                }
                default -> System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    // Display all the books and check out one if needed
    public static void showAvailableBooks(Book[] inventory, Scanner scanner) {
        System.out.println("===== Available Books ======");

        for (Book book : inventory) {
            if (!book.isCheckedOut()) {
                System.out.println(book.getId() + " | " + book.getIsbn() + " | " + book.getTitle());
            }
        }

        System.out.print("Enter a book Id to check out (X to return): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("X")) {
            return;
        }

        int id;
        id = Integer.parseInt(input);
        scanner.nextLine();

        // look for your book
        for (Book book : inventory) {

            if (book.getId() == id && !book.isCheckedOut()) {

                System.out.print("Enter your name: ");
                String name = scanner.nextLine().trim();

                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty.");
                    return;
                }

                book.checkOut(name);
                System.out.println("Book checked out successfully!");
                return;
            }
        }

        System.out.println("Book not found or already checked out.");
    }

    // Display checked-out books and check them back in
    public static void showCheckedOutBooks(Book[] inventory, Scanner scanner) {

        System.out.println("===== Checked-Out Books =====");

        boolean foundBook = false;

        for (Book book : inventory) {

            if (book.isCheckedOut()) {

                System.out.println(book.getId() + " | " + book.getIsbn() + " | " + book.getTitle() + " | Checked out to: " + book.getCheckedOutTo());foundBook = true;
            }
        }

        if (!foundBook) {
            System.out.println("No books are currently checked out.");
            return;
        }

        System.out.println("C - Check in a book");
        System.out.println("X - Return to home screen");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("X")) {
            return;
        }

        if (choice.equalsIgnoreCase("C")) {

            System.out.print("Enter the ID of the book to check in: ");
            String input = scanner.nextLine();
            int id;

            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid book ID.");
                return;
            }

            for (Book book : inventory) {

                if (book.getId() == id && book.isCheckedOut()) {

                    book.checkIn();

                    System.out.println("Book checked in successfully!");
                    return;
                }
            }

            System.out.println("No checked-out book found with that ID.");

        } else {
            System.out.println("Invalid option.");
        }

    }


 }