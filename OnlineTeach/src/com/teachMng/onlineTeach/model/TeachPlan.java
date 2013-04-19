package com.teachMng.onlineTeach.model;

import java.util.Date;

/*
 * desc:½Ì°¸
 * */
public class TeachPlan {
	private Date tpCourseTime;
	private String tpTeachMethod;
	private String tpTeachContent;
	private String tpTeachGoal;
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
}
