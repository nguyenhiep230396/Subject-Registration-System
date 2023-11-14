package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "`StudentClass`", catalog = "SubjectRegistration", uniqueConstraints = @UniqueConstraint(columnNames = {
		"StudentID", "ClassID" }))

public class StudentClass implements Serializable {
	@Column(name = "StudentClassID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short studentClassID;

	@ManyToOne
	@JoinColumn(name = "StudentID")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "ClassID")
	private Clazz clazz;

	// getter, setter
	public short getStudentClassID() {
		return studentClassID;
	}

	public void setStudentClassID(short studentClassID) {
		this.studentClassID = studentClassID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	// constructor không tham số
	public StudentClass() {
		super();
	}

}
