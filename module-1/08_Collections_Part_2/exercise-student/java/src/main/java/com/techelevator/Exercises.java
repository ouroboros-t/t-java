package com.techelevator;

import java.util.*;

public class Exercises {

    /*
     * Given the name of an animal, return the name of a group of that animal
     * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
     *
     * The animal name should be case insensitive so "elephant", "Elephant", and
     * "ELEPHANT" should all return "herd".
     *
     * If the name of the animal is not found, null, or empty, return "unknown".
     *
     * Rhino -> Crash
     * Giraffe -> Tower
     * Elephant -> Herd
     * Lion -> Pride
     * Crow -> Murder
     * Pigeon -> Kit
     * Flamingo -> Pat
     * Deer -> Herd
     * Dog -> Pack
     * Crocodile -> Float
     *
     * animalGroupName("giraffe") → "Tower"
     * animalGroupName("") -> "unknown"
     * animalGroupName("walrus") -> "unknown"
     * animalGroupName("Rhino") -> "Crash"
     * animalGroupName("rhino") -> "Crash"
     * animalGroupName("elephants") -> "unknown"
     *
     */
    public String animalGroupName(String animalName) {
        Map<String, String> animalGroupMap = new HashMap<String, String>();
        //key is group, animal is key, so return the value when key is passed.
        animalGroupMap.put("giraffe", "Tower");
        animalGroupMap.put("rhino", "Crash");
        animalGroupMap.put("elephant", "Herd");
        animalGroupMap.put("lion", "Pride");
        animalGroupMap.put("crow", "Murder");
        animalGroupMap.put("pigeon", "Kit");
        animalGroupMap.put("flamingo", "Pat");
        animalGroupMap.put("deer", "Herd");
        animalGroupMap.put("dog", "Pack");
        animalGroupMap.put("crocodile", "Float");

        if (animalName != null && animalGroupMap.containsKey(animalName.toLowerCase())) {
            return animalGroupMap.get(animalName.toLowerCase());//.toLowercase forces entry to lowercase
        } else {
            return "unknown";
        }
        //WORKS WITH TREEMAP:
//		if (!Objects.equals(animalName, null)) {
//			if (animalName.equals("")) {
//				return "unknown";
//			} else if (animalGroupMap.containsKey(animalName)) {
//				return animalGroupMap.get(animalName);
//			}
//			return "unknown";
//		} else {
//			return "unknown";
//		}
    }

    /*
     * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
     * If the item is not on sale, return 0.00.
     *
     * If the item number is empty or null, return 0.00.
     *
     * "KITCHEN4001" -> 0.20
     * "GARAGE1070" -> 0.15
     * "LIVINGROOM"	-> 0.10
     * "KITCHEN6073" -> 0.40
     * "BEDROOM3434" -> 0.60
     * "BATH0073" -> 0.15
     *
     * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
     * should all return 0.20.
     *
     * isItOnSale("kitchen4001") → 0.20
     * isItOnSale("") → 0.00
     * isItOnSale("GARAGE1070") → 0.15
     * isItOnSale("dungeon9999") → 0.00
     *
     */
    public double isItOnSale(String itemNumber) {
        Map<String, Double> saleMap = new HashMap<String, Double>();

        saleMap.put("KITCHEN4001", 0.20);
        saleMap.put("GARAGE1070", 0.15);
        saleMap.put("LIVINGROOM", 0.10);
        saleMap.put("KITCHEN6073", 0.40);
        saleMap.put("BEDROOM3434", 0.60);
        saleMap.put("BATH0073", 0.15);
        if (itemNumber != null) {
            if (saleMap.containsKey(itemNumber.toUpperCase())) {
                double saleNumber = saleMap.get(itemNumber.toUpperCase());
                return saleNumber;
            }
        } else {
            return 0.00;
        }
        return 0.00;
    }

    /*
     * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
     * but only if Paul has less than $10s.
     *
     * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
     *
     * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
     * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
     *
     */
    public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
        int paulsMoney = peterPaul.get("Paul");
        int petersMoney = peterPaul.get("Peter");
        if (paulsMoney < 1000) {
            int amountToPaul = petersMoney / 2;
            paulsMoney = paulsMoney + amountToPaul;
            peterPaul.put("Peter", petersMoney - amountToPaul);
            peterPaul.put("Paul", paulsMoney);
        }
        return peterPaul;
    }

    /*
     * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
     * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
     * current worth.
     *
     * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
     * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
     *
     */
    public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
        //stays ints.
        //map called peterPaul
        int paulMoney = peterPaul.get("Paul");
        int peterMoney = peterPaul.get("Peter");
        if ((peterMoney >= 5000) && (paulMoney >= 10000)) { //then
            int paulContribution = (int) (paulMoney * 0.25);
            int peterContribution = (int) (peterMoney * 0.25);

            int paulMoneyAfterContribution = paulMoney - paulContribution;
            int peterMoneyAfterContribution = peterMoney - peterContribution;

            int peterPaulPartnership = peterContribution + paulContribution;

            peterPaul.put("Peter", peterMoneyAfterContribution);
            peterPaul.put("Paul", paulMoneyAfterContribution);
            peterPaul.put("PeterPaulPartnership", peterPaulPartnership);
        }
        return peterPaul;
    }

    /*
     * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
     * there is a key of its first character with the value of its last character.
     *
     * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
     * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
     * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
     */
    public Map<String, String> beginningAndEnding(String[] words) {
        //create new map of string objects:
        Map<String, String> firstAndLastLetterMap = new HashMap<String, String>();
        //turn array into string:
        //for each word:
        for (String word : words) {
            firstAndLastLetterMap.put(word.substring(0, 1), word.substring(word.length() - 1));

        }

        return firstAndLastLetterMap;
    }

    /*
     * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
     * number of times that String appears in the array.
     *
     * ** A CLASSIC **
     *
     * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
     * wordCount([]) → {}
     * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
     *
     */
    public Map<String, Integer> wordCount(String[] words) {
        //need a map
        //for each time the word appears, then increase counter
        //return words, counter

        Map<String,Integer> countWordMap = new HashMap<String, Integer>();

//{"a", "b", "a", "c", "d", "z", "e", "f", "z"}
        for(String countWordStr : words) {  //for each countWordStr , go through the above array
            int count = 0;
            for (String wordToCount : words) { //countWordStr : "a" count: 0
                if(countWordStr.equals(wordToCount)) {
                    count++;
                }
            }
            countWordMap.put(countWordStr, count);
        }
        return countWordMap; //return mapname
    }

    /*
     * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
     * number of times that int appears in the array.
     *
     * ** The lesser known cousin of the the classic wordCount **
     *
     * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
     * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
     * intCount([]) → {}
     *
     */
    public Map<Integer, Integer> integerCount(int[] ints) {
        //need new map [done]
        Map<Integer, Integer> intCountMap = new HashMap<Integer, Integer>();
        //need counter[done] because we need to count how many times an int shows up first
        for(int integerCount : ints) {
            int count = 0;
            for (int otherInteger : ints) {
                if(integerCount == otherInteger) {
                    count++;
                }
            }
            intCountMap.put(integerCount, count);
        }

        return intCountMap;
    }

    /*
     * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
     * is true only if that String appears 2 or more times in the array.
     *
     * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
     * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
     * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
     *
     */
    public Map<String, Boolean> wordMultiple(String[] words) {
        Map<String, Boolean> multipleWordMap = new HashMap<String,Boolean>();
        for(String multiWordStr : words) {  //for each countWordStr , go through the above array
            int count = 0;
            boolean isMultiple = false;
            for (String checkWord : words) { //countWordStr : "a" count: 0
                if(multiWordStr.equals(checkWord)) {
                    count++;
                }
            }
            if(count >= 2) {
                isMultiple = true;
            }
            multipleWordMap.put(multiWordStr, isMultiple);
        }
        return multipleWordMap;

    }

    /*
     * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
     * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
     *
     * Unmatched keys and their int values in Map2 are simply added to Map1.
     *
     * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
     * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
     *
     */
    public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
                                                     Map<String, Integer> remoteWarehouse) {
        Map<String, Integer> consolidateWarehouseMap = new HashMap<String, Integer>();

        Set<String> mainWarehouseKeys = mainWarehouse.keySet();
        Set<String> remoteWarehouseKeys = remoteWarehouse.keySet();
        //for within for
        for (String consolidateKey : mainWarehouseKeys) {
            consolidateWarehouseMap.put(consolidateKey, mainWarehouse.get(consolidateKey));
        }
        //consilidateWarehousemap now equals mainwarehouse
        //now we take the new map and
        for (String remoteKey : remoteWarehouseKeys) {
            if (consolidateWarehouseMap.containsKey(remoteKey)){
                consolidateWarehouseMap.put(remoteKey, mainWarehouse.get(remoteKey) + remoteWarehouse.get(remoteKey));
            } else {
                consolidateWarehouseMap.put(remoteKey, remoteWarehouse.get(remoteKey));
            }
        }
        return consolidateWarehouseMap;
    }

    /*
     * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
     *
     * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
     * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
     *
     * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
     * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
     * end subString, which we don't count.
     *
     * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
     *
     * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
     *
     */



    public Map<String, Integer> last2Revisited(String[] words) {
        Map<String, Integer> last2OhNoMap = new HashMap<String, Integer>();

        for (String word : words) {
            int count = 0;
            String last2 = word.substring(word.length()-2);
            for(int i = 0; i < word.length()-2; i++)
                if (word.substring(i, i+2).equals(last2)) {
                    count++;
                }
            last2OhNoMap.put(word, count);
        }
        return last2OhNoMap;

    }

}
