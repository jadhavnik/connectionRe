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

import com.sts.springrest.entities.Answer;
import com.sts.springrest.services.AnswerService;

@RestController
public class AnswerController {
	
	
	
	@Autowired
	private AnswerService answerService;
	

	
	@GetMapping("/answers")
	public List<Answer> getAnswer(){
		return this.answerService.getAnswers();
		
	}
	
	
	@GetMapping("/answers/{answerId}")
	public Answer getAnswer(@PathVariable String answerId)   {
		return this.answerService.getAnswer(Long.parseLong(answerId));
		
	}
	
	@PostMapping("answers/add")
	public Answer addAnswer(@RequestBody Answer answer) throws IOException {
		
		return this.answerService.addAnswer(answer);
		
	}
	
	
	@PutMapping("answers/update")
	public Answer updateAnswer(@RequestBody Answer answer){
		return this.answerService.updateAnswer(answer);
	}
	
	@DeleteMapping("answers/delete/{answerId}")
	public ResponseEntity<HttpStatus> deleteAnswer(@PathVariable String answerId){
		
		try {	
			this.answerService.deleteAnswer(Long.parseLong(answerId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
