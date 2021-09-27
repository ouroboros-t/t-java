package com.techelevator;

/**
 * Bookstore
 */
public class Bookstore {

    public static void main(String[] args) {

        System.out.println("Welcome to the Tech Elevator Bookstore!");
        System.out.println();

        // Step Three: Test the getters and setters
        Book twoCities = new Book();//default constructor requires the setters and getters to be passed..
        twoCities.setTitleName("A Tale of Two Cities");
        twoCities.setAuthorName("Charles Dickens");
        twoCities.setBookPrice("14.99");
        System.out.println(twoCities.bookInfo());
        //calls bookInfo method...

        // Step Five: Test the Book constructor
        Book threeMusketeers = new Book("The Three Musketeers", "Alexadre Dumas", "12.95");
        Book childhoodEnd = new Book ("Childhood's End", "Arthur C. Clark", "5.99");
        System.out.println(threeMusketeers.bookInfo());
        System.out.println(childhoodEnd.bookInfo());

        //EXTRA Step: show book inventory:
        int numBooks = Book.getBookInventory();
        System.out.println();
        System.out.println("We currently have " + numBooks + " books in stock!");

        // Step Nine: Test the ShoppingCart class
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(twoCities);
        shoppingCart.add(threeMusketeers);
        shoppingCart.add(childhoodEnd);
        System.out.println(shoppingCart.receipt());

        
    }
}