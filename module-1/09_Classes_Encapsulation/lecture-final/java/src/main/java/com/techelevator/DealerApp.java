package com.techelevator;

public class DealerApp {
    public static void main(String[] args) {
        Card card = new Card("Spades", "Ace", true);

        //System.out.println(card.getRank() + " of " + card.getSuit());
        System.out.println(card.toStringX());
        card.setFaceUp(false);
        System.out.println(card.toStringX());

        System.out.println();
        System.out.println();

        Deck deck = new Deck();
        deck.shuffle();
        for (Card deckCard : deck.getCards()) {
            deckCard.setFaceUp(true);
            System.out.println(deckCard.toStringX());
        }

        System.out.println();
        int numCardsCreated = Card.getCardCounter();
        System.out.println("Number of cards created " + numCardsCreated);
    }
}
