package com.vti.service;

import java.util.List;

import com.vti.entity.Clazz;

public interface IClazzService {
//	public Page<Clazz> getListClazz(Pageable pageable);
	public List<Clazz> getListClazz();

	public Clazz getByClassID(short classID);
}
