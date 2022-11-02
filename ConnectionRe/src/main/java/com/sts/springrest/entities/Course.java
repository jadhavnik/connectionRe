package com.sts.springrest.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	
//	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private List<Student> sts;
	
//	public List<Student> getSts() {
//	return sts;
//}
//public void setSts(List<Student> sts) {
//	this.sts = sts;
//}
	
	
//	@OneToOne(cascade=CascadeType.ALL)
//	private Question question;
//
//	public Question getQuestion() {
//		return question;
//	}
//	public void setQuestion(Question question) {
//		this.question = question;
//	}
	


	//@JsonIgnore     Add this annotation to get one course belongs 
	//	to many question so for above @OneToOne  and
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "pc_id")  in question table
	

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="pc_id",referencedColumnName = "id")
	private List<Question> questions;
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
@Embedded
	private Certificatess certificatess;
	
	
	public Certificatess getCertificatess() {
		return certificatess;
	}
	public void setCertificatess(Certificatess certificatess) {
		this.certificatess = certificatess;
	}
	@Column(name="titles")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Transient
	private String courseInstructor;
	
	
	@Temporal(TemporalType.TIMESTAMP	)
	@CreatedDate()
	@CreationTimestamp()
	private Date createdBy;
	
	
	@JsonIgnore
	@Lob
	private byte[] image;
	
	
	//  Note : uncomment this to get one course belong to many question for question api
 	//public Course(long id, Certificatess certificatess, String title, String description, String courseInstructor,
//			Date createdBy, byte[] image,List<Question> questions , List<Student> sts,Question question ){
	public Course(long id, Certificatess certificatess, String title, String description, String courseInstructor,
			Date createdBy, byte[] image,List<Question> questions , List<Student> sts ){
		super();
		this.id = id;
		this.certificatess = certificatess;
		this.title = title;
		this.description = description;
		this.courseInstructor = courseInstructor;
		this.createdBy = createdBy;
		this.image = image;
		this.questions= questions;
//		this.question= question;
//		this.sts = sts;
	}
//	public Course(long id, String title, String description,String courseInstructor,Date date) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.courseInstructor= courseInstructor;
//		this.createdBy = date;
//	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getCourseInstructor() {
		return courseInstructor;
	}
	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}
	public Date getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}
