package com.techelevator;

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

		// Sample input line:
		//
		//   Doe,John,123 Main St,Springboro,OH,45066
		//
		// Sample output:
		//
		//   John Doe
		//   123 Main St
		//   Springboro, Ohio 45066
		//
		//  Parallel arrays - DON'T USE
		//
//		List<String> stateAbbrevs = new ArrayList<String>();
//		stateAbbrevs.add("OH");
//		stateAbbrevs.add("KY");
//
//		List<String> stateNames = new ArrayList<String>();
//		stateNames.add("Ohio");
//		stateName.add("Kentucky");

		Map<String,String> stateMap = new HashMap<String, String>();
		stateMap.put("OH", "Ohio");
		stateMap.put("OH", "Ohi."); // Overwrites the value at the key
		stateMap.put("KY", "Kentucky");
		stateMap.put("IN", "Indiana");

		System.out.println(stateMap.size());

		System.out.println("OH = " + stateMap.get("OH"));
		System.out.println("HI = " + stateMap.get("HI"));
		if (!stateMap.containsKey("HI")) {
			stateMap.put("HI", "Hawaii");
			System.out.println(stateMap.get("HI"));
		}

		System.out.println("********************************************");
		System.out.println("Set");
		System.out.println("********************************************");
		Set<Long> couponNums = new HashSet<Long>();
		couponNums.add(53L);
		long butter = 21L;
		System.out.println(couponNums.add(butter));
		System.out.println(couponNums.add(butter));
		System.out.println(couponNums);

		System.out.println("********************************************");
		System.out.println("Looping over a Map");
		System.out.println("********************************************");

		// Looping using keySet()
		Set<String> stateKeys = stateMap.keySet();
		for (String stateKey : stateKeys) {
			String stateName = stateMap.get(stateKey);
			System.out.println(stateKey + "," + stateName);
		}

		// Looping using entrySet()
		Set<Map.Entry<String, String>> stateEntries = stateMap.entrySet();
		for (Map.Entry<String, String> stateEntry : stateEntries) {
			String key = stateEntry.getKey();
			String value = stateEntry.getValue();
			System.out.println(key + "," + value);
		}

//		for (int listOneIdx = 0, listTwoIdx = 0; i < listOne.size() && j < listTwo.size(); i++, j++) {
//
//		}
	}

}
