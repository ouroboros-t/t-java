/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

function printAllToConsole() {
  let outputStr = '';
  for (const arg of arguments) {
    outputStr += arguments + ", ";
  }
  console.log(outputStr);
}

function printArrayElements(arrToPrint) {
  arrToPrint.forEach(printToConsole);
}

function printArrayElementsV2(arrToPrint) {
  arrToPrint.forEach(function (value) {
    console.log(value);
  })
  //function is an anonymous function because it is unnamed and lives inside of the ArrytoPrint 
}

function printArrayElementsV3(arrToPrint) {
  arrToPrint.forEach((val) => {
    console.log(val);
  });
}

//when there's only one parameter, parentheses are optional:
function printArrayElementsV4(arrToPrint) {
  arrToPrint.forEach(val => {
    console.log(val);
  });
}
//=> means anonymous function
function printArrayElementsV5(arrToPrint) {
  arrToPrint.forEach((val, index) => console.log(val));
}

function computeDouble(value) {
  return value * 2;
}

function arrayDoubler(arrToDouble) {
  return arrToDouble.map(value => {
    return value * 2;
  });
}

//evens only can be broken down into 
function isEven(value) {
  return value % 2 == 0;
}

function evensOnly(arrToFilter = []) {
  const result = arrToFilter.filter(isEven);
  return result;
}

//evensOnly without separate method (anonymous function):

function evensOnlyV2(arrToFilter = []) {
  const results = arrToFilter.filter((value) => {
    return value % 2 == 0;
  })
  return results;
}




/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */


function multiplyTogether(firstParameter, secondParameter) {
  console.log(`in multiplyTogether with ${firstParameter} and ${secondParameter}`);
  return firstParameter * secondParameter;
}



/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */

function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  console.log(`in multiplyNoUndefined with ${firstParameter} and ${secondParameter}`);
  return firstParameter * secondParameter;
}


/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}


function argumentsExample() {
  for (const arg of arguments) {
    console.log(`${typeof arg} : ${arg}`);
  }
}


function sum(previousValue, currentValue) {
  console.log(`In sum with ${previousValue} and ${currentValue}`);
  return previousValue + currentValue;
}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {

  return numbersToSum.reduce((runningSum, curValue) =>
    runningSum + curValue);
}
//without the 0 set as the default, the first number will always be added.
//second parameter to reduce is the initial value. 
function sumAllEvenNumbers(numbersToSum) {
  return numbersToSum.reduce((runningSum, curValue) => {
    if (curValue % 2 === 0) {
      return runningSum + curValue;
    } else {
      return runningSum;
    }
  }, 0)
}



//create callback function for the reduce()call:
function sumLetters(previousValue, currentValue) {
  return previousValue + currentValue.length;
}
function countLetters(arrayOfWords) {
  return arrayOfWords.reduce(sumLetters, 0);
}



/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  return numbersToFilter.filter(value => {
    return value % 3 === 0;
  });
}
