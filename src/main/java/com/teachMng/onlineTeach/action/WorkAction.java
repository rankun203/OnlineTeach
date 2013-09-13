package com.teachMng.onlineTeach.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Queue;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.teachMng.onlineTeach.model.exercise.AnswerHistory;
import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetCompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetJudgeExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetQuestionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetSelectionExercise;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;
import com.teachMng.onlineTeach.service.IAnswerHistoryService;
import com.teachMng.onlineTeach.service.IExerciseSetCompletionExerciseService;
import com.teachMng.onlineTeach.service.IExerciseSetJudgeExerciseService;
import com.teachMng.onlineTeach.service.IExerciseSetQuestionExerciseService;
import com.teachMng.onlineTeach.service.IExerciseSetSelectionExerciseService;
import com.teachMng.onlineTeach.service.IExerciseSetService;

@Component("workAction")
@Scope("singleton")
public class WorkAction extends ActionSupport implements
ServletResponseAware {
	private String esId;
	private String topicId;
	private String type;
	private String answer;
	private IExerciseSetService ess;
	private HttpServletResponse response;
	private IExerciseSetSelectionExerciseService esseService;
	private IExerciseSetQuestionExerciseService esqeService;
	private IExerciseSetCompletionExerciseService esceService;
	private IExerciseSetJudgeExerciseService esjeService;

	private IAnswerHistoryService ahs;
	private Queue<AnswerHistory> ah = new LinkedList<AnswerHistory>();

	public void workReply() {
		System.out.println("type:" + type + "  esId:" + esId + "   topicid:"
				+ topicId + "   answer:" + answer);
		ess.workReply(Integer.parseInt(esId), type, Integer.parseInt(topicId),
				answer);
		AnswerHistory answerHistory = new AnswerHistory();
		answerHistory.setEsId(Integer.parseInt(esId));
		answerHistory.settId(Integer.parseInt(topicId));
		answerHistory.setType(type);
		ah.add(answerHistory);
		ahs.insert(answerHistory);
		System.out.println(ah.size() + "*************************");
	}
	
	/**
	 * 获取已经回答的题
	 * 访问URL:http://localhost:8080/OnlineTeach/work/getRepliedWork
	 */
	public void getRepliedWork() {
		if(ah.isEmpty()) {
			return;
		}
		String json = "[";
		AnswerHistory ans = null;
		SelectionExercise _se = null;
		CompletionExercise _ce = null;
		JudgeExercise _je = null;
		QuestionExercise _qe = null;
		boolean flag = false;
		DateFormat df = new SimpleDateFormat("yyyy MM dd hh:mm:ss E");
		while (!ah.isEmpty()) {
			ans = ah.poll();
			if (flag)
				json += ",{";
			else
				json += "{";
			if ("selection".equals(ans.getType())) {
				ExerciseSetSelectionExercise _esse = null;
				_esse = esseService.findByEsIdSeId(ans.getEsId(), ans.gettId());
				_se = _esse.getSe();
				json += "\"type\":\"selection";
				json += "\",\"topic\":\"" + _se.getFullTopic();
				json += "\",\"stuAnswer\":\"" + _esse.getStuAnswer();
				json += "\",\"ansDate\":\"" + df.format(ans.getDate());
				json += "\",\"topicId\":\"" + ans.gettId();
				json += "\",\"esId\":\"" + ans.getEsId() + "\"";
			} else if ("completion".equals(ans.getType())) {
				ExerciseSetCompletionExercise _esce = null;
				_esce = esceService.findByEsIdCeId(ans.getEsId(), ans.gettId());
				_ce = _esce.getCe();
				json += "\"type\":\"selection";
				json += "\",\"topic\":\"" + _se.getFullTopic();
				json += "\",\"stuAnswer\":\"" + _esce.getStuAnswer();
				json += "\",\"ansDate\":\"" + df.format(ans.getDate());
				json += "\",\"topicId\":\"" + ans.gettId();
				json += "\",\"esId\":\"" + ans.getEsId() + "\"";
			} else if ("question".equals(ans.getType())) {
				ExerciseSetQuestionExercise _esqe = null;
				_esqe = esqeService.findByEsIdQeId(ans.getEsId(), ans.gettId());
				_qe = _esqe.getQe();
				json += "\"type\":\"selection";
				json += "\",\"topic\":\"" + _qe.getFullTopic();
				json += "\",\"stuAnswer\":\"" + _esqe.getStuAnswer();
				json += "\",\"ansDate\":\"" + df.format(ans.getDate());
				json += "\",\"topicId\":\"" + ans.gettId();
				json += "\",\"esId\":\"" + ans.getEsId() + "\"";
			} else if ("judge".equals(ans.getType())) {
				ExerciseSetJudgeExercise _esje = null;
				_esje = esjeService.findByEsIdJeId(ans.getEsId(), ans.gettId());
				_je = _esje.getJe();
				json += "\"type\":\"selection";
				json += "\",\"topic\":\"" + _je.getFullTopic();
				json += "\",\"stuAnswer\":\"" + _esje.isStuAnswerIsRight();
				json += "\",\"ansDate\":\"" + df.format(ans.getDate());
				json += "\",\"topicId\":\"" + ans.gettId();
				json += "\",\"esId\":\"" + ans.getEsId() + "\"";			
			}
			json += "}";
			flag = true;
		}
		json += "]";
		out().print(json);
		System.out.println(json);
	}

	public IExerciseSetSelectionExerciseService getEsseService() {
		return esseService;
	}

	@Resource(name = "esseService")
	public void setEsseService(IExerciseSetSelectionExerciseService esseService) {
		this.esseService = esseService;
	}

	public IExerciseSetQuestionExerciseService getEsqeService() {
		return esqeService;
	}

	@Resource(name = "esqeService")
	public void setEsqeService(IExerciseSetQuestionExerciseService esqeService) {
		this.esqeService = esqeService;
	}

	public IExerciseSetCompletionExerciseService getEsceService() {
		return esceService;
	}

	@Resource(name = "esceService")
	public void setEsceService(IExerciseSetCompletionExerciseService esceService) {
		this.esceService = esceService;
	}

	public IExerciseSetJudgeExerciseService getEsjeService() {
		return esjeService;
	}

	@Resource(name = "esjeService")
	public void setEsjeService(IExerciseSetJudgeExerciseService esjeService) {
		this.esjeService = esjeService;
	}

	public IAnswerHistoryService getAhs() {
		return ahs;
	}

	@Resource(name = "answerHistoryService")
	public void setAhs(IAnswerHistoryService ahs) {
		this.ahs = ahs;
	}

	public String getEsId() {
		return esId;
	}

	public void setEsId(String esId) {
		this.esId = esId;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public IExerciseSetService getEss() {
		return ess;
	}

	@Resource(name = "exerciseSetService")
	public void setEss(IExerciseSetService ess) {
		this.ess = ess;
	}
	public PrintWriter out() {
		try {
			response.setCharacterEncoding("utf-8");
			return response.getWriter();
		} catch (IOException e) {
			System.err.println("系统错误，获取response对象失败！");
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
