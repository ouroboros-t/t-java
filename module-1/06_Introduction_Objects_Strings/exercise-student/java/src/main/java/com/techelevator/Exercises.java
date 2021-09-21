package com.techelevator;

public class Exercises {

    /*
     Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
     helloName("Bob") → "Hello Bob!"
     helloName("Alice") → "Hello Alice!"
     helloName("X") → "Hello X!"
     */
    public String helloName(String name) {
        String helloName = "Hello " + name + "!";

        return helloName;
    }

    /*
     Given two strings, a and b, return the result of putting them together in the order abba,
     e.g. "Hi" and "Bye" returns "HiByeByeHi".
     makeAbba("Hi", "Bye") → "HiByeByeHi"
     makeAbba("Yo", "Alice") → "YoAliceAliceYo"
     makeAbba("What", "Up") → "WhatUpUpWhat"
     */
    public String makeAbba(String a, String b) {
        String makeAbba = a + b;
        String abbaMake = b + a;
        return makeAbba + abbaMake;
    }

    /*
     The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example,
     the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the
     HTML string with tags around the word, e.g. "<i>Yay</i>".
     makeTags("i", "Yay") → "<i>Yay</i>"
     makeTags("i", "Hello") → "<i>Hello</i>"
     makeTags("cite", "Yay") → "<cite>Yay</cite>"
     */
    public String makeTags(String tag, String word) {
        String makeTags = "<" + tag + ">" + word + "</" + tag + ">";

        return makeTags;
    }

    /*
     Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the
     middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting
     at index i and going up to but not including index j.
     makeOutWord("<<>>", "Yay") → "<<Yay>>"
     makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
     makeOutWord("[[]]", "word") → "[[word]]"
     */
    //.length is 4 because we know the length we can just use known index positions
    public String makeOutWord(String out, String word) {
        String makeOutWord = (out.substring(0, 2) + word + out.substring(2));
        //01234 out.length is 4
        //ex makeOutWord ("[[]]", "word") -> "[[word]]"
        return makeOutWord;
    }

    /*
     Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string
     length will be at least 2.
     extraEnd("Hello") → "lololo"
     extraEnd("ab") → "ababab"
     extraEnd("Hi") → "HiHiHi"
     */
    public String extraEnd(String str) {
        int endIndex = str.length();
        String extraEnd = str.substring(endIndex - 2);
        //String extraEnd = str.charAt(2) + str.charAt(3);
        //new string

        return extraEnd + extraEnd + extraEnd;
    }

    /*
     Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
     string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
     yields the empty string "". Note that str.length() returns the length of a string.
     firstTwo("Hello") → "He"
     firstTwo("abcdefg") → "ab"
     firstTwo("ab") → "ab"
     */
    public String firstTwo(String str) {
        //we have 2 conditions
        String firstTwo = str;
        if (str.length() >= 2) {
            firstTwo = str.substring(0, 2);
        } else {
            firstTwo = str.substring(0);
        }
        return firstTwo;
    }

    /*
     Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
     firstHalf("WooHoo") → "Woo"
     firstHalf("HelloThere") → "Hello"
     firstHalf("abcdef") → "abc"
     */
    public String firstHalf(String str) {
        int halfInt = str.length() / 2;//cuts the length in half (ex. length = 8, so first half is 4)
        String firstHalf = str.substring(0, halfInt);//starts and 0, ends at 4 (the half)
        //to display the second half:
        // String secondHalf = str.substring(halfInt); as it would start wherever the half is..

        return firstHalf;
    }

    /*
     Given a string, return a version without the first and last char, so "Hello" yields "ell".
     The string length will be at least 2.
     withoutEnd("Hello") → "ell"
     withoutEnd("java") → "av"
     withoutEnd("coding") → "odin"
     */
    public String withoutEnd(String str) {
        //without 0, without str.length or str.length - 1
        int lastChar = str.length();//create int that represents the length of a String (the last Char)
        String withoutEnd = str.substring(1, lastChar - 1); //lastChar - 1 removes value in the index of lastChar.
		/*ex: 01234
		  ex: Hello lastChar = str.length() = 5
		  str.substring(1,) //begin at one immediately removes the first character at 0
		  str.substring(..,lastChar - 1) takes length of string, reduces it by 1, and removes the value at that index
		                           123
		  ex: withoutEnd(Hello) = (ell) -> index 0 and index 4 removed
		*/

        return withoutEnd;
    }

    /*
     Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string
     on the outside and the longer string on the inside. The strings will not be the same length, but
     they may be empty (length 0).
     comboString("Hello", "hi") → "hiHellohi"
     comboString("hi", "Hello") → "hiHellohi"
     comboString("aaa", "b") → "baaab"
     */
    public String comboString(String a, String b) {

        if (a.length() > b.length()) {
            return b + a + b;
        }
        return a + b + a;
    }

    /*
     Given 2 strings, return their concatenation, except omit the first char of each. The strings will
     be at least length 1.
     nonStart("Hello", "There") → "ellohere"
     nonStart("java", "code") → "avaode"
     nonStart("shotl", "java") → "hotlava"
     */
    public String nonStart(String a, String b) {
        String nonStart = a.substring(1) + b.substring(1);

        return nonStart;
    }

    /*
     Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end.
     The string length will be at least 2.
     left2("Hello") → "lloHe"
     left2("java") → "vaja"
     left2("Hi") → "Hi"
     */
    public String left2(String str) {
        String left2 = str.substring(2) + str.substring(0, 2);

        return left2;
    }

    /*
     Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start.
     The string length will be at least 2.
     right2("Hello") → "loHel"
     right2("java") → "vaja"
     right2("Hi") → "Hi"
     */
    public String right2(String str) {
        int lastChar = str.length();
        String right2 = str.substring(lastChar - 2) /*+ str.substring(lastChar)*/ + str.substring(0, lastChar - 2);
        //will also pass with the commented out part!

        return right2;
    }

    /*
     Given a string, return a string length 1 from its front, unless front is false, in which case
     return a string length 1 from its back. The string will be non-empty.
     theEnd("Hello", true) → "H"
     theEnd("Hello", false) → "o"
     theEnd("oh", true) → "o"
     */
    //nani
    //
    public String theEnd(String str, boolean front) {
        int lastChar = str.length();
        if (front == false) {
            str = str.substring(lastChar - 1);
        } else {
            str = str.substring(0, 1);
        }
        return str;

    }

    /*
     Given a string, return a version without both the first and last char of the string. The string
     may be any length, including 0.
     withoutEnd2("Hello") → "ell"
     withoutEnd2("abc") → "b"
     withoutEnd2("ab") → ""
     */
    public String withoutEnd2(String str) {
        int strLength = str.length();
        String withoutEnd2;
        if (strLength > 2) { //if length is greater than 0,1 (2 indexes)
            withoutEnd2 = str.substring(1, strLength - 1);//return only [1] - second to last index
        } else { //if length is less than 2 indexes (length == 0)
            withoutEnd2 = ""; //return empty string
        }
        return withoutEnd2;
    }

    /*
     Given a string of even length, return a string made of the middle two chars, so the string "string"
     yields "ri". The string length will be at least 2.
     middleTwo("string") → "ri"
     middleTwo("code") → "od"
     middleTwo("Practice") → "ct"
     */
    public String middleTwo(String str) {
        int stringLength = str.length();
        if (stringLength % 2 == 0) {
            return str.substring((stringLength / 2 - 1), (stringLength / 2 + 1));
            //example of this working:
            // "string" length = 6,
            //stringLength/2 = 3, i.e index [2], which prints AFTER index 2, returning -ing
            //adding "-1" to StringLength/2 = 3 - 1 = index[1]  which prints AFTER index 1, returning -ring
            //we want to to STOP/end after "ri" so we add the end at stringLength/2 + 1, which
            //prints Stringlength/2 + 1 = 3 + 1 = 4 = index [3], which stops printing everything AFTER index 3
            //return "ri" which is what we want.

        }
        return str;
    }

    /*
     Given a string, return true if it ends in "ly".
     endsLy("oddly") → true
     endsLy("y") → false
     endsLy("oddy") → false
     */
    public boolean endsLy(String str) {
        //define last character to equal y
        //define second to last character to equal l
        //if str second to last char equal l and last char equal y
        //return true
        //else return false
        //use char notation
        int endsLyLastChar = str.length() - 1;
        int endsLySecondToLastChar = str.length() - 2;
        if (str.length() >= 2) {
            if (str.charAt(endsLySecondToLastChar) == 'l' && str.charAt(endsLyLastChar) == 'y') {
                return true;
            }
        }
        return false;
    }

    /*
     Given a string and an int n, return a string made of the first and last n chars from the string. The
     string length will be at least n.
     nTwice("Hello", 2) → "Helo"
     nTwice("Chocolate", 3) → "Choate"
     nTwice("Chocolate", 1) → "Ce"
     */
    public String nTwice(String str, int n) {
        int numOfChars = n;//number of characters to print in a string
        int nTwiceLength = str.length();
        String nTwice = str.substring(0, numOfChars) + str.substring(nTwiceLength - numOfChars);
        /*prints first character always and stops at n*/ /* starts from the right moving to the left by n*/
        return nTwice;
    }

    /*
     Given a string and an index, return a string length 2 starting at the given index. If the index is
     too big or too small to define a string length 2, use the first 2 chars. The string length will be
     at least 2.
     twoChar("java", 0) → "ja"
     twoChar("java", 2) → "va"
     twoChar("java", 3) → "ja"
     */
    public String twoChar(String str, int index) {
        //if index == 2 return the middle char or last two char
        //if index < 2 or index > 2, return [0,2]
        int twoCharLength = str.length();
        if (index >= twoCharLength || index <= 0) {
            str = str.substring(0, 2);
        } else if (index == twoCharLength - 1) {
            str = str.substring(0, 2);
        } else {
            str = str.substring(index, index + 2);
            //str will print (index, index next to the index) index+1 will only reprint the index again.

        }
        return str;
    }

    /*
     Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and".
     The string length will be at least 3.
     middleThree("Candy") → "and"
     middleThree("and") → "and"
     middleThree("solving") → "lvi"
     */
    public String middleThree(String str) {
        int stringLength = str.length();
        if (stringLength % 2 == 1) {
            return str.substring((stringLength / 2 - 1), (stringLength / 2 + 2));
            //divides the length by 2, starts at the index one to the left (-1), and ends 2  to the right(+2)
            // (3 indexes included total)
            //
        }
        return str;
    }

    /*
     Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with
     "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals()
     to compare 2 strings.
     hasBad("badxx") → true
     hasBad("xbadxx") → true
     hasBad("xxbadxx") → false
     */
    public boolean hasBad(String str) {
        //no matter the length, if it has "bad" in it, return true;
        //if bad starts at 0 or 1 and has bad in at all
        if (str.contains("bad") && str.charAt(0) == 'b' ^ str.charAt(1) == 'b') {
            return true;
        }
        return false;
    }

    /*
     Given a string and a non-negative int n, return a larger string that is n copies of the original string.
     stringTimes("Hi", 2) → "HiHi"
     stringTimes("Hi", 3) → "HiHiHi"
     stringTimes("Hi", 1) → "Hi"
     */
    public String stringTimes(String str, int n) {
        //str * n = copies of str
        String copiesOfStr = str.repeat(n);
        return copiesOfStr;
    }

    /*
     Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or
     whatever is there if the string is less than length 3. Return n copies of the front;
     frontTimes("Chocolate", 2) → "ChoCho"
     frontTimes("Chocolate", 3) → "ChoChoCho"
     frontTimes("Abc", 3) → "AbcAbcAbc"
     */
    public String frontTimes(String str, int n) {
        int frontTimesLength = str.length();
        if (frontTimesLength > 3) {
            String frontTimesStr = str.substring(0, 3);
            str = frontTimesStr.repeat(n);
            return str;
        } else {
            String frontTimesStr = str.substring(0, frontTimesLength);
            str = frontTimesStr.repeat(n);
            return str;
        }
    }

    /*
     Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
     countXX("abcxx") → 1
     countXX("xxx") → 2
     countXX("xxxx") → 3
     */
    public int countXX(String str) {
        int countXX = 0;
        for (int i = 0; i < str.length()-1; i++) {
            if (str.substring(i, i+2).contains("xx")) {
                    countXX++;
                }
            }
        return countXX;
        }

    /*
     Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
     doubleX("axxbb") → true
     doubleX("axaxax") → false
     doubleX("xxxxx") → true
     */
    public boolean doubleX(String str) {
        int indexOfX = str.indexOf('x');
        if (indexOfX < str.length()-1) {
            if (str.charAt(indexOfX+1) == 'x') {
                return true;
            }
        }
        return false;
    }

    /*
     Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
     stringBits("Hello") → "Hlo"
     stringBits("Hi") → "H"
     stringBits("Heeololeo") → "Hello"
     */

    public String stringBits(String str) {
        String bitsOfStr = "";
        for(int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                bitsOfStr += str.charAt(i);
            }
        }
        return bitsOfStr;
    }

    /*
                                    0123
     Given a non-empty string like "Code" return a string like "CCoCodCode".
     stringSplosion("Code") → "CCoCodCode"
     stringSplosion("abc") → "aababc"
     stringSplosion("ab") → "aab"
     */
    public String stringSplosion(String str) {
        String splosionStr = "";
        for(int i = 0; i <= str.length(); i++) {
            //we need to include the last i so <=
            splosionStr += str.substring(0,i);
        }
        return splosionStr;
    }

    /*
     Given a string, return the count of the number of times that a substring length 2 appears in the string and
     also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
     last2("hixxhi") → 1
     last2("xaxxaxaxx") → 1
     last2("axxxaaxx") → 2
     */
    //substring is a section of the string from a designated index
    //char is only a single character
    //strings are objects with an array of
    public int last2(String str) {
        int count = 0;
        for (int i = 0; i < str.length()-2; i++) {
            if(str.substring(i, i+2).equals(str.substring(str.length()-2)) ) {
                //this compares the first two indexes with the last two indexes
                count++;
            }
        }
        return count;
    }

    /*
     Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end
     should not be removed.
     stringX("xxHxix") → "xHix"
     stringX("abxxxcd") → "abcd"
     stringX("xabxxxcdx") → "xabcdx"
     */
    public String stringX(String str) {
        String xString = "";
        //if length = 2, return str
        if (str.length() <= 2) {
            return str;
        }
        xString += str.charAt(0);
        for(int i = 1; i< str.length()-1; i++) {
            if(str.charAt(i) == 'x') {
                xString += "";
            } else {
                xString += str.charAt(i);
            }
        }
        xString += str.charAt(str.length()-1);
        /*int stringXLength = str.length();
        if (str.charAt(stringXLength - 1) == 'x') {
            for (int i = 1; i < str.length() - 1; i++) {
                str = str.substring(0, 1) + str.replace("x", "") + str.substring(stringXLength);
            }
        }*/
        return xString;
    }

    /*
     Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
     altPairs("kitten") → "kien"
     altPairs("Chocolate") → "Chole"
     altPairs("CodingHorror") → "Congrr"
     */
    public String altPairs(String str) {
        String somePairs = ""; //helper variables save lives.
        //kitten
        //012345
        for (int i = 0; i < str.length(); i += 4) {
            somePairs += str.charAt(i);
            if(i + 1 < str.length()) {
                somePairs += str.charAt(i+1);
            }

        }
        return somePairs;
    }

    /*
     Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed.
     The "yak" strings will not overlap.
     stringYak("yakpak") → "pak"
     stringYak("pakyak") → "pak"
     stringYak("yak123ya") → "123ya"
     */
    public String stringYak(String str) {
        String stringYak = str.replace("yak", "");
        return stringYak;
    }

}
