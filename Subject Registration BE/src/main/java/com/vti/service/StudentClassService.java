package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Clazz;
import com.vti.entity.Student;
import com.vti.entity.StudentClass;
import com.vti.form.StudentClassFormForCreating;
import com.vti.repository.IClazzRepository;
import com.vti.repository.IStudentClassRepository;
import com.vti.repository.IStudentRepository;

@Service
public class StudentClassService implements IStudentClassService {
	@Autowired
	private IStudentClassRepository studentClassRepository;

	@Autowired
	private IStudentRepository studentRepository;

	@Autowired
	private IClazzRepository clazzRepository;

	@Override
	public List<StudentClass> getListStudentClassByStudent(Student student) {
		return studentClassRepository.getByStudent(student);
	}

	@Override
	public List<StudentClass> getListStudentClass() {
		return studentClassRepository.findAll();
	}

	@Override
	public void createStudentClass(StudentClassFormForCreating studentClassFormForCreating) {
		short newStudentID = studentClassFormForCreating.getStudentID();
		short newClassID = studentClassFormForCreating.getClassID();

		StudentClass newStudentClass = new StudentClass();
		newStudentClass.setStudent(studentRepository.getByStudentID(newStudentID));
		newStudentClass.setClazz(clazzRepository.getByClassID(newClassID));

		studentClassRepository.save(newStudentClass);
	}

	@Override
	public void deleteByStudentClassID(short studentClassID) {
		// không viết được kiểu này???
		// studentClassRepository.deleteByStudentClassID(studentClassID);
		studentClassRepository.deleteById(studentClassID);
	}

	@Override
	public StudentClass getByStudentAndClazz(Student student, Clazz clazz) {
		return studentClassRepository.getByStudentAndClazz(student, clazz);
	}

}
