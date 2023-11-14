package com.vti.dto;

public class SubjectsDTO {
	private short subjectID;
	private String subjectName;

	// getter, setter
	public short getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(short subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	// constructor không tham số
	public SubjectsDTO() {
		super();
	}

}
