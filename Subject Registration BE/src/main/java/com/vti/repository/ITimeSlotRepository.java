package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.TimeSlot;

public interface ITimeSlotRepository extends JpaRepository<TimeSlot, Short>, JpaSpecificationExecutor<TimeSlot> {

}
