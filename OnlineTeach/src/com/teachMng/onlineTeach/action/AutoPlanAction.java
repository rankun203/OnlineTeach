package com.teachMng.onlineTeach.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.teachMng.onlineTeach.service.RunnableAutoPlanTask;

@SuppressWarnings("serial")
@Component("autoPlanAction")
public class AutoPlanAction extends ActionSupport implements ServletResponseAware{

	private HttpServletResponse response;
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
	public String cancel(){
		apt.interrupt();
		return SUCCESS;
	}
	/**
	 * 返回处理百分比
	 * @return
	 */
	public void printProgressPercent(){
		out().print( task.progressedPercent() * 100);
	}
	/**
	 * 返回消息
	 * @return
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
			return response.getWriter();
		} catch (IOException e) {
			System.err.println("系统错误，获取response对象失败！");
			e.printStackTrace();
		}
		return null;
	}

}