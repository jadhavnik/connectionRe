package com.sts.springrest.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.springrest.dao.StudentDao;
import com.sts.springrest.entities.Student;
import com.sts.springrest.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	private StudentDao studentDao;
	
	List<Student> list =null;
	
	@Override
	public List<Student> getStudents() {
		return this.studentDao.findAll();
	}

	@Override
	public Student getStudent(long studentId) {
		// TODO Auto-generated method stub
		Optional<Student> s= 	this.studentDao.findById(studentId);
		return s.get();
	}

	@Override
	public Student addStudent(Student student) {
		return 	this.studentDao.save(student);
	}

	@Override
	public void deleteStudent(long studentId) {
		 	this.studentDao.deleteById(studentId);
	}

	@Override
	public Student updateStudent(Student student) {
		return 	this.studentDao.save(student);
	}

}
