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

// opts represents info about a server
const getPosition = (opts) => {

    const promise = new Promise((resolve, reject) => {

        navigator.geolocation.getCurrentPosition(

            (success) => {
                // the callback function that's passed to the promise 
                // will determine what to do with the data returned
                resolve(success)
            },
            (error) => {
                reject(error)
            },
            opts
        );
    });
    return promise;
}

/**
 * The async & await keywords enable asynchronous, promise-based behavior to be
 * to be written in a cleaner style, avoiding promise chains
 */
async function buttonClickHandler() {

    // this will be invoked FIRST
    console.log('Getting position....')

    // we use await to WAIT for the fullfillment of the promise
    const posData = await getPosition();
    // const timerData = await setDelay(2000);

    console.log(posData);
}

button.addEventListener('click', buttonClickHandler)