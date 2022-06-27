// Goal: When we click the button, capture the input from the form fiels and add it to the table body
console.log('app.js is working'); // proving that when the html doc is loaded, the javascript is also executed

// 1. Capture the button element from the page
let button = document.getElementById('add-student');

// 2. add an Event listener so that when the button is clicked, it invokes a function (callback) 
// - a function passed as a param to another function
button.addEventListener('click', addStudent);

// 3.  Define the function that captures the input from the form and populates the table
function addStudent() {

    console.log('button was clicked, function invoked')

    // 1. Grab the input from the student name & major fields
    let nameField = document.getElementById('student-name').value;
    let majorField = document.getElementById('student-major').value;

    // 2. Check that they're truthy (NOT EMPTY)
    if (nameField && majorField) {

    // 3. If they are truthy (not empty) create a row element
       let row = document.createElement('tr'); // 'tr' means <tr>
       // a NODE is a DOM element in the form of a JS object

        // 4. Create a table cell element for ID
        let idCell = document.createElement('td');

        // 5. Create a table cell element for name
        let nameCell = document.createElement('td')

        // 6. Create a table cell element for major
        let majorCell = document.createElement('td')

        // 7. append the cells to the newly created row
        row.appendChild(idCell);
        row.appendChild(nameCell);
        row.appendChild(majorCell);

        // 8. append the row to the table
        document.getElementById('student-table-body').appendChild(row);

        // 9. set the inner text of each cell == to the info we captured 
        idCell.innerText = idGenerator().next().value;
        nameCell.innerText = nameField;
        majorCell.innerText = majorField;

        // 10. set the input fields to '' very time we click the button
        document.getElementById('student-name').value = '';
        document.getElementById('student-major').value = '';
    }
}

// Shout out to Kyle it is supposed to be 1 because its post incrementation
let counter = 1;
// 3.a Build a GENERATOR function to produce a serial value that will be the auto-generated ID for each student (new feature to ES6)
function* idGenerator() {
    yield counter++;  // the progress is stopped every time it's called
    // it increases once and yields a value each time its invoked
}



