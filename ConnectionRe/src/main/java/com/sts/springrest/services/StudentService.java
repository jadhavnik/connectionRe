package com.sts.springrest.services;

import java.util.List;

import com.sts.springrest.entities.Student;

public interface StudentService {

	public List<Student> getStudents();

	public Student getStudent(long StudentId) ;

	public Student addStudent(Student Student) ;

	public void deleteStudent(long StudentId);

	public Student updateStudent(Student Student);
	
}
