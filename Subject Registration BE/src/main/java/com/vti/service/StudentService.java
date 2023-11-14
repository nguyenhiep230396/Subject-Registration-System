package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vti.entity.Student;
import com.vti.repository.IStudentRepository;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public UserDetails loadUserByUsername(String studentEmail) throws UsernameNotFoundException {
		Student studentLoginDB = studentRepository.findByStudentEmail(studentEmail);

		if (studentLoginDB == null) {
			throw new UsernameNotFoundException(studentEmail);
		} else {
			return new User(studentLoginDB.getStudentEmail(), studentLoginDB.getStudentPassword(),
					AuthorityUtils.createAuthorityList("User"));
		}
	}

	@Override
	public Student findStudentByStudentEmail(String studentEmail) {
		return studentRepository.findByStudentEmail(studentEmail);
	}

	@Override
	public Student getByStudentID(short studentID) {
		return studentRepository.getByStudentID(studentID);
	}

	@Override
	public Student getStudentByStudentEmail(String studentEmail) {
		return studentRepository.getByStudentEmail(studentEmail);
	}

}
