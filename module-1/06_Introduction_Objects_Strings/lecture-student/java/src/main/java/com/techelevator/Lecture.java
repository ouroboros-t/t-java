package com.techelevator;

import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String helloTheHardWay = new String("hello"); //it's built in java to not have to call a new string every time
		String hello = "hello";// the easy way
		String anotherHello = "hello";

		System.out.println(helloTheHardWay == hello); // false. Different strings on the heap
		System.out.println(helloTheHardWay.equalsIgnoreCase(hello)); //true. Same characters on the heap
		System.out.println(hello == anotherHello);

		//does helloTheHardWay point to the same space in memory as anotherHello? NO!
		//this returns true because Strings are immutable (cannot be changed), but when line 18 ("hello") and line 19 ("hello")
		//they are pointing to the same memory address ("hello"). This is why we use .equals() method
		// line 18 and line 19 are pointing to the same point in memory ("hello");

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		                 //0123456
		String filename = "happy.bunny.jpg"; // String filename = new String ("happy.bunny.jpg);
		System.out.println("The length of filename is " + filename.length());
		// it's a method, you need to include () even if no parameters are being passed.
		System.out.println(filename.endsWith("Jpg"));
		//.endsWith is case-sensitive [no endsWithIgnoreCase]

		//it's okay to have two methods of the same name as long as the parameters are different within them
		//ex: method1 (String str) and method1 (String str, int int)

		System.out.println("index of bunny is " + filename.indexOf("bunny")); //where "bunny" starts
		//index starts at 0!
		//if I want to look for all the dots or the dots after 5
		//-1 is the method's way of saying "there aren't anymore" in length.

		// Count all of the dots in filename. - use while loop because we don't KNOW how many there could be.
		int count = 0;
		boolean done = false;
		int dotIndex = 0; //
		while(!done) {
			dotIndex = filename.indexOf(".", dotIndex);//single char string
			if(dotIndex == -1) {
				done = true;
			} else {
				count++;
				dotIndex++;//without this, there's an INFINITE LOOP
			}

		}
		System.out.println("There are " + count +" dots in happy.bunny.jpg");


		//
		String greeting = "Hello, everyone";
		String everyone = greeting.substring(7);
		System.out.println("Everyone equals = " + everyone);

		String firstWord = greeting.substring(0, 5);
		//what if I don't know the placement of the end?
		System.out.println("firstWord = " + firstWord);

		String aWord = greeting.substring(0, greeting.length());
		System.out.println(aWord);

		String mixedCase = "Tay Black";
		mixedCase = mixedCase.toLowerCase();//you don't need to use Locale.root
		//this creates a NEW string and changes that NEW string to lower case, the original string
		//cannot be changed.
		System.out.println(mixedCase);
		mixedCase = mixedCase.toUpperCase();

		System.out.println(mixedCase);

		String hasSpaces = "   lalala   ";
		System.out.println("hasSpaces before using .trim = [" + hasSpaces + "]");
		hasSpaces = hasSpaces.trim();// this returns a NEW string and trims NEW string
		System.out.println(hasSpaces);
		System.out.println("[" + hasSpaces.trim() + "]");
		//can also be trimmed when we print the line , still creates a new string and trims new string

		String abc = "ABC";
		if (abc.charAt(0) == 'A') {
			//we use single quotations ('') to denote a single character in a Sting.
			//do something
		}


		//we only use == for objects when we're checking if the object is "null" or not

		String nullStr = null; //the reference variable is not pointing towards anything(null),

		if (nullStr == null) {
			int len = nullStr.length();
			//this throws exception because you're telling JVM to look at an object that is not pointing towards anything
		} else {
			System.out.println("What are you doing?");
		}

		//contains() is case-sensitive
		//Char sequence = string

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		String hello1 = " ";
		String hello2 = " ";
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
