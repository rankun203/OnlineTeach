package com.teachMng.onlineTeach.model.answerImpl;

import com.teachMng.onlineTeach.model.IAnswer;

public class SelectionAnswer implements IAnswer {
	
	private Selection selected;
	private enum Selection{
		A,
		B,
		C,
		D
	}

	
	/**
	 * 读取选项
	 */
	public Selection getSelected() {
		return selected;
	}
	
	/**
	 * 设置选项
	 * @param selected 设置的选项
	 */
	public void setSelected(Selection selected) {
		this.selected = selected;
	}
	
	/* (non-Javadoc)
	 * @see com.teachMng.onlineTeach.model.IAnswer#desc()
	 */
	@Override
	public String desc() {
		return "" + selected;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return desc();
	}

}
