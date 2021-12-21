package com.interview.activity.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SubjectClassMap {
	@Id
	@GeneratedValue
	private int id;
	private int subjectid;
	private int cls;

	@OneToOne
	private Subjects subject;
	
	@OneToOne
	private Students student;
	public SubjectClassMap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectClassMap(int id, int subjectid, int cls, Subjects subject) {
		super();
		this.id = id;
		this.subjectid = subjectid;
		this.cls = cls;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public int getCls() {
		return cls;
	}

	public void setCls(int cls) {
		this.cls = cls;
	}

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

}
