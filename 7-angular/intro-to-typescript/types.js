var count = 5; // at intilaization the TS compiler determines the TYPE of the 
//count = 'apples'; // the compiler implicitly sets the type of the variable 
/** TS STatically types, we can't reassign a variable a a different type */
var x = 10; // we're  implicity setting the type of x to a number type
// decalre a variable 
var a; // explicityly setting the type of this variable to number
a = 100;
a = 90000;
// a = 'apples';
// intialization
var b = true;
var c = 'cat';
var d = 'dog';
d = 1000; // compiler allows for this because I set its type to any
var e = ['one', 1, false, {}];
var f = [1, 2, 3, 4, 5];
console.log(e[2]); // print out the 3rd element
var numString = "32"; // ``, '', ""
var numNum = +numString; // + operator converts it into the value of 32
// Enums are introduced
var Color;
(function (Color) {
    Color[Color["red"] = 0] = "red";
    Color[Color["blue"] = 1] = "blue";
    Color[Color["green"] = 2] = "green";
})(Color || (Color = {}));
;
var backgroundColor = Color.blue;
