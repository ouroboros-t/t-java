package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

        this.cards = new ArrayList<Card>();

        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }
}
