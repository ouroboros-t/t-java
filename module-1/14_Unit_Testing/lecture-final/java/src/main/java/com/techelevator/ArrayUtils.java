package com.techelevator;

public class ArrayUtils {

    /**
     * Returns the maximum integer in the given array.
     * Returns 0 if the array is null.
     * @param array The array to search
     * @return The maximum value
     */
    public static int max(int[] array) {
        int maxFound = Integer.MIN_VALUE;


        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxFound) {
                maxFound = array[i];
            }
        }

        return maxFound;
    }

    public static int average(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length - 1; i++) {
            sum += array[0];
        }

        return sum / array.length;
    }

}
