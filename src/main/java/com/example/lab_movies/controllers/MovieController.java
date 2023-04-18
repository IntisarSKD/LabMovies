package com.example.lab_movies.controllers;

import com.example.lab_movies.models.Movie;
import com.example.lab_movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }













//    @Autowired
//    MovieService movieService;
//    @PostMapping
//    public ResponseEntity<Reply> newGame(){
//        Reply reply = movieService.watchNewMovie();
//        return new ResponseEntity<>(reply, HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Movie>> getAllMovies(){
//        List<Movie> games = movieService.getAllMovies();
//        return new ResponseEntity<>(games, HttpStatus.OK);
//    }
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Movie> getGameById(@PathVariable int id){
//        Optional<Movie> game = gameService.getMovieById(id);
//        if(game.isPresent()){
//            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }

}