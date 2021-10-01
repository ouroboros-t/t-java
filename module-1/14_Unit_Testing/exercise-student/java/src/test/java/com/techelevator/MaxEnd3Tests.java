package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxEnd3Tests {
    @Test
    public void return_array_of_first_element_when_first_element_is_larger() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = {12, 1, 4};
        int[] result = maxEnd3.makeArray(testArray);
        int[] expectedResult = {12, 12, 12};
        Assert.assertArrayEquals(expectedResult, result);

    }

    @Test
    public void return_array_of_last_element_when_first_element_is_negative() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = {-12, 1, 4};
        int[] result = maxEnd3.makeArray(testArray);
        int[] expectedResult = {4, 4, 4};
        Assert.assertArrayEquals(expectedResult, result);

    }

    @Test
    public void return_array_of_first_element_when_last_element_is_negative() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = {12, 1, -41};
        int[] result = maxEnd3.makeArray(testArray);
        int[] expectedResult = {12, 12, 12};
        Assert.assertArrayEquals(expectedResult, result);

    }

    @Test
    public void return_array_of_larger_element_when_larger_element_is_negative() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = {-12, 1, -41};
        int[] result = maxEnd3.makeArray(testArray);
        int[] expectedResult = {-12, -12, -12};
        Assert.assertArrayEquals(expectedResult, result);

    }


    @Test
    public void return_array_of_last_element_when_last_element_is_larger() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = {2, 1, 15};
        int[] result = maxEnd3.makeArray(testArray);
        int[] expectedResult = {15, 15, 15};
        Assert.assertArrayEquals(expectedResult, result);

    }

    @Test
    public void return_array_of_first_element_when_first_and_last_element_are_equal() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = {3, 15, 3};
        int[] result = maxEnd3.makeArray(testArray);
        int[] expectedResult = {3, 3, 3};
        Assert.assertArrayEquals(expectedResult, result);

    }

    @Test
    public void return_array_of_first_element_when_first_and_last_element_are_equal_and_negative() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] testArray = {-3, 15, -3};
        int[] result = maxEnd3.makeArray(testArray);
        int[] expectedResult = {-3, -3, -3};
        Assert.assertArrayEquals(expectedResult, result);

    }

}
