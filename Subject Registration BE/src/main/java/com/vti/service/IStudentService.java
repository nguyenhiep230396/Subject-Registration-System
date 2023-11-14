package com.vti.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Student;

public interface IStudentService extends UserDetailsService {
	public Student findStudentByStudentEmail(String studentEmail);

	public Student getByStudentID(short studentID);

	public Student getStudentByStudentEmail(String studentEmail);
}
