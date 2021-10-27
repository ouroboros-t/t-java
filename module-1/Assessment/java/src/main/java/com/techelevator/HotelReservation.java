package com.techelevator;

//nothing is working. don't know why. math isn't working. always goes to 0.
public class HotelReservation {
    private String name;
    private int numberOfNights;
    public static final double DAILY_RATE = 59.99;
    public static final double CLEANING_FEE = 34.99;
    public static final double MINIBAR_FEE = 12.99;



    public HotelReservation() {

    }


    public HotelReservation(String name, int numberOfNights){
        this.name = name;
        this.numberOfNights = numberOfNights;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public double getEstimatedTotal() {
        return numberOfNights * DAILY_RATE;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }


    public double totalFee(boolean requiresCleaning, boolean usedMiniBar){
        double roomFee = getEstimatedTotal();

        if(requiresCleaning && usedMiniBar){
            double newCleaningFee = CLEANING_FEE * 2;
            roomFee += newCleaningFee;

            roomFee += MINIBAR_FEE ;
        } else if (!usedMiniBar && requiresCleaning) {
           roomFee+= CLEANING_FEE;
        } else if (usedMiniBar){
            roomFee+= MINIBAR_FEE;
        }

        return roomFee;
    }


    @Override
    public String toString() {
        return "RESERVATION - " + getName() + " - " + getEstimatedTotal();

    }
}