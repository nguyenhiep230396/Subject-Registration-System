package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Subjects;

public interface ISubjectsRepository extends JpaRepository<Subjects, Short>, JpaSpecificationExecutor<Subjects> {
}
