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
	private Boolean stuAnswerIsRight;
	/**
	 * 老师的意见
	 */
	private String teacherComment;
	/**
	 * 学生的得分
	 */
	private Double stuScore;
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
	public Boolean isStuAnswerIsRight() {
		return stuAnswerIsRight;
	}
	public void setStuAnswerIsRight(Boolean stuAnswerIsRight) {
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
	public Double getStuScore() {
		return stuScore;
	}
	public void setStuScore(Double stuScore) {
		this.stuScore = stuScore;
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
