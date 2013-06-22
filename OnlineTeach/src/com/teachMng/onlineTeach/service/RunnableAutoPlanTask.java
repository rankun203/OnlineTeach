package com.teachMng.onlineTeach.service;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.teachMng.onlineTeach.autoplan.AutoPlan;
import com.teachMng.onlineTeach.model.CoursePlanItem;

@Resource(name="autoPlan")
public class RunnableAutoPlanTask implements Runnable{
	AutoPlan ap;
	public RunnableAutoPlanTask(){
	}
	@Override
	public void run() {
		List<CoursePlanItem> coursePlan = ap.beginPlan();
		Iterator<CoursePlanItem> cpIter = coursePlan.iterator();
		CoursePlanItem cpi = null;
		while(cpIter.hasNext()) {
			cpi = cpIter.next();
			System.out.println(cpi.getCpParagraph() + "————————" + cpi.getClassRoom().getCrName());
		}
		ap.insToDB();//把结果插入数据库

	}
}