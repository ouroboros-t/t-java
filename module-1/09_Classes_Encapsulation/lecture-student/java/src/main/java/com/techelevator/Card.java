package com.techelevator;

public class Card {
    //static variables shared by all instances of Card
    //typically go above instance variables
    private static int cardCounter;//0 by default..
    //only one instance of this static variable.


    //Instance variables, each new Card gets its own suit, rank and faceUp...
    private String suit;
    private String rank;
    private boolean faceUp;
    //these define the instance of the card.
    //use new keyword to call new instance
    //constructor is a special method that sets the state of the object
    //constructors match class name
    //your parameters are now the variables that define the instance
    public Card() {
        this("Spades", "Ace", false); //this() method is calling a constructor
    }

    public Card(String suit, String rank, boolean faceUp) {
        //Constructors - Like a method but no return type and name equals class name exactly
        //Initializes the class.
        this.suit = suit;
        this.rank = rank;
        this.faceUp = faceUp;

        Card.cardCounter++;//static variable is in italics.. all instances of the Card will be changed
        //all other constructors refer back to this one... so we only need to put our static
        //(this.) keyword creates new instance of parameter
    }
    public Card (String suit, String rank) {
        //overloaded constructor
        //different amount of parameters
        //or different data types (in this example there's no difference)
        this(suit,rank, false);
        //faceUp is by default false.
    }
    public String getSuit() {
        //getters don't take parameters
        return this.suit; //return this instance of suit
    }
    public String getRank() {
        return this.rank; //return this instance of rank
    }
    public boolean isFaceUp() {
        //getters for boolean replaced with "is"
        return this.faceUp;
    }
    public void setFaceUp(boolean faceUp){
        //we aren't returning anything
        this.faceUp = faceUp;
    }

    public String toString() {
        if(this.faceUp) {
            return this.rank + " of " + this.suit;
        } else {
            return "## this card is face down";
        }
    }

    //static method: a method shared by every instance
    //no this() or this.
    public static int getCardCounter() {
        //static methods only have access to static variables
        return Card.cardCounter;
    }
}
