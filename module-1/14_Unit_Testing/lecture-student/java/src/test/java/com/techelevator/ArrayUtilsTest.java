package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {
    @Test
    public void max_returns_correct_values_for_3_integers (){
        //Arrange: create the data you wish to test...
        int[] TestArray = {1, 2, 3};
        //Act: call the the method..
        int actual = ArrayUtils.max(TestArray);
        //Assert: did you get back the value you expected..?
        Assert.assertEquals("Max didn't return expected value", 3, actual);
        //we expect 3 because we know the data we're passing through, and we can overload the
    }

    @Test
    public void max_returns_correct_values_for_3_negative_integers (){
        //Arrange: create the data you wish to test...
        int[] TestArray = {-1, -2, -3};
        //Act: call the the method..
        int actual = ArrayUtils.max(TestArray);
        //Assert: did you get back the value you expected..?
        Assert.assertEquals("Max didn't return expected value", -1, actual);
        //we expect 3 because we know the data we're passing through, and we can overload the
    }

    @Test
    public void max_returns_correct_value_for_null_array (){
        //Arrange: create the data you wish to test...
        int[] TestArray = null;
        //Act: call the the method..
        int actual = ArrayUtils.max(TestArray);
        //Assert: did you get back the value you expected..?
        Assert.assertEquals("Max didn't return expected value", 0, actual);
        //we expect 3 because we know the data we're passing through, and we can overload the
    }

}

