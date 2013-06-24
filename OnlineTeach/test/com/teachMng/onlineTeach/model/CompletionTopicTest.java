package com.teachMng.onlineTeach.model;

import org.junit.Test;

import com.teachMng.onlineTeach.model.topicImpl.CompletionTopic;

public class CompletionTopicTest {

	@Test
	public void test(){

		CompletionTopic topic = new CompletionTopic();
		topic.setFullTopic("static#!space!#有什么space用途？#!space!#，还有#!space!#");
		int i = topic.getSpaceCount();
		System.out.println("Topic: " + topic.getFullTopic());
		System.out.println("Topic has " + i + " spaces");
	}

}
