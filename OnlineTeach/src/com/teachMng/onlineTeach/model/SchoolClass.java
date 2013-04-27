package com.teachMng.onlineTeach.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * desc:班级
 * */
@Entity
@Table(name="t_schoolclass")
public class SchoolClass {
	private int scID;
	private String scName;
	private Major major;
	private Set<CoursePlanItem> coursePlanItems = new HashSet<CoursePlanItem>();
	private Set<Student> students = new HashSet<Student>();
	@OneToMany(mappedBy="schoolClass", cascade=CascadeType.ALL)
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@OneToMany(mappedBy="schoolClass", cascade=CascadeType.ALL)
	public Set<CoursePlanItem> getCoursePlanItems() {
		return coursePlanItems;
	}
	public void setCoursePlanItems(Set<CoursePlanItem> coursePlanItems) {
		this.coursePlanItems = coursePlanItems;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="majorID")
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getScID() {
		return scID;
	}
	public void setScID(int scID) {
		this.scID = scID;
	}
	public String getScName() {
		return scName;
	}
	public void setScName(String scName) {
		this.scName = scName;
	}
}
