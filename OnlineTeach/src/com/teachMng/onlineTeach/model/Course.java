package com.teachMng.onlineTeach.model;

import java.util.Date;

/*
 * desc:¿Î³ÌÐÅÏ¢
 * */
public class Course {
	private int courseID;
	private String courseName;
	private String courseDesc;
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
}
