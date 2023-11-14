package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Subjects;
import com.vti.repository.ISubjectsRepository;

@Service
public class SubjectsService implements ISubjectsService {
	@Autowired
	private ISubjectsRepository subjectsRepository;

	@Override
	public List<Subjects> getListSubjects() {
		// TODO Auto-generated method stub
		return subjectsRepository.findAll();
	}

}
