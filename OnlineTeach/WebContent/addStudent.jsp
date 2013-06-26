<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html id="generateCoursePlan">
<head>
<meta charset="utf-8">
<title>学期课表生成</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />

</head>

<body>

	<jsp:include page="include/header.jsp" />

	<div class="site">
		<div class="container">
			<div class="subMainNav">
				<div class="currentLocation">
					<a href="main.html">在线教学</a>> <a href="#">教学排课</a>> <a href="#">学期课表生成</a>
				</div>
				<div class="subMainNavItem" id="subNavA" style="display: block;">
					<ul>
						<li><a href="generateCourseplan.jsp" onClick="return true;"
							class="subMainNavItemActive">学期课表生成</a></li>
						<li><a href="courseplanCateSearch.jsp" onClick="return true;">课表分类查询</a></li>
						<li><a href="courseplanExport.html" onClick="return true;">课表分类导出</a></li>
						<li><a href="courseplanUphold.html" onClick="return true;">课表分类维护</a></li>
					</ul>
				</div>
				<div class="subMainNavItem" id="subNavB">
					<ul>
						<li><a href="createWork.html" onClick="return true;">课堂练习创建</a></li>
						<li><a href="workReply.html" onClick="return true;">课堂练习作答</a></li>
						<li><a href="workCheck.html" onClick="return true;">训练结果考核</a></li>
						<li><a href="workUphold.html" onClick="return true;">课堂练习维护</a></li>
					</ul>
				</div>
				<div class="subMainNavItem" id="subNavC">
					<ul>
						<li><a href="teachplanUphold.html" onClick="return true;">教案制作维护</a></li>
						<li><a href="coursewareUp_Down.html" onClick="return true;">课件上传下载</a></li>
						<li><a href="homeWork.html" onClick="return true;">课外作业管理</a></li>
						<li><a href="teachSchedule.html" onClick="return true;">授课计划管理</a></li>
					</ul>
				</div>
				<div class="subMainNavItem" id="subNavD">
					<ul>
						<li><a href="attendance.html" onClick="return true;">在线考勤管理</a></li>
						<li><a href="projectReply.html" onClick="return true;">项目答辩考核</a></li>
						<li><a href="compositeCheck.html" onClick="return true;">课程综合考核</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container">
			<h3 class="autoplantitle">添加学生</h3>
			<div class=" mainbox">
				<div>
					<form action="addStudent">
						<input type="text" name="stuName"/>
						<input type="submit" />
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>
