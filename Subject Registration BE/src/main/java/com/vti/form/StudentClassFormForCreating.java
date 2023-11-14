package com.vti.form;

public class StudentClassFormForCreating {
	private short studentID;
	private short classID;

	// getter, setter
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

	// constructor không tham số
	public StudentClassFormForCreating() {
		super();
	}

}
