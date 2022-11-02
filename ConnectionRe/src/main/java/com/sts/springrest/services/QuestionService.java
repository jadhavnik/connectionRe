package com.sts.springrest.services;


import java.util.List;

import com.sts.springrest.entities.Question;



public interface QuestionService {

	public List<Question> getQuestions();

	public Question getQuestion(long questionId) ;

	public Question addQuestion(Question question);

	public void deleteQuestion(long questionId);

	public Question updateQuestion(Question question);
}
