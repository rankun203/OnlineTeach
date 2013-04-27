package com.teachMng.onlineTeach.model;

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
public class TeachPlan {
	private Date tpCourseTime;
	private CoursePlanItem coursePlanItem;
	private String tpTeachMethod;
	private String tpTeachContent;
	private String tpTeachGoal;
	@Id
	public Date getTpCourseTime() {
		return tpCourseTime;
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
