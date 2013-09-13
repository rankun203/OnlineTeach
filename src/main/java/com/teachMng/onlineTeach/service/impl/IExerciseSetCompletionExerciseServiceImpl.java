package com.teachMng.onlineTeach.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IExerciseSetCompletionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetCompletionExercise;
import com.teachMng.onlineTeach.service.IExerciseSetCompletionExerciseService;
@Transactional
@Component("esceService")
public class IExerciseSetCompletionExerciseServiceImpl implements
		IExerciseSetCompletionExerciseService {
	private IExerciseSetCompletionExerciseDAO esceDao;
	public IExerciseSetCompletionExerciseDAO getEsceDao() {
		return esceDao;
	}
	@Resource(name="esceDao")
	public void setEsceDao(IExerciseSetCompletionExerciseDAO esceDao) {
		this.esceDao = esceDao;
	}

	@Override
	public List<ExerciseSetCompletionExercise> findByEsId(int esId) {
		return esceDao.findByEsId(esId);
	}

	@Override
	public List<ExerciseSetCompletionExercise> findByCeId(int ceId) {
		return esceDao.findByCeId(ceId);
	}

	@Override
	public List<CompletionExercise> getCompletionExercise(int esId) {
		List<CompletionExercise> ceList = new ArrayList<CompletionExercise>();
		Iterator<ExerciseSetCompletionExercise> esjeIter = findByEsId(esId).iterator();
		while (esjeIter.hasNext()) {
			ceList.add(esjeIter.next().getCe());
		}
		return ceList;
	}

	@Override
	public ExerciseSetCompletionExercise findByEsIdCeId(int esId, int ceId) {
		return esceDao.findByEsIdCeId(esId, ceId);
	}

	@Override
	public boolean update(ExerciseSetCompletionExercise esce) {
		return esceDao.update(esce);
	}

	@Override
	public boolean insert(ExerciseSetCompletionExercise esce) {
		return esceDao.insert(esce);
	}

	@Override
	public boolean delete(ExerciseSetCompletionExercise esce) {
		return esceDao.delete(esce);
	}

	@Override
	public boolean deleteByEsIdCeId(int esId, int ceId) {
		return esceDao.deleteByEsIdCeId(esId, ceId);
	}

}
