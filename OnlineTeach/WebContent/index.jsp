<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html id="generateCoursePlan">
<head>
<meta charset="utf-8">
<title>主页</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />

</head>

<body>

	<jsp:include page="include/header.jsp" />

	<div class="site">
		<div class="container">
			<h3 class="autoplantitle">主页</h3>
			<div class="pb mainbox"></div>
		</div>
	</div>
	<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>
