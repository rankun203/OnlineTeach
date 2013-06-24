package com.teachMng.onlineTeach.model;

import java.util.List;

/**
 * @author mindfine
 */
public class GeneralExercises {
	private long id;
	private String name;
	private List<Teacher> belongToTeachers;
	private Teacher origin;
	private IAnswer answer;
	private ITopic topic;
	/**
	 * 获取当前题目的内容
	 * @return 题目对象 {@link com.teachMng.onlineTeach.model.ITopic}
	 */
	public ITopic getTopic() {
		return topic;
	}

	/**
	 * @param topic
	 */
	public void setTopic(ITopic topic) {
		this.topic = topic;
	}

	/**
	 * 获取题目的名称
	 * @return 题目的名称字符串
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取题目的id
	 * @return 题目的id
	 */
	public long getId() {
		return id;
	}
	/**
	 * 指定该题的创建者
	 * @param origin 创建该题的老师
	 */
	public void setOrigin(Teacher origin) {
		this.origin = origin;
	}

	/**
	 * 获得创建该题的老师
	 * @return 创建该题的老师
	 */
	public Teacher getOrigin() {
		return origin;
	}

	/**
	 * 得到该题的答案
	 * @return IAnswer类型的答案
	 */
	public IAnswer getAnswer() {
		return answer;
	}

	/**
	 * 设置该题的答案
	 * @param answer IAnswer类型的答案
	 */
	public void setAnswer(IAnswer answer) {
		this.answer = answer;
	}
	/**
	 * 添加一个拥有该题的老师
	 * @param teacher
	 */
	public void addBelongTeacher(Teacher teacher){
		belongToTeachers.add(teacher);
	}
	/**
	 * 返回拥有该题的老师
	 * @return 拥有该体的老师的集合
	 */
	public List<Teacher> getAuthorizedTeachers(){
		return belongToTeachers;
	}

}
