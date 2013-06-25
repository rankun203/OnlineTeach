package com.teachMng.onlineTeach.model.topicImpl;

import java.util.LinkedList;
import java.util.List;

import com.teachMng.onlineTeach.model.ITopic;
import com.teachMng.onlineTeach.model.UpFile;

/**
 * FIXME 测试我，并添加Hibernate支持
 * 选择题的题目<br>
 * 选择题模型：
 <ol>
 	<li>选择题只有一个空，在题目的某个位置</li>
 	<li>选择题有一个或多个附件</li>
 </ol><br>
 * 空格的位置在<b>#!space!#</b>占位符的位置。
 * @author mindfine
 */
public class SelectionTopic implements ITopic {
	
	private String fullTopic;
	private List<String> selection = new LinkedList<String>();
	private List<UpFile> attachments = new LinkedList<UpFile>();
	private int spaceCounts;

	
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

		int index = 0;
		while(true){
			index = fullTopic.indexOf(spaceHolder, index);
			if(-1 == index)	break;
			index += 9;
			spaceCounts++;
		}
}

	/**
	 * 获取所有的选项集合
	 * @return 选项的集合
	 */
	public List<String> getSelection() {
		return selection;
	}

	/**
	 * 添加一个选项<br>
	 * @param item {@link java.lang.String}类型的数据,代表一个选项
	 */
	public void addSelection(String item) {
		selection.add(item);
	}

	/**
	 * 获取题目中含有的空格数
	 * @return int类型的数，表示题目中含有空格的数量
	 */
	public int getSpaceCount(){
		return spaceCounts;
	}

}
