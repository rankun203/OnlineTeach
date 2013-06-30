package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IQuestionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
import com.teachMng.onlineTeach.service.IQuestionExerciseService;
@Component("questionExerciseService")
public class QuestionExerciseServiceImpl implements IQuestionExerciseService {
	private IQuestionExerciseDAO questionExerciseDao;
	public IQuestionExerciseDAO getQuestionExerciseDao() {
		return questionExerciseDao;
	}
	@Resource(name="questionExerciseDao")
	public void setQuestionExerciseDao(IQuestionExerciseDAO questionExerciseDao) {
		this.questionExerciseDao = questionExerciseDao;
	}

	@Override
	@Transactional
	public List<QuestionExercise> allExercise() {
		return questionExerciseDao.allExercise();
	}

	@Override
	@Transactional
	public QuestionExercise findById(int id) {
		return questionExerciseDao.findById(id);
	}

	@Override
	@Transactional
	public boolean insert(QuestionExercise qe) {
		return questionExerciseDao.insert(qe);
	}


}
