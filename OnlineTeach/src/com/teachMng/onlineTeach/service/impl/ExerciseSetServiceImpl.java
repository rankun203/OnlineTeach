package com.teachMng.onlineTeach.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IExerciseSetDAO;
import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSet;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;
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
	@Override
	@Transactional
	public String getExerciseSet(int esID){
		ExerciseSet es = findById(esID);
		String str = "[";
		List<SelectionExercise> seList = es.getSelectionExercise();
		List<CompletionExercise> ceList = es.getCompletionExercise();
		List<JudgeExercise> jeList = es.getJudgeExercise();
		List<QuestionExercise> qeList = es.getQuestionExercise();

		//System.out.println("selection size:" + seList.size() + " completion size:" + ceList.size());
		
		for(int i=0; i<seList.size(); i++){
			if(i==0)	str += "{";
			else str += ",{";
			str += "\"type\":\"selection\",";
			String selCtn = seList.get(i).getFullTopic();
			str += "\"selCtn\":\""+selCtn+"\"";
			str += "}";
		}
		for(int i=0; i<ceList.size(); i++){
			if(str.indexOf("type") >0)	str += ",{";
			else str += "{";
			str += "\"type\":\"completion\",";
			String cplCtn = ceList.get(i).getFullTopic();
			str += "\"cplCtn\":\""+cplCtn+"\"";
			str += "}";
		}
		for(int i=0; i<jeList.size(); i++){
			if(str.indexOf("type") >0)	str += ",{";
			else str += "{";
			str += "\"type\":\"judge\",";
			String jugCtn = jeList.get(i).getFullTopic();
			str += "\"jugCtn\":\""+jugCtn+"\"";
			str += "}";
		}
		for(int i=0; i<qeList.size(); i++){
			if(str.indexOf("type") >0)	str += ",{";
			else str += "{";
			str += "\"type\":\"question\",";
			String qesCtn = qeList.get(i).getFullTopic();
			str += "\"qesCtn\":\""+qesCtn+"\"";
			str += "}";
		}
		str += "]";
		return str;
	}

}
