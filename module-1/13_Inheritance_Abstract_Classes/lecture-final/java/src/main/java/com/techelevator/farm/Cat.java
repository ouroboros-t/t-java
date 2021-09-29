package com.techelevator.farm;

public class Cat extends FarmAnimal {
    public Cat() {
        super("Cat", "meow!");
    }

    // Won't compile because getSound() is final in the base class (FarmAnimal)
//    @Override
//    public String getSound() {
//        return "meow!";
//    }

    public void eat() {
        System.out.println("The cat is eating cat food");
    }
}
