package com.techelevator;

public class Bid {

	private String bidder;
	private int bidAmount;

	public Bid(String bidder, int bidAmount) {
		this.bidder = bidder;
		this.bidAmount = bidAmount;
	}

	public String getBidder() {
		return bidder;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	//by default, ALL classes extend java.lang.Object, which has the toString method
	//the java.lang.Object points to the Class memory and returns that hexadecimal place instead of the value..
	//by putting toString in our own code, we've "overidden" what the child subclass does
	//such that it no long does the same thing as java.lang.Object (the parent class).


	//BEST PRACTICE: ADD ANNOTATION TO TELL THAT THIS IS THE OVERRIDE
	//Safety check.
	@Override
	public String toString() {
		return "Bidder: " + bidder + " Amount: " + bidAmount;
	}
}
