package com.techelevator;

public class Book {
    //EXTRA: create an inventory static int:
    private static int bookInventory;


    //define class attributes/properties/instance variables
    private String titleName;
    private String authorName;
    private double bookPrice;

    //create the default constructor
    public Book(){
        bookInventory++;
        //parameters are optional...
    }
    public Book(String titleName, String authorName, double bookPrice) {
        this.titleName = titleName;
        this.authorName = authorName;
        this.bookPrice = bookPrice;

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

    public double getBookPrice() {
        return bookPrice;
    }
    public void setBookPrice(double bookPrice){
        this.bookPrice = bookPrice;
    }
    public static int getBookInventory() {
        return Book.bookInventory;
    }

    public String bookInfo() {
        return "Title: " + titleName + ", Author: " + authorName + ", Price $" + bookPrice;
    }

}
