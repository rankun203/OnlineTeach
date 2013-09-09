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
		Session s = sf.getCurrentSession();
		return s.createQuery("from QuestionExercise").list();
	}

	@Override
	public QuestionExercise findById(int id) {
		Session s = sf.getCurrentSession();
		return (QuestionExercise) s.createQuery("from QuestionExercise as qe where qe.id=?").setInteger(0, id).uniqueResult();
	}

	@Override
	public boolean insert(QuestionExercise qe) {
		Session s = sf.getCurrentSession();
		int rows = (Integer) s.save(qe);
		if(rows > 0) return true;
		else return false;
	}
	@Override
	public boolean deleteById(int id) {
		Session s = sf.getCurrentSession();
		int rows = s.createQuery("delete from QuestionExercise as ce where ce.id=?").setInteger(0, id).executeUpdate();
		if(rows > 0) return true;
		else return false;
	}


}
