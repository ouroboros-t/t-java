package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Book> booksToBuy = new ArrayList<Book>();


    //add books to the list
    public void add(Book bookToAdd) {
        booksToBuy.add(bookToAdd);
    }



    public String receipt() {
        String receipt = "\nReceipt\n";
        BigDecimal total = BigDecimal.ZERO;
        for (Book book : booksToBuy) {
            receipt += book.bookInfo();
            total = total.add(book.getBookPrice());
            receipt += "\n";
        }
        receipt += "\nTotal: $" + total + "\nThank you for shopping with us!";

        return receipt;
    }


}
