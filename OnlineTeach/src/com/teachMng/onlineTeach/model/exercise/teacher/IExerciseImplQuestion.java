package com.teachMng.onlineTeach.model.exercise.teacher;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.teachMng.onlineTeach.model.Teacher;
import com.teachMng.onlineTeach.model.UpFile;
import com.teachMng.onlineTeach.model.exercise.IExercise;

/**
 * FIXME 测试我，并添加Hibernate支持 问答题的题目<br>
 * 问答题模型：
 * <ol>
 * <li>问答题只有一段题目描述</li>
 * <li>问答题有一个或多个附件</li>
 * </ol>
 * <br>
 * 
 * @author mindfine
 */
public class IExerciseImplQuestion implements IExercise {

	private long id;
	private String fullTopic;
	private List<UpFile> topicAttachments = new LinkedList<UpFile>();
	private String answerStr;
	private List<UpFile> answerAttachments = new LinkedList<UpFile>();
	private List<Teacher> belongToTeachers;
	private Teacher origin;

	/**
	 * 获取题目的id
	 * 
	 * @return 题目的id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获得答案
	 * 
	 * @return 答案
	 */
	public String getAnswerStr() {
		return answerStr;
	}

	/**
	 * 设置答案
	 * 
	 * @param answerStr
	 *            答案内容
	 */
	public void setAnswerStr(String answerStr) {
		this.answerStr = answerStr;
	}

	/**
	 * 添加一个答题附件
	 * 
	 * @param file
	 *            要添加的文件（{@link com.teachMng.onlineTeach.model.UpFile}）
	 */
	public void addAnswerAttachment(UpFile file) {
		answerAttachments.add(file);
	}

	/**
	 * 获取所有答案的附件
	 * 
	 * @return 附件链表 {@link com.teachMng.onlineTeach.model.UpFile}
	 */
	public List<UpFile> getAnswerAttachments() {
		return answerAttachments;
	}

	/**
	 * 添加一个附件
	 */
	public void addAttachment(UpFile file) {
		topicAttachments.add(file);
	}

	/**
	 * 获取所有的附件
	 * 
	 * @return 附件链表
	 */
	public List<UpFile> getAttachments() {
		return topicAttachments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return answerStr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teachMng.onlineTeach.model.ITopic#getFullTopic()
	 */
	@Override
	public String getFullTopic() {
		return fullTopic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teachMng.onlineTeach.model.ITopic#setFullTopic(java.lang.String)
	 */
	@Override
	public void setFullTopic(String fullTopic) {
		this.fullTopic = fullTopic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teachMng.onlineTeach.model.exercise.IExercise#setOrigin(com.teachMng
	 * .onlineTeach.model.Teacher)
	 */
	@Override
	public void setOrigin(Teacher origin) {
		this.origin = origin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#getOrigin()
	 */
	@Override
	public Teacher getOrigin() {
		return origin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teachMng.onlineTeach.model.exercise.IExercise#addBelongTeacher(com
	 * .teachMng.onlineTeach.model.Teacher)
	 */
	@Override
	public void addBelongTeacher(Teacher teacher) {
		belongToTeachers.add(teacher);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teachMng.onlineTeach.model.exercise.IExercise#getAuthorizedTeachers()
	 */
	@Override
	public List<Teacher> getAuthorizedTeachers() {
		return belongToTeachers;
	}

}
