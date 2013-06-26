package com.teachMng.onlineTeach.model;

import org.junit.Test;

import com.teachMng.onlineTeach.model.exercise.IExerciseTeacher;
import com.teachMng.onlineTeach.model.exercise.student.StudentExerciseCompletion;
import com.teachMng.onlineTeach.model.exercise.teacher.IExerciseImplCompletion;

public class IExerciseTest {
	
	@Test
	public void teacherCompletionTest(){
		IExerciseImplCompletion te1 = new IExerciseImplCompletion();
		te1.setFullTopic("下列框图中的字母分别代表一种常见的物质或其溶液，相互之间的转化关系如下图所示（部分产物及反应条件已略去）。已知A、B为气态单质，F是地壳中含量最多的金属元素的单质；E、H、I为氧化物，E为黑色固体，I为红棕色气体；M为红褐色沉淀。#!newline!#请回答下列问题：#!newline!#（1）B中所含元素位于周期表中第#!space!#周期，#!space!#族。#!newline!#（2）A在B中燃烧的现象是#!space!#。#!newline!#（3） 的反应中，被氧化与被还原的物质的物质的量比是#!space!# 。#!newline!#（4） G+J→的离子方程式是#!space!# 。#!newline!#（5） Y受热分解的化学方程式是#!space!#。");
		te1.setStdScore(5.0);
		te1.addAnswer("标准答案一");
		te1.addAnswer("标准答案二");
		te1.addAnswer("标准答案三");
		te1.addAnswer("标准答案四");
		te1.addAnswer("标准答案五");
		te1.addAnswer("标准答案六");
		
		StudentExerciseCompletion sec1 = new StudentExerciseCompletion();
		sec1.setOriginExercise(te1);
		sec1.addAnswer("我的答案1");
		sec1.addAnswer("我的答案2");
		sec1.addAnswer("我的答案3");
		sec1.addAnswer("我的答案4");
		sec1.addAnswer("我的答案5");
		sec1.addAnswer("我的答案6");

		sec1.setScore(5);
		sec1.setTeacherComment("你个2B，这么简单的题都会做错，第一个空明显不是“我的答案1！！！”");

		System.out.println("题目：\r\n" + te1.getFullTopic().replaceAll(IExerciseTeacher.spaceHolder, "_______").replaceAll(IExerciseTeacher.newLineHolder, "\r\n"));
		System.out.println("老师的答案：");
		for(String s : te1.getAnswers())
			System.out.println(s);
		System.out.println("-------------");
		System.out.println("我的答案：");
		for(String s : sec1.getAnswers())
			System.out.println(s);
		System.out.println("老师给了我" + sec1.getScore() + "分，并对我说：" + sec1.getTeacherComment());
		
	}

}
