package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.ITeacherDAO;
import com.teachMng.onlineTeach.model.Teacher;
@Component("teacherDao")
public class TeacherDAOImpl implements ITeacherDAO {
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
	public List<Teacher> allTeacher() {
		List<Teacher> list = null;
		String hql = "from Teacher";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		list = s.createQuery(hql).list();
		//s.getTransaction().commit();
		return list;
	}

	@Override
	public Teacher findById(int tID) {
		Teacher teacher = null;
		String hql = "from Teacher where teacID=?";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		teacher = (Teacher)s.createQuery(hql).setInteger(0, tID).uniqueResult();
		//s.getTransaction().commit();
		return teacher;
	}

	@Override
	public boolean updTeacher(Teacher teacher) {
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		s.update(teacher);
		//s.getTransaction().commit();
		return true;
	}
	@Override
	public Teacher login(String username, String password) {
		String hql = "from Teacher where username=? and password=?";
		Session s = sf.getCurrentSession();
		Teacher teacher = (Teacher) s.createQuery(hql).setString(0, username).setString(1, password).uniqueResult();
		return teacher;
	}

}
