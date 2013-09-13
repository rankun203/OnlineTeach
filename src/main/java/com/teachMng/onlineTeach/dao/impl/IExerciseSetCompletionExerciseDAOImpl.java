package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IExerciseSetCompletionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetCompletionExercise;

@Component("esceDao")
public class IExerciseSetCompletionExerciseDAOImpl implements
		IExerciseSetCompletionExerciseDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	@Resource(name = "sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<ExerciseSetCompletionExercise> findByEsId(int esId) {
		Session s = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ExerciseSetCompletionExercise> list = s
				.createQuery(
						"from ExerciseSetCompletionExercise esce where esce.es=?")
				.setInteger(0, esId).list();
		return list;
	}

	@Override
	public List<ExerciseSetCompletionExercise> findByCeId(int ceId) {
		Session s = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ExerciseSetCompletionExercise> list = s
				.createQuery(
						"from ExerciseSetCompletionExercise esce where esce.ce=?")
				.setInteger(0, ceId).list();
		return list;

	}

	@Override
	public ExerciseSetCompletionExercise findByEsIdCeId(int esId, int ceId) {
		Session s = sf.getCurrentSession();
		ExerciseSetCompletionExercise esce = (ExerciseSetCompletionExercise) s
				.createQuery(
						"from ExerciseSetCompletionExercise esce where esce.ce=? and esce.es=?")
				.setInteger(0, ceId).setInteger(1, esId).uniqueResult();
		return esce;
	}

	@Override
	public boolean update(ExerciseSetCompletionExercise esce) {
		Session s = sf.getCurrentSession();
		s.update(esce);
		return true;
	}

	@Override
	public boolean insert(ExerciseSetCompletionExercise esce) {
		Session s = sf.getCurrentSession();
		s.save(esce);
		return true;
	}

	@Override
	public boolean delete(ExerciseSetCompletionExercise esce) {
		Session s = sf.getCurrentSession();
		s.delete(esce);
		return true;
	}

	@Override
	public boolean deleteByEsIdCeId(int esId, int ceId) {
		// TODO Auto-generated method stub
		return false;
	}
}
