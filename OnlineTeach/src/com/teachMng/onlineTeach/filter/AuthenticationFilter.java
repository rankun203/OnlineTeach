package com.teachMng.onlineTeach.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain fc) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)req).getSession();
		String reqUrl = ((HttpServletRequest)req).getRequestURI();
		if(reqUrl.indexOf("login") > 0||reqUrl.indexOf("index") > 0){
			fc.doFilter(req, rep);
			return;
		}
		String usertype = (String) session.getAttribute("usertype");
		if(usertype!=null && usertype.equals("学生")){
			fc.doFilter(req, rep);
		} else if(usertype!=null && usertype.equals("教师")){
			fc.doFilter(req, rep);
		} else {
			req.setAttribute("oktip", "false");
			req.setAttribute("tip", "请先登录");
			((HttpServletRequest)req).getRequestDispatcher("/login.jsp").forward(req, rep);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
