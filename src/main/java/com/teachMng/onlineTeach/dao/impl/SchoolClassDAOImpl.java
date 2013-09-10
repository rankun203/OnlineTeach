package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.ISchoolClassDAO;
import com.teachMng.onlineTeach.model.SchoolClass;
import com.teachMng.onlineTeach.model.Student;
@Component("schoolClassDao")
public class SchoolClassDAOImpl implements ISchoolClassDAO {
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
	public List<SchoolClass> allSchoolClass() {
		List<SchoolClass> list = null;
		String hql = "from SchoolClass";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		list = s.createQuery(hql).list();
		//s.getTransaction().commit();
		return list;
	}

	@Override
	public SchoolClass findById(int scID) {
		SchoolClass schoolClass = null;
		String hql = "from SchoolClass where scID=?";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		schoolClass = (SchoolClass)s.createQuery(hql).setInteger(0, scID).uniqueResult();
		//s.getTransaction().commit();
		return schoolClass;
	}

	@Override
	public boolean updSchoolClass(SchoolClass sc) {
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		s.update(sc);
		//s.getTransaction().commit();
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents(int scId) {
		Session s = sf.getCurrentSession();
		List<Student> stuList = (List<Student>)(s.createQuery("from Student s where s.schoolClass=?")
				.setInteger(0, scId).list());
		return stuList;
	}
}
