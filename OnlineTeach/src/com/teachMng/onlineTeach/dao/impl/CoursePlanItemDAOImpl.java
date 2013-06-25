package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.ICoursePlanItemDAO;
import com.teachMng.onlineTeach.model.CoursePlanItem;
@Component("coursePlanItemDao")
public class CoursePlanItemDAOImpl implements ICoursePlanItemDAO {
	private SessionFactory sf;
	public SessionFactory getSf() {
		return sf;
	}
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	public void deleteAll() {
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		s.createQuery("delete from CoursePlanItem").executeUpdate();
		//s.getTransaction().commit();
	}
	@Override
	public boolean insCoursePlanItem(CoursePlanItem cpi) {
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		s.save(cpi);
		//s.getTransaction().commit();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CoursePlanItem> allCoursePlan() {
		List<CoursePlanItem> cpis = null;
		String hql = "from CoursePlanItem";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		cpis = s.createQuery(hql).list();
		//s.getTransaction().commit();
		return cpis;
	}

	@Override
	public boolean updCoursePlan(CoursePlanItem cpi) {
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		s.update(cpi);
		//s.getTransaction().commit();
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CoursePlanItem> allCoursePlanByClassId(int classID) {
		//System.out.println("aaaaaaaaaaaa");
		List<CoursePlanItem> cpis = null;
		String hql = "from CoursePlanItem where scID=?";
		Session s = sf.getCurrentSession();
		cpis = s.createQuery(hql).setInteger(0, classID).list();
		return cpis;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CoursePlanItem> allCoursePlanByTeacherId(int teacherID) {
		List<CoursePlanItem> cpis = null;
		String hql = "from CoursePlanItem where teacID=?";
		Session s = sf.getCurrentSession();
		cpis = s.createQuery(hql).setInteger(0, teacherID).list();
		return cpis;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CoursePlanItem> allCoursePlanByRoomId(int roomID) {
		List<CoursePlanItem> cpis = null;
		String hql = "from CoursePlanItem where crID=?";
		Session s = sf.getCurrentSession();
		cpis = s.createQuery(hql).setInteger(0, roomID).list();
		return cpis;
	}


}
