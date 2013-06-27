package com.teachMng.onlineTeach.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * desc:教室
 * */
@Entity
@Table(name="t_classroom")
public class ClassRoom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int crID;
	private String crName;
	private Set<CoursePlanItem> coursePlanItem = new HashSet<CoursePlanItem>();
	private int crType;
	
	@OneToMany(mappedBy="classRoom", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	public Set<CoursePlanItem> getCoursePlanItem() {
		return coursePlanItem;
	}
	public void setCoursePlanItem(Set<CoursePlanItem> coursePlanItem) {
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
