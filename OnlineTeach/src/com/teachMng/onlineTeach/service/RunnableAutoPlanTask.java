package com.teachMng.onlineTeach.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.autoplan.AutoPlan;
import com.teachMng.onlineTeach.util.Timer;

@Component("runnableAutoPlanTask")
public class RunnableAutoPlanTask implements Runnable{
	private AutoPlan ap;
	private Timer t;
	public RunnableAutoPlanTask(){
	}
	public String getInfoTag() {
		
		return ap.getInfoTag();
	}
	@Override
	public void run() {
		t = new Timer();
		ap.beginPlan();
		ap.insToDB();
		t.reset();
	}
	public double usedTime(){
		return t.total();
	}
	/**
	 * 取出消息队列中的所有消息
	 * @return 消息字符串
	 */
	public String pollMsg(){
		return ap.getMsg();
	}
	public double progressedPercent(){
		return ap.getProgress();
	}
	public void init(){
//		ap.deleteAll();
	}

	public AutoPlan getAp() {
		return ap;
	}

	@Resource(name="autoPlan")
	public void setAp(AutoPlan autoPlan) {
		this.ap = autoPlan;
	}
	
}