package com.teachMng.onlineTeach.service.impl;

import java.util.Iterator;
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
	@Transactional
	public String getCEString() {
		List<CompletionExercise> ceList = allExercise();
		String json = "";
		Iterator<CompletionExercise> ceIter = ceList.iterator();
		CompletionExercise _ce;
		String topic = "";
		while(ceIter.hasNext()) {
			_ce = ceIter.next();
			topic = _ce.getFullTopic();
			topic = topic.replaceAll("@space@", "_______");
			if(topic.length() > 31) {
				topic = topic.substring(0, 31);
				topic += "...";
			}
			json += "{id:\"" + _ce.getId() + "\",topic:\"" + topic + "\",type:\"completionExercise\"},";
		}
		return json;
	}
	@Override
	@Transactional
	public String quickLook(int id) {
		CompletionExercise ce = findById(id);
		String json="{";
		json += "填空题：" + ce.getFullTopic().replaceAll("@space@", "_______") + "}";
		return json;
	}
	@Override
	@Transactional
	public String getAnswerInfo(int id) {
		CompletionExercise ce = findById(id);
		String json="{";
		String[] ans = ce.getStdAnswer().split(",");
		for(int i = 0; i < ans.length; i++) {
			json += (i+1) + "：" + ans[i] + "    ";
		}
		json +="}";
		return json;
	}
	@Override
	@Transactional
	public boolean deleteById(int id) {
		return completionExerciseDao.deleteById(id);
	}

}
