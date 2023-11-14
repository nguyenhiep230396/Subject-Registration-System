package com.vti.dto;

public class StudentClassDTO_Ver3 {
	private String dayOfTheWeek;
	private short startAtPeriod;
	private short endAtPeriod;

	// getter setter
	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	public short getStartAtPeriod() {
		return startAtPeriod;
	}

	public void setStartAtPeriod(short startAtPeriod) {
		this.startAtPeriod = startAtPeriod;
	}

	public short getEndAtPeriod() {
		return endAtPeriod;
	}

	public void setEndAtPeriod(short endAtPeriod) {
		this.endAtPeriod = endAtPeriod;
	}

	// constructor không tham số
	public StudentClassDTO_Ver3() {
		super();
	}

}
