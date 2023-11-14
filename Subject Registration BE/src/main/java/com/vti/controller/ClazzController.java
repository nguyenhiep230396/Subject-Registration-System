package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.ClazzDTO;
import com.vti.entity.Clazz;
import com.vti.service.IClazzService;

@RestController
@RequestMapping(value = "api/v1/clazzs")
@CrossOrigin("*")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;

	@GetMapping()
	public ResponseEntity<?> getListClazz() {
		List<Clazz> listClazz_DB = clazzService.getListClazz();

//		Page<ClazzDTO> pageClazz_DTO = pageClazz_DB.map(new Function<Clazz, ClazzDTO>() {
//			@Override
//			public ClazzDTO apply(Clazz clazz) {
//				ClazzDTO clazzDTO = new ClazzDTO();
//				clazzDTO.setClassID(clazz.getClassID());
//				clazzDTO.setSubjectName(clazz.getSubjects().getSubjectName());
//				clazzDTO.setDayOfTheWeek(clazz.getTimeSlot().getDayOfTheWeek().toString());
//				clazzDTO.setNumberOfPeriod(clazz.getTimeSlot().getNumberOfPeriod());
//				clazzDTO.setStartAtPeriod(clazz.getTimeSlot().getStartAtPeriod());
//				clazzDTO.setEndAtPeriod(clazz.getTimeSlot().getEndAtPeriod());
//				return clazzDTO;
//			}
//		});

		List<ClazzDTO> listClazzDTO = new ArrayList<ClazzDTO>();
		for (Clazz clazz : listClazz_DB) {
			ClazzDTO clazzDTO = new ClazzDTO();
			clazzDTO.setClassID(clazz.getClassID());
			clazzDTO.setSubjectName(clazz.getSubjects().getSubjectName());
			clazzDTO.setDayOfTheWeek(clazz.getTimeSlot().getDayOfTheWeek().toString());
			clazzDTO.setNumberOfPeriod(clazz.getTimeSlot().getNumberOfPeriod());
			clazzDTO.setStartAtPeriod(clazz.getTimeSlot().getStartAtPeriod());
			clazzDTO.setEndAtPeriod(clazz.getTimeSlot().getEndAtPeriod());

			listClazzDTO.add(clazzDTO);
		}

		return new ResponseEntity<>(listClazzDTO, HttpStatus.OK);
	}
}
