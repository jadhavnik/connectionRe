package com.sts.springrest.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Answer {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long answerId;
	private String answerName;
	
	
	
	//He one to one mapping ahe answer madhun direct question insert hoil as well as vice versa
	@OneToOne(cascade=CascadeType.ALL)
	private Question question;
	
	
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getAnswerName() {
		return answerName;
	}
	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}
	public long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int answerId, String answerName, Question question) {
		super();
		this.answerId = answerId;
		this.answerName = answerName;
		this.question = question;
	}

	
	
	
}
