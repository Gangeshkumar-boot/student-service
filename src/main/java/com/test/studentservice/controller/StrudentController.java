package com.test.studentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.studentservice.dto.StudentResponse;
import com.test.studentservice.model.StudentModel;
import com.test.studentservice.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/students")
public class StrudentController {
	
	private StudentService studentService;
	
	public StrudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping()
	public ResponseEntity<StudentModel> registorStudent(@RequestBody StudentModel studentRequest){
		log.info("Request for student:",studentRequest);
		
		StudentModel studentResponse = studentService.registorStudent(studentRequest);
		
		return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
	}
	
	 @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> getStudentById(@PathVariable("id") String id){
		log.info("Get student by id:",id);
		
		StudentResponse studentResponse = studentService.getStudentById(id);
		
		return new ResponseEntity<>(studentResponse, HttpStatus.OK);
	}
	

}
