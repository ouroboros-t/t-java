package com.techelevator;

public class TriangleWall extends Wall{
    private int base;
    private int height;

    public TriangleWall(String name, String color, int base, int height){
        super(name, color);
        this.base = base;
        this.height = height;
    }

    public int getBase(){
        return base;
    }
    public int getHeight(){
        return height;
    }

    @Override
    public int getArea(){
        int area = 0;
        area = base * height;
        area = area/2;
        return area;
    }

    public String toString(){
        return getName() +" " + "(" + getBase() +"x" + getHeight() + ")" + " triangle";
    }


}
