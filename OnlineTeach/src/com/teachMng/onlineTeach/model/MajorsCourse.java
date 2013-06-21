package com.teachMng.onlineTeach.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_majorscourse")
public class MajorsCourse implements Serializable{
	private static final long serialVersionUID = 1L;
	private int paragraph;       //此专业此门课程每周上多少节
	private Major major;
	private Course course;

	@Id
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="majorID")
	public Major getMajor() {
		return major;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		MajorsCourse mc = (MajorsCourse)obj;
		return this.major.getMajorID() == mc.getMajor().getMajorID() && this.major.getMajorID() == mc.getMajor().getMajorID();
	}

	public void setMajor(Major major) {
		this.major = major;
	}
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="courseID")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getParagraph() {
		return paragraph;
	}

	public void setParagraph(int paragraph) {
		this.paragraph = paragraph;
	}
}
