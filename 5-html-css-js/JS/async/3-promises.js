const button = document.querySelector('button');

// this reutnrs a promise!!!!
const setDelay = (duration) => {
    // a promise an object in which we can specify what to do when a
    // value is returned (or not) at a certain time
    const promise = new Promise((resolve, reject) => {

        setTimeout(() => {
            resolve('Done');
        }, duration);
    });

    return promise;
}

function buttonClickHandler() {


    navigator.geolocation.getCurrentPosition(

        // success callback (if everything goes smoothly)
        posData => { // posData represents the data that's successfully returned
            // callback within a callback
            setDelay(2000)
                .then(data => {
                    console.log(data, posData)
                })
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