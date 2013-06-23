package com.teachMng.onlineTeach.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
@Component("ajaxTestAction")
public class AjaxTestAction extends ActionSupport implements ServletResponseAware{
	HttpServletResponse response;
	static int index = 0;
	public String show() {
		out().print(index);
		index += 20;
		return null;
	}
	public PrintWriter out() {
		try {
			return response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}

}
