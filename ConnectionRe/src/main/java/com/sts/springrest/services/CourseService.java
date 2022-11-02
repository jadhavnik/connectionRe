package com.sts.springrest.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.sts.springrest.entities.Course;

public interface CourseService {
	
	public List<Course> findByTitle(String title);
	
	public List<Course> findByDescriptionAndTitle(String desc,String title);

	public List<Course> getCourses();

	public Course getCourse(long courseId) throws FileNotFoundException;

	public Course addCourse(Course course) throws IOException;

	public void deleteCourse(long courseId);

	public Course updateCourse(Course course);
}
