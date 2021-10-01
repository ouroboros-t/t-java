package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Tests {
    @Test
    public void return_true_if_mod_20_equals_19() {
        Less20 less20 = new Less20();

        boolean actual = less20.isLessThanMultipleOf20(39);

        Assert.assertTrue(actual);
    }

    @Test
    public void return_true_if_mod_20_equals_18() {
        Less20 less20 = new Less20();

        boolean actual = less20.isLessThanMultipleOf20(38);

        Assert.assertTrue(actual);
    }

    @Test
    public void return_false_if_mod_20_equals_0() {
        Less20 less20 = new Less20();

        boolean actual = less20.isLessThanMultipleOf20(40);

        Assert.assertFalse(actual);
    }

    @Test
    public void return_false_if_0() {
        Less20 less20 = new Less20();

        boolean actual = less20.isLessThanMultipleOf20(0);

        Assert.assertFalse(actual);
    }


}
