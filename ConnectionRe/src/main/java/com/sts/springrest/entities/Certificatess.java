package com.sts.springrest.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Certificatess {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long certId;
//	
//	public long getCertId() {
//		return certId;
//	}
//	public void setCertId(long certId) {
//		this.certId = certId;
//	}
	

	private String courseName;
	
	
	private String courseDuration;
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public Certificatess() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certificatess( String courseName, String courseDuration) {
		super();
//		this.certId = certId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}
	@Override
	public String toString() {
		return "Certificatess [certId=" + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ "]";
	}
	
	
	
}
