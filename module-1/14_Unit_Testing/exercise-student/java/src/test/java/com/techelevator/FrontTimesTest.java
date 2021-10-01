package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {
    @Test
    public void return_first_3_chars_of_chocolate_3_times() {
        //Arrange
        FrontTimes stringFront = new FrontTimes();
        //Act
        String actual = stringFront.generateString("Chocolate", 3);
        //Assert
        Assert.assertEquals("ChoChoCho", actual);
    }

    @Test
    public void return_chars_of_bo_7_times() {
        //Arrange
        FrontTimes stringFront = new FrontTimes();
        //Act
        String actual = stringFront.generateString("Bo", 7);
        //Assert
        Assert.assertEquals("BoBoBoBoBoBoBo", actual);
    }

    @Test
    public void return_blank_if_string_is_null() {
        //Arrange
        FrontTimes stringFront = new FrontTimes();
        //Act
        String actual = stringFront.generateString(null, 7);
        //Assert
        Assert.assertEquals("", actual);
    }

    @Test
    public void return_blank_if_string_is_blank() {
        //Arrange
        FrontTimes stringFront = new FrontTimes();
        //Act
        String actual = stringFront.generateString("", 7);
        //Assert
        Assert.assertEquals("", actual);
    }


}
