package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.ICourseDAO;
import com.teachMng.onlineTeach.model.ClassRoom;
import com.teachMng.onlineTeach.model.Course;
import com.teachMng.onlineTeach.util.HibernateUtil;
@Component("courseDao")
public class CourseDAOImpl implements ICourseDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> allCourse() {
		// TODO Auto-generated method stub
		List<Course> list = null;
		String hql = "from Course";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		list = s.createQuery(hql).list();
		//s.getTransaction().commit();
		return list;
	}

	@Override
	public Course findById(int cID) {
		Course course = null;
		String hql = "from Course where courseID=?";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		course = (Course)s.createQuery(hql).setInteger(0, cID).uniqueResult();
		//s.getTransaction().commit();
		return course;
	}

	@Override
	public boolean updCourse(Course course) {
		// TODO Auto-generated method stub
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		s.update(course);
		//s.getTransaction().commit();
		return true;
	}

}
