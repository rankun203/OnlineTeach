package com.teachMng.onlineTeach.model.exercise;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.teachMng.onlineTeach.model.UpFile;

/**
 * 填空题
 * @author mindfine
 */
@Entity
@Table(name="t_completionexercise")
public class CompletionExercise {
	/**
	 * 标识符
	 */
	private long id;
	/**
	 * 题目的内容
	 */
	private String fullTopic;
	/**
	 * 有几个空
	 */
	private int spaceCounts;
	/**
	 * 题目自身包含的附件
	 */
	private List<UpFile> topicAttachments = new LinkedList<UpFile>();
	/**
	 * 回答问题时贴的附件
	 */
	private List<UpFile> answerAttachments = new LinkedList<UpFile>();
	/**
	 * 满分的分数
	 */
	private double stdScore;
	/**
	 * 老师给出的答案<br>
	 * 每个空之间用#!split!#隔开
	 */
	private String stdAnswer;
	/**
	 * 学生答题的答案<br>
	 * 每个空之间用#!split!#隔开
	 */
	private String stuAnswer;
	/**
	 * 老师的意见
	 */
	private String teacherComment;
	/**
	 * 学生的得分
	 */
	private double stuScore;

	
	
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullTopic() {
		return fullTopic;
	}
	public void setFullTopic(String fullTopic) {
		this.fullTopic = fullTopic;
	}
	public int getSpaceCounts() {
		return spaceCounts;
	}
	public void setSpaceCounts(int spaceCounts) {
		this.spaceCounts = spaceCounts;
	}
	@OneToMany
	public List<UpFile> getTopicAttachments() {
		return topicAttachments;
	}
	public void setTopicAttachments(List<UpFile> topicAttachments) {
		this.topicAttachments = topicAttachments;
	}
	@OneToMany
	public List<UpFile> getAnswerAttachments() {
		return answerAttachments;
	}
	public void setAnswerAttachments(List<UpFile> answerAttachments) {
		this.answerAttachments = answerAttachments;
	}
	public double getStdScore() {
		return stdScore;
	}
	public void setStdScore(double stdScore) {
		this.stdScore = stdScore;
	}
	public String getStdAnswer() {
		return stdAnswer;
	}
	public void setStdAnswer(String stdAnswer) {
		this.stdAnswer = stdAnswer;
	}
	public String getStuAnswer() {
		return stuAnswer;
	}
	public void setStuAnswer(String stuAnswer) {
		this.stuAnswer = stuAnswer;
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

}
