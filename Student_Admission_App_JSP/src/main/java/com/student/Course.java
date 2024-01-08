package com.student;

public enum Course {
	DAC (80), DBDA(70), DMC(50), DITISS(60), DESD(50);
	
	private int minMarks;
	
	private Course(int minMarks)
	{
		this.minMarks=minMarks;
	}

	public int getMinMarks() {
		return minMarks;
	}	
}
