const button = document.querySelector('button');

// when we click the button, print the 
// location of the user

function buttonClickHandler() {


    navigator.geolocation.getCurrentPosition(

        // success callback (if everything goes smoothly)
        posData => { // posData represents the data that's successfully returned
            // callback within a callback
            setTimeout(() => {
                console.log(posData)
            }, 2000)
        },

        // error represents the error data of what we got back
        error => {
            console.log(error)
        }
    );

    // this will be invoked FIRST
    console.log('Getting position....')

}

button.addEventListener('click', buttonClickHandler)