package com.vti.service;

import java.util.List;

import com.vti.entity.Clazz;
import com.vti.entity.Student;
import com.vti.entity.StudentClass;
import com.vti.form.StudentClassFormForCreating;

public interface IStudentClassService {
	public List<StudentClass> getListStudentClassByStudent(Student student);

	public List<StudentClass> getListStudentClass();

	public void createStudentClass(StudentClassFormForCreating studentClassFormForCreating);

	public void deleteByStudentClassID(short studentClassID);

	public StudentClass getByStudentAndClazz(Student student, Clazz clazz);
}
