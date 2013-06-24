package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IMajorDAO;
import com.teachMng.onlineTeach.model.Major;
@Component("majorDao")
public class MajorDAOImpl implements IMajorDAO {
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
	public List<Major> allMajor() {
		List<Major> list = null;
		String hql = "from Major";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		list = s.createQuery(hql).list();
		//s.getTransaction().commit();
		return list;
	}

	@Override
	public Major findById(int mID) {
		Major major = null;
		String hql = "from Major where majorID=?";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		major = (Major)s.createQuery(hql).setInteger(0, mID).uniqueResult();
		//s.getTransaction().commit();
		return major;
	}

	@Override
	public boolean updMajor(Major major) {
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		s.update(major);
		//s.getTransaction().commit();
		return true;
	}

}
