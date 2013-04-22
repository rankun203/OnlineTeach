package com.teachMng.onlineTeach.model;

import java.util.Date;

/*
 * desc:Á·Ï°Çé¿ö
 * */
public class WorkState {
	private int wsID;
	private Float wsGrade;
	private String wsTeacherComment;
	public int getWsID() {
		return wsID;
	}
	public void setWsID(int wsID) {
		this.wsID = wsID;
	}
	public Float getWsGrade() {
		return wsGrade;
	}
	public void setWsGrade(Float wsGrade) {
		this.wsGrade = wsGrade;
	}
	public String getWsTeacherComment() {
		return wsTeacherComment;
	}
	public void setWsTeacherComment(String wsTeacherComment) {
		this.wsTeacherComment = wsTeacherComment;
	}
}
