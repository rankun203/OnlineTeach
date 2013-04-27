package com.teachMng.onlineTeach.model;

import java.util.Date;

/*
 * desc:作业
 * */
public class CourseWork {
	private String cwTitle;
	private String cwDesc;
	private int cwType;
	private int cwState;
	public String getCwTitle() {
		return cwTitle;
	}
	public void setCwTitle(String cwTitle) {
		this.cwTitle = cwTitle;
	}
	public String getCwDesc() {
		return cwDesc;
	}
	public void setCwDesc(String cwDesc) {
		this.cwDesc = cwDesc;
	}
	public int getCwType() {
		return cwType;
	}
	public void setCwType(int cwType) {
		this.cwType = cwType;
	}
	public int getCwState() {
		return cwState;
	}
	public void setCwState(int cwState) {
		this.cwState = cwState;
	}
}
