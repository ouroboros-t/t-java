package com.techelevator.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayApp {

    public static void main(String[] args) {
        String greeting = "hello";

        int[] numArray = { 53, 10, 12};
        List<Integer> numList = new ArrayList<Integer>(Arrays.asList(53, 10, 12));

        numList.contains(10);

        int firstNumList = numList.get(0);
        int firstArrayInt = numArray[0];

        // numList = arrayList; // Doesn't compile. Must be same types
    }
}
