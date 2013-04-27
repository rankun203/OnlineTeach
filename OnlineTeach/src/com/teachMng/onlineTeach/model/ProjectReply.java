package com.teachMng.onlineTeach.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
/*
 * desc:项目答辩
 * */
@Entity
@Table(name="t_projectreply")
public class ProjectReply {
	private int prID;
	private float prGrade;
	private int prState;
	private Date prDate;
	private Project project;
	private ProjectGroup projectGroup;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=true)
	public int getPrID() {
		return prID;
	}
	public void setPrID(int prID) {
		this.prID = prID;
	}

	@ManyToOne
	@JoinColumn(name="projID")
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne
	@JoinColumn(name="pgID")
	public ProjectGroup getProjectGroup() {
		return projectGroup;
	}
	public void setProjectGroup(ProjectGroup projectGroup) {
		this.projectGroup = projectGroup;
	}
	
	public float getPrGrade() {
		return prGrade;
	}
	public void setPrGrade(float prGrade) {
		this.prGrade = prGrade;
	}
	public int getPrState() {
		return prState;
	}
	public void setPrState(int prState) {
		this.prState = prState;
	}
	public Date getPrDate() {
		return prDate;
	}
	public void setPrDate(Date prDate) {
		this.prDate = prDate;
	}
}
