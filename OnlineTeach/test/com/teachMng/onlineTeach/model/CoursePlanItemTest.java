package com.teachMng.onlineTeach.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.teachMng.onlineTeach.util.HibernateUtil;
import com.teachMng.onlineTeach.util.SerilNumber;

public class CoursePlanItemTest {
	static SessionFactory sf = null;
	@BeforeClass
	public static void beforeC() {
		sf = HibernateUtil.getSessionFactory();
	}
	@AfterClass 
	public static void afterC() {
		sf.close();
	}
	@Test
	public void testSave() {
		ClassRoom cr = new ClassRoom();
		cr.setCrName("哈哈");
		cr.setCrType(1);
		
		Teacher teacher = new Teacher();
		teacher.setTeacName("张三");
		
		Major major = new Major();
		major.setMajorName("软件技术");
		
		
		SchoolClass sc = new SchoolClass();
		sc.setScName("113-2");
		sc.setMajor(major);
		
		Session se = sf.openSession();
		se.beginTransaction();
		se.save(sc);
		se.getTransaction().commit();
		se.close();
		Course course = new Course();
		course.setCourseName("大学英语");
		course.setCourseDesc("这是一门必修课");
		course.setPriority(SerilNumber.OBLIGCOURSE);
		CoursePlanItem cpi = new CoursePlanItem();
		cpi.setCpParagraph(18);
		cpi.setCpState(1);
		cpi.setClassRoom(cr);
		course.setCoursePlanItem(cpi);
		cpi.setCourse(course);
		cpi.setTeacher(teacher);
		cpi.setSchoolClass(sc);
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(cpi);
		s.getTransaction().commit();
	}
	@Test
	public void testGet() {
		CoursePlanItem cpi = null;
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		cpi = (CoursePlanItem) s.get(CoursePlanItem.class, 1);
		System.out.println("节：" + cpi.getCpParagraph() + "教室：" + cpi.getClassRoom().getCrName() + 
				"课程名称：" + cpi.getCourse().getCourseName() + "教师名称：" + cpi.getTeacher().getTeacName());
	}
}
