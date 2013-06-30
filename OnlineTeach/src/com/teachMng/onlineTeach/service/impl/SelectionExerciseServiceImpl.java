package com.teachMng.onlineTeach.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.ISelectionExerciseDAO;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
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
	@Transactional
	public String getCEString() {
		List<SelectionExercise> jeList = allExercise();
		String json = "";
		Iterator<SelectionExercise> ceIter = jeList.iterator();
		SelectionExercise _ce;
		String topic = "";
		while(ceIter.hasNext()) {
			_ce = ceIter.next();
			topic = _ce.getFullTopic();
			topic = topic.replaceAll("@newline@", " ");
			if(topic.length() > 31) {
				topic = topic.substring(0, 31);
				topic += "...";
			}
			json += "{id:\"" + _ce.getId() + "\",topic:\"" + topic + "\",type:\"selectionExercise\"},";
		}
		return json;
	}
	@Override
	@Transactional
	public String quickLook(int id) {
		SelectionExercise ce = findById(id);
		String json="{";
		json += "选择题：" + ce.getFullTopic().replaceAll("@newline@", "<br />") + "}";
		return json;
	}
}
