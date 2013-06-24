package com.teachMng.onlineTeach.model.answerImpl;

import com.teachMng.onlineTeach.model.IAnswer;

public class JudgeAnswer implements IAnswer {

	private boolean answer;
	
	@Override
	public String desc() {
		return "" + answer;
	}
	/**
	 * 设置答案
	 * @param answer 要设置的答案
	 */
	public void setAnswer(boolean answer){
		this.answer = answer;
	}
	/**
	 * 读取答案
	 * @return boolean值，表示答案的对错
	 */
	public boolean getAnswer(){
		return answer;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return desc();
	}

}
