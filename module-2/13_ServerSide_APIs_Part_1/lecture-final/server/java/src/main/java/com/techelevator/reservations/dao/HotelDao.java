package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Hotel;

import java.util.List;

public interface HotelDao {

    List<Hotel> list();

    void create(Hotel hotel);

    Hotel get(int id);

    /**
     * Finds and returns all Hotels in the given state and, optionally, city
     *
     * @param city City to search. Pass <code>null</code> for all cities
     * @param state State to search
     * @return List of matching Hotels
     */
    List<Hotel> find(String city, String state);

}