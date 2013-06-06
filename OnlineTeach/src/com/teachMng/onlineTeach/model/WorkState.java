package com.teachMng.onlineTeach.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 * desc:练习情况
 * */
@Entity
@Table(name = "t_workstate")
public class WorkState implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int wsID;
	private Float wsGrade;
	private String wsTeacherComment;
	private CourseWork courseWork;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getWsID() {
		return wsID;
	}
	public void setWsID(int wsID) {
		this.wsID = wsID;
	}
	public Float getWsGrade() {
		return wsGrade;
	}
	public void setWsGrade(Float wsGrade) {
		this.wsGrade = wsGrade;
	}
	public String getWsTeacherComment() {
		return wsTeacherComment;
	}
	public void setWsTeacherComment(String wsTeacherComment) {
		this.wsTeacherComment = wsTeacherComment;
	}
	public CourseWork getCourseWork() {
		return courseWork;
	}
	public void setCourseWork(CourseWork courseWork) {
		this.courseWork = courseWork;
	}
}
