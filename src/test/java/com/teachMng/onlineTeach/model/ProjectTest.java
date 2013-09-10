package com.teachMng.onlineTeach.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Ignore
public class ProjectTest extends AbstractJUnit4SpringContextTests {
	static SessionFactory sf = null;

	public static void beforeC() {
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.buildServiceRegistry();
		sf = new Configuration().configure("lonely.hibernate.cfg.xml").buildSessionFactory(
				serviceRegistry);
	}

	public static void afterC() {
		sf.close();
	}

	public void testProject_group_replySave() {
		ProjectGroup pg1 = new ProjectGroup();
		pg1.setPgName("神影1组");
		pg1.setPgSlogan("我一个哈，我们是神影1组。");
		Project p1 = new Project();
		p1.setProjDesc("这是一个宇宙无敌大难题");
		p1.setProjTitle("张三姓张吗？");
		p1.getProjectGroups().add(pg1);

		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(p1);
		s.getTransaction().commit();
	}

	public void testProject_group_replyGet() {
		ProjectGroup pg1 = null;
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		pg1 = (ProjectGroup) s.get(ProjectGroup.class, 1);
		System.out.println(pg1.getPgName());
		System.out.println(pg1.getProjects().size());
		s.getTransaction().commit();
	}

}
