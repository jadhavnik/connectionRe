package com.sts.springrest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.springrest.entities.Student;
import com.sts.springrest.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	

	
	@GetMapping("/students")
	public List<Student> getStudent(){
		return this.studentService.getStudents();
		
	}
	
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable String studentId)   {
		return this.studentService.getStudent(Long.parseLong(studentId));
		
	}
	
	@PostMapping("students/add")
	public Student addStudent(@RequestBody Student answer) throws IOException {
		
		return this.studentService.addStudent(answer);
		
	}
	
	
	@PutMapping("students/update")
	public Student updateStudent(@RequestBody Student answer){
		return this.studentService.updateStudent(answer);
	}
	
	@DeleteMapping("students/delete/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String studentId){
		
		try {	
			this.studentService.deleteStudent(Long.parseLong(studentId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
