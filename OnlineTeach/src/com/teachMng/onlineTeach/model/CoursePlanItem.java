package com.teachMng.onlineTeach.model;

import java.util.Date;

/*
 * desc:课程表原子
 * */
public class CoursePlanItem {
	private int cpID;
	private int cpParagraph;
	private int cpState;
	public int getCpID() {
		return cpID;
	}
	public void setCpID(int cpID) {
		this.cpID = cpID;
	}
	public int getCpParagraph() {
		return cpParagraph;
	}
	public void setCpParagraph(int cpParagraph) {
		this.cpParagraph = cpParagraph;
	}
	public int getCpState() {
		return cpState;
	}
	public void setCpState(int cpState) {
		this.cpState = cpState;
	}
}
