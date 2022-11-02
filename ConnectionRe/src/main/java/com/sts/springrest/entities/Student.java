package com.sts.springrest.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sid;

	private String studentName;


	@ManyToMany(cascade = CascadeType.ALL)
	private List<Course> crs;

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Course> getCrs() {
		return crs;
	}

	public void setCrs(List<Course> crs) {
		this.crs = crs;
	}

	public Student(long sid, String studentName, List<Course> crs) {
		super();
		this.sid = sid;
		this.studentName = studentName;
		this.crs = crs;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", studentName=" + studentName + ", crs=" + crs + "]";
	}

}
