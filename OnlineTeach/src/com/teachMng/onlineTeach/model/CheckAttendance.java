package com.teachMng.onlineTeach.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * desc:考勤
 * */
@Entity
@Table(name = "t_checkattendance")
public class CheckAttendance implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	int id;
/*	private int caAttendance;
	private TeachPlan teachPlan;
	private Student student;

	@Column(nullable = true)
	public int getCaAttendance() {
		return caAttendance;
	}

	public void setCaAttendance(int caAttendance) {
		this.caAttendance = caAttendance;
	}

	//@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "tpCourseTime"),
		@JoinColumn(name = "coursePlanItem")
	})
	public TeachPlan getTeachPlan() {
		return teachPlan;
	}

	public void setTeachPlan(TeachPlan teachPlan) {
		this.teachPlan = teachPlan;
	}

	//@Id
	@ManyToOne
	@JoinColumn(name = "stuID")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}*/
}
