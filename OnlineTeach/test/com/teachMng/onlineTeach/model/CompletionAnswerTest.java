package com.teachMng.onlineTeach.model;

import org.junit.Test;

import com.teachMng.onlineTeach.model.answerImpl.CompletionAnswer;

public class CompletionAnswerTest {

	@Test
	public void test(){
		CompletionAnswer answer = new CompletionAnswer();
		answer.addAnswer("经常性，习惯性");
		answer.addAnswer("一起来");
		
		System.out.println(answer);
	}
}
