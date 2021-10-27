package com.techelevator.hotels.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hotel {

    private int id;
    private String name;

    @JsonProperty("address")
    private Address address;

    private int stars;
    private int roomsAvailable;
    private String coverImage;

    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Hotel Details" +
                "\n--------------------------------------------" +
                "\n Id: " + id +
                "\n Name: " + name +
                "\n Address: " + address.getAddress() + " " + address.getCity() + ", " + address.getState() + " " + address.getZip() +
                "\n Stars: " + stars +
                "\n Rooms Available: " + roomsAvailable +
                "\n Cover Image: " + coverImage;
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
}
