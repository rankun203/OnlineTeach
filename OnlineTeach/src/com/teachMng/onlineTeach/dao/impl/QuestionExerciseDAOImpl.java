package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IQuestionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
@Component("questionExerciseDao")
public class QuestionExerciseDAOImpl implements IQuestionExerciseDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	public List<QuestionExercise> allExercise() {
		// TODO Auto-generated method stub
		Session s = sf.getCurrentSession();
		return s.createQuery("from QuestionExercise").list();
	}

	@Override
	public QuestionExercise findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(QuestionExercise qe) {
		// TODO Auto-generated method stub
		Session s = sf.getCurrentSession();
		int rows = (Integer) s.save(qe);
		if(rows > 0) return true;
		else return false;
	}


}
