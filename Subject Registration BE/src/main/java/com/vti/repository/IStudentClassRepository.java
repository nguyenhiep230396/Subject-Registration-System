package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Clazz;
import com.vti.entity.Student;
import com.vti.entity.StudentClass;

public interface IStudentClassRepository
		extends JpaRepository<StudentClass, Short>, JpaSpecificationExecutor<StudentClass> {
	public List<StudentClass> getByStudent(Student student);

	public void deleteByStudentClassID(short studentClassID);

	public StudentClass getByStudentAndClazz(Student student, Clazz clazz);
}
