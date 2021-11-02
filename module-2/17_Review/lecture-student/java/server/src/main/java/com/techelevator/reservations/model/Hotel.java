package com.techelevator.reservations.model;

public class Hotel {

    private int id;
    private String name;
    private Address address;
    private int stars;
    private int roomsAvailable;
    private double costPerNight;
    private String coverImage;
    private String createdByUser;

    public Hotel(int id, String name, Address address, int stars, int roomsAvailable, double costPerNight, String createdByUser) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.stars = stars;
        this.roomsAvailable = roomsAvailable;
        this.costPerNight = costPerNight;
        this.coverImage = "default-cover-image.png";
        this.createdByUser = createdByUser;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Hotel Details" +
                "\n--------------------------------------------" +
                "\n Id: " + id +
                "\n Name:'" + name + '\'' +
                "\n Stars: " + stars +
                "\n RoomsAvailable: " + roomsAvailable +
                "\n Cost Per Night: " + costPerNight +
                "\n Image:" + coverImage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(double costPerNight) {
        this.costPerNight = costPerNight;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }
}
