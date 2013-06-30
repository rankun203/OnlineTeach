package com.teachMng.onlineTeach.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IJudgeExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
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
	@Override
	@Transactional
	public String getCEString() {
		List<JudgeExercise> jeList = allExercise();
		String json = "";
		Iterator<JudgeExercise> ceIter = jeList.iterator();
		JudgeExercise _ce;
		String topic = "";
		while(ceIter.hasNext()) {
			_ce = ceIter.next();
			topic = _ce.getFullTopic();
			topic = topic.replaceAll("@space@", "_______");
			if(topic.length() > 31) {
				topic = topic.substring(0, 31);
				topic += "...";
			}
			json += "{id:\"" + _ce.getId() + "\",topic:\"" + topic + "\",type:\"judgeExercise\"},";
		}
		return json;
	}
	@Override
	@Transactional
	public String quickLook(int id) {
		JudgeExercise ce = findById(id);
		String json="{";
		json += "判断题：" + ce.getFullTopic() + "}";
		return json;
	}
	@Override
	@Transactional
	public String getAnswerInfo(int id) {
		JudgeExercise ce = findById(id);
		String json="{";
		if(ce.isStdAnswerIsRight())
			json += "正确";
		else 
			json += "错误";
		json +="}";
		return json;
	}

}
