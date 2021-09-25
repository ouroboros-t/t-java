package com.techelevator;

public class Airplane {
    //PROPERTIES of AIRPLANE CLASS:
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    //DERIVED PROPERTY: availableFirstClassSeats
    public int getAvailableFirstClassSeats() {
        int availableFirstClassSeats = this.totalFirstClassSeats - this.bookedFirstClassSeats;
        return availableFirstClassSeats;
    }

    //DERIVED PROPERTY: availableCoachSeats
    public int getAvailableCoachSeats() {
        int availableCoachSeats = this.totalCoachSeats - this.bookedCoachSeats;
        return availableCoachSeats;
    }

    //CONSTRUCT EMPLOYEE CLASS DEFAULT
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    //GETTERS & SETTERS
    public String getPlaneNumber() {
        return this.planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return this.totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return this.bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return this.totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return this.bookedCoachSeats;
    }


    //METHODS
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){
        int actualRemainingSeatsFC = totalFirstClassSeats - bookedFirstClassSeats;
        int actualRemainingSeatsCo = totalCoachSeats - bookedCoachSeats;
        boolean canIReserve = true;

        if (forFirstClass){
            if (totalNumberOfSeats <= actualRemainingSeatsFC) {
                bookedFirstClassSeats = totalNumberOfSeats + bookedFirstClassSeats;
                return true;
            }
        } else if (totalNumberOfSeats <= actualRemainingSeatsCo) {
            bookedCoachSeats = totalNumberOfSeats + bookedCoachSeats;
            return true;
        }
        return false;
    }



}
