package com.techelevator;

public class ReferenceVariables {

    public static void main(String[] args) {

        int x = 5;

        doSomethingWithAnInt(x);

        int[] nums = new int[3];

        doSomethingWithAnIntArray(nums);
    }

    static void doSomethingWithAnInt(int someNum) {
        someNum++;
    }

    static void doSomethingWithAnIntArray(int[] someArray) {
        someArray[0] = 5;
    }
}
