package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.ICompletionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.service.ICompletionExerciseService;

@Component("completionExerciseService")
public class CompletionExerciseServiceImpl implements ICompletionExerciseService {
	private ICompletionExerciseDAO completionExerciseDao;
	public ICompletionExerciseDAO getCompletionExerciseDao() {
		return completionExerciseDao;
	}
	@Resource(name="completionExerciseDao")
	public void setCompletionExerciseDao(
			ICompletionExerciseDAO completionExerciseDao) {
		this.completionExerciseDao = completionExerciseDao;
	}

	@Override
	@Transactional
	public List<CompletionExercise> allExercise() {
		return completionExerciseDao.allExercise();
	}

	@Override
	@Transactional
	public CompletionExercise findById(int id) {
		return completionExerciseDao.findById(id);
	}

	@Override
	@Transactional
	public boolean insert(CompletionExercise ce) {
		return completionExerciseDao.insert(ce);
	}


}
