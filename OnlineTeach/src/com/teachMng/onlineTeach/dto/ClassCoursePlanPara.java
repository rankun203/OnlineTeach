package com.teachMng.onlineTeach.dto;
/*
 * 学生课程表
 * 此类的一个对象代表一节课程，用于在页面中显示
 */
public class ClassCoursePlanPara {
	public int getCpID() {
		return cpID;
	}
	public void setCpID(int cpID) {
		this.cpID = cpID;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getParagraph() {
		return paragraph;
	}
	public void setParagraph(int paragraph) {
		this.paragraph = paragraph;
	}
	

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return courseID;
	}


	private int cpID;
	private int courseID;
	private int teacherID;
	private int roomID;
	private String courseName;
	private String teacherName;
	private String roomName;
	private int paragraph;	
}
