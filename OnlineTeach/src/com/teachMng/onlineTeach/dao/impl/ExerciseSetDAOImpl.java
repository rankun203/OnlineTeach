package com.teachMng.onlineTeach.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IExerciseSetDAO;
import com.teachMng.onlineTeach.model.exercise.ExerciseSet;
@Component("exerciseSetDao")
public class ExerciseSetDAOImpl implements IExerciseSetDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	public List<ExerciseSet> allExerciseSet() {
		Session s = sf.getCurrentSession();
		return s.createQuery("from ExerciseSet").list();
	}

	@Override
	public ExerciseSet findById(int id) {
		Session s = sf.getCurrentSession();
		return (ExerciseSet) s.createQuery("from ExerciseSet es where es.id=?").setInteger(0, id).uniqueResult();
	}

	@Override
	public ExerciseSet findByTeacherId(int tid) {
		return null;
	}

	@Override
	public List<ExerciseSet> findByStudentId(int sid) {
		Session s = sf.getCurrentSession();
		return s.createQuery("from ExerciseSet es where es.student=?").setInteger(0, sid).list();
	}

	@Override
	public boolean insert(ExerciseSet es) {
		Session s = sf.getCurrentSession();
		int rows = (Integer) s.save(es);
		if(rows > 0) return true;
		else return false;
	}
	@Override
	public boolean save(ExerciseSet es) {
		Session s = sf.getCurrentSession();
		es.setCreateDate(new Date());
		int generatedId = (Integer) s.save(es);
		if(generatedId > 0)	return true;
		return false;
	}

}
