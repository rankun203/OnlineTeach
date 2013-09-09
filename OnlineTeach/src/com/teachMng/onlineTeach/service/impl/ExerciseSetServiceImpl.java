package com.teachMng.onlineTeach.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teachMng.onlineTeach.dao.IExerciseSetDAO;
import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSet;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetCompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetJudgeExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetQuestionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetSelectionExercise;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;
import com.teachMng.onlineTeach.service.IExerciseSetService;
@Transactional
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
	public List<ExerciseSet> allExerciseSet() {
		return exerciseSetDao.allExerciseSet();
	}

	@Override
	public ExerciseSet findById(int id) {
		return exerciseSetDao.findById(id);
	}

	@Override
	public ExerciseSet findByTeacherId(int tid) {
		return exerciseSetDao.findByTeacherId(tid);
	}

	@Override
	public List<ExerciseSet> findByStudentId(int sid) {
		return exerciseSetDao.findByStudentId(sid);
	}

	@Override
	public boolean insert(ExerciseSet es) {
		return exerciseSetDao.insert(es);
	}
	@Override
	public boolean save(ExerciseSet es) {
		
		return exerciseSetDao.save(es);
	}
	@Override
	public String getExerciseSet(int esID){
		String str = "[";
		List<SelectionExercise> seList = getSelectionExerciseById(esID);
		List<CompletionExercise> ceList = getCompletionExerciseById(esID);
		List<JudgeExercise> jeList = getJudgeExerciseById(esID);
		List<QuestionExercise> qeList = getQuestionExerciseById(esID);

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
	@Override
	public List<SelectionExercise> getSelectionExerciseById(int esId) {
		List<SelectionExercise> seList = new ArrayList<SelectionExercise>();
		Iterator<ExerciseSetSelectionExercise> esseIter = exerciseSetDao.findById(esId).getEsse().iterator();
		ExerciseSetSelectionExercise _esse = null;
		while(esseIter.hasNext()) {
			_esse = esseIter.next();
			seList.add(_esse.getSe());
		}
		return seList;
	}
	@Override
	public List<CompletionExercise> getCompletionExerciseById(int esId) {
		List<CompletionExercise> ceList = new ArrayList<CompletionExercise>();
		Iterator<ExerciseSetCompletionExercise> esceIter = exerciseSetDao.findById(esId).getEsce().iterator();
		ExerciseSetCompletionExercise _esce = null;
		while(esceIter.hasNext()) {
			_esce = esceIter.next();
			ceList.add(_esce.getCe());
		}
		return ceList;
	}
	@Override
	public List<JudgeExercise> getJudgeExerciseById(int esId) {
		List<JudgeExercise> jeList = new ArrayList<JudgeExercise>();
		Iterator<ExerciseSetJudgeExercise> esjeIter = exerciseSetDao.findById(esId).getEsje().iterator();
		ExerciseSetJudgeExercise _esje = null;
		while(esjeIter.hasNext()) {
			_esje = esjeIter.next();
			jeList.add(_esje.getJe());
		}
		return jeList;
	}
	@Override
	public List<QuestionExercise> getQuestionExerciseById(int esId) {
		List<QuestionExercise> qeList = new ArrayList<QuestionExercise>();
		Iterator<ExerciseSetQuestionExercise> esqeIter = exerciseSetDao.findById(esId).getEsqe().iterator();
		ExerciseSetQuestionExercise _esqe = null;
		while(esqeIter.hasNext()) {
			_esqe = esqeIter.next();
			qeList.add(_esqe.getQe());
		}
		return qeList;
	}

}
