package com.teachMng.onlineTeach.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * desc:项目组
 * */
@Entity
@Table(name="t_projectGroup")
public class ProjectGroup {
	private int pgID;
	private String pgName;
	private String pgSlogan;
	private Set<Project> projects = new HashSet<Project>();
	private Set<Student> students = new HashSet<Student>();
	@OneToMany(mappedBy="projectGroup", cascade=CascadeType.ALL)
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@ManyToMany(mappedBy="projectGroups", cascade=CascadeType.ALL)
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPgID() {
		return pgID;
	}
	public void setPgID(int pgID) {
		this.pgID = pgID;
	}
	public String getPgName() {
		return pgName;
	}
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}
	public String getPgSlogan() {
		return pgSlogan;
	}
	public void setPgSlogan(String pgSlogan) {
		this.pgSlogan = pgSlogan;
	}
}
