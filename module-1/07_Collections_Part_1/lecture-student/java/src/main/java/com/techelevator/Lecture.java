package com.techelevator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//use java.util.* when importing A LOT of tools, keeps the top cleaner
public class Lecture {

    public static void main(String[] args) {
        int x = 5;//primitive type on the stack
        //Integer xInteger = new Integer(5); //reference type on the heap
        Integer xInteger = 5; //same thing as above in a shorter way. Integer is reference type
        int xInt = xInteger; //automatically takes the value from the memory address and stores it into the primitive type


        //The conversion from primitive to object is called "autoboxing",
        //while the reverse, from object to primitive, is known as "unboxing."


        System.out.println("####################");
        System.out.println("       LISTS");
        System.out.println("####################");
        List<String> animals = new ArrayList<String>();//String(); is the constructor with no args
        //String is the type of ArrayList = ArrayList of Strings called "animals"
        //can be written as List<String> animals = new ArrayList<>(); where <> = <String>
        //more flexible than an Array
        //List is an interface, ArrayList is a class
        //programming interfaces are important to know/remember

        animals.add("dog"); //.add() method adds to the end of the list
        animals.add("cat");
        animals.add("snake");
        System.out.println(animals.size());
        System.out.println(animals.get(0));
        //to print a specific index in a list, use .get method [.get()]
        //remember, methods require parentheses! ()!
        List<Integer> numbers = new ArrayList<Integer>();
        //cannot use primitive type int, must use object version Integer
        numbers.add(5);
        numbers.add(63);
        Integer indexZero = numbers.get(0);
        int indexOne = numbers.get(1);

        List<String> otherAnimals = new ArrayList<String>(Arrays.asList("dog", "cat"));
        //this tells ArraysList to initialize to certain values in asList
        //it's still as flexible as any other list.

        System.out.println("####################");
        System.out.println("Lists are ordered");
        System.out.println("####################");
        animals.add(1, "lizard"); //.add(int index, element)
        System.out.println(animals); //prints the whole list.

        animals.remove(3); //removed a specific index from the list
        System.out.println(animals);


        //animals.add(40,"gerbil");
        animals.add("gerbil");
        System.out.println(animals);


        System.out.println("####################");
        System.out.println("Lists allow duplicates");
        System.out.println("####################");

        animals.add(0, "lizard");
        System.out.println(animals);
        //animals.add(7); won't work because 7 is int and .animals is a string


        System.out.println("####################");
        System.out.println("Lists allow elements to be inserted in the middle");
        System.out.println("####################");


        System.out.println("####################");
        System.out.println("Lists allow elements to be removed by index");
        System.out.println("####################");

        System.out.println("Before remove: " + animals);
        String removedAnimal = animals.remove(2);
        System.out.println("After remove: " + animals);
        System.out.println("Removed: " + removedAnimal);

        boolean catRemoved = animals.remove("cat");
        //removes first instance of the cat
        System.out.println(animals);
        ;
        System.out.println("catRemoved = " + catRemoved);


        System.out.println("####################");
        System.out.println("Find out if something is already in the List");
        System.out.println("####################");
        boolean raptorFound = animals.contains("raptor");
        System.out.println("raptorFound = " + raptorFound);

        System.out.println("####################");
        System.out.println("Find index of item in List");
        System.out.println("####################");
        int indexOfDog = animals.indexOf("dog");
        System.out.println("index of dog is " + indexOfDog);


        System.out.println("####################");
        System.out.println("Lists can be turned into an array");
        System.out.println("####################");
        String[] animalsArray = animals.toArray(new String[0]);//turns animals into a String array
        System.out.println(animalsArray.length);
        //

        System.out.println("####################");
        System.out.println("Lists can be sorted");
        System.out.println("####################");
        Collections.sort(animals);
        System.out.println("After sorting: " + animals);
        //strings by default are sorted in alphabetical order.
        //can be sorted by unicode --uppercase comes before lowercase


        System.out.println("####################");
        System.out.println("Lists can be reversed too");
        System.out.println("####################");
        Collections.reverse(animals);
        System.out.println("After reverse: " + animals);
        //Collections is a helper method?

        System.out.println("####################");
        System.out.println("       FOREACH");
        System.out.println("####################");
        System.out.println();
        for (int i = 0; i < animals.size(); i++)
        {
            String currentAnimal = animals.get(i);
            System.out.print(currentAnimal + " ");
        }

        for (String animal : animals)
            /*for each string available, iterate through animals and do something*/
            {
                System.out.println(" ");
                System.out.print(animal);

        }


    }
}
