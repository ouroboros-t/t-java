package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDao.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.get(id);
    }

    /**
     * Return all reservations
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDao.findAll();
        //gets list of reservations
    }

    /**
     * Return all reservations by Hotel id
     */
//    @RequestMapping(path = "/reservations/{reservationId}", method = RequestMethod.GET)
//    public Reservation getReservation(@PathVariable int reservationId){
//        return reservationDao.get(reservationId);
//    }
    @GetMapping(path = "/reservations/{reservationId}")
    public Reservation getReservation(@PathVariable int reservationId){
        return reservationDao.get(reservationId);
    }


    /**
     *
     * @param hotelId
     * @return all reservations for specific hotel (id)
     */
    @GetMapping(path = "/hotels/{hotelId}/reservations")
    public List<Reservation> getReservationByHotelId(@PathVariable int hotelId){
        return reservationDao.findByHotel(hotelId);
    }

    /**
     * Add a new reservation
     */
    @PostMapping(path = "/reservations")
    public Reservation addReservation(@RequestBody Reservation newReservation){
       return reservationDao.create(newReservation, newReservation.getHotelID());
    }

    /**
     * query parameters
     * filter hotels by state and city (optional)
     */
    //the path does not include the ? - that begins the query.
    @GetMapping(path = "/hotels/filter")
    //deal with query inside annotations inside parameters
    public List<Hotel> filterHotels(@RequestParam(required = false) String city, @RequestParam String state){
        System.out.println("In filterHotels with city = " + city + " and state = " + state);
        return null;
    }
        //order of parameters do not matter.. have to match url when called
        //at default every request parameter is required...must add (required = false) next to RequestParam annotation

}
