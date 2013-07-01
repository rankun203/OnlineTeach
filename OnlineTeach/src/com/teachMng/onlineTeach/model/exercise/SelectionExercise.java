package com.teachMng.onlineTeach.model.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.teachMng.onlineTeach.model.UpFile;

/**
 * 选择题
 * @author mindfine
 */
@Entity
@Table(name="t_selectionexercise")
public class SelectionExercise {
	@Transient
	public static String spaceHolder = "@space@";
	@Transient
	public static String brHolder = "@br@";
	@Transient
	public static String imgHolder = "@img@";
	@Transient
	public static String hrHolder = "@hr@";

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
	 * 老师给出的答案<br>
	 * 字符：A、B、C、D
	 */
	private char stdAnswer;
	/**
	 * 满分的分数
	 */
	private double stdScore;
	private Set<ExerciseSet> es = new HashSet<ExerciseSet>();
	@ManyToMany(mappedBy="selectionExercise", cascade=CascadeType.ALL)
	public Set<ExerciseSet> getEs() {
		return es;
	}
	public void setEs(Set<ExerciseSet> es) {
		this.es = es;
	}
	@Column(length=4096)
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
	public char getStdAnswer() {
		return stdAnswer;
	}
	public void setStdAnswer(char stdAnswer) {
		this.stdAnswer = stdAnswer;
	}
	public double getStdScore() {
		return stdScore;
	}
	public void setStdScore(double stdScore) {
		this.stdScore = stdScore;
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
