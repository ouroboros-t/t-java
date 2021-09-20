package com.techelevator;

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
		String helloTheHardWay = new String("hello");
		String hello = "hello";
		String anotherHello = "hello";

		System.out.println(helloTheHardWay == hello); // false. Different Strings on the heap
		System.out.println(helloTheHardWay.equals(hello)); // true. Same characters on the heap
		// String has an equalsIgnoreCase(String other) method
		System.out.println(hello == anotherHello);

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * endsWith *
		 * startsWith *
		 * indexOf *
		 * lastIndexOf *
		 * length *
		 * substring *
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */
		//                 0....+....1....+....2..
		//                 012345678901234
		String filename = "happy.bunny.jpg";
		System.out.println("The length of filename is " + filename.length());
		System.out.println("filename ends with jpg returned " + filename.endsWith("jpg"));
		System.out.println("index of bunny is " + filename.indexOf("bunny"));

		// Count all of the dots in filename
		int count = 0;
		boolean done = false;
		int dotIndex = 0;
		while (!done) {
			dotIndex = filename.indexOf(".", dotIndex);
			if (dotIndex == -1) {
				done = true;
			} else {
				count++;
				dotIndex++;
			}
		}

		System.out.println("Number of dots in filename is " + count);

		//                 0....+....1....+....2..
		String greeting = "Hello, everyone";
		String everyone = greeting.substring(7);
		System.out.println("everyone = " + everyone);

		String firstWord = greeting.substring(0, 5); // From beginning, up to but not including character at index 5
		System.out.println("firstWord = " + firstWord);

		String mixedCase = "Dave Hoy";
		mixedCase = mixedCase.toLowerCase();
		System.out.println(mixedCase);

		String hasSpaces = "  a   bc ";
		System.out.println("hasSpaces = [" + hasSpaces.trim() + "]");

		String abc = "ABC";
		if (abc.charAt(0) == 'A') {
			// do something
		}

		String nullStr = null;

		if (nullStr == null) {
			int len = nullStr.length();
		}

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();



		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		String hello1 = "";
		String hello2 = "";
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
