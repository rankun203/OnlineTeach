package com.teachMng.onlineTeach.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * desc:教案
 * */
@Entity
@Table(name = "t_teachplan")
public class TeachPlan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date tpCourseTime;
	private CoursePlanItem coursePlanItem;
	private String tpTeachMethod;
	private String tpTeachContent;
	private String tpTeachGoal;
	@Id
	public Date getTpCourseTime() {
		return tpCourseTime;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		TeachPlan tp = (TeachPlan)obj;
		return tp.getTpCourseTime() == this.getTpCourseTime() && tp.getCoursePlanItem().getCpID() == this.getCoursePlanItem().getCpID();
	}
	public void setTpCourseTime(Date tpCourseTime) {
		this.tpCourseTime = tpCourseTime;
	}
	public String getTpTeachMethod() {
		return tpTeachMethod;
	}
	public void setTpTeachMethod(String tpTeachMethod) {
		this.tpTeachMethod = tpTeachMethod;
	}
	public String getTpTeachContent() {
		return tpTeachContent;
	}
	public void setTpTeachContent(String tpTeachContent) {
		this.tpTeachContent = tpTeachContent;
	}
	public String getTpTeachGoal() {
		return tpTeachGoal;
	}
	public void setTpTeachGoal(String tpTeachGoal) {
		this.tpTeachGoal = tpTeachGoal;
	}
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cpID")
	public CoursePlanItem getCoursePlanItem() {
		return coursePlanItem;
	}
	public void setCoursePlanItem(CoursePlanItem coursePlanItem) {
		this.coursePlanItem = coursePlanItem;
	}
}
