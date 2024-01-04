package com.movieapp.pojos;

import java.util.Date;

public class User {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String mobile;
	private Date birth;
	private String password;
	
	public User() {

	}

	public User(int id, String first_name, String last_name, String email, String mobile, Date birth, String password) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.mobile = mobile;
		this.birth = birth;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", first_name=").append(first_name).append(", last_name=")
				.append(last_name).append(", email=").append(email).append(", mobile=").append(mobile)
				.append(", birth=").append(birth).append(", password=").append(password).append("]");
		return builder.toString();
	}
	
}