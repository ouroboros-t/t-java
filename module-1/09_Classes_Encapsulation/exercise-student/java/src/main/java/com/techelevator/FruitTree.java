package com.techelevator;

public class FruitTree {
    //initial variables/properties/attributes

private String typeOfFruit;
private int piecesOfFruitLeft;

//constructor/building default instance:
    public FruitTree (String typeOfFruit, int piecesOfFruitLeft){
        //use this. to instantiate..
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = piecesOfFruitLeft;
    }

    //create getters and setters:
    //in this class, I DONT want setters
    public String getTypeOfFruit(){
        return this.typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return this.piecesOfFruitLeft;
    }

    //create a method that returns true if there are enough pieces to remove
    public boolean pickFruit(int numberOfPiecesToRemove) {

        if (piecesOfFruitLeft == 0){
            return false;
        }
        piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;

        return true;
    }










}
