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
//	private Set<ExerciseSet> es = new HashSet<ExerciseSet>();
//	@ManyToMany(mappedBy="judgeExercise", cascade=CascadeType.ALL)
//	public Set<ExerciseSet> getEs() {
//		return es;
//	}
//	public void setEs(Set<ExerciseSet> es) {
//		this.es = es;
//	}
	private List<ExerciseSetJudgeExercise> esje = new ArrayList<ExerciseSetJudgeExercise>();
	@OneToMany(mappedBy="es", cascade=CascadeType.ALL)
	public List<ExerciseSetJudgeExercise> getEsje() {
		return esje;
	}
	public void setEsje(List<ExerciseSetJudgeExercise> esje) {
		this.esje = esje;
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
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
