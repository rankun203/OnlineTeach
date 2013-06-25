package com.teachMng.onlineTeach.model.exercise.teacher;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.teachMng.onlineTeach.model.Teacher;
import com.teachMng.onlineTeach.model.UpFile;
import com.teachMng.onlineTeach.model.exercise.IExerciseTeacher;

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
public class IExerciseImplQuestion implements IExerciseTeacher {

	private long id;
	private String fullTopic;
	private List<UpFile> topicAttachments = new LinkedList<UpFile>();
	private String answerStr;
	private List<UpFile> answerAttachments = new LinkedList<UpFile>();
	private List<Teacher> belongToTeachers;
	private Teacher origin;
	private double stdScore;

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

	@Override
	public String toString() {
		return answerStr;
	}

	@Override
	public String getFullTopic() {
		return fullTopic;
	}

	@Override
	public void setFullTopic(String fullTopic) {
		this.fullTopic = fullTopic;
	}

	@Override
	public void setOrigin(Teacher origin) {
		this.origin = origin;
	}

	@Override
	public Teacher getOrigin() {
		return origin;
	}

	@Override
	public void addBelongTeacher(Teacher teacher) {
		belongToTeachers.add(teacher);
	}

	@Override
	public List<Teacher> getAuthorizedTeachers() {
		return belongToTeachers;
	}
	@Override
	public double getStdScore() {
		return stdScore;
	}

	@Override
	public void setStdScore(double stdScore) {
		this.stdScore = stdScore;
	}

}
