package com.movieapp.pojos;

import java.sql.Timestamp;
import java.util.Date;

public class Review {
	
	private int id; 
	private int movie_id;
	private String review;
	private int rating;
	private int user_id;
	private Date modified;
	
	public Review() {

	}
	
	public Review(int id, int movie_id, String review, int rating, int user_id, Timestamp modified) {
		super();
		this.id = id;
		this.movie_id = movie_id;
		this.review = review;
		this.rating = rating;
		this.user_id = user_id;
		this.modified = modified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date date) {
		this.modified = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [id=").append(id).append(", movie_id=").append(movie_id).append(", review=")
				.append(review).append(", rating=").append(rating).append(", user_id=").append(user_id)
				.append(", modified=").append(modified).append("]");
		return builder.toString();
	}
	
}
