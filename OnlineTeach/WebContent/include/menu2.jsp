<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userRole = (String)(session.getAttribute("usertype"));
	String role = "";
	if (userRole!=null && userRole.equals("学生"))	role = "student";
	else if (userRole!=null && userRole.equals("教师"))	role="teacher";
%>

<div class="subMainNavItem" id="subNavA" style="display: block;">
	<ul>
	
<%if(role.equals("teacher")){%>		<li><a href="generateCourseplan.jsp" class="subMainNavItemActive">学期课表生成</a></li><%} %>
<%if(role.equals("teacher")){%>		<li><a href="courseplanCateSearch.jsp">课表分类查询</a></li><%} %>
<%if(role.equals("student")){%>		<li><a href="courseplanCateSearch.jsp">课表查询</a></li><%} %>
<%if(role.equals("teacher")){%>		<li><a href="courseplanExport.jsp">课表分类导出</a></li><%} %>
<%if(role.equals("teacher")){%>		<li><a href="courseplanUphold.jsp">课表分类维护</a></li><%} %>
	</ul>
</div>
<div class="subMainNavItem" id="subNavB">
	<ul>
<%if(role.equals("teacher")){%>		<li><a href="createWork.jsp">课堂练习创建</a></li><%}%>
<%if(role.equals("student")){%>		<li><a href="workReply.jsp">课堂练习作答</a></li><%}%>
<%if(role.equals("teacher")){%>		<li><a href="workCheck.jsp">训练结果考核</a></li><%} %>
<%if(role.equals("teacher")){%>		<li><a href="workUphold.jsp">课堂练习维护</a></li><%} %>
	</ul>
</div>
<div class="subMainNavItem" id="subNavC">
	<ul>
<%if(role.equals("teacher")){%>		<li><a href="teachplanUphold.jsp">教案制作维护</a></li><%} %>
		<li><a href="coursewareUp_Down.jsp">课件上传下载</a></li>
<%if(role.equals("teacher")){%>		<li><a href="homeWork.jsp">课外作业管理</a></li><%} %>
<%if(role.equals("teacher")){%>		<li><a href="teachSchedule.jsp">授课计划管理</a></li><%} %>
	</ul>
</div>
<div class="subMainNavItem" id="subNavD">
	<ul>
		<li><a href="attendance.jsp">在线考勤管理</a></li>
		<li><a href="projectReply.jsp">项目答辩考核</a></li>
		<li><a href="compositeCheck.jsp">课程综合考核</a></li>
	</ul>
</div>
