package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction reserveAuction = new ReserveAuction("Tech Elevator t-shirt", 100);
        //because reserveAuction is an Auction type, I cannot call the methods within the ReserveAuction class like .getReservePrice
        //I only have access to Auction methods and java.lang.Object methods..

        //ReserveAuction is an Auction AND is an Object
        //polymorphism - polymorphism means if B (ReserveAuction) is a subclass of A (Auction) and a function (placeBid) can accept A as a parameter, then it can also accept B (placeBid Override).
        reserveAuction.placeBid(new Bid("Josh", 1));
        reserveAuction.placeBid(new Bid("Fonz", 23));
        reserveAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        System.out.println("The winning bid is: " + reserveAuction.getHighBid().toString());




    }
}
