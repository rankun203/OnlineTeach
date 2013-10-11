<%@ page language="java" contentType="text/jsp; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.teachMng.onlineTeach.model.*"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String userRole = (String)(session.getAttribute("usertype"));
	String role = "";
	if (userRole!=null && userRole.equals("学生"))	role = "student";
	else if (userRole!=null && userRole.equals("教师"))	role="teacher";
%>
<div class="header">
    <div class="container">
        <svg version="1.1" 
            xmlns="http://www.w3.org/2000/svg"
            xmlns:xlink="http://www.w3.org/1999/xlink"
            xmlns:ev="http://www.w3.org/2001/xml-events"     
            baseProfile="full"
            height="40"
            width="125"
            onmouseover="document.getElementById('theCircle').style.fill='#4183c4';"
            onmouseout="document.getElementById('theCircle').style.fill='#333';"
            class="pullleft"
            onclick="window.location='http://localhost:8080/OnlineTeach';"
            id="logoSvg"
            >
            <line x1="5" y1="20" x2="60" y2="20" style="stroke:black; stroke-width:1;"/>
            <text x="5" y="15" style="fill:#333; font-size:17px; font-family:Gabriola; letter-spacing:3px;">Online</text>
            <text x="5" y="32" style="fill:#333; font-size:14px; font-family:Gabriola; letter-spacing:1px;">Teach</text>
            <text x="39" y="32" style="fill:#333; font-size:11px; font-family:微软雅黑;">高效</text>
            <text x="63" y="32" style="fill:#333; font-size:29px; font-family:微软雅黑;">智能</text>
            <rect x="79" y="10" width="11" height="12" style="fill:#f6f6f6;" />
            <circle cx="85" cy="15" r="6" style="fill:#333;" id="theCircle" />
        </svg>

        <div class="headerPaneDivide pullleft"></div>
        <div class="siteTitle pullleft">在线教学</div>    
        <div class="mainNav pullleft">
        	<% if(!"".equals(role)) {%>
	            <ul>
	             <li class="pullleft">
	             	<a class="aMainNavItem" id="mainNavA" href="index.jsp" onMouseOver="mainNavExchange('mainNavA');" onmouseout="mainNavOut();">
	             		首页
	             	</a>
	             </li>
	            <%if(role.equals("student")){%>		
					<li class="pullleft">
						<a class="aMainNavItem" id="mainNavB" onMouseOver="mainNavExchange('mainNavB');" onmouseout="mainNavOut();" href="courseplanCateSearch.jsp">
							课表查询
						</a>
					</li>
	                <li class="pullleft">
	                	<a class="aMainNavItem" id="mainNavC" href="workReply.jsp" onMouseOver="mainNavExchange('mainNavC');" onmouseout="mainNavOut();">
	                		练习作答
	                	</a>
	                </li>
				<%} else if(role.equals("teacher")) {%>
	                <li class="pullleft">
	                	<a class="aMainNavItem" id="mainNavD" href="generateCourseplan.jsp" onMouseOver="mainNavExchange('mainNavD');" onmouseout="mainNavOut();">
	                		课表生成
	                	</a>
	                </li>
	                <li class="pullleft">
	                	<a class="aMainNavItem" id="mainNavE" href="courseplanCateSearch.jsp" onMouseOver="mainNavExchange('mainNavE');" onmouseout="mainNavOut();">
	                		课表查询
	                	</a>
	                </li>
	                <li class="pullleft">
	                	<a class="aMainNavItem" id="mainNavF" href="createWork.jsp" onMouseOver="mainNavExchange('mainNavF');" onmouseout="mainNavOut();">
	                		练习创建
	                	</a>
	                </li>
            	<%}%>
            	</ul>
           	<%}%>
        </div>
        <% if("student".equals(role)) {%>
	        <div class="headerPaneDivide pullleft" style="margin-left:90px;"></div>
        <%} else {%>
	        <div class="headerPaneDivide pullleft"></div>
        <%}%>
        <% if(!"".equals(role)) {%>
	        <div class="userProfile pullleft">
	            <div class="userProfileLeft pullleft" >
	                <div class="userProfileItem">
	                	<%
	                		if (userRole != null && userRole.equals("学生")) {
	                			Object userObject = (session.getAttribute("user"));
	                			if (userObject != null){
	                				out.print(((Student) userObject).getStuName());
	                				out.println("<div style=\"display:none;\" id=\"sid\">"+((Student) userObject).getStuID()+"</div>");
	                			}
	                			else out.println("<script>setTimeout('msgerror(\"登录信息错误，建议重新登录！\");',1000);</script>");
	                		} else if (userRole != null) {
	                			Object userObject = (session.getAttribute("user"));
	                			if (userObject != null){
	                				out.print(((Teacher) userObject).getTeacName());
	                				out.println("<div style=\"display:none;\" id=\"tid\">"+((Teacher) userObject).getTeacID()+"</div>");                				
	                			}
	                			else out.println("<script>setTimeout('msgerror(\"登录信息错误，建议重新登录！\");',1000);</script>");
	                		} else
	                			out.println("未登录");
	                	%>
	                </div>
	                <div class="userProfileItem"><%=userRole==null?"未登录":userRole%></div>
	            </div>
	            <div class="userProfileRight pullright">
	                <div class="userProfileItem"><s:property value="#session.user.schoolClass.major.majorName"/>&nbsp;&nbsp;<s:property value="#session.user.schoolClass.scName"/></div>
	                <s:if test="#session.user.schoolClass.major.majorName != null">
	                <div class="userProfileItem">2013年 4月 8日</div>
	                </s:if>
	            </div>
	        </div>
        <%} else {%>
       	 	<span class="no_login pullright">未登录?</span>
       	 <%}%>
        <%if(role!=null&&role!=""&&!(role.equals(""))){%>
	        <a class="logooffbox" id="logoffbox" href="login/logout"></a>
        <%} else {%>
	        <a href="<%=request.getContextPath()%>/login.jsp" class="nav-logina submitBtn">登录</a>
        <%}%>
        <div class="clearboth"></div>
    </div>
</div>


