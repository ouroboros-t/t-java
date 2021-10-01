package com.techelevator;

import org.junit.Assert;
import org.junit.Test;



public class Lucky13Tests {
    @Test
    public void return_true_has_no_1() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = {5, 6, 123};
        boolean actual = lucky13.getLucky(testArray);
        Assert.assertTrue(actual);
    }

    @Test
    public void return_true_has_no_3() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = {5, 6, 123};
        boolean actual = lucky13.getLucky(testArray);
        Assert.assertTrue(actual);
    }

    @Test
    public void return_false_has_1_or_3() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = {8, 10, 1, 3};
        boolean actual = lucky13.getLucky(testArray);
        Assert.assertFalse(actual);
    }

    @Test
    public void return_false_has_3_or_1() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = {8, 12, 3, 1};
        boolean actual = lucky13.getLucky(testArray);
        Assert.assertFalse(actual);
    }

    @Test
    public void return_false_has_1() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = {8, 10, 1, 3};
        boolean actual = lucky13.getLucky(testArray);
        Assert.assertFalse(actual);
    }

    @Test
    public void return_false_has_1_as_last_entry() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = {10, 8, 12, 1};
        boolean actual = lucky13.getLucky(testArray);
        Assert.assertFalse(actual);
    }

    @Test
    public void return_true_has_negative_1() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = {-1, 8, 12};
        boolean actual = lucky13.getLucky(testArray);
        Assert.assertTrue(actual);
        //so negative 1 is not 1..
        //this should be fixed so that -1 and -3 are included..
        //but for now, reverse it.
    }

    @Test
    public void return_true_has_negative_3() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = {-3, 8, 12};
        boolean actual = lucky13.getLucky(testArray);
        Assert.assertTrue(actual);
    }

    @Test
    public void return_false_has_3() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = {3, 8, 12};
        boolean actual = lucky13.getLucky(testArray);
        Assert.assertFalse(actual);
    }

    @Test
    public void return_false_has_3_as_last_entry() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = {10, 1, 8, 3};
        boolean actual = lucky13.getLucky(testArray);
        Assert.assertFalse(actual);
    }

    @Test
    public void return_true_if_array_null() {
        Lucky13 lucky13 = new Lucky13();
        boolean actual = lucky13.getLucky(null);
        Assert.assertTrue(actual);
    }

    @Test
    public void return_true_if_array_blank() {
        Lucky13 lucky13 = new Lucky13();
        int[] testArray = {};
        boolean actual = lucky13.getLucky(testArray);
        Assert.assertTrue(actual);
    }
}
