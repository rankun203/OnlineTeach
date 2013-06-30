package com.teachMng.onlineTeach.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.teachMng.onlineTeach.model.exercise.ExerciseSet;
import com.teachMng.onlineTeach.service.IExerciseSetService;

@Component("exsGoAction")
public class ExerciseGoAction extends ActionSupport{
	IExerciseSetService ess;
	
	/**
	 * 学生获取自己的练习题
	 */
	public void getMyExercises(){
		List<ExerciseSet> esList = ess.allExerciseSet();
	}
	public void generateExerciseSet(){
		
	}
	/**
	 * 教师给班级分配题目集
	 	{
			classId	:	班级编号,
			exs		:	["题目ID1","题目ID2","题目ID3"]
		}
	 */
	public void assignment(){
	}

	public IExerciseSetService getEss() {
		return ess;
	}
	@Resource(name="exerciseSetService")
	public void setEss(IExerciseSetService ess) {
		this.ess = ess;
	}
}
