package com.teachMng.onlineTeach.model;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
	static SessionFactory sf = null;
	@BeforeClass
	public static void beforeC() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@AfterClass 
	public static void afterC() {
		sf.close();
	}
	@Test        //保存学生和班级
	public void testSave1() {
		SchoolClass sc = null;
		Session s = sf.openSession();
		s.beginTransaction();
		sc = (SchoolClass) s.get(SchoolClass.class, 1);
		s.getTransaction().commit();
		s.close();
		
		Student stu = new Student();
		stu.setStuName("学生1");
		stu.setSchoolClass(sc);
		
		s = sf.openSession();
		s.beginTransaction();
		s.save(stu);
		s.getTransaction().commit();
		s.close();
	}
	@Test
	public void testSave2() {
		SchoolClass sc = null;
		Session s = sf.openSession();
		s.beginTransaction();
		sc = (SchoolClass) s.get(SchoolClass.class, 1);
		s.getTransaction().commit();
		s.close();
		
		ProjectGroup pg = null;
		s = sf.openSession();
		s.beginTransaction();
		pg = (ProjectGroup) s.get(ProjectGroup.class, 1);
		s.getTransaction().commit();
		s.close();
		
		
		Student stu = new Student();
		stu.setStuName("学生2");
		stu.setSchoolClass(sc);
		stu.setProjectGroup(pg);
		
		s = sf.openSession();
		s.beginTransaction();
		s.save(stu);
		s.getTransaction().commit();
		s.close();
	}
	@Test
	public void testGet() {
		Student stu = null;
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		stu = (Student) s.get(Student.class, 2);
		System.out.println("学生名称：" + stu.getStuName() + " 组名称：" + stu.getProjectGroup().getPgName() + " 班级名称：" + stu.getSchoolClass().getScName());
		s.getTransaction().commit();
		
	}
}
