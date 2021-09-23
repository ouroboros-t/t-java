package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Tutorial {
	

    public static void main(String[] args) {

        // Step One: Declare a Map
        Map<String,String> projects = new HashMap<String,String>();
        //coding conventions say that Map<> and HashMap<> have same data types written out
        //Map<data types> automatically match HashMap<data types> when "<>" is left empty.

    	
    	// Step Two: Add items to a Map
        projects.put("Ada", "Inventing Computer Programming");
        projects.put("Grace", "COBOL");
        projects.put("Margaret", "Apollo Guidance Computer");
        projects.put("Adele", "Graphical User Interfaces");

        //Maps are unordered collection objects; therefore when a key and value are passed, there is no definitive structure in which they'll be returned.

        //Step Four: Remove from a Map
        projects.remove("Grace");//passes a key through


        // Step Three: Loop through a Map
        //Map.Entry<Key type, Value type> entryName : mapName.entrySet();
        for(Map.Entry<String,String> projectEntries : projects.entrySet()) {
            //entrySetName.getKey prints key  projectEntries.getKey();
            //entrySetName.getValue prints corresponding value
            //Combine them together

            System.out.println(projectEntries.getKey()+"'s project is: " +  projectEntries.getValue());
            //can be printed in one line
        }




    }

}
