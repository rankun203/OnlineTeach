package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IExerciseSetDAO;
import com.teachMng.onlineTeach.model.exercise.ExerciseSet;
import com.teachMng.onlineTeach.service.IExerciseSetService;
@Component("exerciseSetService")
public class ExerciseSetServiceImpl implements IExerciseSetService {
	private IExerciseSetDAO exerciseSetDao;
	public IExerciseSetDAO getExerciseSetDao() {
		return exerciseSetDao;
	}
	@Resource(name="exerciseSetDao")
	public void setExerciseSetDao(IExerciseSetDAO exerciseSetDao) {
		this.exerciseSetDao = exerciseSetDao;
	}

	@Override
	@Transactional
	public List<ExerciseSet> allExerciseSet() {
		return exerciseSetDao.allExerciseSet();
	}

	@Override
	@Transactional
	public ExerciseSet findById(int id) {
		return exerciseSetDao.findById(id);
	}

	@Override
	@Transactional
	public ExerciseSet findByTeacherId(int tid) {
		return exerciseSetDao.findByTeacherId(tid);
	}

	@Override
	@Transactional
	public List<ExerciseSet> findByStudentId(int sid) {
		return exerciseSetDao.findByStudentId(sid);
	}

	@Override
	@Transactional
	public boolean insert(ExerciseSet es) {
		return exerciseSetDao.insert(es);
	}
	@Override
	@Transactional
	public boolean save(ExerciseSet es) {
		
		return exerciseSetDao.save(es);
	}

}
