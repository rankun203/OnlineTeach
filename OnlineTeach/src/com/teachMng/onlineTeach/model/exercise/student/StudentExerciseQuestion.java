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
public class StudentExerciseQuestion implements IExerciseStudent {

	private long id;
	private String answerStr;
	private List<UpFile> answerAttachments = new LinkedList<UpFile>();
	private IExerciseTeacher originExercise;

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
	 * @see
	 * com.teachMng.onlineTeach.model.exercise.IExerciseStudent#getOriginExercise
	 * ()
	 */
	@Override
	public IExerciseTeacher getOriginExercise() {
		return originExercise;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teachMng.onlineTeach.model.exercise.IExerciseStudent#setOriginExercise
	 * (com.teachMng.onlineTeach.model.exercise.IExerciseTeacher)
	 */
	@Override
	public void setOriginExercise(IExerciseTeacher originExercise) {
		this.originExercise = originExercise;
	}

}
