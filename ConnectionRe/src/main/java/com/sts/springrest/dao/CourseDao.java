package com.sts.springrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.springrest.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

	public List<Course> findByTitle(String title);
	public List<Course> findByDescriptionAndTitle(String desc,String title);

}
