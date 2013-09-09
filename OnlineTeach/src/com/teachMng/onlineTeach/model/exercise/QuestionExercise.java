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
 * 问答题
 * 
 * @author mindfine
 */
@Entity
@Table(name = "t_questionexercise")
public class QuestionExercise {
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
	 * 老师给出的答案的关键字<br>
	 */
	private String stdKeyword;
	/**
	 * 满分的分数
	 */
	private double stdScore;

	// private Set<ExerciseSet> es = new HashSet<ExerciseSet>();
	// @ManyToMany(mappedBy="questionExercise", cascade=CascadeType.ALL)
	// public Set<ExerciseSet> getEs() {
	// return es;
	// }
	// public void setEs(Set<ExerciseSet> es) {
	// this.es = es;
	// }
	private List<ExerciseSetQuestionExercise> esqe = new ArrayList<ExerciseSetQuestionExercise>();

	@OneToMany(mappedBy = "es", cascade = CascadeType.ALL)
	public List<ExerciseSetQuestionExercise> getEsqe() {
		return esqe;
	}

	public void setEsqe(List<ExerciseSetQuestionExercise> esqe) {
		this.esqe = esqe;
	}

	@Column(length = 4096)
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

	@Column(length = 4096)
	public String getStdKeyword() {
		return stdKeyword;
	}

	public void setStdKeyword(String stdKeyword) {
		this.stdKeyword = stdKeyword;
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
