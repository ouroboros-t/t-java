package com.techelevator.hotels.services;

import com.fasterxml.jackson.databind.MappingIterator;
import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        String url = API_BASE_URL + "hotels"; //this is the completed url for hotels
        //this is the call to our url:
       /*ver. 1 - more info we don't always need:*/ResponseEntity<Hotel[]> response = restTemplate.getForEntity(url,Hotel[].class); //returns response entity
                                                    // that is our response type (Hotel []) have to use .class..
        //
        System.out.println( response.getStatusCode());

        return response.getBody(); //it knows that getBody returns Hotel[]
    }

    public Review[] listReviews() {
        String url = API_BASE_URL + "reviews";
    /*ver.2 - get general info we usually care about*/Review[] reviews = restTemplate.getForObject(url, Review[].class);
                        //don't have to get the body with using the get for object

        return reviews;
    }

    public Hotel getHotelById(int id) {
        String url = API_BASE_URL +"hotels/" + id;
        Hotel hotel = restTemplate.getForObject(url,Hotel.class);
        return hotel;
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        String url = API_BASE_URL +"hotels/" + hotelID + "/reviews";
        /*shorter way of writing ver. 2: */return restTemplate.getForObject(url, Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        String url = API_BASE_URL + "hotels?" + "stars_gte=" + stars;
        Hotel[] hotels = restTemplate.getForObject(url, Hotel[].class);

        return hotels;

    }

    public City getWithCustomQuery(){
        String url = "https://api.teleport.org/api/cities/geonameid:4180564/";
        City cincinnati = restTemplate.getForObject(url, City.class);

        return cincinnati;
    }

}
