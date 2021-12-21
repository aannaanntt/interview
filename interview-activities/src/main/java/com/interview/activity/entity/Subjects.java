package com.interview.activity.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Subjects {
	@Id
	@GeneratedValue
	private int id;
	private String subjectname;
	private int passingmarks;
	
	@ManyToOne
	private Students student;

	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Subjects(int id, String subjectname, int passingmarks, Students students) {
		super();
		this.id = id;
		this.subjectname = subjectname;
		this.passingmarks = passingmarks;
		this.student = students;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public int getPassingmarks() {
		return passingmarks;
	}

	public void setPassingmarks(int passingmarks) {
		this.passingmarks = passingmarks;
	}

	public Students getStudents() {
		return student;
	}

	public void setStudents(Students students) {
		this.student = students;
	}

	

}
