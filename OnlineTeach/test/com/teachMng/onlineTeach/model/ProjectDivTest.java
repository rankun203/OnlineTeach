package com.teachMng.onlineTeach.model;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.teachMng.onlineTeach.util.HibernateUtil;
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ProjectDivTest extends AbstractJUnit4SpringContextTests {
	static SessionFactory sf = null;
	public static void beforeC() {
		sf = HibernateUtil.getSessionFactory();
	}
	public static void afterC() {
		sf.close();
	}
	public void testSave() {
		Project project = null;
		Student student = null;
		Session s = sf.openSession();
		s.beginTransaction();
		project = (Project) s.get(Project.class, 1);
		student = (Student) s.get(Student.class, 1);
		s.getTransaction().commit();
		s.close();
		
		ProjectDiv projectDiv = new ProjectDiv();
		projectDiv.setPdGrade(98);
		projectDiv.setPdWorkDesc("编码");
		projectDiv.setProject(project);
		projectDiv.setStudent(student);
		
		Session se = sf.getCurrentSession();
		se.beginTransaction();
		se.save(projectDiv);
		se.getTransaction().commit();
	}
	@SuppressWarnings("rawtypes")
	public void testGet() {
		String hql = "from ProjectDiv pd where pd.pdID = 0";
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		
		Iterator iter = s.createQuery(hql).list().iterator();
		while(iter.hasNext()) {
			ProjectDiv projD = (ProjectDiv)iter.next();
			System.out.println("学生名称：" + projD.getStudent().getStuName()
					    + "得分：" +projD.getPdGrade() + "工作描述：" + projD.getPdWorkDesc()
						+ "项目名称：" + projD.getProject().getProjTitle());
		}
		s.getTransaction().commit();		
	}
}
