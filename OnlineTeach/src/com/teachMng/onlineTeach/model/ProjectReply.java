package com.teachMng.onlineTeach.model;

import java.util.Date;
/*
 * desc:ÏîÄ¿´ð±ç
 * */
public class ProjectReply {
	private float prGrade;
	private int prState;
	private Date prDate;
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
