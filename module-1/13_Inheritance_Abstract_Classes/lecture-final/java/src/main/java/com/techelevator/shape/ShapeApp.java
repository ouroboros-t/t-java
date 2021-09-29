package com.techelevator.shape;

import com.techelevator.farm.Cow;

public class ShapeApp {
    public static void main(String[] args) {
        Shape t1 = new Triangle(10, 5);
        Shape r1 = new Rectangle(3, 6);
        //Shape s = new Shape();

        Cow cow = new Cow();
        // cow.setAsleep(true); // Doesn't compile because setAsleep is protected
        System.out.println(cow.isAsleep());

    }
}
