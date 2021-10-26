package com.techelevator.hotels.model;

/*
        // Sample Address as JSON

        "address": {
            "id": "44144a78-725b-47bf-9516-fe9a9d65fbb2",
            "address": "1111 W 10th St",
            "address2": "",
            "city": "Cleveland",
            "state": "Ohio",
            "zip": "44113"
        },

 */
public class Address {
    private String address;
    private String city;
    private String state;
    private String zip;

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
