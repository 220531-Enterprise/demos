function doSomething() {

    for (let i=0; i<5; i++) {

        console.log(i);
    }

    console.log(i); // TS compiler alerts me that this is unreachable code
}

doSomething();