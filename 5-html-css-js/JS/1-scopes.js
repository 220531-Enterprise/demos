/**
 * 4 Main Scopes in JS
 *
 * 1. Global - variables declared are accesible from ANYWHERE in the application
 * 2. Functional/Local - variables declared within the function are ONLY accessible within the function
 * 3. Block Scope - anything in between {} (think of a for-loop)
 * 4. Lexical Scope - when you nest functions within eachother with a process called CLOSURE
 */

// this is why ES6 introuced var 
var greeter = 'hey hi';
// variables declared with VAR outside of a function are GLOBALLY SCOPED

// classic function declartion
function newFunction() {
    // any variable intialized within a function is restricted to the functional scope
    var hello =  'hello';
}

// console.log(hello); // this will return an error that hello is not defined 
// (because I'm trying to access a variable from the GLOBAL scope  that's decalred & intialized at the functional scope)

var times = 4;

// this is a BLCOK SCOPE (anything in {})
// VAR is NOT block scoped
if (times > 3) {
    var greeter = 'say hello instead'
    // we shouldn't be able to access this because it's in a block scope
}

console.log(greeter); // this returns the value of 'greeter' in the if statement

// Let and const were introduced to allow block scoping of variables

let greeting = 'say Hi';

if (times > 3) {
    // block scoping prohibits access to the variable outside the block {}
 let hello = 'say hello instead'
    // we shouldn't be able to access this because it's in a block scope
}

// console.log(hello); hello is not defined!

// if you declare a variable with let or const OUTSIDE of a function, those too, become globally scoped
let someGlobalGreeting = 'Welcome';
const somePermanentGreeting = 'Welcome forever'; // we can never reassign the value of this

function funScope() {

    console.log(someGlobalGreeting);

    let x = 'xylophone';

    if (true) {
        console.log(x);
        let z = 'zebra';

        if (true) {
            // you can always retrieve block scoped variables from outside
            console.log(z);
        }
    }
}

funScope();

// this points to the global object (which is the Window in the browser and the general global object in node)
console.log(this);