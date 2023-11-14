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
@Table(name = "`TimeSlot`", catalog = "SubjectRegistration")

public class TimeSlot implements Serializable {
	public enum DayOfTheWeek {
		Monday, Tuesday, Wednesday, Thursday, Friday
	}

	@Column(name = "TimeSlotID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short timeSlotID;

	@Column(name = "DayOfTheWeek", nullable = false)
	@Enumerated(EnumType.STRING)
	private DayOfTheWeek dayOfTheWeek;

	@Column(name = "NumberOfPeriod", nullable = false)
	private short numberOfPeriod;

	@Column(name = "StartAtPeriod", nullable = false)
	private short startAtPeriod;

	@Column(name = "EndAtPeriod", nullable = false)
	private short endAtPeriod;

	// FK
	@OneToMany(mappedBy = "timeSlot", fetch = FetchType.EAGER)
	private List<Clazz> listClazz;

	// getter, setter
	public short getTimeSlotID() {
		return timeSlotID;
	}

	public void setTimeSlotID(short timeSlotID) {
		this.timeSlotID = timeSlotID;
	}

	public DayOfTheWeek getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
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

	public List<Clazz> getListClazz() {
		return listClazz;
	}

	public void setListClazz(List<Clazz> listClazz) {
		this.listClazz = listClazz;
	}

	// constructor không tham số
	public TimeSlot() {
		super();
	}

}
