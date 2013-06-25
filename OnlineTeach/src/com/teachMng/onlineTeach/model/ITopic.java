package com.teachMng.onlineTeach.model;

/**
 * 该接口用来表示题目的内容，包括选择题、问答题、填空题、判断题……等等
 * @author mindfine
 */
public interface ITopic {

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

}
