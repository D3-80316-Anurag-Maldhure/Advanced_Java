package com.movieapp.pojos;

import java.util.Date;

public class Movie {
	private int id;
	private String title;
	private Date rel_date;
	
	public Movie() {
	}

	public Movie(int id, String title, Date rel_date) {
		super();
		this.id = id;
		this.title = title;
		this.rel_date = rel_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRel_date() {
		return rel_date;
	}

	public void setRel_date(Date rel_date) {
		this.rel_date = rel_date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [id=").append(id).append(", title=").append(title).append(", rel_date=").append(rel_date)
				.append("]");
		return builder.toString();
	}
	
}
