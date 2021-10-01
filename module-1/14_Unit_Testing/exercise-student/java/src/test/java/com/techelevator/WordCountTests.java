package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTests {
    @Test
    public void return_accurate_word_count_unique_values() {
        //create a new map that can contain our "expected"
        //create new instance of our class so we can access methods
        WordCount wordCount = new WordCount();
        Map<String, Integer> expected = new HashMap<String, Integer>();
        //fill the map with things:
        expected.put("Ember", 1);
        expected.put("Niobe", 1);
        expected.put("Nova", 1);
        //make sure petNameStr matches our expected Map keys.
        String[] petNameStr = {"Ember", "Niobe", "Nova"};
        //build map that contains our actual output
        Map<String, Integer> actual = wordCount.getCount(petNameStr);
        //assert equals between expected map and actual map.
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void return_accurate_word_count_non_unique_values() {
        //create a new map that can contain our "expected"
        //create new instance of our class so we can access methods
        WordCount wordCount = new WordCount();
        Map<String, Integer> expected = new HashMap<String, Integer>();
        //fill the map with things:
        expected.put("Ember", 2);
        expected.put("Niobe", 1);
        expected.put("Nova", 2);
        //make sure petNameStr matches our expected Map keys.
        String[] petNameStr = {"Ember", "Niobe", "Nova", "Ember", "Nova"};
        //build map that contains our actual output
        Map<String, Integer> actual = wordCount.getCount(petNameStr);
        //assert equals between expected map and actual map.
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void return_blank_if_blank() {
        //create a new map that can contain our "expected"
        //create new instance of our class so we can access methods
        WordCount wordCount = new WordCount();
        //create blank map:
        Map<String, Integer> expected = new HashMap<String, Integer>();

        //create blank array of strings.
        String[] petNameStr = {};
        //build map that contains our actual output
        Map<String, Integer> actual = wordCount.getCount(petNameStr);
        //assert equals between expected map and actual map.
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void return_blank_if_null() {
        //create a new map that can contain our "expected"
        //create new instance of our class so we can access methods
        WordCount wordCount = new WordCount();
        //create blank map:
        Map<String, Integer> expected = new HashMap<String, Integer>();

        //create blank array of strings.
        String[] petNameStr = null;
        //build map that contains our actual output
        Map<String, Integer> actual = wordCount.getCount(petNameStr);
        //assert equals between expected map and actual map.
        Assert.assertEquals(expected, actual);
    }

}
