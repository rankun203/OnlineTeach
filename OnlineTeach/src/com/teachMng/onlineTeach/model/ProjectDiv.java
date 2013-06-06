package com.teachMng.onlineTeach.model;

import java.io.Serializable;

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
public class ProjectDiv implements Serializable {
	private static final long serialVersionUID = 1L;
	private String pdWorkDesc;
	private float pdGrade;
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
	public float getPdGrade() {
		return pdGrade;
	}
	public void setPdGrade(float pdGrade) {
		this.pdGrade = pdGrade;
	}
}
