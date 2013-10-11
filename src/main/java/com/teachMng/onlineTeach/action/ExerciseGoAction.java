package com.teachMng.onlineTeach.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.teachMng.onlineTeach.model.Student;
import com.teachMng.onlineTeach.model.Teacher;
import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSet;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetCompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetJudgeExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetQuestionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSetSelectionExercise;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;
import com.teachMng.onlineTeach.service.ICompletionExerciseService;
import com.teachMng.onlineTeach.service.IExerciseSetService;
import com.teachMng.onlineTeach.service.IJudgeExerciseService;
import com.teachMng.onlineTeach.service.IQuestionExerciseService;
import com.teachMng.onlineTeach.service.ISchoolClassService;
import com.teachMng.onlineTeach.service.ISelectionExerciseService;
import com.teachMng.onlineTeach.service.IStudentService;
import com.teachMng.onlineTeach.service.ITeacherService;

@Component("exsGoAction")
public class ExerciseGoAction extends ActionSupport implements
		ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private IExerciseSetService ess;
	private ITeacherService tService;
	private ISchoolClassService sClassService;
	private IStudentService studentService;
	private ISelectionExerciseService selService;
	private ICompletionExerciseService cplService;
	private IJudgeExerciseService jugService;
	private IQuestionExerciseService qusService;
	private HttpServletResponse response;
	private String teacherId;
	private String classId;
	private String exs;
	private String sid;
	private String esId;
	/**
	 * 获取题目集，组成Json数据组 return [ { "type":"selection", "selCtn":"我是选择题的内容" }, {
	 * "type":"completion", "cplCtn":"我是填空题的内容" }, { "type":"judge",
	 * "jugCtn":"我是判断题的内容" }, { "type":"question", "qesCtn": "我是问答题的内容" } ]
	 * 
	 * @throws IOException
	 *             打印消息的时候如果出错会抛出异常
	 */
	public String getExerciseSet() throws IOException {
		if (esId != null && !esId.equals("")) {
			System.out.println("esId=" + esId);
			int esID = Integer.parseInt(esId);
			String str = ess.getExerciseSet(esID);
			System.out.println("value=" + str);
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(str);
		}
        return null;
	}

	/**
	 * 学生获取自己的练习题们
	 * 
	 * @throws IOException
	 *             打印消息的时候如果出错会抛出异常
	 */
	public String getMyExerciseSets() throws IOException {
		if (sid != null && !sid.equals("")) {
			int sidInt = Integer.parseInt(sid);
			List<ExerciseSet> es = ess.findByStudentId(sidInt);
			String esInfo = "[";
			for (ExerciseSet e : es) {
				esInfo += "{";
				esInfo += "\"cdate\":\"" + e.getCreateDate() + "\", ";
				esInfo += "\"founder\":\"" + e.getFounder().getTeacName()
						+ "\", ";
				esInfo += "\"esId\":\"" + e.getId() + "\"},";
			}
			if (esInfo.length() > 1)
				esInfo = esInfo.substring(0, esInfo.length() - 1);
			esInfo += "]";
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(esInfo);
		}
        return null;
	}

	/**
	 * 教师给班级分配题目集 teacherId : 教师的编号 classId : 班级编号, exs :
	 * 10:selection,14:completion,12:judge,15:answer
	 * 
	 * eg http://localhost:8080/OnlineTeach/ei/assignment?teacherId=1&classId=1&
	 * exs=1:selectionExercise,2:selectionExercise,3:selectionExercise,4:
	 * selectionExercise
	 * ,1:answerExercise,2:answerExercise,1:judgeExercise,2:judgeExercise
	 * ,3:judgeExercise
	 * ,4:judgeExercise,1:completionExercise,2:completionExercise
	 * ,3:completionExercise,4:completionExercise#
	 * 
	 * @throws IOException
	 *             打印消息的时候如果出错会抛出异常
	 */
	public String assignment() throws IOException {
//		System.out.println("teacherId:" + teacherId + "____classId:" + classId
//				+ "____exs:" + exs);
		if (teacherId != null && !teacherId.equals("") && classId != null
				&& !classId.equals("") && exs != null && !exs.equals("")) {
			int teacherIdInt = Integer.parseInt(teacherId);
			int classIdInt = Integer.parseInt(classId);
			String[] exsArray = exs.split(",");

			// 试题类型数组
			String[] exsTypeArray = new String[exsArray.length];
			// 试题ID数组
			int[] exIds = new int[exsArray.length];
			for (int i = 0; i < exsArray.length; i++) {
				String[] temps = exsArray[i].split(":");
				exIds[i] = Integer.parseInt(temps[0]);
				exsTypeArray[i] = temps[1];
			}
			List<Student> stuList = sClassService.getStudents(classIdInt);
			Iterator<Student> stuItor = stuList.iterator();
			Teacher t = tService.findById(teacherIdInt);
			ExerciseSet es = null;
			// 先把所有的题目拿出来
			List<SelectionExercise> seList = new LinkedList<SelectionExercise>();
			List<CompletionExercise> cplList = new LinkedList<CompletionExercise>();
			List<JudgeExercise> jugList = new LinkedList<JudgeExercise>();
			List<QuestionExercise> qusList = new LinkedList<QuestionExercise>();
//			System.out.println("********" + exsTypeArray.length);
			for (int i = 0; i < exsTypeArray.length; i++) {
				if (exsTypeArray[i] != null) {
					if (exsTypeArray[i].equals("selectionExercise")) {
						SelectionExercise se = selService.findById(exIds[i]);
						seList.add(se);
					} else if (exsTypeArray[i].equals("completionExercise")) {
						CompletionExercise cp = cplService.findById(exIds[i]);
						cplList.add(cp);
					} else if (exsTypeArray[i].equals("judgeExercise")) {
						JudgeExercise je = jugService.findById(exIds[i]);
						jugList.add(je);
					} else if (exsTypeArray[i].equals("answerExercise")) {
						QuestionExercise qe = qusService.findById(exIds[i]);
						qusList.add(qe);
					}
				}
			}
			boolean isOk = true;
			// 每个学生
			while (stuItor.hasNext()) {
				es = new ExerciseSet();
				es.setFounder(t);
				es.setStudent(stuItor.next());
				if(seList.size() >0 )
					es = setSelectionExercise(es, seList);
				if(qusList.size() > 0)
					es = setQuestionExercise(es, qusList);
				//System.out.println(jugList.get(0).getFullTopic() + "******");
				if(jugList.size() > 0)
					es = setJudgeExercise(es, jugList);
				if(cplList.size() > 0)
					es = setCompletionExercise(es, cplList);
				//System.out.println("exercise set :" + es);
				System.out.println("completion size:" + es.getEsce().size() + "  judge size:" + es.getEsje().size() +
						"  question size:" + es.getEsqe().size() + "  selection size:" + es.getEsse().size());
				isOk = ess.save(es) && isOk;
//				System.out.println(isOk + "|" + es.getFounder().getTeacName()
//						+ "|" + getJudgeExercise(es).size() + "|"
//						+ getQuestionExercise(es).size() + "|"
//						+ getSelectionExercise(es).size() + "|"
//						+ getCompletionExercise(es).size() + "|"
//						+ es.getStudent().getStuName());
			}
			String sucFaild = isOk ? "成功！" : "失败！";
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(
					"{\"oktip\":\"" + isOk + "\",\"tip\":\"试卷发布" + sucFaild
							+ "\"}");
		}
        return null;
	}

	private ExerciseSet setSelectionExercise(ExerciseSet es,
			List<SelectionExercise> seList) {
		if (null == es || null == seList) {
			System.out.println("分发题目发生错误!");
			return null;
		}
		List<ExerciseSetSelectionExercise> esseList = new ArrayList<ExerciseSetSelectionExercise>();
		ExerciseSetSelectionExercise _esse = null;
		Iterator<SelectionExercise> _se = seList.iterator();
		while (_se.hasNext()) {
			_esse = new ExerciseSetSelectionExercise();
			_esse.setEs(es);
			_esse.setSe(_se.next());
			esseList.add(_esse);
		}
		es.setEsse(esseList);
		return es;
	}

	private ExerciseSet setQuestionExercise(ExerciseSet es,
			List<QuestionExercise> qeList) {
		if (null == es || null == qeList) {
			System.out.println("分发题目发生错误!");
			return null;
		}
		List<ExerciseSetQuestionExercise> esseList = new ArrayList<ExerciseSetQuestionExercise>();
		ExerciseSetQuestionExercise _esse = null;
		Iterator<QuestionExercise> _se = qeList.iterator();
		while (_se.hasNext()) {
			_esse = new ExerciseSetQuestionExercise();
			_esse.setEs(es);
			_esse.setQe(_se.next());
			esseList.add(_esse);
		}
		es.setEsqe(esseList);
		return es;
	}

	private ExerciseSet setJudgeExercise(ExerciseSet es,
			List<JudgeExercise> jeList) {
		if (null == es || null == jeList) {
			System.out.println("分发题目发生错误!");
			return null;
		}
		//System.out.println("________________________");
		List<ExerciseSetJudgeExercise> esseList = new ArrayList<ExerciseSetJudgeExercise>();
		ExerciseSetJudgeExercise _esse = null;
		Iterator<JudgeExercise> _se = jeList.iterator();
		while (_se.hasNext()) {
			_esse = new ExerciseSetJudgeExercise();
			_esse.setEs(es);
			_esse.setJe(_se.next());
			esseList.add(_esse);
		}
		es.setEsje(esseList);
		return es;
	}

	private ExerciseSet setCompletionExercise(ExerciseSet es,
			List<CompletionExercise> ceList) {
		if (null == es || null == ceList) {
			System.out.println("分发题目发生错误!");
			return null;
		}
		List<ExerciseSetCompletionExercise> esseList = new ArrayList<ExerciseSetCompletionExercise>();
		ExerciseSetCompletionExercise _esse = null;
		Iterator<CompletionExercise> _se = ceList.iterator();
		while (_se.hasNext()) {
			_esse = new ExerciseSetCompletionExercise();
			_esse.setEs(es);
			_esse.setCe(_se.next());
			esseList.add(_esse);
		}
		es.setEsce(esseList);
		return es;
	}

	public IExerciseSetService getEss() {
		return ess;
	}

	@Resource(name = "exerciseSetService")
	public void setEss(IExerciseSetService ess) {
		this.ess = ess;
	}

	public ITeacherService gettService() {
		return tService;
	}

	@Resource(name = "teacherService")
	public void settService(ITeacherService tService) {
		this.tService = tService;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getExs() {
		return exs;
	}

	public void setExs(String exs) {
		this.exs = exs;
	}

	public ISchoolClassService getsClassService() {
		return sClassService;
	}

	@Resource(name = "schoolClassService")
	public void setsClassService(ISchoolClassService sClassService) {
		this.sClassService = sClassService;
	}

	public IStudentService getStudentService() {
		return studentService;
	}

	@Resource(name = "studentService")
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public ISelectionExerciseService getSelService() {
		return selService;
	}

	@Resource(name = "selectionExerciseService")
	public void setSelService(ISelectionExerciseService selService) {
		this.selService = selService;
	}

	public ICompletionExerciseService getCplService() {
		return cplService;
	}

	@Resource(name = "completionExerciseService")
	public void setCplService(ICompletionExerciseService cplService) {
		this.cplService = cplService;
	}

	public IJudgeExerciseService getJugService() {
		return jugService;
	}

	@Resource(name = "judgeExerciseService")
	public void setJugService(IJudgeExerciseService jugService) {
		this.jugService = jugService;
	}

	public IQuestionExerciseService getQusService() {
		return qusService;
	}

	@Resource(name = "questionExerciseService")
	public void setQusService(IQuestionExerciseService qusService) {
		this.qusService = qusService;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getEsId() {
		return esId;
	}

	public void setEsId(String esId) {
		this.esId = esId;
	}
}
