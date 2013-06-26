<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.9.1.js"></script>
<script type="text/javascript">
	function getData() {
		htmlobj=$.ajax({url:"test/show",async:false});
		$(".test").html(htmlobj.responseText);
		setTimeout("getData()", 1000);
	}
	$(document).ready(function() {
		$(".begin").click(function() {
			getData();
		});
	});
</script>
</head>
<body>
	<%=request.getParameter("typeName") %>
</body>
</html>