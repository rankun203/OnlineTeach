package com.teachMng.onlineTeach.autoplan;

import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.teachMng.onlineTeach.autoplan.CoursePlanUtil;
import com.teachMng.onlineTeach.dto.ClassCoursePlanPara;
import com.teachMng.onlineTeach.dto.RoomCoursePlanPara;
import com.teachMng.onlineTeach.dto.TeacherCoursePlanPara;

@ContextConfiguration(locations="classpath:applicationContext.xml")
public class CorusePlanUtil extends AbstractJUnit4SpringContextTests {
	@Resource(name="coursePlanUtil")
	CoursePlanUtil cpu;
	@Test
	public void getClassCoursePlan() {          //获取班级课表
		Set<ClassCoursePlanPara> cpps = cpu.getClassCoursePlanByClassId(1);
		Iterator<ClassCoursePlanPara> cppIter = cpps.iterator();
		ClassCoursePlanPara cpp = null;
		System.out.println("课程名称        教室名称        教师名称        第几节课");
		while(cppIter.hasNext()) {
			cpp = cppIter.next();
			System.out.println(cpp.getCourseName() + "        " + cpp.getRoomName() + "        " + cpp.getTeacherName() + "        " + cpp.getParagraph());
		}
	}
	@Test
	public void getTeacherCoursePlan() {   //获取教师课表
		Set<TeacherCoursePlanPara> cpps = cpu.getTeacherCoursePlanByTeacherId(1);
		Iterator<TeacherCoursePlanPara> cppIter = cpps.iterator();
		TeacherCoursePlanPara cpp = null;
		System.out.println("课程名称        教室名称        班级名称        第几节课");
		while(cppIter.hasNext()) {
			cpp = cppIter.next();
			System.out.println(cpp.getCourseName() + "        " + cpp.getRoomName() + "        " + cpp.getMajorName() + cpp.getClassName() + "        " + cpp.getParagraph());
		}	
	}
	@Test
	public void getRoomCoursePlan() {   //获取教室课表
		Set<RoomCoursePlanPara> cpps = cpu.getRoomCoursePlanByRoomId(1);
		Iterator<RoomCoursePlanPara> cppIter = cpps.iterator();
		RoomCoursePlanPara cpp = null;
		System.out.println("第几节课        课程名称        教师名称        班级名称");
		while(cppIter.hasNext()) {
			cpp = cppIter.next();
			System.out.println("第" + cpp.getParagraph() + "节        " + cpp.getCourseName() + "        " + cpp.getTeacherName() + "        " + cpp.getMajorName() + cpp.getClassName());
		}	
	}
}
