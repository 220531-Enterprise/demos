/**
 * AJAX is the old way, Fetch API is the more modern 
 * approach to asynchronously making request to a server
 * 
 * Asynchronous JavaScript & XML 
 */

// grab all the elements from the page to work with
const pokeId = document.getElementById("poke-id");
const respId = document.getElementById("resp-id");
const pokeName = document.getElementById("resp-name");
const pokeImg = document.getElementById("resp-sprite");
const button = document.querySelector("button");

function ajaxCall() {


    // capture the input from the document
    let idNum = pokeId.value;

    // build XMLHttpRequestObject
    let xhr = new XMLHttpRequest();

    /**
     * 0. UNSENT: open() method has not been called
     * 1. OPENED: open() method has been called
     * 2. HEADERS_REQUEST: the send method has been called and the headers + status code 
     *      of the response from the server are ready
     * 3. LOADING: downloading the full response from the server
     * 4. DONE: entire operation is complete and we now have a complete response from the server
     */
    xhr.onreadystatechange = function() {

        // every time the"ready state" of this XHR object changes, this function fires.
        if (this.readyState == 4 && this.status == 200) {

            // the repsonseText property of the XMLHttpRequest object is fulfilled by the Serverw
           let respPokemon = JSON.parse(xhr.responseText); // transform the data returned returned to JSON
           console.log(respPokemon);

            renderPokemon(respPokemon);
        }
    }

    xhr.open('GET', `https://pokeapi.co/api/v2/pokemon/${idNum}`);

    xhr.send();
}

button.addEventListener('click', ajaxCall)



function renderPokemon(data) {
    // set all the elements that we captured above, EQUAL TO the
    // properties that we pull from the data
    pokeName.innerHTML = `Name: ${data.name}`;
    respId.innerHTML = `Id: ${data.id}`;
  
    pokeImg.setAttribute("src", data.sprites.front_default);
    pokeImg.setAttribute("height", 300);
  }