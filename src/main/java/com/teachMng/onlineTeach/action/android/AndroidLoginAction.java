package com.teachMng.onlineTeach.action.android;

import com.opensymphony.xwork2.ActionSupport;
import com.teachMng.onlineTeach.model.Student;
import com.teachMng.onlineTeach.model.Teacher;
import com.teachMng.onlineTeach.service.IStudentService;
import com.teachMng.onlineTeach.service.ITeacherService;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
@Component("androidLoginAction")
public class AndroidLoginAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {
    private String username;
    private String password;
    private String role;
    private IStudentService studentService;
    private ITeacherService teacherService;
    private Map<String, Object> session;
    private HttpServletRequest req;
    private HttpServletResponse resp;

    public String findTeacher () {
        Teacher teacher = teacherService.login(username, password);
        if (teacher != null) {
            session.put("usertype", "教师");
            session.put("user", teacher);
            out().println("{\"status\":\"ok\"}");
        } else {
            out().println("{\"status\":\"no-user\", \"msg\":\"用户名或密码错误！\"}");
        }
System.err.println("role:teacher" + "-username:" + username + "-password:" + password);
        return null;
    }

    public String findStudent () {
        Student student = studentService.login(username, password);
        if (student != null) {
            session.put("usertype", "学生");
            session.put("user", student);
            out().println("{\"status\":\"ok\"}");
        } else {
            out().println("{\"status\":\"no-user\", \"msg\":\"用户名或密码错误！\"}");
        }
System.err.println("role:student" + "username:" + username + "-password:" + password);
        return null;
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

    @Resource(name = "studentService")
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    public ITeacherService getTeacherService() {
        return teacherService;
    }

    @Resource(name = "teacherService")
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

    public PrintWriter out() {
        try {
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json");
            return resp.getWriter();
        } catch (IOException e) {
            System.err.println("系统错误，获取response对象失败！");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setServletResponse(HttpServletResponse arg0) {
        resp = arg0;
    }
}
