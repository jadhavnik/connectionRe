package com.sts.springrest.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long questionId;
	
	private String question;

	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="my_custome_id")
	@JoinColumn(name="answer_id",referencedColumnName = "question_id")
	private Answer answer;

//	@OneToMany(cascade=CascadeType.ALL)
//	private List<Answer> answerList;
	

//	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	// Enable below  annotation get many question belongs to one course
//	@JoinColumn(name = "pc_id")
	private Course course;
	
	
	
	
//	@OneToMany(mappedBy="question")
//	private List<Answer> answerList;
	
	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


//	public List<Answer> getAnswerList() {
//		return answerList;
//	}
//
//
//	public void setAnswerList(List<Answer> answerList) {
//		this.answerList = answerList;
//	}


	public long getQuestionId() {
		return questionId;
	}


	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Answer getAnswer() {
		return answer;
	}


	public void setAnswer(Answer answer) {
		this.answer = answer;
	}


//	public Question(long questionId, String question, Answer answer, List<Answer> answerList,Course course) {
//		super();
//		this.questionId = questionId;
//		this.question = question;
//		this.answer = answer;
////		this.answerList = answerList;
//		this.course= course;
//	}

	
	public Question(long questionId, String question, Answer answer, Course course) {
//	public Question(long questionId, String question,Course course) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
		this.course= course;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
