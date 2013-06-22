package com.teachMng.onlineTech.autoplan;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.teachMng.onlineTeach.autoplan.AutoPlan;
import com.teachMng.onlineTeach.model.CoursePlanItem;

@ContextConfiguration(locations="classpath:applicationContext.xml")
public class AutoPlanTest extends AbstractJUnit4SpringContextTests {
	@Resource(name="autoPlan")
	AutoPlan ap;
	@Test
	public void testArrange() {
//		ap.deleteAll();
		long pre = System.currentTimeMillis();
		List<CoursePlanItem> coursePlan = ap.beginPlan();
		System.out.println("此次排课费时" + (System.currentTimeMillis() - pre) + "毫秒");
		//System.out.println(ap.status);
//		Iterator<CoursePlanItem> cpIter = coursePlan.iterator();
//		CoursePlanItem cpi = null;
//		while(cpIter.hasNext()) {
//			cpi = cpIter.next();
//			System.out.println(cpi.getCpParagraph() + "————————" + cpi.getClassRoom().getCrName());
//		}
		//ap.insToDB();

	}
}
