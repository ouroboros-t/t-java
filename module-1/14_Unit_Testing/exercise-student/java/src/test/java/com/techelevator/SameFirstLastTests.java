package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTests {
    @Test
    public void true_if_first_element_equals_last_element() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] testArray = {3, 4, 5, 6, 4, 3};
        boolean result = sameFirstLast.isItTheSame(testArray);
        Assert.assertTrue(result);
    }
    @Test
    public void true_if_first_element_equals_last_element_when_negative() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] testArray = {-3, 4, 5, 6, 4, -3};
        boolean result = sameFirstLast.isItTheSame(testArray);
        Assert.assertTrue(result);
    }

    @Test
    public void false_if_first_element_does_not_equal_last_element() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] testArray = {3, 4, 5, 6, 4, 13};
        boolean result = sameFirstLast.isItTheSame(testArray);
        Assert.assertFalse(result);
    }
    @Test
    public void false_if_first_element_does_not_equal_last_element_when_negative() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] testArray = {3, 4, 5, 6, 4, -3};
        boolean result = sameFirstLast.isItTheSame(testArray);
        Assert.assertFalse(result);
    }

    @Test
    public void false_if_array_is_null() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        boolean result = sameFirstLast.isItTheSame(null);
        Assert.assertFalse(result);
    }

    @Test
    public void false_if_array_is_blank() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] testArray = {};//blank arrays have 0 length.
        boolean result = sameFirstLast.isItTheSame(testArray);
        Assert.assertFalse(result);
    }
}
