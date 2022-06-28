/**
 * JS has a special way of coercing all different values to either true or false (boolean)
 * 
 * THere are only 6 falsey values and everything else are truthy
 * 
 * - NaN
 * - 0
 * - null
 * - undefined
 * - empty string
 * - false
 * 
 * !! -- checks for a variables truthy or falsey value
 */


function checkTruthy(input) {

    console.log(`
    
        input is ${input} and is of type ${typeof(input)}
        It has a truthy value of ${!!input}

    `);
}

let myName = ''; // empty string returns falsey
checkTruthy(myName);
checkTruthy(3 * 'bob'); // falsey (because it's NaN which is a falsey value)

checkTruthy([]); // truthy because it's not one of the falsey values