package com.sts.springrest.controller;

import java.io.FileNotFoundException;
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

import com.sts.springrest.entities.Course;
import com.sts.springrest.services.CourseService;

@RestController
public class CourseController {

	//adding comment to push 3rd 
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home(){
			return "Hi";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
		
	}
	
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) throws NumberFormatException, FileNotFoundException {
		return this.courseService.getCourse(Long.parseLong(courseId));
		
	}
	
	@GetMapping("/courses/get/{title}")
	public List<Course> getCourseByTitle(@PathVariable String title) {
		return this.courseService.findByTitle(title);
	}
	
	@GetMapping("/courses/get/{desc}/{title}")
	public List<Course> getCourseByDescriptionAndTitle(@PathVariable String desc,@PathVariable String title) {
		return this.courseService.findByDescriptionAndTitle(desc,title);
		
	}
	
	@PostMapping("courses/add")
	public Course addCourse(@RequestBody Course course) throws IOException {
		
		return this.courseService.addCourse(course);
		
	}
	
	
	@PutMapping("courses/update")
	public Course updateCourse(@RequestBody Course course){
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("courses/delete/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		
		try {	
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
