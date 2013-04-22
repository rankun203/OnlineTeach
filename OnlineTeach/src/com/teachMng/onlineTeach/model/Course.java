package com.teachMng.onlineTeach.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * desc:¿Î³ÌÐÅÏ¢
 * */
@Entity
@Table(name="t_course")
public class Course {
	private int courseID;
	private String courseName;
	private String courseDesc;
	private CoursePlanItem coursePlanItem;
	@OneToOne(mappedBy="course", cascade=CascadeType.ALL)
	public CoursePlanItem getCoursePlanItem() {
		return coursePlanItem;
	}
	public void setCoursePlanItem(CoursePlanItem coursePlanItem) {
		this.coursePlanItem = coursePlanItem;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JoinColumn(name="cpID")
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
