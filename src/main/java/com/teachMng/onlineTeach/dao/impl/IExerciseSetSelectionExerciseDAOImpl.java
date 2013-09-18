package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IExerciseSetSelectionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetSelectionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetSelectionExercise;
@Component("esseDao")
public class IExerciseSetSelectionExerciseDAOImpl implements IExerciseSetSelectionExerciseDAO  {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	@Resource(name = "sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<ExerciseSetSelectionExercise> findByEsId(int esId) {
		Session s = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ExerciseSetSelectionExercise> list = s
				.createQuery(
						"from ExerciseSetSelectionExercise esse where esse.es=?")
				.setInteger(0, esId).list();
		return list;
	}

	@Override
	public List<ExerciseSetSelectionExercise> findBySeId(int seId) {
		Session s = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ExerciseSetSelectionExercise> list = s
				.createQuery(
						"from ExerciseSetSelectionExercise esse where esse.se=?")
				.setInteger(0, seId).list();
		return list;

	}

	@Override
	public ExerciseSetSelectionExercise findByEsIdSeId(int esId, int seId) {
		Session s = sf.getCurrentSession();
		ExerciseSetSelectionExercise esse = (ExerciseSetSelectionExercise) s
				.createQuery(
						"from ExerciseSetSelectionExercise esse where esse.se=? and esse.es=?")
				.setInteger(0, seId).setInteger(1, esId).uniqueResult();
		return esse;
	}

	@Override
	public boolean update(ExerciseSetSelectionExercise esse) {
		Session s = sf.getCurrentSession();
		s.update(esse);
		return true;
	}

	@Override
	public boolean insert(ExerciseSetSelectionExercise esse) {
		Session s = sf.getCurrentSession();
		s.save(esse);
		return true;
	}

	@Override
	public boolean delete(ExerciseSetSelectionExercise esse) {
		Session s = sf.getCurrentSession();
		s.delete(esse);
		return true;
	}

	@Override
	public boolean deleteByEsIdSeId(int esId, int seId) {
		return false;
	}
}
