package com.teachMng.onlineTeach.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.teachMng.onlineTeach.dto.InfoTagItem;
import com.teachMng.onlineTeach.service.RunnableAutoPlanTask;

@SuppressWarnings("serial")
@Component("autoPlanAction")
public class AutoPlanAction extends ActionSupport implements ServletResponseAware{

	private HttpServletResponse response;
	private String typeName;
	private String selectName;
	public void setSelectName(String selectName) {
		this.selectName = selectName;
	}
	public String getSelectName() {
		return selectName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	private Set<InfoTagItem> infoTag = new HashSet<InfoTagItem>();
	public Set<InfoTagItem> getInfoTag() {
		return infoTag;
	}
	public void setInfoTag(Set<InfoTagItem> infoTag) {
		this.infoTag = infoTag;
	}

	/**
	 * 定义一个线程引用，保存排课线程
	 */
	Thread apt;
	
	/**
	 * 排课线程运行对象引用
	 */
	@Resource(name = "runnableAutoPlanTask")
	RunnableAutoPlanTask task;
	
	public void start(){
		boolean onProgress = task.getAp().onProgress;
		if(!onProgress){
			task.init();
			Thread taskThread = new Thread(task);
			taskThread.start();
			out().print("start");
			out().close();
		} else {
			out().print("onProgress");
		}
	}
	public String getSName() {
		out().print(task.getSelectList(getTypeName()));
		return null;
	}
	public String generateCoursePlan() {
		out().print(task.getInfoTag());
		return null;
	}
	public String getCoursePlan() {
		out().print(task.getCoursePlanBysName(typeName, selectName));
		return null;
	}
	public String cancel(){
		apt.interrupt();
		return SUCCESS;
	}
	/**
	 * 返回处理百分比
	 */
	public void printProgressPercent(){
		out().print( task.progressedPercent() * 100);
	}
	/**
	 * 返回消息
	 */
	public void msg(){
		out().print(task.pollMsg());
	}
	@Override
	public void setServletResponse(HttpServletResponse resp) {
		response = resp;
	}
	public String giveMeSuccess(){
		return SUCCESS;
	}
	
//	getters and setters
	public RunnableAutoPlanTask getTask() {
		return task;
	}
	public void setTask(RunnableAutoPlanTask task) {
		this.task = task;
	}

//	util
	public PrintWriter out(){
		try {
			response.setCharacterEncoding("utf-8");
			return response.getWriter();
		} catch (IOException e) {
			System.err.println("系统错误，获取response对象失败！");
			e.printStackTrace();
		}
		return null;
	}

}
