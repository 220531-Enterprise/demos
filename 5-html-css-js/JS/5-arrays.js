let scores = new Array(10); // we're instantiating an array obj 
                            // by calling on the Array constructor in JS

console.log(scores);

// array literal (simple readbale, and fast)
let colors = ['red', 'blue', 'green'];

// access elements within the aray 
console.log(colors[1]);
// reassign the value of the element at a certain index
colors[1] = 'purple';
console.log(colors[1]);

let size = colors.length; // grabs the number of elements in an array

// JS arrrays are dynamic, meaning they expand is size and contract whenever we need them to
colors.push('yellow');
console.log(colors);

// remove with .pop() (from the end)
colors.pop(); // returns the element removed

// rmeove the first element with .shift()
colors.indexOf('purple'); // returns index # or -1 if the element isn't present 

// declare some variables
let a = 'ten';
let b = 10;
let c = true; 
let d = {};
let e = null;
let f = '';
let g = 0;
let h = [];
let i = function(){}; // assigining i to an anonymous function 

// build an array called lsit and add all the variables to it
let list = [a, b, c, d, e, f, g, h, i];

// iterate over it in 3 ways

// 1. Basic for loop 
// becuase i is a global vairbale, and the iterator in this loop would not be confide to 
// block scope yet, we can't use i here
for (let j =  0; j<list.length; j++) {
    // PRINT THE ELEMENT AT THE INDEX OF J
    console.log(list[j]);
}

// 2. For-in loop (TARGETS INDEX)
// reutnrs the index of each element in the list
for (let elIndex in list) { // (think of this as a simplified for loop)
    console.log(list[elIndex]);
}

// 3. For-of loop  (TARGETS ELEMENT DIRECTLY)
// similar to an enhanced for loop in Java in which we don't need the index at all
// returns THE ELEMENT ITSELF
for (let el of list) {
    console.log(el); // we don't need to access the element by its index
}

console.log('--------------------------------')

list.forEach(e => console.log(e));
list.forEach(printItOut) // we don't need to pass the parameter (that's inferred)

function printItOut(input) {

   console.log(`The input is ${input}`)

}

function returnAndPrint(input) {
    return (`The input is ${input}`);
}

let descriptions = list.map(returnAndPrint)
console.log(descriptions);

// return an array with the result
let nums = [1, 2, 3, 4, 5, 6, 7, 8];

// square each number and return a list of all the values produced
let squares = nums.map(n => n*n); // (forEach + return something)
console.log(squares);





