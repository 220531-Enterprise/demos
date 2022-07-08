var count = 5; // at intilaization the TS compiler determines the TYPE of the 
//count = 'apples'; // the compiler implicitly sets the type of the variable 

/** TS STatically types, we can't reassign a variable a a different type */

let x = 10; // we're  implicity setting the type of x to a number type

// decalre a variable 
let a: number; // explicityly setting the type of this variable to number
a = 100;
a = 90000;
// a = 'apples';

// intialization
let b: boolean = true;
let c: string = 'cat';
let d: any = 'dog';
d = 1000; // compiler allows for this because I set its type to any
let e: any[] = ['one', 1, false, {}];
let f: number[] = [1, 2, 3, 4, 5];

console.log(e[2]) // print out the 3rd element

let numString = "32"; // ``, '', ""
let numNum: number = +numString; // + operator converts it into the value of 32

// Enums are introduced
enum Color {'red', 'blue', 'green'};
let backgroundColor = Color.blue;
let num: string | number | boolean;  // composite type
num = 6;
num = 'six';

let y;
let something: any;






