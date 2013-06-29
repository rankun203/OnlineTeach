package com.teachMng.onlineTeach.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.teachMng.onlineTeach.model.Student;
import com.teachMng.onlineTeach.model.Teacher;
import com.teachMng.onlineTeach.service.IStudentService;
import com.teachMng.onlineTeach.service.ITeacherService;

@SuppressWarnings("serial")
@Component("loginAction")
public class LoginAction extends ActionSupport implements SessionAware, ServletRequestAware{
	private String username;
	private String password;
	private String role;
	private IStudentService studentService;
	private ITeacherService teacherService;
	private Map<String, Object> session;
	private HttpServletRequest req;
	
	public String login(){
		if(role != null){
			if(role.equals("student")){
				Student student = studentService.login(username, password);
				if(student!=null){
					session.put("usertype", "学生");
					session.put("user", student);
					return SUCCESS;
				} else {
					req.setAttribute("oktip", "false");
					req.setAttribute("tip", "没找到匹配条件的学生噢，请检查你输入的学号和密码！");
				}
			} else if(role.equals("teacher")) {
				Teacher teacher = teacherService.login(username, password);
				if(teacher!=null){
					session.put("usertype", "教师");
					session.put("user", teacher);
					return SUCCESS;
				} else {
					req.setAttribute("oktip", "false");
					req.setAttribute("tip", "没找到匹配条件的教师噢，请检查你输入的用户名和密码！");
				}
			}
		}
		return LOGIN;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public IStudentService getStudentService() {
		return studentService;
	}
	@Resource(name="studentService")
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	public ITeacherService getTeacherService() {
		return teacherService;
	}
	@Resource(name="teacherService")
	public void setTeacherService(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.req = arg0;
	}
}
