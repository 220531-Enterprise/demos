/**
 * the THIS keyword
 * 
 * In JavaScript, "this" refers to the object that's calling it (the obj that it belogns to)
 * 
 * - alone, it refers to the global object (in the browser thats Window, in 
 * Node that's the global object {})
 * 
 * - in a FUNCTION,this still refers to the global object
 * 
 * - in a METHOD this refers to the owner object of the method
 * 
 * - in STRICT MDOE "this" in a function returns undefined
 */

console.log(this); // reutns the global object in Node {}

// here I've added the global proerty dog on to the global object
this.dog = 'Spot';

console.log(this);

function foo() {

    console.log(this); // reutsn the global object
    // in strict mode this reutns undefined in a function

}
foo();


// obj literal 
const person = {

    firstName: 'Bob',
    lastName: 'Smith',
    id: 1234,
    sayFullName: function() {
        // within a METHOD, this refers to the properties of the object who defined the method
        return `${this.firstName} ${this.lastName}`;

    }

}

console.log(person.sayFullName());