package com.teachMng.onlineTeach.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * desc:课程信息
 * */
@Entity
@Table(name="t_course")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	private int courseID;
	private String courseName;
	private String courseDesc;
	private int priority;
	private int roomType;
	private Set<Teacher> teachers = new HashSet<Teacher>();
	private Set<MajorsCourse> majorsCourses = new HashSet<MajorsCourse>();
	
	@OneToMany(mappedBy="course", cascade=CascadeType.ALL)
	public Set<MajorsCourse> getMajorsCourses() {
		return majorsCourses;
	}
	public void setMajorsCourses(Set<MajorsCourse> majorsCourses) {
		this.majorsCourses = majorsCourses;
	}
	public int getRoomType() {
		return roomType;
	}
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="t_courseandteacher", 
			joinColumns=@JoinColumn(name="courseID"), 
			inverseJoinColumns=@JoinColumn(name="teacID"))
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	private CoursePlanItem coursePlanItem;
	private Set<Student> students = new HashSet<Student>();
	
	@ManyToMany(mappedBy="courses", cascade=CascadeType.ALL)
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
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
