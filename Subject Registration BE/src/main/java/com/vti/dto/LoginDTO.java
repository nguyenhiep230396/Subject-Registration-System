package com.vti.dto;

public class LoginDTO {
	private short studentID;
	private String studentName;

	// getter, setter
	public short getStudentID() {
		return studentID;
	}

	public void setStudentID(short studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	// construtor không tham số
	public LoginDTO() {
		super();
	}

}
