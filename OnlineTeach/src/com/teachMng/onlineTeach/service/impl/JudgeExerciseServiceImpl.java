package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IJudgeExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.service.IJudgeExerciseService;
@Component("judgeExerciseService")
public class JudgeExerciseServiceImpl implements IJudgeExerciseService {
	private IJudgeExerciseDAO judgeExerciseDao;
	public IJudgeExerciseDAO getJudgeExerciseDao() {
		return judgeExerciseDao;
	}
	@Resource(name="judgeExerciseDao")
	public void setJudgeExerciseDao(IJudgeExerciseDAO judgeExerciseDao) {
		this.judgeExerciseDao = judgeExerciseDao;
	}

	@Override
	@Transactional
	public List<JudgeExercise> allExercise() {
		return judgeExerciseDao.allExercise();
	}

	@Override
	@Transactional
	public JudgeExercise findById(int id) {
		return judgeExerciseDao.findById(id);
	}

	@Override
	@Transactional
	public boolean insert(JudgeExercise je) {
		return judgeExerciseDao.insert(je);
	}

}
