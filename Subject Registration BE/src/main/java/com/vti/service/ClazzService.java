package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Clazz;
import com.vti.repository.IClazzRepository;

@Service
public class ClazzService implements IClazzService {
	@Autowired
	private IClazzRepository clazzRepository;

	@Override
	public List<Clazz> getListClazz() {
		return clazzRepository.findAll();
	}

	@Override
	public Clazz getByClassID(short classID) {
		return clazzRepository.getByClassID(classID);
	}

}
