package com.teachMng.onlineTeach.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * desc:专业
 * */
@Entity
@Table(name="t_major")
public class Major {
	private int majorID;
	private String majorName;
	private Set<SchoolClass> schoolClasses;
	@OneToMany(mappedBy="major", cascade=CascadeType.ALL)
	public Set<SchoolClass> getSchoolClasses() {
		return schoolClasses;
	}
	public void setSchoolClasses(Set<SchoolClass> schoolClasses) {
		this.schoolClasses = schoolClasses;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getMajorID() {
		return majorID;
	}
	public void setMajorID(int majorID) {
		this.majorID = majorID;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
}
