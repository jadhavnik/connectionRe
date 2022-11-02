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

import com.sts.springrest.entities.Question;
import com.sts.springrest.services.QuestionService;


@RestController
public class QuestionController {

	
	@Autowired
	private QuestionService questionService;
	

	
	@GetMapping("/questions")
	public List<Question> getCourses(){
		return this.questionService.getQuestions();
		
	}
	
	
	@GetMapping("/questions/{questionId}")
	public Question getCourse(@PathVariable String questionId)  {
		return this.questionService.getQuestion(Long.parseLong(questionId));
		
	}
	
	@PostMapping("questions/add")
	public Question addCourse(@RequestBody Question question) throws IOException {
		
		return this.questionService.addQuestion(question);
		
	}
	
	
	@PutMapping("questions/update")
	public Question updateCourse(@RequestBody Question question){
		return this.questionService.updateQuestion(question);
	}
	
	@DeleteMapping("questions/delete/{questionId}")
	public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable String questionId){
		
		try {	
			this.questionService.deleteQuestion(Long.parseLong(questionId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
