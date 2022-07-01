// BEFORE ES6
function Computer(compName, ramSizegb, cpuCores, cpuSpeedGhz) {

    this.compName = compName;
    this.ramSizegb = ramSizegb;
    this.cpuCores = cpuCores;
    this.cpuSpeedGhz = cpuSpeedGhz;

    this.printSpecs = function() {
        console.log('This computer is named ' + this.compName + '. It has ' + ramSizegb + 'GB of ram');
    }
}

// new keyword builds an empty object and fills out the properties according to the function
let myComputer = new Computer('Acer5000', 4, 4, 4.2);
myComputer.printSpecs();


// in ES6 classes were introduced
class Animal {

    constructor(name, species) {
        this.name = name; 
        this.species = species;
    }

    dance() {
        console.log(`${this.name} can dance`)
    }

    sing() {
        console.log(`${this.name} can sing`)
    }
}

let bingo = new Animal('Bingo', 'Dog');
bingo.dance();