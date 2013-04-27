package com.teachMng.onlineTeach.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * desc:教室
 * */
@Entity
@Table(name="t_classroom")
public class ClassRoom {
	private int crID;
	private String crName;
	private CoursePlanItem coursePlanItem;
	private int crType;
	
	@OneToOne(mappedBy="classRoom", cascade=CascadeType.ALL)
	@JoinColumn(name="cpID")
	public CoursePlanItem getCoursePlanItem() {
		return coursePlanItem;
	}
	public void setCoursePlanItem(CoursePlanItem coursePlanItem) {
		this.coursePlanItem = coursePlanItem;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
}
