package com.teachMng.onlineTeach.service;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.autoplan.AutoPlan;
import com.teachMng.onlineTeach.dto.InfoTagItem;
import com.teachMng.onlineTeach.util.Timer;

@Component("runnableAutoPlanTask")
public class RunnableAutoPlanTask implements Runnable{
	private AutoPlan ap;
	private Timer t;
	public RunnableAutoPlanTask(){
	}
	public String getCoursePlanBysName(String sType, String sName) {
		if("sbClass".equals(sType)) {
			return "{coursePlan:[" + ap.getClassStringById(Integer.parseInt(sName)) + "]}";
		} else if("sbTeacher".equals(sType)) {
			return "{coursePlan:[" + ap.getTeacherStringById(Integer.parseInt(sName)) + "]}";
		} else if("sbRoom".equals(sType)) {
			System.out.println("hello");
			return "{coursePlan:[" + ap.getRoomStringById(Integer.parseInt(sName)) + "]}";
		}
		return null;
	}
	public String getInfoTag() {
		return ap.getInfoTag();
	}
	public String getSelectList(String sType) {
		if("sbClass".equals(sType)) {
			System.out.println("sbClass");
			return ap.getClassList();
		} else if("sbTeacher".equals(sType)) {
			System.out.println("sbTeacher");
			return ap.getTeacherList();
		} else if("sbRoom".equals(sType)) {
			System.out.println("sbRoom");
			return ap.getRoomList();
		}
		return null;
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
	 * @return
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