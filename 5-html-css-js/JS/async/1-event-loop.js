function task(message) {

    // emulating some time consuming task
    let n = 100000000;

    while (n >0) {
        n--;
    }

    // when complete, print the message passed thru
    console.log(message)
}

console.log('Start script!')
task('download complete')
console.log('Script done!')

console.log('Start script!');

setTimeout(() => {

    task('download complete')

}, 6000);

// wait 2000 miliseconds before invoking that function

console.log('Script done!');

console.log('Hi');

// The Event loop identifies this as a callback and 
// now by DEFAULT, we MUST wait until the call stack
// is empty for this to run
setTimeout(() => {

    console.log('Execute immediately')

}, 2000);

setTimeout(() => {
    
    console.log('hey whatsup')

}, 0)

console.log('Bye')

let button = document.querySelector('button');
button.addEventListener('click', () => {

    task('some message')

});
