package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.Application;
import com.example.model.Movie;
import com.example.service.MovieService;

@RestController
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	MovieService movieService;
	
	public MovieController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/movie")
	public Movie welcome(){
		return movieService.getMovieById(1);
		
	}
	
	
	@RequestMapping("/movies/")
	public List<Movie> allMovies(){
		logger.info("in list movies service");
		return movieService.getMovieByAllMovies();
		
	}
	
	@RequestMapping(value = "/movies/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody Movie movie, UriComponentsBuilder ucBuilder) {
        //logger.info("Creating User : {}", user);
 
       
		Boolean flag=movieService.saveMovie(movie);
		HttpHeaders headers = new HttpHeaders();
        if(flag){
        	 return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        }else{
        	 return new ResponseEntity<String>(headers, HttpStatus.METHOD_FAILURE);
        }

       
    }
	
	
	@RequestMapping(value = "/movies/{movie_ID}", method = RequestMethod.PUT)
    public ResponseEntity<?> createUser(@PathVariable("movie_ID") Integer movie_ID,@RequestBody Movie movie, UriComponentsBuilder ucBuilder) {
        //logger.info("Creating User : {}", user);
 
		movie.setMovie_ID(movie_ID);
		Boolean flag=movieService.updateMovie(movie);
		HttpHeaders headers = new HttpHeaders();
        if(flag){
        	 return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        }else{
        	 return new ResponseEntity<String>(headers, HttpStatus.METHOD_FAILURE);
        }

       
    }
	
	
}
