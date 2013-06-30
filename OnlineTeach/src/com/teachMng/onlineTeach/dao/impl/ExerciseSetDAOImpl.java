package com.teachMng.onlineTeach.dao.impl;

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
		// TODO Auto-generated method stub
		Session s = sf.getCurrentSession();
		return s.createQuery("from ExerciseSet").list();
	}

	@Override
	public ExerciseSet findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExerciseSet findByTeacherId(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExerciseSet findByStudentId(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(ExerciseSet es) {
		// TODO Auto-generated method stub
		Session s = sf.getCurrentSession();
		int rows = (Integer) s.save(es);
		if(rows > 0) return true;
		else return false;
	}

}
