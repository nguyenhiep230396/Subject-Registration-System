package com.vti.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.LoginDTO;
import com.vti.entity.Student;
import com.vti.service.IStudentService;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin("*")
public class LoginController {
	@Autowired
	private IStudentService studentService;

	@GetMapping()
	public ResponseEntity<?> getLogin(Principal principal) {
		String studentEmail = principal.getName();

		Student studentLogin = studentService.getStudentByStudentEmail(studentEmail);

		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setStudentID(studentLogin.getStudentID());
		loginDTO.setStudentName(studentLogin.getStudentName());

		return new ResponseEntity<>(loginDTO, HttpStatus.OK);
	}
}
