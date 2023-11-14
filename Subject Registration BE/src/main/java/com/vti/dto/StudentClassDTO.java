package com.vti.dto;

public class StudentClassDTO {
	private short studentClassID;
	private short studentID;
	private short classID;
	private String subjectName;
	private String dayOfTheWeek;
	private short numberOfPeriod;
	private short startAtPeriod;
	private short endAtPeriod;

	// getter, setter
	public short getStudentClassID() {
		return studentClassID;
	}

	public void setStudentClassID(short studentClassID) {
		this.studentClassID = studentClassID;
	}

	public short getStudentID() {
		return studentID;
	}

	public void setStudentID(short studentID) {
		this.studentID = studentID;
	}

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
	public StudentClassDTO() {
		super();
	}

}
