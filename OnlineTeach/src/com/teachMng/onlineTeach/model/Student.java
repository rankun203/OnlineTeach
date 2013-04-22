package com.teachMng.onlineTeach.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * desc:Ñ§Éú
 * */
@Entity
@Table(name="t_student")
public class Student {
	private int stuID;
	private String stuName;
	private SchoolClass schoolClass;
	private ProjectGroup projectGroup;
	private Set<Project> projects = new HashSet<Project>();
	private Set<Course> courses = new HashSet<Course>();
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="t_compositecheck", 
			joinColumns=@JoinColumn(name="stuID"),
			inverseJoinColumns=@JoinColumn(name="courseID")
			)
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@ManyToMany(mappedBy="students", cascade=CascadeType.ALL)
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pgID")
	public ProjectGroup getProjectGroup() {
		return projectGroup;
	}
	public void setProjectGroup(ProjectGroup projectGroup) {
		this.projectGroup = projectGroup;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="scID")
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getStuID() {
		return stuID;
	}
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
}
