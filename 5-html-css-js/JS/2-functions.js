// 4 ways to declare functions in JS


// 1. Classic Function declaration
function divide(x, y) {
    return x/y;
}

// invoke the function normally:
let num1 = 10;
let num2 = 2;

// assigning the variable quotient to the return value of the function
let quotient = divide(num1, num2);

// print it out to the console
console.log(quotient);

console.log(divide('apple', 4)); // dividing a string by a number.....
// NaN itself is a number...but it means that what you returned is Not A Number

// 2. Function Expression - assign an anonymous function to a variable
const divide2 = function (x, y) {
    return x/y;
}

let n1 = 20;
let n2 = 40;

// if it IS a number, go ahead and return
if (!isNaN(divide2(n1, n2))) {
/*if (n1 > 0 && !isNaN(n1) && n2 > 0 && !isNaN(n2)) { */
    console.log(divide2(n1, n2))
} else {
    console.warn('Pass through a valid number');
}


// 3. Arrow Function Expression (introduced in ES6 - the 2015 version of JavaScript)
const divide3 = (x, y) => {
    return x/y;
}


// 4. Concise Arrow Function Expression (using arrow function introduced in ES6)
const divide4 = (x, y) => x /y; // no "return" keyword needed