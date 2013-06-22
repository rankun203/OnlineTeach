package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IStudentDAO;
import com.teachMng.onlineTeach.model.Student;
@Component("studentDao")
public class StudentDAOImpl implements IStudentDAO {
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
	public List<Student> allStudent() {
		// TODO Auto-generated method stub
		List<Student> list = null;
		String hql = "from Student";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		list = s.createQuery(hql).list();
		//s.getTransaction().commit();
		return list;
	}

	@Override
	public Student findById(int sID) {
		Student student = null;
		String hql = "from Student where stuID=?";
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		student = (Student)s.createQuery(hql).setInteger(0, sID).uniqueResult();
		//s.getTransaction().commit();
		return student;
	}

	@Override
	public boolean updStudent(Student stu) {
		// TODO Auto-generated method stub
		Session s = sf.getCurrentSession();
		//s.beginTransaction();
		s.update(stu);
		//s.getTransaction().commit();
		return true;
	}

}
