const addMovieModal = document.getElementById('add-modal'); 
const startAddMovieButton = document.querySelector('header button'); 
const backdrop = document.getElementById('backdrop');
const cancelAddMovieButton = addMovieModal.querySelector('.btn--passive')
const confirmAddMovieButton = cancelAddMovieButton.nextElementSibling;
const userInputs = addMovieModal.querySelectorAll('input');
const entryTextSection = document.getElementById('entry-text');

const movies = []; 

const updateUI = () => {
    if (movies.length === 0) {
        entryTextSection.style.display = 'block';
      } else {
        entryTextSection.style.display = 'none';
      }
}

const renderNewMovieElement = (id, title, imageUrl, rating) => {
    const newMovieElement = document.createElement('li');
    newMovieElement.className = 'movie-element';
    newMovieElement.innerHTML = `
      <div class="movie-element__image">
        <img src="${imageUrl}" alt="${title}">
      </div>
      <div class="movie-element__info">
        <h2>${title}</h2>
        <p>${rating}/5 stars</p>
      </div>
    `;
    const listRoot = document.getElementById('movie-list');
    listRoot.append(newMovieElement); 
}

const toggleBackdropHandler = () => {
    backdrop.classList.toggle('visible');
}

const cancelAddMovieHandler = () => {
    toggleMovieModal();
     clearMovieInput(); 
}


const clearMovieInput = () => {
    for (const usrInput of userInputs) {    
        usrInput.value = ''; 
    }
};

const confirmAddMovieHandler = () => {
    const titleValue = userInputs[0].value; 
    const imageUrlValue = userInputs[1].value; 
    const ratingValue = userInputs[2].value;

    if (
        titleValue.trim() === '' || 
        imageUrlValue.trim() === '' || 
        ratingValue.trim() == '' || 
        +ratingValue < 1 || 
        +ratingValue > 5 
        ) {
        alert('Please enter valid values (rating must be between 1 and 5)')
        return;
    }

    const newMovie = {
        title: titleValue,
        image: imageUrlValue,
        rating: ratingValue
    };
    
    console.log(`Posting the new movie object to the server`)
    sendMovieToServer(newMovie);

    movies.push(newMovie);
    console.log(movies);
    
    toggleMovieModal(); 
    clearMovieInput();
    renderNewMovieElement(newMovie.id, newMovie.title, newMovie.image, newMovie.rating)
    updateUI(); 
    
};

const sendMovieToServer = (newMovie) => {

    console.log('sendMovieToServer invoked')

    fetch(`http://localhost:8080/movie-app/addmovie`, {

        method: "POST",
  
        body: JSON.stringify({
          title: newMovie.title,
          imageUrl: newMovie.image,
          rating: newMovie.rating
        }),
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
      })
        .then((response) => response.json())
        .then((json) => console.log(json));
}

const toggleMovieModal = () => {
    // toggle the addMovieModal's class and change it to 'visible' with classList.toggle();
    // Example: https://www.w3schools.com/jsref/prop_element_classlist.asp
    addMovieModal.classList.toggle('visible');
    toggleBackdropHandler();
}

function getMovies() {
  fetch("http://localhost:8080/movie-app/getmovies", {
    method: "POST",
    redirect: "follow",
    credentials: "include",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      userId: sessionStorage.getItem("currentUser"), // this returns the ID we saved in the session earlier
    }),
  })
    .then(function (response) {
      if (!response.ok) {
        throw Error("ERROR");
      }
      return response.json();
    })
    .then(function (data) {
      console.log(data);

      data.forEach((obj) => {
        let newMovie = {
          title: obj.title,
          image: obj.imageUrl,
          rating: obj.rating,
        };
        console.log(newMovie);
        movies.push(newMovie);
        renderNewMovieElement(newMovie.id, newMovie.title, newMovie.image, newMovie.rating)
        updateUI(); 
      });
    })
    .catch((error) => {
      console.log(error);
      //  window.location.href = 'http://localhost:8080/project-1/resources/html/error.html'
    });
}

startAddMovieButton.addEventListener('click', toggleMovieModal);
backdrop.addEventListener('click', toggleMovieModal);
cancelAddMovieButton.addEventListener('click', cancelAddMovieHandler);
confirmAddMovieButton.addEventListener('click', confirmAddMovieHandler);


getMovies();