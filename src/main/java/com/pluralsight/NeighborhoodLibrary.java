package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    public static void main(String[] args) {
        String[] books = {"1|9798581484234|The Great Gatsby by F. Scott Fitzgerald",
                "2|9798364017192|Moby-Dick by Herman Melville",
                "3|9798518317222|1984 by George Orwell",
                "4|Crime and Punishment by Fyodor Dostoevsky",
                "5|9798721748271|Pride and Prejudice by Jane Austen",
                "6|9781558630482|To Kill a Mockingbird by Harper Lee",
                "7|9789124095468|The Lord Of The Rings by J. R. R. Tolkien",
                "8|9780718097905|The Bible by Various writers",
                "9|798367932430|Adventures of Huckleberry Finn by Mark Twain",
                "10|9798705768813|The Odyssey by Homer",
                "11|9781614640950|Watchmen by Alan Moore",
                "12|9781586634506|Native Son by Richard Wright",
                "13|9786055114329|Animal Farm by by George Orwell",
                "14|9781402523809|Dune by Frank Herbert",
                "15|9780684102399|For Whom the Bell Tolls by Ernest Hemingway",
                "16|9781559273619|The Name of the Rose by Umberto Eco",
                "17|9781623306984|The Stand by by Stephen King",
                "18|9781906075415|Brave New World by Aldous Huxley",
                "19|9798500248923|The Count of Monte Cristo by Alexandre Dumas",
                "20|9798448482212|The Adventures of Huckleberry Finn  by Mark Twain"};

                Scanner scanner = new Scanner(System.in);

        try {
            boolean isDone = false;
            while(!isDone){
                System.out.println("=====Home Screen=====");
                System.out.println("What would you like to do:");
                System.out.println("  1, Show all available books");
                System.out.println("  2, Show checked out books");
                System.out.println("  3, Exit");
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine();


            }

        } catch (Exception e){
            System.out.println("Something went wrong");
        }




    }
    public static void showAvailableBooks(){

    }
    public static void showCheckedOutBooks(){

    }
    public static void checkInBook(){

    }

}
