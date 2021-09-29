package com.techelevator.shape;

public class Triangle extends Shape {
    int base;
    int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public int getArea() {
        return base * height / 2;
    }
}
