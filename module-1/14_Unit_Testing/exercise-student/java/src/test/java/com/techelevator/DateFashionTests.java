package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class DateFashionTests {
    @Test
    public void no_table_if_score_for_you_or_date_is_less_than_2() {
        //Arrange
        DateFashion meAndMyGirl = new DateFashion();
        //Act
        int actual = meAndMyGirl.getATable(1, 4);
        //Assert
        Assert.assertEquals("You shouldn't get a table.", 0, actual);
    }

    @Test
    public void no_table_if_score_for_you_or_date_is_0() {
        //Arrange
        DateFashion meAndMyGirl = new DateFashion();
        //Act
        int actual = meAndMyGirl.getATable(8, 0);
        //Assert
        Assert.assertEquals("You shouldn't get a table.", 0, actual);
    }

    @Test
    public void table_if_score_for_you_or_date_is_more_than_8() {
        //Arrange
        DateFashion meAndMyGirl = new DateFashion();
        //Act
        int actual = meAndMyGirl.getATable(8, 4);
        //Assert
        Assert.assertEquals("You should've gotten a table.", 2, actual);
    }

    @Test
    public void maybe_table_if_score_for_you_or_date_is_less_than_8_and_more_than_2() {
        //Arrange
        DateFashion meAndMyGirl = new DateFashion();
        //Act
        int actual = meAndMyGirl.getATable(6, 5);
        //Assert
        Assert.assertEquals("You might get a table.", 1, actual);
    }


}
