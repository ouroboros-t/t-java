package com.techelevator;

public class Card {

    /*
        Static variable. Shared by all instances of Card
     */
    private static int cardCounter;

    /*
        Instance variable. Each new Card gets is own suit, rank and faceUp
     */
    private String suit;
    private String rank;
    private boolean faceUp;

    /*
        Constructors - Like a method but no return type and name equals class name exactly
     */

    /**
     * Default constructor creates Ace of Spades
     */
    public Card() {
        this("Spades", "Ace", false);
        //this.suit = "Spades";
        //this.rank = "Ace";
    }

    public Card(String suit, String rank, boolean faceUp) {
        this.suit = suit;
        this.rank = rank;
        this.faceUp = faceUp;

        Card.cardCounter++;
    }

    public Card(String suit, String rank) {
        this(suit, rank, false);
        //this.suit = suit;
        //this.rank = rank;
    }

    /*
        Getters and setters
     */
    public String getSuit() {
        return this.suit;
    }

    public String getRank() {
        return this.rank;
    }

    public boolean isFaceUp() {
        return this.faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    /*
        Helper methods
     */
    public String toStringX() {
        if (this.faceUp) {
            return this.rank + " of " + this.suit;
        } else {
            return "##";
        }
    }

    /*
        Static methods
     */
    public static int getCardCounter() {
        return Card.cardCounter;
    }
}
