package com.techelevator.farm;

//INTERFACE: a declaration of one or more methods
//Alternative "is-a" relationship: FarmAnimal "is-a" Singable class
//NO constructors
//Interface "implements": className implements interfaceName
//Methods are always public

public interface Singable {
    String getName();

    String getSound();

    String getIndefiniteArticleForSound();

}
