package com.teachMng.onlineTeach.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IExerciseSetJudgeExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetCompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetJudgeExercise;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.service.IExerciseSetJudgeExerciseService;
@Transactional
@Component("esjeService")
public class IExerciseSetJudgeExerciseServiceImpl implements IExerciseSetJudgeExerciseService  {
	private IExerciseSetJudgeExerciseDAO esjeDao; 
	public IExerciseSetJudgeExerciseDAO getEsjeDao() {
		return esjeDao;
	}
	@Resource(name="esjeDao")
	public void setEsjeDao(IExerciseSetJudgeExerciseDAO esjeDao) {
		this.esjeDao = esjeDao;
	}

	@Override
	public List<ExerciseSetJudgeExercise> findByEsId(int esId) {
		return esjeDao.findByEsId(esId);
	}

	@Override
	public List<ExerciseSetJudgeExercise> findByJeId(int jeId) {
		return esjeDao.findByJeId(jeId);
	}

	@Override
	public List<JudgeExercise> getJudgeExercise(int esId) {
		List<JudgeExercise> jeList = new ArrayList<JudgeExercise>();
		Iterator<ExerciseSetJudgeExercise> esjeIter = findByEsId(esId).iterator();
		while (esjeIter.hasNext()) {
			jeList.add(esjeIter.next().getJe());
		}
		return jeList;
	}

	@Override
	public ExerciseSetJudgeExercise findByEsIdJeId(int esId, int jeId) {
		return esjeDao.findByEsIdJeId(esId, jeId);
	}

	@Override
	public boolean update(ExerciseSetJudgeExercise esje) {
		return esjeDao.update(esje);
	}

	@Override
	public boolean insert(ExerciseSetJudgeExercise esje) {
		return esjeDao.insert(esje);
	}

	@Override
	public boolean delete(ExerciseSetJudgeExercise esje) {
		return esjeDao.delete(esje);
	}

	@Override
	public boolean deleteByEsIdJeId(int esId, int jeId) {
		return esjeDao.deleteByEsIdJeId(esId, jeId);
	}

}
