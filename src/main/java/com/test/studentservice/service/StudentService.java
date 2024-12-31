package com.test.studentservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.studentservice.dto.CourceResponse;
import com.test.studentservice.dto.StudentResponse;
import com.test.studentservice.model.StudentModel;
import com.test.studentservice.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	private RestTemplate restTemplate;
	private ModelMapper modelMapper;

	public StudentService(StudentRepository studentRepository, RestTemplate restTemplate, ModelMapper modelMapper) {
		this.studentRepository = studentRepository;
		this.restTemplate = restTemplate;
		this.modelMapper = modelMapper;
	}

	public StudentModel registorStudent(StudentModel studentRequest) {
		
		StudentModel studentResponse = studentRepository.save(studentRequest);
		
		return studentResponse;
	}

	public StudentResponse getStudentById(String id) {
		String url = String.format("%s/%s", "http://localhost:8082/cources","274d6c10-aa8c-4274-9516-100d1a24f510");
		CourceResponse cource = restTemplate.getForObject(url, CourceResponse.class);

		StudentModel studentModel = studentRepository.findById(id).orElseThrow();
		StudentResponse studentResponse = modelMapper.map(studentModel, StudentResponse.class);
		studentResponse.setCource(cource);
		return studentResponse;
	}

}
