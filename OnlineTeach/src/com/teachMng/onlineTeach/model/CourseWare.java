package com.teachMng.onlineTeach.model;

import java.util.Date;

/*
 * desc:课件
 * */
public class CourseWare {
	private int cwareID;
	private String cwareName;
	private String cwareDesc;
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
}
