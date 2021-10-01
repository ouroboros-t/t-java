package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTests {
    @Test
    public void return_a_and_b_string_without_first_char() {
        NonStart nonStart = new NonStart();
        String actual = nonStart.getPartialString("ntira", "bmisu");
        Assert.assertEquals("tiramisu", actual);
    }

    @Test
    public void return_a_only_without_first_char_when_b_length_is_1() {
        NonStart nonStart = new NonStart();
        String actual = nonStart.getPartialString("vtired", "b");
        Assert.assertEquals("tired", actual);
    }

    @Test
    public void return_b_only_without_first_char_when_a_length_is_1() {
        NonStart nonStart = new NonStart();
        String actual = nonStart.getPartialString("v", "zbruh");
        Assert.assertEquals("bruh", actual);
    }
    @Test
    public void return_b_only_when_a_is_blank() {
        NonStart nonStart = new NonStart();
        String actual = nonStart.getPartialString("", "zbruh");
        Assert.assertEquals("bruh", actual);
    }
    @Test
    public void return_a_only_when_b_is_blank() {
        NonStart nonStart = new NonStart();
        String actual = nonStart.getPartialString("vtired", "");
        Assert.assertEquals("tired", actual);
    }

}
