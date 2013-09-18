package com.teachMng.onlineTeach.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dao.IExerciseSetJudgeExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetJudgeExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetJudgeExercise;
@Component("esjeDao")
public class IExerciseSetJudgeExerciseDAOImpl implements IExerciseSetJudgeExerciseDAO  {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	@Resource(name = "sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<ExerciseSetJudgeExercise> findByEsId(int esId) {
		Session s = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ExerciseSetJudgeExercise> list = s
				.createQuery(
						"from ExerciseSetJudgeExercise esje where esje.es=?")
				.setInteger(0, esId).list();
		return list;
	}

	@Override
	public List<ExerciseSetJudgeExercise> findByJeId(int jeId) {
		Session s = sf.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ExerciseSetJudgeExercise> list = s
				.createQuery(
						"from ExerciseSetJudgeExercise esje where esje.je=?")
				.setInteger(0, jeId).list();
		return list;

	}

	@Override
	public ExerciseSetJudgeExercise findByEsIdJeId(int esId, int jeId) {
		Session s = sf.getCurrentSession();
		ExerciseSetJudgeExercise esje = (ExerciseSetJudgeExercise) s
				.createQuery(
						"from ExerciseSetJudgeExercise esje where esje.je=? and esje.es=?")
				.setInteger(0, jeId).setInteger(1, esId).uniqueResult();
		return esje;
	}

	@Override
	public boolean update(ExerciseSetJudgeExercise esje) {
		Session s = sf.getCurrentSession();
		s.update(esje);
		return true;
	}

	@Override
	public boolean insert(ExerciseSetJudgeExercise esje) {
		Session s = sf.getCurrentSession();
		s.save(esje);
		return true;
	}

	@Override
	public boolean delete(ExerciseSetJudgeExercise esje) {
		Session s = sf.getCurrentSession();
		s.delete(esje);
		return true;
	}

	@Override
	public boolean deleteByEsIdJeId(int esId, int jeId) {
		return false;
	}
}
