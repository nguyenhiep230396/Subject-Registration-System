package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`Subjects`", catalog = "SubjectRegistration")

public class Subjects implements Serializable {
	@Column(name = "SubjectID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short subjectID;

	@Column(name = "SubjectName", length = 30, nullable = false, unique = true)
	private String subjectName;

	// FK
	@OneToMany(mappedBy = "subjects", fetch = FetchType.EAGER)
	private List<Clazz> listClazz;

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

	public List<Clazz> getListClazz() {
		return listClazz;
	}

	public void setListClazz(List<Clazz> listClazz) {
		this.listClazz = listClazz;
	}

	// constructor không tham số
	public Subjects() {
		super();
	}

	// toString
	@Override
	public String toString() {
		return "Subjects:\n" + "SubjectID: " + subjectID + "\n" + "SubjectName: " + subjectName + "\n";
	}

}
