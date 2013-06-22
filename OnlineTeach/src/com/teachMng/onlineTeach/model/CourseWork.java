package com.teachMng.onlineTeach.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*
 * desc:作业
 * */
//@Entity
@Table(name = "t_coursework")
public class CourseWork implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cworkID;
	private String cworkTitle;
	private String cworkDesc;
	private int cworkType;
	private int cworkState;
	private TeachPlan teachPlan;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCworkID() {
		return cworkID;
	}
	public void setCworkID(int cworkID) {
		this.cworkID = cworkID;
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
	public String getCworkTitle() {
		return cworkTitle;
	}
	public void setCworkTitle(String cworkTitle) {
		this.cworkTitle = cworkTitle;
	}
	public String getCworkDesc() {
		return cworkDesc;
	}
	public void setCworkDesc(String cworkDesc) {
		this.cworkDesc = cworkDesc;
	}
	public int getCworkType() {
		return cworkType;
	}
	public void setCworkType(int cworkType) {
		this.cworkType = cworkType;
	}
	public int getCworkState() {
		return cworkState;
	}
	public void setCworkState(int cworkState) {
		this.cworkState = cworkState;
	}
}
