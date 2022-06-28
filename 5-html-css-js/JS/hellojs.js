console.log('Hello World!');

/**
 * PRIMITIVE DATATYPES
 * (data that's not an object and doesn't have properties or methods)
 * 
 * - boolean
 * - number
 * - string
 * - null
 * - undefined
 * - bigint
 * - symbol
 * 
 * REFERENCE DATATYPES
 * - objects
 * - arrays
 * - functions (it's an object)
 */

// this is a single line comment

// How do we declare & initialize a variable in JS?
var num = 5; // the dataype is automatically inferred upon initialization

console.log(typeof(num)); // typof is a special operator that will tell us the type of a variable
// up UNTIL 2015 all variables were declared with var
// that changed in 2015 with the advent of let & const

let fruit = 'apple';
let vegetable = "pumpkin";

// unles you're in STRICT mode you can decalre variables without a declariation keyword 

x = 'tiger'; // this is as if you declared with with var

let y; // this is declartion 

console.log(y); // -- returns undefined

y = 'elephant'; // intitialization assigns value
console.log(y); // return elephant

// the difference between let and const
// they are both BLOCK SCOPED (which var lacks)
// let can be reassigned, const cannot

let b = true;
b = 'one billion';
b = 1;
console.log(b);

const myName = 'Sophia';
// myName = 'Sofia'; // you can't do this!!!!
console.log(myName);
