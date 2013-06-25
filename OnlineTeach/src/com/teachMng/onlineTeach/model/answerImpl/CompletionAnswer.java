package com.teachMng.onlineTeach.model.answerImpl;

import java.util.LinkedList;
import java.util.List;

import com.teachMng.onlineTeach.model.IAnswer;

public class CompletionAnswer implements IAnswer {
	
	private List<String> answers = new LinkedList<String>();

	/**
	 * 添加一个答案，按顺序依次为题目答案的第一个空、第二个空……
	 * @param answer 答案
	 */
	public void addAnswer(String answer){
		this.answers.add(answer);
	}
	/**
	 * 获取答案，如果要获取答案的描述，请调用 @See {@link com.teachMng.onlineTeach.model.answerImpl.CompletionAnswer#desc()}
	 * @return 答案集
	 */
	public List<String> getAnswers(){
		return answers;
	}
	
	@Override
	public String desc() {
		String desc = "";
		for(int i = 1; i <= answers.size(); i++){
			desc += "第" + i + "空：" + answers.get(i - 1) + "；";
		}
		return desc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return desc();
	}

}
