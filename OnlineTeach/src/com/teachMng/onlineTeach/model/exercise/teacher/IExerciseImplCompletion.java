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
 * FIXME 测试我，并添加Hibernate支持 老师的填空题<br>
 * 填空题模型：
 * <ol>
 * <li>填空题有一个或多个空</li>
 * <li>填空题有一个或多个附件</li>
 * </ol>
 * <br>
 * 空格的位置在<b>#!space!#</b>占位符的位置。
 * 
 * @author mindfine
 */
public class IExerciseImplCompletion implements IExerciseTeacher {

	private long id;
	private String fullTopic;
	private int spaceCounts;
	private List<UpFile> topicAttachments = new LinkedList<UpFile>();
	private List<String> answers = new LinkedList<String>();
	private List<Teacher> belongToTeachers;
	private Teacher origin;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#getId()
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

	/**
	 * 添加一个答案，按顺序依次为题目答案的第一个空、第二个空……
	 * 
	 * @param answer
	 *            答案
	 */
	public void addAnswer(String answer) {
		this.answers.add(answer);
	}

	/**
	 * 获取答案
	 * 
	 * @return 答案集
	 */
	public List<String> getAnswers() {
		return answers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#getFullTopic()
	 */
	@Override
	public String getFullTopic() {
		return fullTopic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teachMng.onlineTeach.model.exercise.IExercise#setFullTopic(java.lang
	 * .String)
	 */
	@Override
	public void setFullTopic(String fullTopic) {
		this.fullTopic = fullTopic;

		int index = 0;
		while (true) {
			index = fullTopic.indexOf(spaceHolder, index);
			if (-1 == index)
				break;
			index += 9;
			spaceCounts++;
		}
	}

	/**
	 * 给题目添加一个附件
	 */
	public void addTopicAttachments(UpFile file) {
		topicAttachments.add(file);
	}

	/**
	 * 获取所有题目的附件
	 * 
	 * @return 附件链表
	 */
	public List<UpFile> getTopicAttachments() {
		return topicAttachments;
	}

	/**
	 * 获取题目中含有的空格数
	 * 
	 * @return int类型的数，表示题目中含有空格的数量
	 */
	public int getSpaceCount() {
		return spaceCounts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String desc = "";
		for (int i = 1; i <= answers.size(); i++) {
			desc += "第" + i + "空：" + answers.get(i - 1) + "；";
		}
		return desc;
	}

}
