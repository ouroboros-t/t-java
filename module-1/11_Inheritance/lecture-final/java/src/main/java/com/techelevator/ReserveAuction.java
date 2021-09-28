package com.techelevator;

public class ReserveAuction extends Auction {

    private int reservePrice;

    public ReserveAuction(String itemOnSale, int reservePrice) {
        super(itemOnSale);
        this.reservePrice = reservePrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        System.out.println("Received a bid for item " + getItemForSale());
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() >= reservePrice) {
            isCurrentWinningBid = super.placeBid(offeredBid); }
        return isCurrentWinningBid;
    }

    public int getReservePrice() {
        return reservePrice;
    }
}
