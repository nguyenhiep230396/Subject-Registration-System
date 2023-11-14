package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Short>, JpaSpecificationExecutor<Student> {
	public Student findByStudentEmail(String studentEmail);

	public Student getByStudentID(short studentID);

	public Student getByStudentEmail(String studentEmail);

}
