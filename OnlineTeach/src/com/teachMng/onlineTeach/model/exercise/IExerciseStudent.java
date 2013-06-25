package com.teachMng.onlineTeach.model.exercise;

/**
 * 老师布置题的时候，从TeacherExercise里面把每道题复制一份到学生题中，
 * 然后系统根据学生答题情况对题目进行作答，本接口只包含与学生作答相关的内容， 
 * 比如学生给出的答案，以及老师对本次作答做出的评价，这道题的题目信息等等（属于哪道教师题{@link IExerciseTeacher}）
 * 
 * @author mindfine
 */
public interface IExerciseStudent {

	/**
	 * 获取题目的id
	 * 
	 * @return 题目的id
	 */
	public long getId();

	/**
	 * 设置题目的id
	 */
	public void setId(int id);

	/**
	 * 获取这道学生题的教师题
	 * 
	 * @return 一道教师题{@link IExerciseTeacher}
	 */
	public IExerciseTeacher getOriginExercise();

	/**
	 * 设置该学生题的教师题
	 * 
	 * @param originExercise
	 *            教师题{@link IExerciseTeacher}
	 */
	public void setOriginExercise(IExerciseTeacher originExercise);
	/**
	 * 设置老师对该学生答的这道题的评价
	 * @param comment 评价内容
	 */
	public void setTeacherComment(String comment);
	/**
	 * 获得老师对本题的评价
	 * @return 评价内容
	 */
	public String getTeacherComment();
	/**
	 * 获得老师对本题的打分
	 * @return float类型的分数
	 */
	public double getScore();
	/**
	 * 给这道题打分
	 * @param score float类型的分数
	 */
	public void setScore(double score);
}
