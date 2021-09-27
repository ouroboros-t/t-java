package com.techelevator;

public class ReserveAuction extends Auction{
    //PROPERTIES:
    private int reservePrice;

    //CONSTRUCTOR:
    public ReserveAuction(String itemOnSale, int reservePrice){
        super(itemOnSale);//calls base-class constructor..
        //ctrl h = hierarchy.
        //if there's no super(); inside here, then it will call the default constructor of the base class
        //will throw error if there's no default constructor...
        this.reservePrice = reservePrice;
    }

    @Override
    public boolean placeBid(Bid offerBid) {
        //what I'm overriding HAS to match the method I'm overriding!
        //the list that the original method refers to we don't have access to (it's private)
        boolean isCurrentWinningBid = false;
        if(offerBid.getBidAmount() >= reservePrice){
            isCurrentWinningBid = super.placeBid(offerBid);
            //this takes offerBid and moves it through the superclass Auction placeBid method.
            //IF I DON'T have the super method or call a method when I NEED it, the app will break..

        }
        return isCurrentWinningBid;
    }











}
