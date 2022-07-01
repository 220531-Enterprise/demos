/**
 * JavaScript Execution context
 * 
 * Everytime JS engine executes a scri[t, an Execution Context is build
 * 
 * Phase 1: Creation
 * Phase 2: Execution
 * 
 * Creation Phase (STEP 1) 
 * 1. Create the global object (Window in browser, global obj in Node)
 * 
 * 2. bind "this" to the global object
 * 
 * 3. setup the memory heap fro storing variable and function references
 * 
 * 4. stored function declarations and reference variables are stored with
 * the assigned value of undefined.
 * 
 * PHASE 2 (EXECUTION PHASE) 
 * JS engine  executes the code line by l,ine 
 * In this phase it assigns values to variables and executes function calls
 * 
 *  During the execution phase, variable hoisting occurs
 */

console.log(a); // returns undefined

// this is a hoisted variable in that its value is undefined
// which is assigned during the creation phase
var a = "apple";

// variables declared with let & const are 
// NOT hoisted meaning that they're not declared during
// creation phase

console.log(add(5, 6));

console.log(subtract(10, 9));

// this is NOT HOISTED -- will throw an error if invoked before it's
// declared; 
const subtract = (x, y) => {

    return x - y;
}

// functions decalred like thids are HOISTED 
function add(x, y) {
    return x + y;
}