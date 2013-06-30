package com.teachMng.onlineTeach.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IQuestionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
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
	@Transactional
	public String getCEString() {
		List<QuestionExercise> qeList = allExercise();
		String json = "";
		Iterator<QuestionExercise> ceIter = qeList.iterator();
		QuestionExercise _ce;
		String topic = "";
		while(ceIter.hasNext()) {
			_ce = ceIter.next();
			topic = _ce.getFullTopic();
			topic = topic.replaceAll("@space@", "_______");
			if(topic.length() > 31) {
				topic = topic.substring(0, 31);
				topic += "...";
			}
			json += "{id:\"" + _ce.getId() + "\",topic:\"" + topic + "\",type:\"questionExercise\"},";
		}
		return json;
	}
	@Override
	@Transactional
	public String quickLook(int id) {
		QuestionExercise ce = findById(id);
		String json="{";
		json += "问答题：" + ce.getFullTopic() + "}";
		return json;
	}

}
