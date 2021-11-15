/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const DAYS_IN_WEEK = 7;
  // DAYS_IN_WEEK = 8; <-- Not allowed

  // Declares a variable those value can be changed
  let num = 5;
  num = 6;
  console.log(num);

  // Declares a variable that will always be an array
  const myArray = [];
  myArray.push(5);
  console.log(myArray);

  let x = 7;
  // let x = 8;

  let isMonday = true;
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`);
  console.log(`x === y : ${x === y}`);
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

function sumArray(arrayToSum) {
  let sum = 0;

  for (let i = 0; i < arrayToSum.length; ++i) {
    sum += arrayToSum[i];
  }

  return sum;
}

function sumArrayEnhanced(arrayToSum) {
  let sum = 0;

  for (const value of arrayToSum) {
    // value += 1; // Can't do this
    sum += value;
  }

  return sum;
}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {
    firstName: "Bill",
    lastName: "Lumbergh",
    age: 42,
    favoriteColor: "blue",
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],
    department: {
      id: 101,
      name: "IT Development"
    }
  };

  // Log the object
  console.table(person);

  // Log the first and last name
  console.log(`First last name --> ${person.firstName} ${person.lastName} ${person.middleName}`);

  // Log each employee
  for (let i = 0; i < person.employees.length; ++i) {
    console.log(`Employee --> ${person.employees[i]}`);
  }

  // Log the department ID
  console.log(`Department ID: ${person.department.id}`);

  // for in loop iterates over the properties of an object
  // property values can be retrieving using brackets and the property name
  for (const prop in person) {
    console.log(prop + " " + person[prop]);
  }

  return {
    isMonday: true,
    cohortWeek: 10
  };
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overridden and the most recent one will be used.
*/

function add(num1, num2) {
  console.log("In the first add");
  return num1 + num2;
}

function add(num1, num2, num3) {
  console.log("In the second add");
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length - ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}
