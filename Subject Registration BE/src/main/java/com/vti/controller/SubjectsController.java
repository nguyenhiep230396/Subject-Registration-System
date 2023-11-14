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

import com.vti.dto.SubjectsDTO;
import com.vti.entity.Subjects;
import com.vti.service.ISubjectsService;

@RestController
@RequestMapping(value = "api/v1/subjectss")
@CrossOrigin("*")
public class SubjectsController {
	@Autowired
	private ISubjectsService subjectsService;

	@GetMapping()
	public ResponseEntity<?> getListSubjects() {
		List<Subjects> listSubjects_DB = subjectsService.getListSubjects();

		// chuyển từ pageSubjects sang pageSubjectsDTO
//		Page<SubjectsDTO> pageSubjects_DTO = pageSubjects_DB.map(new Function<Subjects, SubjectsDTO>() {
//			@Override
//			public SubjectsDTO apply(Subjects subjects) {
//				SubjectsDTO subjectsDTO = new SubjectsDTO();
//				subjectsDTO.setSubjectID(subjects.getSubjectID());
//				subjectsDTO.setSubjectName(subjects.getSubjectName());
//				return subjectsDTO;
//			}
//		});
//		
		List<SubjectsDTO> listSubjects_DTO = new ArrayList<SubjectsDTO>();
		for (Subjects subjects : listSubjects_DB) {
			SubjectsDTO subjectsDTO = new SubjectsDTO();
			subjectsDTO.setSubjectID(subjects.getSubjectID());
			subjectsDTO.setSubjectName(subjects.getSubjectName());

			listSubjects_DTO.add(subjectsDTO);
		}

		return new ResponseEntity<>(listSubjects_DTO, HttpStatus.OK);
	}

}
