package com.teachMng.onlineTeach.action;

import java.io.IOException;
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
public class ExerciseGoAction extends ActionSupport implements ServletResponseAware{
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
	 * 获取题目集，组成Json数据组
		[
			{
				"type":"selection",
				"selCtn":"我是选择题的内容"
			},
			{
				"type":"completion",
				"cplCtn":"我是填空题的内容"
			},
			{
				"type":"judge",
				"jugCtn":"我是判断题的内容"
			},
			{
				"type":"question",
				"qesCtn":	"我是问答题的内容"
			}
		]
	 * @throws IOException  打印消息的时候如果出错会抛出异常
	 * TODO http://localhost:8080/OnlineTeach/ei/getExs?esId=2 访问出错无法获取到题目 No session... http://hi.baidu.com/hzeewpeffeacyze/item/19aa91285368670f73863e77
	 */
	public void getExerciseSet() throws IOException{
		if(esId!=null&&!esId.equals("")){
			int esID = Integer.parseInt(esId);
			ExerciseSet es = ess.findById(esID);
			response.setCharacterEncoding("utf-8");
			String str = "[";
			List<SelectionExercise> seList = es.getSelectionExercise();
			List<CompletionExercise> ceList = es.getCompletionExercise();
			List<JudgeExercise> jeList = es.getJudgeExercise();
			List<QuestionExercise> qeList = es.getQuestionExercise();
			
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
				str += "\"type\":\"selection\",";
				String cplCtn = ceList.get(i).getFullTopic();
				str += "\"cplCtn\":\""+cplCtn+"\"";
				str += "}";
			}
			for(int i=0; i<jeList.size(); i++){
				if(str.indexOf("type") >0)	str += ",{";
				else str += "{";
				str += "\"type\":\"judge\",";
				String jugCtn = ceList.get(i).getFullTopic();
				str += "\"jugCtn\":\""+jugCtn+"\"";
				str += "}";
			}
			for(int i=0; i<qeList.size(); i++){
				if(str.indexOf("type") >0)	str += ",{";
				else str += "{";
				str += "\"type\":\"question\",";
				String qesCtn = ceList.get(i).getFullTopic();
				str += "\"qesCtn\":\""+qesCtn+"\"";
				str += "}";
			}
			str += "]";
			response.getWriter().print(str);
		}
	}
	/**
	 * 学生获取自己的练习题们
	 * @throws IOException  打印消息的时候如果出错会抛出异常
	 */
	public void getMyExerciseSets() throws IOException{
		if(sid!=null && !sid.equals("")){
			int sidInt = Integer.parseInt(sid);
			List<ExerciseSet> es = ess.findByStudentId(sidInt);
			String esInfo = "[";
			for(ExerciseSet e : es){
				esInfo += "{";
				esInfo += "\"cdate\":\""+e.getCreateDate()+"\", ";
				esInfo += "\"founder\":\""+e.getFounder().getTeacName()+"\", ";
				esInfo += "\"esId\":\""+e.getId()+"\"},";
			}
			if(esInfo.length() > 1) esInfo = esInfo.substring(0, esInfo.length()-1);
			esInfo += "]";
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(esInfo);
		}
	}
	/**
	 * 教师给班级分配题目集
	 		teacherId	:	教师的编号
			classId		:	班级编号,
			exs			:	10:selection,14:completion,12:judge,15:answer
			
	 * eg http://localhost:8080/OnlineTeach/ei/assignment?teacherId=1&classId=1&exs=1:selection,2:selection,3:selection,4:selection,1:answer,2:answer,1:judge,2:judge,3:judge,4:judge,1:completion,2:completion,3:completion,4:completion#
	 * @throws IOException 打印消息的时候如果出错会抛出异常
	 */
	public void assignment() throws IOException{
		if(teacherId!=null&&!teacherId.equals("") && classId!=null&&!classId.equals("") && exs!=null&&!exs.equals("")){
			int teacherIdInt = Integer.parseInt(teacherId);
			int classIdInt = Integer.parseInt(classId);
			String[] exsArray = exs.split(",");

			//试题类型数组
			String[] exsTypeArray = new String[exsArray.length];
			//试题ID数组
			int[] exIds = new int[exsArray.length];

			for(int i=0; i<exsArray.length; i++){
				String[] temps = exsArray[i].split(":");
				exIds[i] = Integer.parseInt(temps[0]);
				exsTypeArray[i] = temps[1];
			}
			List<Student> stuList = sClassService.getStudents(classIdInt);
			Iterator<Student> stuItor = stuList.iterator();
			Teacher t = tService.findById(teacherIdInt);
			ExerciseSet es = null;
			//先把所有的题目拿出来
			List<SelectionExercise> seList = new LinkedList<SelectionExercise>();
			List<CompletionExercise> cplList = new LinkedList<CompletionExercise>();
			List<JudgeExercise> jugList = new LinkedList<JudgeExercise>();
			List<QuestionExercise> qusList = new LinkedList<QuestionExercise>();
			for(int i=0; i< exsTypeArray.length; i++){
				if(exsTypeArray[i]!=null){
					if(exsTypeArray[i].equals("selection")){
						SelectionExercise se = selService.findById(exIds[i]);
						seList.add(se);
					} else if (exsTypeArray[i].equals("completion")){
						CompletionExercise cp = cplService.findById(exIds[i]);
						cplList.add(cp);
					} else if (exsTypeArray[i].equals("judge")){
						JudgeExercise je = jugService.findById(exIds[i]);
						jugList.add(je);
					} else if (exsTypeArray[i].equals("answer")){
						QuestionExercise qe = qusService.findById(exIds[i]);
						qusList.add(qe);
					}
				}
			}
			boolean isOk = true;
			//每个学生
			while(stuItor.hasNext()){
				es = new ExerciseSet();
				es.setFounder(t);
				es.setStudent(stuItor.next());
				es.setSelectionExercise(seList);
				es.setQuestionExercise(qusList);
				es.setJudgeExercise(jugList);
				es.setCompletionExercise(cplList);
				isOk = ess.save(es) && isOk;
System.out.println(isOk+"|"+es.getFounder().getTeacName()+"|"+es.getJudgeExercise().size()+"|"+es.getQuestionExercise().size()+"|"+es.getSelectionExercise().size()+"|"+es.getCompletionExercise().size()+"|"+es.getStudent().getStuName());
			}
			String sucFaild = isOk?"成功！":"失败！";
			response.setCharacterEncoding("utf-8");
			response.getWriter().print("{\"oktip\":\""+isOk+"\",\"tip\":\"试卷发布"+sucFaild+"\"}");
		}
	}

	public IExerciseSetService getEss() {
		return ess;
	}
	@Resource(name="exerciseSetService")
	public void setEss(IExerciseSetService ess) {
		this.ess = ess;
	}
	public ITeacherService gettService() {
		return tService;
	}
	@Resource(name="teacherService")
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
	@Resource(name="schoolClassService")
	public void setsClassService(ISchoolClassService sClassService) {
		this.sClassService = sClassService;
	}
	public IStudentService getStudentService() {
		return studentService;
	}
	@Resource(name="studentService")
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	public ISelectionExerciseService getSelService() {
		return selService;
	}
	@Resource(name="selectionExerciseService")
	public void setSelService(ISelectionExerciseService selService) {
		this.selService = selService;
	}
	public ICompletionExerciseService getCplService() {
		return cplService;
	}
	@Resource(name="completionExerciseService")
	public void setCplService(ICompletionExerciseService cplService) {
		this.cplService = cplService;
	}
	public IJudgeExerciseService getJugService() {
		return jugService;
	}
	@Resource(name="judgeExerciseService")
	public void setJugService(IJudgeExerciseService jugService) {
		this.jugService = jugService;
	}
	public IQuestionExerciseService getQusService() {
		return qusService;
	}
	@Resource(name="questionExerciseService")
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
