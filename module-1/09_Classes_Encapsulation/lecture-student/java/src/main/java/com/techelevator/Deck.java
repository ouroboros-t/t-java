package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    //Collections! Create a list of 52 cards:
    private List<Card> cards;

    public Deck() { //constructors don't have a return type
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                            "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
        this.cards = new ArrayList<Card>();
        for (String suit: suits) { //goes through all the suits
            for (String rank : ranks) { //goes through all the ranks
                Card card = new Card(suit, rank);
                cards.add(card);

            }
        }

    }
    public List<Card> getCards() {
        return this.cards;
    }
    public void shuffleCards() {
        Collections.shuffle(this.cards);
    }

}
