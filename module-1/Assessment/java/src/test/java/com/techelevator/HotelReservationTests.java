package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class HotelReservationTests {
    //num nights (variations)
    //booleans (minibar and cleaning fee)

    @Test
    public void return_correct_estimated_total_for_4_nights(){
        //call classname.staticvariable
        double expectedRate = HotelReservation.DAILY_RATE * 4;

        HotelReservation reservation = new HotelReservation();
        reservation.setNumberOfNights(4);
        double actual = reservation.getEstimatedTotal();

        Assert.assertEquals(expectedRate, actual,0.01);
    }

    @Test
    public void return_correct_estimated_total_for_6_nights(){
        //call classname.staticvariable
        double expectedRate = HotelReservation.DAILY_RATE * 6;

        HotelReservation reservation = new HotelReservation();
        reservation.setNumberOfNights(6);
        double actual = reservation.getEstimatedTotal();

        Assert.assertEquals(expectedRate, actual,0.01);
    }

    @Test
    public void return_correct_estimated_total_for_0_nights(){
        //call classname.staticvariable
        double expectedRate = HotelReservation.DAILY_RATE * 0;

        HotelReservation reservation = new HotelReservation();
        reservation.setNumberOfNights(0);
        double actual = reservation.getEstimatedTotal();

        Assert.assertEquals(expectedRate, actual,0.01);
    }

}
