package com.student;

public class Student {
	String firstName;
	String lastName;
	int testScore;
	boolean admissionStatus;
	private Course selectedCourse;
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, int testScore, boolean admissionStatus, Course selectedCourse) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.testScore = testScore;
		this.admissionStatus = admissionStatus;
		this.selectedCourse = selectedCourse;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTestScore() {
		return testScore;
	}

	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}

	public boolean isAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(boolean admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public Course getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [firstName=").append(firstName).append(", lastName=").append(lastName)
				.append(", testScore=").append(testScore).append(", admissionStatus=").append(admissionStatus)
				.append(", selectedCourse=").append(selectedCourse).append("]");
		return builder.toString();
	}
	
	
}
