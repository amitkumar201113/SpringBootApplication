package com.example.model;

import java.util.Date;

public class Movie {

	private String movie_name;
	private Integer movie_ID;
	private Date released_date;
	private String leadActorName;
	private String leadActressName;
	private String userRating;
	
	
	public Integer getMovie_ID() {
		return movie_ID;
	}

	public void setMovie_ID(Integer movie_ID) {
		this.movie_ID = movie_ID;
	}

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public Date getReleased_date() {
		return released_date;
	}

	public void setReleased_date(Date released_date) {
		this.released_date = released_date;
	}

	public String getLeadActorName() {
		return leadActorName;
	}

	public void setLeadActorName(String leadActorName) {
		this.leadActorName = leadActorName;
	}

	public String getLeadActressName() {
		return leadActressName;
	}

	public void setLeadActressName(String leadActressName) {
		this.leadActressName = leadActressName;
	}

	public String getUserRating() {
		return userRating;
	}

	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}

}
