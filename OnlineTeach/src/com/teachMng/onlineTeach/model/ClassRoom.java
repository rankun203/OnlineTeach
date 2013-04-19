package com.teachMng.onlineTeach.model;

import java.util.Date;

/*
 * desc:ฝฬสา
 * */
public class ClassRoom {
	private int crID;
	private String crName;
	public int getCrID() {
		return crID;
	}
	public void setCrID(int crID) {
		this.crID = crID;
	}
	public String getCrName() {
		return crName;
	}
	public void setCrName(String crName) {
		this.crName = crName;
	}
	public int getCrType() {
		return crType;
	}
	public void setCrType(int crType) {
		this.crType = crType;
	}
	private int crType;
}
