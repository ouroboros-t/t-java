package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTests {
    @Test
    public void successful_return_every_other_char_in_long_string() {
        StringBits stringBits = new StringBits();
        String actual = stringBits.getBits("HelloMyBabyHelloMyHoney");
        Assert.assertEquals("Every other char means %2 equals 0.", "HloyayelMHny", actual);
    }

    @Test
    public void successful_return_every_other_char_in_short_string() {
        StringBits stringBits = new StringBits();
        String actual = stringBits.getBits("Hi");
        Assert.assertEquals("Every other char means %2 equals 0.", "H", actual);
    }
    @Test
    public void successful_return_every_other_char_in_num_string() {
        StringBits stringBits = new StringBits();
        String actual = stringBits.getBits("101021030");
        Assert.assertEquals("Every other char means %2 equals 0.", "11200", actual);
    }

    @Test
    public void return_blank_string_when_blank() {
        StringBits stringBits = new StringBits();
        String actual = stringBits.getBits("");
        Assert.assertEquals("", actual);
    }

    @Test
    public void return_blank_string_when_null() {
        StringBits stringBits = new StringBits();
        String actual = stringBits.getBits(null);
        Assert.assertEquals("", actual);
    }


}
