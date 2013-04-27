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
import javax.persistence.Table;

/*
 * desc:项目
 * */
@Entity
@Table(name="t_project")
public class Project {
	private int projID;
	private String projTitle;
	private String projDesc;
	private Set<ProjectGroup> projectGroups = new HashSet<ProjectGroup>();
	private Set<Student> students = new HashSet<Student>();
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="t_projectdiv", 
			joinColumns=@JoinColumn(name="projID"), 
			inverseJoinColumns=@JoinColumn(name="stuID")
			)
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="t_projectReply", 
			joinColumns=@JoinColumn(name="projID"),
			inverseJoinColumns=@JoinColumn(name="pgID")
			)
	public Set<ProjectGroup> getProjectGroups() {
		return projectGroups;
	}
	public void setProjectGroups(Set<ProjectGroup> projectGroups) {
		this.projectGroups = projectGroups;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getProjID() {
		return projID;
	}
	public void setProjID(int projID) {
		this.projID = projID;
	}
	public String getProjTitle() {
		return projTitle;
	}
	public void setProjTitle(String projTitle) {
		this.projTitle = projTitle;
	}
	public String getProjDesc() {
		return projDesc;
	}
	public void setProjDesc(String projDesc) {
		this.projDesc = projDesc;
	}
}
