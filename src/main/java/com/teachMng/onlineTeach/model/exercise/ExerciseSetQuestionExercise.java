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
@Table(name="t_exerciseset_t_questionexercise")
public class ExerciseSetQuestionExercise implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 学生答题的答案<br>
	 */
	private String stuAnswer;
	/**
	 * 老师的意见
	 */
	private String teacherComment;
	/**
	 * 学生的得分
	 */
	private Double stuScore;
	private ExerciseSet es;
	private QuestionExercise qe;
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="qeID")	
	public QuestionExercise getQe() {
		return qe;
	}
	public void setQe(QuestionExercise qe) {
		this.qe = qe;
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
	public String getStuAnswer() {
		return stuAnswer;
	}
	public void setStuAnswer(String stuAnswer) {
		this.stuAnswer = stuAnswer;
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
