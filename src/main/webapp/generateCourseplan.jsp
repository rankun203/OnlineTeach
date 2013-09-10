<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html id="generateCoursePlan">
<head>
<meta charset="utf-8">
<title>学期课表生成</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<base href='http://<%=request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+request.getServletPath()%>' />
</head>

<body>

	<jsp:include page="include/header.jsp" />
	<div class="container">
		<div class="subMainNav">
			<div class="currentLocation">
				<a href="main.jsp">在线教学</a>> <a href="#">教学排课</a>> <a href="#">学期课表生成</a>
			</div>
			<jsp:include page="include/menu2.jsp"></jsp:include>
		</div>
	</div>
	<div class="site">

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
				<div id="autoPlaninfoLeft">
					<button class="evert btn">翻转</button>
				</div>
				<div id="autoPlanInfo">
					<div id="console" style="display: none;">
						<font id="pkTitle">Studio325排课系统</font>
					</div>
					<div id="apiList" style="display: block;">正在加载信息中...</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="include/footer.jsp"></jsp:include>
	<script type="text/javascript">
		$.post("ap/generateCP", null, function(data){
			var obj = eval("(" + data + ")");
			var oldInfo = "";
			var cName = "";
			for(var i = 0; i < obj.length; i++) {
				if("1" == obj[i].id) 
					cName = "studentTag showTag"; 
				else if("2" == obj[i].id) 
					cName = "teacherTag showTag";
				else if("3" == obj[i].id)
					cName = "roomTag showTag";
				oldInfo += "<div class=\"" + cName + "\" >" + obj[i].name + "</div>";
			}
			console.log(oldInfo);
			$("#apiList").html(oldInfo);
		});
	</script>
</body>
</html>
