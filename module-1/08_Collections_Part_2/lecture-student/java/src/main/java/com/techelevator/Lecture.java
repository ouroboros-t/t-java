package com.techelevator;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<String, String> stateMap = new HashMap<String,String>();
		stateMap.put("OH", "Ohio"); //single key and single value - value is object.
		stateMap.put("OH", "Ohi.");//can only have a single key, if the key repeats, it
		//upsert - insert if it doesn't exist; update if it does exist already. ("Ohio" was upserted to "Ohi.")
		stateMap.put("KY", "Kentucky");
		stateMap.put("IN", "Indiana");

		System.out.println(stateMap.size());

		System.out.println("OH = " + stateMap.get("OH"));
		//Map.get() returns the value of the key passed.

		System.out.println("HI = " + stateMap.get("HI"));
		//this will return null because the key "HI" doesn't have an entry.

		if (!stateMap.containsKey("HI")){
			stateMap.put("HI", "Hawaii");//data types must match, in this case it's string, string
			System.out.println(stateMap.get("HI"));
			//this checks to see IF there's an entry at the key
		}

		System.out.println("********************************");
		System.out.println("            SET                 ");
		System.out.println("********************************");
		//Sets do not have duplicates, only one of each value.
		Set<Long> couponNums = new HashSet<Long>();
		//coding standard at TE is to make the data sets match in declaration
		couponNums.add(53L);
		long butter = 21L;
		System.out.println(couponNums.add(butter)); //returns boolean to check if it is in the set
		System.out.println(couponNums.add(butter)); //returns false because it's already in there.
		System.out.println(couponNums);
		//if I have multiple entries of "butter", then the following values are ignored.

		System.out.println("********************************");
		System.out.println("*************LOOPS**************");
		System.out.println("********************************");

		//Looping using keySet() method:
		stateMap.keySet();//returns set of Key values - matches the type *string in this example
		Set<String> stateKeys = stateMap.keySet();
		for (String stateKey : stateKeys) { //this will return the entire map
			String stateName = stateMap.get(stateKey);
			System.out.println(stateKey + "," + stateName);

		}
		System.out.println();
		//Looping using entrySet() method:
		Set<Map.Entry<String,String>> stateEntries = stateMap.entrySet();
		//creates a set, names the new set, and sets it to equal our mapName.entrySet(); data types must match!
		//instance of Key and values mapped within a map of Key and values
		for (Map.Entry<String,String> stateEntry : stateEntries ) {
			String key = stateEntry.getKey(); // gets the key
			String value = stateEntry.getValue();//gets the corresponding value
			System.out.println(key + "," + value);
		}






	}

}
