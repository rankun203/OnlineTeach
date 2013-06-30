package com.teachMng.onlineTeach.model.exercise;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.teachMng.onlineTeach.model.UpFile;

/**
 * 填空题
 * 添加答案的时候，先把答案取出去，再添加一个进去，再set回来。
 * @author mindfine
 */
@Entity
@Table(name="t_completionexercise")
public class CompletionExercise {
	@Transient
	public static String spaceHolder = "@space@";
	@Transient
	public static String brHolder = "@br@";
	@Transient
	public static String imgHolder = "@img@";

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
	 * 回答问题时贴的附件
	 */
	private List<UpFile> answerAttachments = new ArrayList<UpFile>();
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

	
	
	@Column(length=4096)
	public String getFullTopic() {
		return fullTopic;
	}
	public void setFullTopic(String fullTopic) {
		this.fullTopic = fullTopic;
	}
	@Transient
	public int getSpaceCounts() {
		int spaceCounts = 0;
		int curTemp = 0;
		while(curTemp != -1){
			curTemp = fullTopic.indexOf(CompletionExercise.spaceHolder, 
					curTemp + spaceHolder.length());
			spaceCounts++;
		}
		return spaceCounts;
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
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
