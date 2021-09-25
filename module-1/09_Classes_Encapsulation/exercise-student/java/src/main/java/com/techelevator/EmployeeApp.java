package com.techelevator;

import java.sql.SQLOutput;

public class EmployeeApp {
    public static void main(String[] args) {
        Employee myNameIs = new Employee(32564, "Tay", "Black", 92500);

        System.out.println("My Name Is: " + myNameIs.getFullName());

        System.out.println();
        System.out.println("A raise of 2% would equal...");



    }
}
