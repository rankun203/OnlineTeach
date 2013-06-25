package com.teachMng.onlineTeach.model.topicImpl;

import java.util.LinkedList;
import java.util.List;

import com.teachMng.onlineTeach.model.ITopic;
import com.teachMng.onlineTeach.model.UpFile;

/**
 * FIXME 测试我，并添加Hibernate支持
 * 问答题的题目<br>
 * 问答题模型：
 <ol>
 	<li>问答题只有一段题目描述</li>
 	<li>问答题有一个或多个附件</li>
 </ol><br>
 * @author mindfine
 */
public class QuestionTopic implements ITopic {
	
	private String fullTopic;
	private List<UpFile> attachments = new LinkedList<UpFile>();

	/**
	 * 添加一个附件
	 */
	public void addAttachmentss(UpFile file){
		attachments.add(file);
	}
	/**
	 * 获取所有的附件
	 * @return 附件链表
	 */
	public List<UpFile> getAttachments(){
		return attachments;
	}
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
