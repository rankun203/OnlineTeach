package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IClassRoomDAO;
import com.teachMng.onlineTeach.model.ClassRoom;
@Component("classRoomDao")
public class ClassRoomDAOImpl implements IClassRoomDAO {
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
	public List<ClassRoom> allClassRoom() {
		// TODO Auto-generated method stub
		List<ClassRoom> list = null;
		String hql = "from ClassRoom";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		list = s.createQuery(hql).list();
		//s.getTransaction().commit();
		return list;
	}

	@Override
	public ClassRoom findById(int crID) {
		// TODO Auto-generated method stub
		ClassRoom cr = null;
		String hql = "from ClassRoom where crID=?";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		cr = (ClassRoom)s.createQuery(hql).setInteger(0, crID).uniqueResult();
		//s.getTransaction().commit();
		return cr;
	}

	@Override
	public boolean updClassRoom(ClassRoom cr) {
		// TODO Auto-generated method stub
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		s.update(cr);
		//s.getTransaction().commit();
		return true;
	}

}
