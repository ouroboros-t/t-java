package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction reserveAuction = new ReserveAuction("Tech Elevator t-shirt", 100);

        reserveAuction.placeBid(new Bid("Josh", 1));
        reserveAuction.placeBid(new Bid("Fonz", 23));
        reserveAuction.placeBid(new Bid("Rick Astley", 13));

        // System.out.println(reserveAuction.getReservePrice()); // Doesn't compile because Auction doesn't have getReservePrice()

        ((ReserveAuction)reserveAuction).getReservePrice();
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        System.out.println("The winning bid is " + reserveAuction.getHighBid());

    }
}
