package com.teachMng.onlineTeach.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * desc:综合考核
 * */
//@Entity
@Table(name="t_compositecheck")
public class CompositeCheck implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float ccGrade;
	private float ccState;
	private int ccID;
	private Course course;
	private Student student;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="courseID")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="stuID")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Id
	@Column(nullable = false)
	public int getCcID() {
		return ccID;
	}
	public void setCcID(int ccID) {
		this.ccID = ccID;
	}
	@Column(nullable = true)
	public float getCcGrade() {
		return ccGrade;
	}
	public void setCcGrade(float ccGrade) {
		this.ccGrade = ccGrade;
	}
	@Column(nullable = true)
	public float getCcState() {
		return ccState;
	}
	public void setCcState(float ccState) {
		this.ccState = ccState;
	}
}
