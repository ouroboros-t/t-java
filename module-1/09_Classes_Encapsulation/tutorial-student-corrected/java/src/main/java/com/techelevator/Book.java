package com.techelevator;

import java.math.BigDecimal;

public class Book {
    //EXTRA: create an inventory static int:
    private static int bookInventory;


    //define class attributes/properties/instance variables
    private String titleName;
    private String authorName;
    private BigDecimal bookPrice;

    //create the default constructor
    public Book(){
        bookInventory++;
        //parameters are optional...
    }
    public Book(String titleName, String authorName, String bookPrice) {
        this.titleName = titleName;
        this.authorName = authorName;
        this.bookPrice = new BigDecimal(bookPrice);
        //can pass a string through BigDecimal and number is made.

        bookInventory++;
    }

    //Set getters and setters...
    public String getTitleName() {
        return titleName;
    }
    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }
    public void setBookPrice(String bookPrice){
        this.bookPrice = new BigDecimal(bookPrice);
    }
    public static int getBookInventory() {
        return Book.bookInventory;
    }

    public String bookInfo() {
        return "Title: " + titleName + ", Author: " + authorName + "\nPrice: $" + bookPrice;
    }

}
