package com.teachMng.onlineTeach.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * desc:项目分工
 * */
@Entity
@Table(name="t_projectdiv")
public class ProjectDiv {
	private String pdWorkDesc;
	private String pdGrade;
	private int pdID;
	private Project project;
	private Student student;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="projID")
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPdID() {
		return pdID;
	}
	public void setPdID(int pdID) {
		this.pdID = pdID;
	}
	public String getPdWorkDesc() {
		return pdWorkDesc;
	}
	public void setPdWorkDesc(String pdWorkDesc) {
		this.pdWorkDesc = pdWorkDesc;
	}
	public String getPdGrade() {
		return pdGrade;
	}
	public void setPdGrade(String pdGrade) {
		this.pdGrade = pdGrade;
	}
}
