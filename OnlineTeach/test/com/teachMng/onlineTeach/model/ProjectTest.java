package com.teachMng.onlineTeach.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProjectTest {
	static SessionFactory sf = null;
	@BeforeClass
	public static void beforeC() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@AfterClass 
	public static void afterC() {
		sf.close();
	}
	public static void main(String[] args) {
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
	}
	@Test
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
	@Test
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
