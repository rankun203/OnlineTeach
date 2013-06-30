package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IJudgeExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
@Component("judgeExerciseDao")
public class JudgeExerciseDAOImpl implements IJudgeExerciseDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	public List<JudgeExercise> allExercise() {
		Session s = sf.getCurrentSession();
		return s.createQuery("from JudgeExercise").list();
	}

	@Override
	public JudgeExercise findById(int id) {
		return null;
	}

	@Override
	public boolean insert(JudgeExercise je) {
		Session s = sf.getCurrentSession();
		int rows = (Integer) s.save(je);
		if(rows > 0) return true;
		else return false;
	}

}
