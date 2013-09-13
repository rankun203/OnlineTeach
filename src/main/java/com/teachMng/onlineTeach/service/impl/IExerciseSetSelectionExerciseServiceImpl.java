package com.teachMng.onlineTeach.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IExerciseSetSelectionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetJudgeExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetSelectionExercise;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;
import com.teachMng.onlineTeach.service.IExerciseSetSelectionExerciseService;
@Transactional
@Component("esseService")
public class IExerciseSetSelectionExerciseServiceImpl implements IExerciseSetSelectionExerciseService  {
	private IExerciseSetSelectionExerciseDAO esseDao;
	public IExerciseSetSelectionExerciseDAO getEsseDao() {
		return esseDao;
	}
	@Resource(name="esseDao")
	public void setEsseDao(IExerciseSetSelectionExerciseDAO esseDao) {
		this.esseDao = esseDao;
	}

	@Override
	public List<ExerciseSetSelectionExercise> findByEsId(int esId) {
		return esseDao.findByEsId(esId);
	}

	@Override
	public List<ExerciseSetSelectionExercise> findBySeId(int seId) {
		return esseDao.findBySeId(seId);
	}

	@Override
	public List<SelectionExercise> getSelectionExercise(int esId) {
		List<SelectionExercise> seList = new ArrayList<SelectionExercise>();
		Iterator<ExerciseSetSelectionExercise> esseIter = findByEsId(esId).iterator();
		while (esseIter.hasNext()) {
			seList.add(esseIter.next().getSe());
		}
		return seList;
	}

	@Override
	public ExerciseSetSelectionExercise findByEsIdSeId(int esId, int seId) {
		return esseDao.findByEsIdSeId(esId, seId);
	}

	@Override
	public boolean update(ExerciseSetSelectionExercise esse) {
		return esseDao.update(esse);
	}

	@Override
	public boolean insert(ExerciseSetSelectionExercise esse) {
		return esseDao.insert(esse);
	}

	@Override
	public boolean delete(ExerciseSetSelectionExercise esse) {
		return esseDao.delete(esse);
	}

	@Override
	public boolean deleteByEsIdSeId(int esId, int seId) {
		return esseDao.deleteByEsIdSeId(esId, seId);
	}
}
