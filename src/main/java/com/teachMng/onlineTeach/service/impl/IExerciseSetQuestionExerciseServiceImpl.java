package com.teachMng.onlineTeach.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IExerciseSetQuestionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetJudgeExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetQuestionExercise;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
import com.teachMng.onlineTeach.service.IExerciseSetQuestionExerciseService;
@Transactional
@Component("esqeService")
public class IExerciseSetQuestionExerciseServiceImpl implements IExerciseSetQuestionExerciseService  {
	private IExerciseSetQuestionExerciseDAO esqeDao;
	public IExerciseSetQuestionExerciseDAO getEsqeDao() {
		return esqeDao;
	}
	@Resource(name="esqeDao")
	public void setEsqeDao(IExerciseSetQuestionExerciseDAO esqeDao) {
		this.esqeDao = esqeDao;
	}

	@Override
	public List<ExerciseSetQuestionExercise> findByEsId(int esId) {
		return esqeDao.findByEsId(esId);
	}

	@Override
	public List<ExerciseSetQuestionExercise> findByQeId(int qeId) {
		return esqeDao.findByQeId(qeId);
	}

	@Override
	public List<QuestionExercise> getQuestionExercise(int esId) {
		List<QuestionExercise> qeList = new ArrayList<QuestionExercise>();
		Iterator<ExerciseSetQuestionExercise> esqeIter = findByEsId(esId).iterator();
		while (esqeIter.hasNext()) {
			qeList.add(esqeIter.next().getQe());
		}
		return qeList;
	}

	@Override
	public ExerciseSetQuestionExercise findByEsIdQeId(int esId, int qeId) {
		return esqeDao.findByEsIdQeId(esId, qeId);
	}

	@Override
	public boolean update(ExerciseSetQuestionExercise esqe) {
		return esqeDao.update(esqe);
	}

	@Override
	public boolean insert(ExerciseSetQuestionExercise esqe) {
		return esqeDao.insert(esqe);
	}

	@Override
	public boolean delete(ExerciseSetQuestionExercise esqe) {
		return esqeDao.delete(esqe);
	}

	@Override
	public boolean deleteByEsIdQeId(int esId, int qeId) {
		return esqeDao.deleteByEsIdQeId(esId, qeId);
	}

}
