package com.sts.springrest.services;

import java.util.List;

import com.sts.springrest.entities.Answer;

public interface AnswerService {

	public List<Answer> getAnswers();

	public Answer getAnswer(long answerId) ;

	public Answer addAnswer(Answer answer) ;

	public void deleteAnswer(long answerId);

	public Answer updateAnswer(Answer answer);
	
}
