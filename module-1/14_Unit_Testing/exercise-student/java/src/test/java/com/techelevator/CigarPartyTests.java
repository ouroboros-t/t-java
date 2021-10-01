package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTests {
    @Test
    public void return_successful_event_in_correct_integer_minimum() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        Boolean actual = cigarParty.haveParty(40, false);
        //Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void return_successful_event_in_correct_integer_maximum() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        Boolean actual = cigarParty.haveParty(60, false);
        //Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void return_unsuccessful_event_outside_integer_range() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        Boolean actual = cigarParty.haveParty(20, false);
        //Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void return_unsuccessful_event_is_weekend() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        Boolean actual = cigarParty.haveParty(30, true);
        //Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void return_successful_event_is_weekend_in_range() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        Boolean actual = cigarParty.haveParty(41, true);
        //Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void return_successful_event_is_weekend_no_upper_range() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        Boolean actual = cigarParty.haveParty(610, true);
        //Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void return_unsuccessful_event_not_weekend_not_in_range() {
        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        Boolean actual = cigarParty.haveParty(610, false);
        //Assert
        Assert.assertEquals(false, actual);
    }


}
