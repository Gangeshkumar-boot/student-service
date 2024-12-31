package com.test.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String mobileNo;
	
	private CourceResponse cource;

}
