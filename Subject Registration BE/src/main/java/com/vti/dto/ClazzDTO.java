package com.vti.dto;

public class ClazzDTO {
	private short classID;
	private String subjectName;
	private String dayOfTheWeek;
	private short numberOfPeriod;
	private short startAtPeriod;
	private short endAtPeriod;

	// getter, setter
	public short getClassID() {
		return classID;
	}

	public void setClassID(short classID) {
		this.classID = classID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	public short getNumberOfPeriod() {
		return numberOfPeriod;
	}

	public void setNumberOfPeriod(short numberOfPeriod) {
		this.numberOfPeriod = numberOfPeriod;
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
	public ClazzDTO() {
		super();
	}

}
