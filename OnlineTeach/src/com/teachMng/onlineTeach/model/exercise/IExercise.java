package com.teachMng.onlineTeach.model.exercise;

import java.util.List;

import com.teachMng.onlineTeach.model.Teacher;

public interface IExercise {
	public String spaceHolder = "#!space!#";

	/**
	 * 返回题目的内容
	 * @return 题目的内容
	 */
	public String getFullTopic();
	
	/**
	 * 设置题目的内容
	 * @param fullTopic 题目的内容
	 */
	public void setFullTopic(String fullTopic);
	/**
	 * 获取题目的id
	 * @return 题目的id
	 */
	public long getId();
	/**
	 * 设置题目的id
	 * @return 题目的id
	 */
	public void setId(int id);
	/**
	 * 指定该题的创建者
	 * @param origin 创建该题的老师
	 */
	public void setOrigin(Teacher origin);

	/**
	 * 读取创建该题的老师
	 * @return 创建该题的老师
	 */
	public Teacher getOrigin();

	/**
	 * 添加一个拥有该题的老师
	 * @param teacher
	 */
	public void addBelongTeacher(Teacher teacher);
	
	/**
	 * 返回拥有该题的老师
	 * @return 拥有该体的老师的集合
	 */
	public List<Teacher> getAuthorizedTeachers();

}
