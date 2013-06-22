package com.teachMng.onlineTeach.action;

import com.opensymphony.xwork2.ActionSupport;
import com.teachMng.onlineTeach.autoplan.AutoPlan;

public class AutoPlanAction extends ActionSupport{

	/**
	 * 定义一个线程引用，保存排课线程
	 */
	Thread apt;
	AutoPlan ap;
	public String start(){
		
		return SUCCESS;
	}
	
}
