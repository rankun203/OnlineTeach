package com.teachMng.onlineTeach.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class exerciseSetTest {

	ServiceRegistry serviceRegistry;
	SessionFactory sf;

	@Before
	public void before(){
		Configuration configuration = new Configuration();
		configuration = configuration.configure("lonely.hibernate.cfg.xml");
		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		srb = srb.applySettings(configuration.getProperties());
		serviceRegistry = srb.buildServiceRegistry();
		sf = configuration.buildSessionFactory(serviceRegistry);
	}
	@Test
	public void judgeExerciseTest(){
		Session session = sf.openSession();
		session.beginTransaction();
		
		
		
		session.getTransaction().commit();
		sf.getCurrentSession().close();
	}


	@Test
	public void setUp(){
System.out.println("before");
		new SchemaExport(new Configuration().configure("lonely.hibernate.cfg.xml")).create(true, true);
System.out.println("after");
	}
	@After
	public void after(){
//		sf.close();
	}
}
