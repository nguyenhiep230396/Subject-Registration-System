package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.StudentClassDTO;
import com.vti.dto.StudentClassDTO_Ver2;
import com.vti.dto.StudentClassDTO_Ver3;
import com.vti.entity.Clazz;
import com.vti.entity.Student;
import com.vti.entity.StudentClass;
import com.vti.form.StudentClassFormForCreating;
import com.vti.service.IClazzService;
import com.vti.service.IStudentClassService;
import com.vti.service.IStudentService;

@RestController
@RequestMapping(value = "api/v1/studentclass")
@CrossOrigin("*")

public class StudentClassController {
	@Autowired
	private IStudentClassService studentClassService;

	@Autowired
	private IStudentService studentService;

	@Autowired
	private IClazzService clazzService;

	@GetMapping(value = "/{studentid}")
	public ResponseEntity<?> getListStudentClassByStudentID(@PathVariable(name = "studentid") short studentID) {
		Student student = studentService.getByStudentID(studentID);

		List<StudentClass> listStudentClassByStudent_DB = studentClassService.getListStudentClassByStudent(student);

//		Page<StudentClassDTO> pageStudentClassByStudent_DTO = pageStudentClassByStudent_DB
//				.map(new Function<StudentClass, StudentClassDTO>() {
//					@Override
//					public StudentClassDTO apply(StudentClass studentClass) {
//						StudentClassDTO studentClassDTO = new StudentClassDTO();
//						studentClassDTO.setStudentClassID(studentClass.getStudentClassID());
//						studentClassDTO.setStudentID(studentClass.getStudent().getStudentID());
//						studentClassDTO.setClassID(studentClass.getClazz().getClassID());
//						studentClassDTO.setSubjectName(studentClass.getClazz().getSubjects().getSubjectName());
//						studentClassDTO
//								.setDayOfTheWeek(studentClass.getClazz().getTimeSlot().getDayOfTheWeek().toString());
//						studentClassDTO.setNumberOfPeriod(studentClass.getClazz().getTimeSlot().getNumberOfPeriod());
//						studentClassDTO.setStartAtPeriod(studentClass.getClazz().getTimeSlot().getStartAtPeriod());
//						studentClassDTO.setEndAtPeriod(studentClass.getClazz().getTimeSlot().getEndAtPeriod());
//
//						return studentClassDTO;
//					}
//
//				});

		List<StudentClassDTO> listStudentClassByStudent_DTO = new ArrayList<StudentClassDTO>();
		for (StudentClass studentClass : listStudentClassByStudent_DB) {
			StudentClassDTO studentClassDTO = new StudentClassDTO();
			studentClassDTO.setStudentClassID(studentClass.getStudentClassID());
			studentClassDTO.setStudentID(studentClass.getStudent().getStudentID());
			studentClassDTO.setClassID(studentClass.getClazz().getClassID());
			studentClassDTO.setSubjectName(studentClass.getClazz().getSubjects().getSubjectName());
			studentClassDTO.setDayOfTheWeek(studentClass.getClazz().getTimeSlot().getDayOfTheWeek().toString());
			studentClassDTO.setNumberOfPeriod(studentClass.getClazz().getTimeSlot().getNumberOfPeriod());
			studentClassDTO.setStartAtPeriod(studentClass.getClazz().getTimeSlot().getStartAtPeriod());
			studentClassDTO.setEndAtPeriod(studentClass.getClazz().getTimeSlot().getEndAtPeriod());

			listStudentClassByStudent_DTO.add(studentClassDTO);
		}

		return new ResponseEntity<>(listStudentClassByStudent_DTO, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<?> getListStudentClass(Pageable pageable) {
		List<StudentClass> listStudentClassByStudent_DB = studentClassService.getListStudentClass();

//		List<StudentClassDTO> pageStudentClassByStudent_DTO = pageStudentClassByStudent_DB
//				.map(new Function<StudentClass, StudentClassDTO>() {
//					@Override
//					public StudentClassDTO apply(StudentClass studentClass) {
//						StudentClassDTO studentClassDTO = new StudentClassDTO();
//						studentClassDTO.setStudentClassID(studentClass.getStudentClassID());
//						studentClassDTO.setStudentID(studentClass.getStudent().getStudentID());
//						studentClassDTO.setClassID(studentClass.getClazz().getClassID());
//						studentClassDTO.setSubjectName(studentClass.getClazz().getSubjects().getSubjectName());
//						studentClassDTO
//								.setDayOfTheWeek(studentClass.getClazz().getTimeSlot().getDayOfTheWeek().toString());
//						studentClassDTO.setNumberOfPeriod(studentClass.getClazz().getTimeSlot().getNumberOfPeriod());
//						studentClassDTO.setStartAtPeriod(studentClass.getClazz().getTimeSlot().getStartAtPeriod());
//						studentClassDTO.setEndAtPeriod(studentClass.getClazz().getTimeSlot().getEndAtPeriod());
//
//						return studentClassDTO;
//					}
//
//				});

		List<StudentClassDTO> listStudentClassByStudent_DTO = new ArrayList<StudentClassDTO>();
		for (StudentClass studentClass : listStudentClassByStudent_DB) {
			StudentClassDTO studentClassDTO = new StudentClassDTO();
			studentClassDTO.setStudentClassID(studentClass.getStudentClassID());
			studentClassDTO.setStudentID(studentClass.getStudent().getStudentID());
			studentClassDTO.setClassID(studentClass.getClazz().getClassID());
			studentClassDTO.setSubjectName(studentClass.getClazz().getSubjects().getSubjectName());
			studentClassDTO.setDayOfTheWeek(studentClass.getClazz().getTimeSlot().getDayOfTheWeek().toString());
			studentClassDTO.setNumberOfPeriod(studentClass.getClazz().getTimeSlot().getNumberOfPeriod());
			studentClassDTO.setStartAtPeriod(studentClass.getClazz().getTimeSlot().getStartAtPeriod());
			studentClassDTO.setEndAtPeriod(studentClass.getClazz().getTimeSlot().getEndAtPeriod());

			listStudentClassByStudent_DTO.add(studentClassDTO);
		}

		return new ResponseEntity<>(listStudentClassByStudent_DTO, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createStudentClass(@RequestBody StudentClassFormForCreating studentClassFormForCreating) {
		studentClassService.createStudentClass(studentClassFormForCreating);
		return new ResponseEntity<>("Create Success", HttpStatus.OK);
	}

//	@GetMapping(value = "/{studentid}/{classid}")
//	public ResponseEntity<?> getStudentClassByStudentIDAndClassID(@PathVariable(name = "studentid") short studentID,
//			@PathVariable(name = "classid") short classID) {
//		Student student = studentService.getByStudentID(studentID);
//		Clazz clazz = clazzService.getByClassID(classID);
//
//		StudentClass studentClass = studentClassService.getByStudentAndClazz(student, clazz);
//
//		StudentClassDTO_Ver2 studentClassDTO_Ver2 = new StudentClassDTO_Ver2();
//		studentClassDTO_Ver2.setStudentClassID(studentClass.getStudentClassID());
//
//		return new ResponseEntity<>(studentClassDTO_Ver2, HttpStatus.OK);
//	}

	@DeleteMapping(value = "/{studentclassid}")
	public ResponseEntity<?> deleteStudentClass(@PathVariable(name = "studentclassid") short studentClassID) {
		studentClassService.deleteByStudentClassID(studentClassID);
		return new ResponseEntity<>("Delete Success", HttpStatus.OK);
	}

	@GetMapping(value = "/{studentid}/{classid}")
	public ResponseEntity<?> getStudentClassInfoByStudentIDAndClassID(@PathVariable(name = "studentid") short studentID,
			@PathVariable(name = "classid") short classID) {
		Student student = studentService.getByStudentID(studentID);
		Clazz clazz = clazzService.getByClassID(classID);

		StudentClass studentClass = studentClassService.getByStudentAndClazz(student, clazz);

		StudentClassDTO_Ver3 studentClassDTO_Ver3 = new StudentClassDTO_Ver3();
		studentClassDTO_Ver3.setDayOfTheWeek(studentClass.getClazz().getTimeSlot().getDayOfTheWeek().toString());
		studentClassDTO_Ver3.setStartAtPeriod(studentClass.getClazz().getTimeSlot().getStartAtPeriod());
		studentClassDTO_Ver3.setEndAtPeriod(studentClass.getClazz().getTimeSlot().getEndAtPeriod());

		return new ResponseEntity<>(studentClassDTO_Ver3, HttpStatus.OK);
	}

	// deleteStudentClassByStudentIDAndClassID
	@DeleteMapping(value = "/{studentid}/{classid}")
	public ResponseEntity<?> deleteStudentClassByStudentIDAndClassID(@PathVariable(name = "studentid") short studentID,
			@PathVariable(name = "classid") short classID) {
		Student student = studentService.getByStudentID(studentID);
		Clazz clazz = clazzService.getByClassID(classID);

		StudentClass studentClass = studentClassService.getByStudentAndClazz(student, clazz);

		StudentClassDTO_Ver2 studentClassDTO_Ver2 = new StudentClassDTO_Ver2();
		studentClassDTO_Ver2.setStudentClassID(studentClass.getStudentClassID());

		studentClassService.deleteByStudentClassID(studentClassDTO_Ver2.getStudentClassID());
		return new ResponseEntity<>("Delete Success", HttpStatus.OK);
	}

}
