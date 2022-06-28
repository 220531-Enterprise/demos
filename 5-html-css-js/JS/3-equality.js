/**
 * = is an assignment operator (x = 9); 
 * 
 * == comparaes an object's VALUE on either side of the == and performs something called type coersion (2 == '2')
 * 
 * === compares both value AND TYPE
 */

// this will reutnr true or false
console.log(2 == '2'); // type coersion allows the == to JUST asserss for value (regardless of type)

console.log(2 === '2'); // no type coersion here... === assess both vlaue and type

// build a function that takes in 2 params and tests their equality for both == and ===

function compare(first, second) {

    // template literals were introduced in ES6 (EcmaScript 6 introduced in 2015)
    console.log(`
    
        first param = ${first}, and is of type ${typeof(first)}
        second param = ${second}, and is of type ${typeof(second)}
    
        Is first == second? : ${first == second}
        is first === second : ${first === second} 
    `);
}

compare(2, '2'); // true, false
compare('2', 'two'); // false false
compare({}, {}); // false, false - in JS, 2 empty objects do NOT have the same value
compare([], null); // false, false
compare(('bob' * 3), NaN); // false, false

console.log(typeof([]));

