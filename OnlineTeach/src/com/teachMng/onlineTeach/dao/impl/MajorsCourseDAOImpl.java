package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IMajorsCourseDAO;
import com.teachMng.onlineTeach.model.Course;
import com.teachMng.onlineTeach.model.Major;
import com.teachMng.onlineTeach.model.MajorsCourse;
import com.teachMng.onlineTeach.util.HibernateUtil;
@Component("majorsCourseDao")
public class MajorsCourseDAOImpl implements IMajorsCourseDAO {
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
	public List<MajorsCourse> allMajorsCourse() {
		List<MajorsCourse> list = null;
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		list = s.createQuery("from MajorsCourse").list();
		//s.getTransaction().commit();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MajorsCourse> getByMajorId(int majorID) {
		List<MajorsCourse> list = null;
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		list = s.createQuery("from MajorsCourse where majorID=?").setInteger(0, majorID).list();
		//s.getTransaction().commit();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MajorsCourse> getByCourseId(int courseID) {
		List<MajorsCourse> list = null;
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		list = s.createQuery("from MajorsCourse where courseID=?").setInteger(0, courseID).list();
		//s.getTransaction().commit();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MajorsCourse> getById(int majorID, int courseID) {
		List<MajorsCourse> list = null;
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		list = s.createQuery("from MajorsCourse where majorID=? and courseID=?")
				.setInteger(0, majorID)
				.setInteger(1, courseID)
				.list();
		//s.getTransaction().commit();
		return list;
	}

}
