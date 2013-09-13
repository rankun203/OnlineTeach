package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IExerciseSetQuestionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetQuestionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetQuestionExercise;
@Component("esqeDao")
public class IExerciseSetQuestionExerciseDAOImpl implements IExerciseSetQuestionExerciseDAO  {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	@Resource(name = "sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<ExerciseSetQuestionExercise> findByEsId(int esId) {
		Session s = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ExerciseSetQuestionExercise> list = s
				.createQuery(
						"from ExerciseSetQuestionExercise esqe where esqe.es=?")
				.setInteger(0, esId).list();
		return list;
	}

	@Override
	public List<ExerciseSetQuestionExercise> findByQeId(int qeId) {
		Session s = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ExerciseSetQuestionExercise> list = s
				.createQuery(
						"from ExerciseSetQuestionExercise esqe where esqe.qe=?")
				.setInteger(0, qeId).list();
		return list;

	}

	@Override
	public ExerciseSetQuestionExercise findByEsIdQeId(int esId, int qeId) {
		Session s = sf.getCurrentSession();
		ExerciseSetQuestionExercise esqe = (ExerciseSetQuestionExercise) s
				.createQuery(
						"from ExerciseSetQuestionExercise esqe where esqe.qe=? and esqe.es=?")
				.setInteger(0, qeId).setInteger(1, esId).uniqueResult();
		return esqe;
	}

	@Override
	public boolean update(ExerciseSetQuestionExercise esqe) {
		Session s = sf.getCurrentSession();
		s.update(esqe);
		return true;
	}

	@Override
	public boolean insert(ExerciseSetQuestionExercise esqe) {
		Session s = sf.getCurrentSession();
		s.save(esqe);
		return true;
	}

	@Override
	public boolean delete(ExerciseSetQuestionExercise esqe) {
		Session s = sf.getCurrentSession();
		s.delete(esqe);
		return true;
	}

	@Override
	public boolean deleteByEsIdQeId(int esId, int qeId) {
		// TODO Auto-generated method stub
		return false;
	}
}
