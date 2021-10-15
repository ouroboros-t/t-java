package com.techelevator;

//nothing is working. don't know why. math isn't working. always goes to 0.
public class HotelReservation {
    private String name;
    private String numberOfNights;
    private double estimatedTotal;
    private boolean requiresCleaning = false;
    private boolean usedMiniBar = false;


    public HotelReservation() {

    }


    public HotelReservation(String name, String numberOfNights){
        this.name = name;
        this.numberOfNights = numberOfNights;
    }

    public String getName() {
        return name;
    }

    public String getNumberOfNights() {
        return numberOfNights;
    }

    public double getEstimatedTotal() {
        return estimatedTotal * Double.parseDouble(numberOfNights);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfNights(String numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setEstimatedTotal(double estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    public boolean isRequiresCleaning() {
        return requiresCleaning;
    }

    public void setRequiresCleaning(boolean requiresCleaning) {
        this.requiresCleaning = requiresCleaning;
    }

    public boolean hasUsedMiniBar() {
        return usedMiniBar;
    }

    public void setUsedMiniBar(boolean usedMiniBar) {
        this.usedMiniBar = usedMiniBar;
    }

    public double totalPerNight(double estimatedTotal){
        double roomFee = estimatedTotal;
        double newRoomFee = 0;
        double cleaningFee = 34.99;
        double minibarFee =12.99;
        if(requiresCleaning && usedMiniBar){
            double newCleaningFee = cleaningFee * 2;
            newRoomFee = roomFee + newCleaningFee;

            newRoomFee = roomFee + minibarFee ;
        } else if (!usedMiniBar && requiresCleaning) {
           newRoomFee = roomFee + cleaningFee;
        } else if (usedMiniBar){
            newRoomFee = roomFee + minibarFee;
        }

        estimatedTotal = newRoomFee;

        return estimatedTotal;
    }

    public double completeTotal(String numberOfNights){
        double nightsDouble = Double.parseDouble(numberOfNights);
        double completeTotal = estimatedTotal * nightsDouble;
        return completeTotal;
    }

    @Override
    public String toString() {
        return "RESERVATION - " + getName() + " - " + completeTotal(numberOfNights);

    }
}