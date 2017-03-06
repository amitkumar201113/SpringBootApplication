package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MovieDao;
import com.example.model.Movie;

@Service
public class MovieService {
	@Autowired
	MovieDao movieDao;

	public MovieService() {
		// TODO Auto-generated constructor stub
	}

	public String printMessage(){
		return "Welcome to Spring Boot";
	}
	
	 public Movie getMovieById(Integer id) {
		return  movieDao.getMovieById(1);
	 }
	 
	 public List<Movie> getMovieByAllMovies() {
			return  movieDao.getMovieByAllMovies();
		 }
	 
	 public Boolean saveMovie(Movie movie) {
			return  movieDao.saveMovie(movie);
		 }
	 

	 public Boolean updateMovie(Movie movie) {
			return  movieDao.updateMovie(movie);
		 }
}
