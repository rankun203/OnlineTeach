package com.teachMng.onlineTeach.model.exercise;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.teachMng.onlineTeach.model.UpFile;

/**
 * 判断题
 * 题是否做对：判断stdScore和stuScore是否相等
 * @author mindfine
 */
@Entity
@Table(name="t_judgeexercise")
public class JudgeExercise {
	/**
	 * 标识符
	 */
	private int id;
	/**
	 * 题目的内容
	 */
	private String fullTopic;
	/**
	 * 题目自身包含的附件
	 */
	private List<UpFile> topicAttachments = new ArrayList<UpFile>();
	/**
	 * 满分的分数
	 */
	private double stdScore;
	/**
	 * 老师给出的答案，答案是“对”？？？
	 */
	private boolean stdAnswerIsRight;
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
	
	
	public String getFullTopic() {
		return fullTopic;
	}
	public void setFullTopic(String fullTopic) {
		this.fullTopic = fullTopic;
	}
	@OneToMany
	public List<UpFile> getTopicAttachments() {
		return topicAttachments;
	}
	public void setTopicAttachments(List<UpFile> topicAttachments) {
		this.topicAttachments = topicAttachments;
	}
	public double getStdScore() {
		return stdScore;
	}
	public void setStdScore(double stdScore) {
		this.stdScore = stdScore;
	}
	public boolean isStdAnswerIsRight() {
		return stdAnswerIsRight;
	}
	public void setStdAnswerIsRight(boolean stdAnswerIsRight) {
		this.stdAnswerIsRight = stdAnswerIsRight;
	}
	public boolean isStuAnswerIsRight() {
		return stuAnswerIsRight;
	}
	public void setStuAnswerIsRight(boolean stuAnswerIsRight) {
		this.stuAnswerIsRight = stuAnswerIsRight;
	}
	public String getTeacherComment() {
		return teacherComment;
	}
	public void setTeacherComment(String teacherComment) {
		this.teacherComment = teacherComment;
	}
	public double getStuScore() {
		return stuScore;
	}
	public void setStuScore(double stuScore) {
		this.stuScore = stuScore;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
