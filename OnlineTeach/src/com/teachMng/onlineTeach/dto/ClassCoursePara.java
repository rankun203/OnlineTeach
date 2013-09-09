package com.teachMng.onlineTeach.dto;
/*
 * 班级与课程的关系
 */
public class ClassCoursePara {
	private int scID;
	private int cID;
	private int planPara;
	public int getScID() {
		return scID;
	}
	public void setScID(int scID) {
		this.scID = scID;
	}
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public int getPlanPara() {
		return planPara;
	}
	public void setPlanPara(int planPara) {
		this.planPara = planPara;
	}
}
