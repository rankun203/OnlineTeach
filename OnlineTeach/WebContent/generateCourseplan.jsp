<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>学期课表生成</title>
<link rel="stylesheet" href="css/style.css" />

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
						<li><a href="generateCourseplan.html" onClick="return true;"
							class="subMainNavItemActive">学期课表生成</a></li>
						<li><a href="main.html" onClick="return true;">课表分类查询</a></li>
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
			<h3 class="autoplantitle">课程编排</h3>
			<div class="pb mainbox">
				<div class="pbBtn pullleft">
					<button class="apstart btn">开始排课</button>
				</div>


				<div class="pbpb pullleft">
					<div class="progress-bar blue stripes">
						<!-- <span style="width: 40%"></span> -->
						<span id="pbprogress">已就绪</span>
					</div>
				</div> 
				<button class="evert btn">翻转</button>
				<div id="autoPlanInfo">
					<div id="console" style="display: none;">
						排课系统准备就绪，点击开始排课开始。
					</div>
					<div id="apiList" style="display: block;">
						<div
							style="text-align:center; line-height:15px; margin: 3px; background-color: #f0f; width: 65px; height: 30px;">软件技术
							113-1</div>
						<div
							style="text-align:center; line-height:30px; margin: 30px; background-color: #53f; width: 80px; height: 30px;">李灵黛</div>
						<div
							style="text-align:center; line-height:30px; margin: 23px; background-color: #78e; width: 80px; height: 30px;">A101</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>
