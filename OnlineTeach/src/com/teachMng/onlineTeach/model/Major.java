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
import javax.persistence.Table;

/*
 * desc:专业
 * */
@Entity
@Table(name="t_major")
public class Major implements Serializable {
	private static final long serialVersionUID = 1L;
	private int majorID;
	private String majorName;
	private Set<SchoolClass> schoolClasses = new HashSet<SchoolClass>();
	private Set<Course> courses = new HashSet<Course>();
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="t_majorscourse",
				joinColumns=@JoinColumn(name="majorID"), 
				inverseJoinColumns=@JoinColumn(name="courseID"))
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@OneToMany(mappedBy="major", cascade=CascadeType.ALL)
	public Set<SchoolClass> getSchoolClasses() {
		return schoolClasses;
	}
	public void setSchoolClasses(Set<SchoolClass> schoolClasses) {
		this.schoolClasses = schoolClasses;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getMajorID() {
		return majorID;
	}
	public void setMajorID(int majorID) {
		this.majorID = majorID;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
}
