package com.teachMng.onlineTeach.autoplan;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.teachMng.onlineTeach.model.CoursePlanItem;
import com.teachMng.onlineTeach.service.IExerciseSetService;

@ContextConfiguration(locations="classpath:applicationContext.xml")
@Ignore
public class AutoPlanTest extends AbstractJUnit4SpringContextTests {
	@Resource(name="autoPlan")
	AutoPlan ap;
	@Resource(name="exerciseSetService")
	IExerciseSetService ess;
	@SuppressWarnings("unused")
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
	public void testExerciseSet() {
		ess.getExerciseSet(2);
	}
}
