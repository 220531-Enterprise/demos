// when index.html page loads

// grab user's id from the session

// fetch all the movie objects from the movies table associates
// with the user's ID that's in the session

// push the movie objects to the movies[]
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
      });

      updateUI();
    })
    .catch((error) => {
      console.log(error);
      //  window.location.href = 'http://localhost:8080/project-1/resources/html/error.html'
    });
}

export { getMovies };
