package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`Student`", catalog = "SubjectRegistration")

public class Student implements Serializable {
	public enum StudentStatus {
		NOT_ACTIVE, ACTIVE
	}

	@Column(name = "StudentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short studentID;

	@Column(name = "StudentName", length = 30, nullable = false)
	private String studentName;

	@Column(name = "StudentEmail", length = 30, nullable = false, unique = true)
	private String studentEmail;

	@Column(name = "StudentPassword", length = 200, nullable = false)
	private String studentPassword;

	@Column(name = "StudentStatus", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private StudentStatus studentStatus = StudentStatus.NOT_ACTIVE;

	// FK
	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	private List<StudentClass> listStudentClass;

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

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public List<StudentClass> getListStudentClass() {
		return listStudentClass;
	}

	public void setListStudentClass(List<StudentClass> listStudentClass) {
		this.listStudentClass = listStudentClass;
	}

	// constructor không tham số
	public Student() {
		super();
	}

}
