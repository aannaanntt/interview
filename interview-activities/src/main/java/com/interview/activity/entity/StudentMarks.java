package com.interview.activity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class StudentMarks {
	@Id
	@GeneratedValue
	private int id;
	private String session;
	private int studentid;
	private int marksobtained;

	@ManyToOne
	private Students student;

	public StudentMarks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentMarks(int id, String session, int studentid, int marksobtained, Students student) {
		super();
		this.id = id;
		this.session = session;
		this.studentid = studentid;
		this.marksobtained = marksobtained;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getMarksobtained() {
		return marksobtained;
	}

	public void setMarksobtained(int marksobtained) {
		this.marksobtained = marksobtained;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

}
