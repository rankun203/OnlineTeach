package com.teachMng.onlineTeach.model.exercise.student;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.teachMng.onlineTeach.model.UpFile;
import com.teachMng.onlineTeach.model.exercise.IExerciseStudent;
import com.teachMng.onlineTeach.model.exercise.IExerciseTeacher;

/**
 * @author mindfine
 */
public class StudentExerciseCompletion implements IExerciseStudent {

	private long id;
	private int spaceCounts;
	private List<UpFile> topicAttachments = new LinkedList<UpFile>();
	private List<String> answers = new LinkedList<String>();
	private IExerciseTeacher originExercise;

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

	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExerciseStudent#getOriginExercise()
	 */
	@Override
	public IExerciseTeacher getOriginExercise() {
		return originExercise;
	}

	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExerciseStudent#setOriginExercise(com.teachMng.onlineTeach.model.exercise.IExerciseTeacher)
	 */
	@Override
	public void setOriginExercise(IExerciseTeacher originExercise) {
		this.originExercise = originExercise;
	}

}
