package com.techelevator;

public class Elevator {
    //PROPERTIES
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    //DEFAULT CONSTRUCTOR
    public Elevator(int numberOfFloors) {
        this.currentFloor = 1;
        this.numberOfFloors = numberOfFloors;
    }
    //GETTERS AND SETTERS
    public int getCurrentFloor() {
        return this.currentFloor;
    }
    public int getNumberOfFloors(){
        return this.numberOfFloors;
    }
    public boolean isDoorOpen() {
        return doorOpen;
    }
    //METHODS

    public void openDoor(){
        doorOpen = true;
    }
    public void closeDoor(){
        doorOpen = false;
    }
    public void goUp(int desiredFloor){
        if(!doorOpen){
            if(currentFloor>=1 && desiredFloor > currentFloor && desiredFloor <= numberOfFloors){
                currentFloor++;
            }
        }
    }
    public void goDown(int desiredFloor){
        if(!doorOpen){
            if(currentFloor > desiredFloor && desiredFloor <= numberOfFloors && desiredFloor >= 1){
                currentFloor--;
            }
        }

    }

}
