package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RegistrationUserToken", catalog = "SubjectRegistration")

public class RegistrationUserToken implements Serializable {
	@Column(name = "RegistrationUserTokenID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short registrationUserTokenID;

	@Column(name = "Token", length = 36, nullable = false, unique = true)
	private String token;

	@OneToOne(targetEntity = Student.class)
	@JoinColumn(name = "StudentID")
	private Student student;

	@Column(name = "ExpiredDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiredDate;

	// getter, setter
	public short getRegistrationUserTokenID() {
		return registrationUserTokenID;
	}

	public void setRegistrationUserTokenID(short registrationUserTokenID) {
		this.registrationUserTokenID = registrationUserTokenID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	// constructor không tham số
	public RegistrationUserToken() {
		super();
	}

}
