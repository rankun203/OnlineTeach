package com.teachMng.onlineTeach.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("createExercise")
public class CreateExercise extends ActionSupport implements ServletResponseAware{

	private HttpServletResponse response;
	private String createExerciseType;
	private String stdGrade;
	private String selCtn;
	private String selted;
	private String cplCtn;
	private String anstopic;
	private String anskw;
	private String jgtopic;
	private String judgeans;
	
	@Override
	public void setServletResponse(HttpServletResponse resp) {
		response = resp;
	}
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
