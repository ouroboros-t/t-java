package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class LectureTest {

    @Test
    public void read_sort_and_print_correctly_sorts() {
        // Arrange
        String sep = System.lineSeparator();

        Scanner inputScanner = new Scanner("banana" + sep + "apple");

//        while (inputScanner.hasNextLine()) {
//            System.out.println(inputScanner.nextLine());
//        }

        StringWriter strWriter = new StringWriter();
        PrintWriter sortedWriter = new PrintWriter(strWriter);

        String expected = "apple" + sep + "banana" + sep;

        // Act
        Lecture.readSortAndPrint(inputScanner, sortedWriter);

        // Assert
        String actual = strWriter.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void some_test() {
        String bad = null;
        bad.length();
    }
}
