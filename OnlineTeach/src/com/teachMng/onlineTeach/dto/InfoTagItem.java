package com.teachMng.onlineTeach.dto;
/*
 * 显示在排课页面中的标签数据
 */
public class InfoTagItem {
	private int ID;       //1-班级，2-教师，3-教室
	private String name;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}    
}
