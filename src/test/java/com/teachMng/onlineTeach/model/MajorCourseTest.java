package com.teachMng.onlineTeach.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.teachMng.onlineTeach.util.HibernateUtil;
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Ignore
public class MajorCourseTest extends AbstractJUnit4SpringContextTests {
	static SessionFactory sf ;
	public static void before() {
		sf = HibernateUtil.getSessionFactory();
	}
	public void test() {
		Session s = sf.openSession();
		s.beginTransaction();
		Major  m = (Major) s.get(Major.class, 1);
		Course c = (Course) s.get(Course.class, 1);
		s.getTransaction().commit();
		s.close();
		MajorsCourse mc = new MajorsCourse();
		mc.setMajor(m);
		mc.setCourse(c);
		mc.setParagraph(4);
		s = sf.openSession();
		s.beginTransaction();
		s.save(mc);
		s.getTransaction().commit();
		s.close();
	}

}
