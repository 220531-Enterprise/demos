document.addEventListener('DOMContentLoaded', () => {
    document
        .getElementById('login-btn')
        .addEventListener('click', signin);
});

const signin = (ev) => {
    ev.preventDefault(); //stop the page reloading

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    console.log(username);
    console.log(password);
    
    fetch('http://localhost:8080/movie-app/login', {
        method: 'POST',
        // redirect: 'follow',
        // credentials: 'include',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    }).then(function (response) {

        if(!response.ok){
            throw Error("ERROR")
        }

        let childDiv= document.getElementById("warningText")
        childDiv.innerHTML =`<p style="color:red;"><b>Failed to sign in!</b> <br> <b>Username or Password is incorrect</b></p>`;

        return response.json(); 

    }).then(function (data) {

        console.log(data)
        console.log(data.status)

        if (data.id > 0) {
            console.log('Success!!!')
            sessionStorage.setItem('currentUser', data.id);
            // sessionStorage.setItem('userRole', data.role.role);
            window.location.href = 'http://localhost:8080/movie-app/index.html'
        } else if (data.status == 'process failed') {
            console.log("login failed");
            let childDiv= document.getElementById("warningText")
            childDiv.innerHTML =`<p style="color:red;"><b>Failed to sign in!</b> <br> <b>Username or Password is incorrect</b></p>`;
        }

    }).catch(error => {
        console.log(error);
        // warning message later...
        let childDiv= document.getElementById("warningText")
        childDiv.innerHTML =`<p style="color:red;"><b>Failed to sign in!</b> <br> <b>Username or Password is incorrect</b></p>`;
    })

}