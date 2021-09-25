package com.techelevator;

public class Employee {
    //PROPERTIES of EMPLOYEE CLASS:
    private int employeeID;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;

    //DERIVED PROPERTY: fullName
    public String getFullName() {
        String fullName = this.lastName + ", "+ this.firstName;
        return fullName;
    }

    //CONSTRUCT EMPLOYEE CLASS DEFAULT
    public Employee(int employeeID, String firstName, String lastName, double annualSalary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }

    //GETTERS & SETTERS

    public int getEmployeeId() {
        return this.employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    //METHODS
    public void raiseSalary(double percent) {
        double raisePercent = percent / 100;
        double newSalaryAmount = annualSalary + (annualSalary* raisePercent);
        this.annualSalary = newSalaryAmount;
    }
}
