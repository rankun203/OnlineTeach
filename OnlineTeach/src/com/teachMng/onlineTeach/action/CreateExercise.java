package com.teachMng.onlineTeach.action;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("createExercise")
public class CreateExercise extends ActionSupport {

	private String createExerciseType;
	private String stdGrade;
	private String selCtn;
	private String selted;
	private String cplCtn;
	private String anstopic;
	private String anskw;
	private String jgtopic;
	private String judgeans;
	
	public String success(){
		return SUCCESS;
	}
	
	public void newOne(){
		System.out.println("createExerciseType:" + createExerciseType);
		System.out.println("stdGrade:" + stdGrade);
		System.out.println("selCtn:" + selCtn);
		System.out.println("selted:" + selted);
		System.out.println("cplCtn:" + stdGrade);
		System.out.println("anstopic:" + anstopic);
		System.out.println("anskw:" + anskw);
		System.out.println("jgtopic:" + jgtopic);
		System.out.println("judgeans:" + judgeans);
		
		//题目们的service & dao...存储之
/*
		TODO 遗留创建题目功能
		TODO 学生答题功能
		TODO 教师的答题动态更新功能		
*/		
		if(createExerciseType!=null&&!createExerciseType.equals("")){
			if(createExerciseType.equals("selectionExercise")){
/*
					stdGrade:stdGrade,
					selCtn:selCtn,
					selted:selted
*/			
			} else if (createExerciseType.equals("completionExercise")) {
/*
					stdGrade:stdGrade,
					cplCtn:cplCtn
*/			
				
			} else if (createExerciseType.equals("answerExercise")) {
/*
					createExerciseType:createExerciseType,
					stdGrade:stdGrade,
					anstopic:anstopic,
					anskw:anskw
*/			
				
			} else if (createExerciseType.equals("judgeExercise")) {
/*
					createExerciseType:createExerciseType,
					stdGrade:stdGrade,
					jgtopic:jgtopic
*/			
				
			}
		}
		
	}
	public String getCreateExerciseType() {
		return createExerciseType;
	}
	public void setCreateExerciseType(String createExerciseType) {
		this.createExerciseType = createExerciseType;
	}
	public String getStdGrade() {
		return stdGrade;
	}
	public void setStdGrade(String stdGrade) {
		this.stdGrade = stdGrade;
	}
	public String getSelCtn() {
		return selCtn;
	}
	public void setSelCtn(String selCtn) {
		this.selCtn = selCtn;
	}
	public String getSelted() {
		return selted;
	}
	public void setSelted(String selted) {
		this.selted = selted;
	}
	public String getCplCtn() {
		return cplCtn;
	}
	public void setCplCtn(String cplCtn) {
		this.cplCtn = cplCtn;
	}
	public String getAnstopic() {
		return anstopic;
	}
	public void setAnstopic(String anstopic) {
		this.anstopic = anstopic;
	}
	public String getAnskw() {
		return anskw;
	}
	public void setAnskw(String anskw) {
		this.anskw = anskw;
	}
	public String getJgtopic() {
		return jgtopic;
	}
	public void setJgtopic(String jgtopic) {
		this.jgtopic = jgtopic;
	}
	public String getJudgeans() {
		return judgeans;
	}
	public void setJudgeans(String judgeans) {
		this.judgeans = judgeans;
	};

}
