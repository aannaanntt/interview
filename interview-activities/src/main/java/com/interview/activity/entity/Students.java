package com.interview.activity.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Students {

	@Id
	@GeneratedValue
	private int studentid;
	private String name;
	private int cls;
	private char section;
	private String rollnumber;

	@OneToMany(mappedBy = "student")
	private List<StudentMarks> studentmarks;
	@OneToMany(mappedBy = "student")
	private List<Subjects> subjects;

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(int studentid, String name, int cls, char section, String rollnumber,
			List<StudentMarks> studentmarks, List<Subjects> subjects) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.cls = cls;
		this.section = section;
		this.rollnumber = rollnumber;
		this.studentmarks = studentmarks;
		this.subjects = subjects;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCls() {
		return cls;
	}

	public void setCls(int cls) {
		this.cls = cls;
	}

	public char getSection() {
		return section;
	}

	public void setSection(char section) {
		this.section = section;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public List<StudentMarks> getStudentmarks() {
		return studentmarks;
	}

	public void setStudentmarks(List<StudentMarks> studentmarks) {
		this.studentmarks = studentmarks;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

}
