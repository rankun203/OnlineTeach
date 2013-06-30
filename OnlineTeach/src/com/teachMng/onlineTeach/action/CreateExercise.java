package com.teachMng.onlineTeach.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;
import com.teachMng.onlineTeach.service.ICompletionExerciseService;
import com.teachMng.onlineTeach.service.IExerciseSetService;
import com.teachMng.onlineTeach.service.IJudgeExerciseService;
import com.teachMng.onlineTeach.service.IQuestionExerciseService;
import com.teachMng.onlineTeach.service.ISelectionExerciseService;

@SuppressWarnings("serial")
@Component("createExercise")
public class CreateExercise extends ActionSupport implements ServletResponseAware {
	
	private HttpServletResponse response;	
	private ICompletionExerciseService ceService;
	private IExerciseSetService esService;
	private IJudgeExerciseService jeService;
	private IQuestionExerciseService qeService;
	private ISelectionExerciseService seService;
	private String createExerciseType;
	private String stdGrade;
	private String selCtn;
	private String selted;
	private String cplCtn;
	private String anstopic;
	private String anskw;
	private String jgtopic;
	private String judgeans;
	private String completionAnswer;
	
	private String id;
	private String type;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String success(){
		return SUCCESS;
	}
	
	public void newOne(){
		System.out.println("createExerciseType:" + createExerciseType);
		System.out.println("stdGrade:" + stdGrade);
		System.out.println("selCtn:" + selCtn);
		System.out.println("selted:" + selted);
		System.out.println("cplCtn:" + cplCtn);
		System.out.println("completionAnswer:" + completionAnswer);
		System.out.println("anstopic:" + anstopic);
		System.out.println("anskw:" + anskw);
		System.out.println("jgtopic:" + jgtopic);
		System.out.println("judgeans:" + judgeans);
		//题目们的service & dao...存储之
/*
		TODO 遗留创建题目功能
		TODO 学生答题功能
		TODO 教师的答题动态更新功能		
*/		
		if(createExerciseType!=null&&!createExerciseType.equals("")){
			if(createExerciseType.equals("selectionExercise")){
				SelectionExercise se = new SelectionExercise();
				se.setFullTopic(selCtn.replaceAll("\\s", SelectionExercise.brHolder));
				se.setStdAnswer(selted.charAt(selted.length() - 1));
				se.setStdScore(Double.parseDouble(stdGrade));
				seService.insert(se);		
			} else if (createExerciseType.equals("completionExercise")) {
				CompletionExercise ce = new CompletionExercise();
				ce.setFullTopic(cplCtn.replaceAll("\\[[^\\[]*\\]", "@space@"));
				ce.setStdAnswer((String) completionAnswer.subSequence(0, completionAnswer.length()-1));
				ce.setStdScore(Double.parseDouble(stdGrade));
				ceService.insert(ce);	
			} else if (createExerciseType.equals("answerExercise")) {
				QuestionExercise ae = new QuestionExercise();
				ae.setFullTopic(anstopic);
				ae.setStdScore(Double.parseDouble(stdGrade));
				ae.setStdKeyword(anskw);
				qeService.insert(ae);		
				
			} else if (createExerciseType.equals("judgeExercise")) {
				JudgeExercise je = new JudgeExercise();
				je.setFullTopic(jgtopic);
				je.setStdScore(Double.parseDouble(stdGrade));
				je.setStdAnswerIsRight(Boolean.parseBoolean(judgeans));
				jeService.insert(je);	
			}
		}
	}
	public void getAllExercise() {
		String json = "[";
		json += ceService.getCEString();
		json += jeService.getCEString();
		json += qeService.getCEString();
		json += seService.getCEString();
		json += "]";
		out().print(json);
	}
	public void quickLook() {
		String json = "";
		if("completionExercise".equals(type)) {
			json = ceService.quickLook(Integer.parseInt(id));
		} else if("judgeExercise".equals(type)) {
			json = jeService.quickLook(Integer.parseInt(id));
		} else if("questionExercise".equals(type)) {
			json = qeService.quickLook(Integer.parseInt(id));
		} else if("selectionExercise".equals(type)) {
			json = seService.quickLook(Integer.parseInt(id));
		}
		out().print(json);
	}
	public void showAnswerInfo() {
		String json = "";
		if("completionExercise".equals(type)) {
			json = ceService.getAnswerInfo(Integer.parseInt(id));
		} else if("judgeExercise".equals(type)) {
			json = jeService.getAnswerInfo(Integer.parseInt(id));
		} else if("questionExercise".equals(type)) {
			json = qeService.getAnswerInfo(Integer.parseInt(id));
		} else if("selectionExercise".equals(type)) {
			json = seService.getAnswerInfo(Integer.parseInt(id));
		}
		out().print(json);
	}
	public String getCreateExerciseType() {
		return createExerciseType;
	}
	public void setCreateExerciseType(String createExerciseType) {
		this.createExerciseType = createExerciseType;
	}
	public String getStdGrade() {
		return stdGrade;
	}
	public void setStdGrade(String stdGrade) {
		this.stdGrade = stdGrade;
	}
	public String getSelCtn() {
		return selCtn;
	}
	public void setSelCtn(String selCtn) {
		this.selCtn = selCtn;
	}
	public String getSelted() {
		return selted;
	}
	public void setSelted(String selted) {
		this.selted = selted;
	}
	public String getCplCtn() {
		return cplCtn;
	}
	public void setCplCtn(String cplCtn) {
		this.cplCtn = cplCtn;
	}
	public String getAnstopic() {
		return anstopic;
	}
	public void setAnstopic(String anstopic) {
		this.anstopic = anstopic;
	}
	public String getAnskw() {
		return anskw;
	}
	public void setAnskw(String anskw) {
		this.anskw = anskw;
	}
	public String getJgtopic() {
		return jgtopic;
	}
	public void setJgtopic(String jgtopic) {
		this.jgtopic = jgtopic;
	}
	public String getJudgeans() {
		return judgeans;
	}
	public void setJudgeans(String judgeans) {
		this.judgeans = judgeans;
	}
	
	public ICompletionExerciseService getCeService() {
		return ceService;
	}
	@Resource(name="completionExerciseService")
	public void setCeService(ICompletionExerciseService ceService) {
		this.ceService = ceService;
	}

	public IExerciseSetService getEsService() {
		return esService;
	}
	@Resource(name="exerciseSetService")
	public void setEsService(IExerciseSetService esService) {
		this.esService = esService;
	}

	public IJudgeExerciseService getJeService() {
		return jeService;
	}
	@Resource(name="judgeExerciseService")
	public void setJeService(IJudgeExerciseService jeService) {
		this.jeService = jeService;
	}

	public IQuestionExerciseService getQeService() {
		return qeService;
	}
	@Resource(name="questionExerciseService")
	public void setQeService(IQuestionExerciseService qeService) {
		this.qeService = qeService;
	}

	public ISelectionExerciseService getSeService() {
		return seService;
	}
	@Resource(name="selectionExerciseService")
	public void setSeService(ISelectionExerciseService seService) {
		this.seService = seService;
	}

	public String getCompletionAnswer() {
		return completionAnswer;
	}

	public void setCompletionAnswer(String completionAnswer) {
		this.completionAnswer = completionAnswer;
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
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	};

}
