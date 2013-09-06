package com.teachMng.onlineTeach.model.exercise;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_exerciseset_t_judgeexercise")
public class ExerciseSetJudgeExercise implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 学生答题的答案，答案是“对”？？？
	 */	
	private boolean stuAnswerIsRight;
	/**
	 * 老师的意见
	 */
	private String teacherComment;
	/**
	 * 学生的得分
	 */
	private double stuScore;
	private ExerciseSet es;
	private JudgeExercise je;
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="jeID")	
	public JudgeExercise getJe() {
		return je;
	}
	public void setJe(JudgeExercise je) {
		this.je = je;
	}
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="esID")
	public ExerciseSet getEs() {
		return es;
	}
	public void setEs(ExerciseSet es) {
		this.es = es;
	}	
	@Column(nullable=true)
	public boolean isStuAnswerIsRight() {
		return stuAnswerIsRight;
	}
	public void setStuAnswerIsRight(boolean stuAnswerIsRight) {
		this.stuAnswerIsRight = stuAnswerIsRight;
	}
	@Column(nullable=true)
	public String getTeacherComment() {
		return teacherComment;
	}
	public void setTeacherComment(String teacherComment) {
		this.teacherComment = teacherComment;
	}
	@Column(nullable=true)
	public double getStuScore() {
		return stuScore;
	}
	public void setStuScore(double stuScore) {
		this.stuScore = stuScore;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
