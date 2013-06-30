package com.teachMng.onlineTeach.model;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class CompositeCheckTest extends AbstractJUnit4SpringContextTests {
	static SessionFactory sf = null;
	@BeforeClass
	public static void beforeC() {
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().buildServiceRegistry();
		sf = new Configuration().configure().buildSessionFactory(serviceRegistry);
	}
	@AfterClass 
	public static void afterC() {
		sf.close();
	}
	@Test
	public void testSave() {
		Student stu = null;
		Course course = null;
		Session s1 = sf.openSession();
		s1.beginTransaction();
		stu = (Student) s1.get(Student.class, 1);
		course = (Course) s1.get(Course.class, 1);
		s1.getTransaction().commit();
		s1.close();
		
		CompositeCheck compc = new CompositeCheck();
		compc.setCourse(course);
		compc.setStudent(stu);
		compc.setCcGrade(98);
		s1 = sf.openSession();
		s1.beginTransaction();
		s1.save(compc);
		s1.getTransaction().commit();
		s1.close();
	}
	@SuppressWarnings("rawtypes")
	@Test
	public void testGet() {	
		CompositeCheck cpc = null;
		String hql = "from CompositeCheck cc where cc.ccID=0";
		Session s = sf.openSession();
		s.beginTransaction();
		Iterator iter = s.createQuery(hql).iterate();
		while(iter.hasNext()) {
			cpc = (CompositeCheck) iter.next();
			System.out.println("得分：" + cpc.getCcGrade() + "课程名称：" + cpc.getCourse().getCourseName() + "学生姓名：" + cpc.getStudent().getStuName());
		}
		s.getTransaction().commit();
	}
}
