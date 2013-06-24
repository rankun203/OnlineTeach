package com.teachMng.onlineTeach.model.answerImpl;

import java.util.LinkedList;
import java.util.List;

import com.teachMng.onlineTeach.model.IAnswer;
import com.teachMng.onlineTeach.model.UpFile;

public class QuestionAnswer implements IAnswer {
	private String answerStr;
	private List<UpFile> attachments = new LinkedList<UpFile>();
	
	/**
	 * 获得答案
	 * @return 答案
	 */
	public String getAnswerStr() {
		return answerStr;
	}
	/**
	 * 设置答案
	 * @param answerStr 答案内容
	 */
	public void setAnswerStr(String answerStr) {
		this.answerStr = answerStr;
	}
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
	 * @see com.teachMng.onlineTeach.model.IAnswer#desc()
	 */
	@Override
	public String desc() {
		return answerStr;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return desc();
	}
}
