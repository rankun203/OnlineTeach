package com.teachMng.onlineTeach.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		ExerciseSet es = findById(esID);
		int esId = es.getId();
		//System.out.println("selection size:" + seList.size() + " completion size:" + ceList.size());
		
		for(int i=0; i<seList.size(); i++){
			if(i==0)	str += "{";
			else str += ",{";
			str += "\"type\":\"selection\",";
			String selCtn = seList.get(i).getFullTopic();
			int selId = seList.get(i).getId();
			str += "\"selCtn\":\""+selCtn+"\",";
			str += "\"esId\":\""+esId+"\",";
			str += "\"selId\":\""+selId+"\"";
			str += "}";
		}
		for(int i=0; i<ceList.size(); i++){
			if(str.indexOf("type") >0)	str += ",{";
			else str += "{";
			str += "\"type\":\"completion\",";
			String cplCtn = ceList.get(i).getFullTopic();
			int cplId = ceList.get(i).getId();
			str += "\"cplCtn\":\""+cplCtn+"\",";
			str += "\"esId\":\""+esId+"\",";
			str += "\"cplId\":\""+cplId+"\"";
			str += "}";
		}
		for(int i=0; i<jeList.size(); i++){
			if(str.indexOf("type") >0)	str += ",{";
			else str += "{";
			str += "\"type\":\"judge\",";
			String jugCtn = jeList.get(i).getFullTopic();
			int jugId = jeList.get(i).getId();
			str += "\"jugCtn\":\""+jugCtn+"\",";
			str += "\"esId\":\""+esId+"\",";
			str += "\"jugId\":\""+jugId+"\"";
			str += "}";
		}
		for(int i=0; i<qeList.size(); i++){
			if(str.indexOf("type") >0)	str += ",{";
			else str += "{";
			str += "\"type\":\"question\",";
			String qesCtn = qeList.get(i).getFullTopic();
			int qesId = qeList.get(i).getId();
			str += "\"qesCtn\":\""+qesCtn+"\",";
			str += "\"esId\":\""+esId+"\",";
			str += "\"qesId\":\""+qesId+"\"";			
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
	@Override
	public boolean workReply(int esId, String type, int topicId, String answer) {
		ExerciseSet es = findById(esId);
		if("completion".equals(type)) {
			Iterator<ExerciseSetCompletionExercise> esceIter = es.getEsce().iterator();
			ExerciseSetCompletionExercise esce = null;
			while(esceIter.hasNext()) {
				esce = esceIter.next();
				if(esce.getCe().getId() == topicId) {
					esce.setStuAnswer(answer);
				}
			}
		} else if("selection".equals(type)) {
			Iterator<ExerciseSetSelectionExercise> esseIter = es.getEsse().iterator();
			ExerciseSetSelectionExercise esse = null;
			while(esseIter.hasNext()) {
				esse = esseIter.next();
				if(esse.getSe().getId() == topicId) {
					esse.setStuAnswer(answer);
				}
			}
		} else if("judge".equals(type)) {
			Iterator<ExerciseSetJudgeExercise> esjeIter = es.getEsje().iterator();
			ExerciseSetJudgeExercise esje = null;
			while(esjeIter.hasNext()) {
				esje = esjeIter.next();
				if(esje.getJe().getId() == topicId) {
					if("1".equals(answer))
						esje.setStuAnswerIsRight(true);
					else if("2".equals(answer)) 
						esje.setStuAnswerIsRight(false);
				}
			}
		} else if("question".equals(type)) {
			Iterator<ExerciseSetQuestionExercise> esqeIter = es.getEsqe().iterator();
			ExerciseSetQuestionExercise esqe = null;
			while(esqeIter.hasNext()) {
				esqe = esqeIter.next();
				if(esqe.getQe().getId() == topicId) {
					esqe.setStuAnswer(answer);
				}
			}
		}
		save(es);
		return false;
	}
	@Override
	public String getCwCoursing(int count) {
		Set<String> courses = new HashSet<String>();
		Iterator<ExerciseSet> esIter = allExerciseSet().iterator();
		ExerciseSet es = null;
		while(esIter.hasNext()) {
			es = esIter.next();
			for(ExerciseSetSelectionExercise esse : es.getEsse()) {
				courses.add(esse.getSe().getFullTopic().split("@hr@")[0]);
			}
			for(ExerciseSetCompletionExercise esce : es.getEsce()) {
				courses.add(esce.getCe().getFullTopic());
			}
			for(ExerciseSetQuestionExercise esqe : es.getEsqe()) {
				courses.add(esqe.getQe().getFullTopic());
			}
			for(ExerciseSetJudgeExercise esje : es.getEsje()) {
				courses.add(esje.getJe().getFullTopic().split("@hr@")[0]);
			}
		}
		String s = "[";
		Iterator<String> cIter = courses.iterator();
		for(int i = 0; i < count && cIter.hasNext(); i++) {
			String t = cIter.next();
			if(0 != i)s += ", ";
			s += "\"" + t + "\"";  
		}
		s += "]";
		return s;
	}

}