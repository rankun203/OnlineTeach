package com.teachMng.onlineTeach.model.topicImpl;

import com.teachMng.onlineTeach.model.ITopic;

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
public class JudgeTopic implements ITopic {
	
	private String fullTopic;

	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.ITopic#getFullTopic()
	 */
	@Override
	public String getFullTopic() {
		return fullTopic;
	}

	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.ITopic#setFullTopic(java.lang.String)
	 */
	@Override
	public void setFullTopic(String fullTopic) {
		this.fullTopic = fullTopic;
	}
	

}
