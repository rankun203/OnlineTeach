package com.teachMng.onlineTeach.filter;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
@Component("athIcs")
public class AuthenticationInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext ac = arg0.getInvocationContext();
		Map<String, Object> sessionMap = ac.getSession();
		String usertype = (String)sessionMap.get("usertype");
		if(usertype!=null && usertype.equals("学生")){
			return arg0.invoke();
		} else if(usertype!=null && usertype.equals("教师")){
			return arg0.invoke();
		} else {
			ac.put("oktip", "false");
			ac.put("tip", "请先登录");
			return Action.LOGIN;
		}
	}

}
