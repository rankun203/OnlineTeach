package com.teachMng.onlineTeach.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * desc:课程表原子，一周总共有84条课程表原子记录。
 * */
@Entity
@Table(name="t_courseplanitem")
public class CoursePlanItem implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cpID;
	private int cpParagraph;
	private int cpState;
	private ClassRoom classRoom;
	private Course course;
	private SchoolClass schoolClass;
	private Teacher teacher;
	
	/*课程表原子与教师的多对一关系*/
	@ManyToOne(cascade=CascadeType.REMOVE) 
	@JoinColumn(name="teacID")
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	/*课程表原子与班级的多对一关系*/
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="scID")
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	/*课程表原子与课程的一对一关系*/
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="courseID")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	/*课程表原子与教室的一对一关系。*/
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="crID")
	public ClassRoom getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCpID() {
		return cpID;
	}
	public void setCpID(int cpID) {
		this.cpID = cpID;
	}
	@Column(nullable = true)
	public int getCpParagraph() {
		return cpParagraph;
	}
	public void setCpParagraph(int cpParagraph) {
		this.cpParagraph = cpParagraph;
	}
	@Column(nullable = true)
	public int getCpState() {
		return cpState;
	}
	public void setCpState(int cpState) {
		this.cpState = cpState;
	}
}
