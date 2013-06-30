package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.ISelectionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;
import com.teachMng.onlineTeach.service.ISelectionExerciseService;
@Component("selectionExerciseService")
public class SelectionExerciseServiceImpl implements ISelectionExerciseService {
	private ISelectionExerciseDAO selectionExerciseDao;
	public ISelectionExerciseDAO getSelectionExerciseDao() {
		return selectionExerciseDao;
	}
	@Resource(name="selectionExerciseDao")
	public void setSelectionExerciseDao(ISelectionExerciseDAO selectionExerciseDao) {
		this.selectionExerciseDao = selectionExerciseDao;
	}

	@Override
	@Transactional
	public List<SelectionExercise> allExercise() {
		return selectionExerciseDao.allExercise();
	}

	@Override
	@Transactional
	public SelectionExercise findById(int id) {
		return selectionExerciseDao.findById(id);
	}

	@Override
	@Transactional
	public boolean insert(SelectionExercise ce) {
		return selectionExerciseDao.insert(ce);
	}

}
