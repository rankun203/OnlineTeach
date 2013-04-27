package com.teachMng.onlineTeach.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * desc:教师
 * */
@Entity
@Table(name="t_teacher")
public class Teacher {
	private int teacID;
	private String teacName;
	private Set<CoursePlanItem> coursePlanItems = new HashSet<CoursePlanItem>();
	@OneToMany(mappedBy="teacher", cascade=CascadeType.ALL)
	public Set<CoursePlanItem> getCoursePlanItems() {
		return coursePlanItems;
	}
	public void setCoursePlanItems(Set<CoursePlanItem> coursePlanItems) {
		this.coursePlanItems = coursePlanItems;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getTeacID() {
		return teacID;
	}
	public void setTeacID(int teacID) {
		this.teacID = teacID;
	}
	public String getTeacName() {
		return teacName;
	}
	public void setTeacName(String teacName) {
		this.teacName = teacName;
	}
}
