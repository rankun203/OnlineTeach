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
 * FIXME 测试我，并添加Hibernate支持
 * 判断题的题目
 * 判断题模型：
 <ol>
 	<li>判断题只有答案，对或错</li>
 	<li>填空题有一个或多个附件</li>
 </ol><br>
 * @author mindfine
 */
public class IExerciseImplJudge implements IExercise {

	private long id;
	private String fullTopic;
	private List<UpFile> topicAttachments = new LinkedList<UpFile>();
	private List<Teacher> belongToTeachers;
	private Teacher origin;
	private boolean answer;
	
	/**
	 * 设置答案
	 * @param answer 要设置的答案
	 */
	public void setAnswer(boolean answer){
		this.answer = answer;
	}
	/**
	 * 读取答案
	 * @return boolean值，表示答案的对错
	 */
	public boolean getAnswer(){
		return answer;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "" + answer;
	}

	/* (non-Javadoc)
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
	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#setOrigin(com.teachMng.onlineTeach.model.Teacher)
	 */
	@Override
	public void setOrigin(Teacher origin) {
		this.origin = origin;
	}

	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#getOrigin()
	 */
	@Override
	public Teacher getOrigin() {
		return origin;
	}
	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#addBelongTeacher(com.teachMng.onlineTeach.model.Teacher)
	 */
	@Override
	public void addBelongTeacher(Teacher teacher){
		belongToTeachers.add(teacher);
	}
	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#getAuthorizedTeachers()
	 */
	@Override
	public List<Teacher> getAuthorizedTeachers(){
		return belongToTeachers;
	}
	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#getFullTopic()
	 */
	@Override
	public String getFullTopic() {
		return fullTopic;
	}

	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.exercise.IExercise#setFullTopic(java.lang.String)
	 */
	@Override
	public void setFullTopic(String fullTopic) {
		this.fullTopic = fullTopic;
	}
	/**
	 * 给题目添加一个附件
	 */
	public void addTopicAttachments(UpFile file){
		topicAttachments.add(file);
	}
	/**
	 * 获取所有题目的附件
	 * @return 附件链表
	 */
	public List<UpFile> getTopicAttachments(){
		return topicAttachments;
	}

}
