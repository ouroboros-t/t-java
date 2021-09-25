package com.techelevator;

public class DealerApp {
    public static void main (String[] args) {
        //this method HAS to be this.
    Card card = new Card ("Spades", "Ace", true);

        //System.out.println(card.getRank() + " of " + card.getSuit());
        System.out.println(card.toString());
        card.setFaceUp(false);
        System.out.println(card.toString());

        Deck deck = new Deck();
        deck.shuffleCards();
        for (Card deckCard : deck.getCards()) {
            deckCard.setFaceUp(true);
            System.out.println(deckCard.toString());

        }

        System.out.println();
        int numCardsCreated = Card.getCardCounter();
        //IDE knows that since we're calling the Card class, I only have access to the static method..
        System.out.println("Number of cards created: " +numCardsCreated);

    }

}
