package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "`Class`", catalog = "SubjectRegistration", uniqueConstraints = @UniqueConstraint(columnNames = {
		"SubjectID", "TimeSlotID" }))

public class Clazz implements Serializable {
	@Column(name = "ClassID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short classID;

	// FK
	@ManyToOne
	@JoinColumn(name = "SubjectID", nullable = false)
	private Subjects subjects;

	// FK
	@ManyToOne
	@JoinColumn(name = "TimeSlotID", nullable = false)
	private TimeSlot timeSlot;

	// FK
	@OneToMany(mappedBy = "clazz", fetch = FetchType.EAGER)
	private List<StudentClass> listStudentClass;

	// getter, setter
	public short getClassID() {
		return classID;
	}

	public void setClassID(short classID) {
		this.classID = classID;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	public List<StudentClass> getListStudentClass() {
		return listStudentClass;
	}

	public void setListStudentClass(List<StudentClass> listStudentClass) {
		this.listStudentClass = listStudentClass;
	}

	// constructor không tham số
	public Clazz() {
		super();
	}

}
