package com.teachMng.onlineTeach.model.exercise;


public interface IExerciseStudent {

	/**
	 * 获取题目的id
	 * @return 题目的id
	 */
	public long getId();
	/**
	 * 设置题目的id
	 */
	public void setId(int id);
	
	/**
	 * 获取这道学生题的教师题
	 * @return 一道教师题{@link IExerciseTeacher}
	 */
	public IExerciseTeacher getOriginExercise();
	/**
	 * 设置该学生题的教师题
	 * @param originExercise 教师题{@link IExerciseTeacher}
	 */
	public void setOriginExercise(IExerciseTeacher originExercise);
}
