package com.teachMng.onlineTeach.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*
 * desc:课件
 * */
@Entity
@Table(name = "t_courseware")
public class CourseWare implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cwareID;
	private String cwareName;
	private String cwareDesc;
	private TeachPlan teachPlan;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCwareID() {
		return cwareID;
	}
	public void setCwareID(int cwareID) {
		this.cwareID = cwareID;
	}
	public String getCwareName() {
		return cwareName;
	}
	public void setCwareName(String cwareName) {
		this.cwareName = cwareName;
	}
	public String getCwareDesc() {
		return cwareDesc;
	}
	public void setCwareDesc(String cwareDesc) {
		this.cwareDesc = cwareDesc;
	}
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "tpCourseTime"),
		@JoinColumn(name = "coursePlanItem")
	})
	public TeachPlan getTeachPlan() {
		return teachPlan;
	}
	public void setTeachPlan(TeachPlan teachPlan) {
		this.teachPlan = teachPlan;
	}
}
