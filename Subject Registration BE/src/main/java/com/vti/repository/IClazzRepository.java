package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Clazz;

public interface IClazzRepository extends JpaRepository<Clazz, Short>, JpaSpecificationExecutor<Clazz> {
	public Clazz getByClassID(short classID);
}
