<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html id="courseplanCateSearch"> 
<head>
<meta charset="utf-8">
<title>课表分类查询</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
    <base href='${pageContext.request.requestURL}' />
</head>


<body>
	<jsp:include page="include/header.jsp" />
	<div class="site">
		<div id="searchType">
			<div id="colorPoint">
				<div class="prompt">
					<div class="teacherColor"></div>
					教师
				</div>
				<div class="prompt">
					<div class="classColor"></div>
					班级
				</div>
				<div class="prompt">
					<div class="roomColor"></div>
					教室
				</div>
				<div class="prompt">
					<div class="courseColor"></div>
					课程
				</div>
			</div>
			<s:if test="#session.usertype == '教师'">
			查询类型：<select id="sType">
					<option value="sbClass">班级</option>
					<option value="sbTeacher">教师</option>
					<option value="sbRoom">教室</option>
				</select>
			选项：
			<select id="sName">
				</select>
			</s:if>
			<s:else>
				<input type="hidden" name="user" id="user" value='<s:property value="#session.user.schoolClass.scID"/>' />
			</s:else>
		</div>
		<div id="coursePlanView">
			<table cellspacing="0" onselectstart="return false;">
				<tr class="coursePlanTitle1 coursePlanTitle">
					<td>&nbsp;</td>
					<td>节数</td>
					<td>星期一</td>
					<td>星期二</td>
					<td>星期三</td>
					<td>星期四</td>
					<td>星期五</td>
					<td>星期六</td>
					<td>星期日</td>
				</tr>
				<tr>
					<td rowspan="4" class="coursePlanTitle3 coursePlanTitle">上<br />午
					</td>
					<td class="coursePlanTitle2 coursePlanTitle">第一节</td>
					<div>
						<td id="p1" rowspan="2">&nbsp;</td>
						<td id="p7" rowspan="2">&nbsp;</td>
						<td id="p13" rowspan="2">&nbsp;</td>
						<td id="p19" rowspan="2">&nbsp;</td>
						<td id="p25" rowspan="2">&nbsp;</td>
						<td id="p31" rowspan="2">&nbsp;</td>
						<td id="p37" rowspan="2">&nbsp;</td>
					</div>
				</tr>
				<tr>
					<td class="coursePlanTitle2 coursePlanTitle">第二节</td>
				</tr>
				<tr>
					<td class="coursePlanTitle2 coursePlanTitle">第三节</td>
					<td id="p2" rowspan="2">&nbsp;</td>
					<td id="p8" rowspan="2">&nbsp;</td>
					<td id="p14" rowspan="2">&nbsp;</td>
					<td id="p20" rowspan="2">&nbsp;</td>
					<td id="p26" rowspan="2">&nbsp;</td>
					<td id="p32" rowspan="2">&nbsp;</td>
					<td id="p38" rowspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td class="coursePlanTitle2 coursePlanTitle">第四节</td>
				</tr>
				<tr>
					<td rowspan="4" class="coursePlanTitle3 coursePlanTitle">下<br />午
					</td>
					<td class="coursePlanTitle2 coursePlanTitle">第五节</td>
					<td id="p3" rowspan="2">&nbsp;</td>
					<td id="p9" rowspan="2">&nbsp;</td>
					<td id="p15" rowspan="2">&nbsp;</td>
					<td id="p21" rowspan="2">&nbsp;</td>
					<td id="p27" rowspan="2">&nbsp;</td>
					<td id="p33" rowspan="2">&nbsp;</td>
					<td id="p39" rowspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td class="coursePlanTitle2 coursePlanTitle">第六节</td>
				</tr>
				<tr>
					<td class="coursePlanTitle2 coursePlanTitle">第七节</td>
					<td id="p4" rowspan="2">&nbsp;</td>
					<td id="p10" rowspan="2">&nbsp;</td>
					<td id="p16" rowspan="2">&nbsp;</td>
					<td id="p22" rowspan="2">&nbsp;</td>
					<td id="p28" rowspan="2">&nbsp;</td>
					<td id="p34" rowspan="2">&nbsp;</td>
					<td id="p40" rowspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td class="coursePlanTitle2 coursePlanTitle">第八节</td>
				</tr>
				<tr>
					<td rowspan="4" class="coursePlanTitle3 coursePlanTitle">晚<br />上
					</td>
					<td class="coursePlanTitle2 coursePlanTitle">第九节</td>
					<td id="p5" rowspan="2">&nbsp;</td>
					<td id="p11" rowspan="2">&nbsp;</td>
					<td id="p17" rowspan="2">&nbsp;</td>
					<td id="p23" rowspan="2">&nbsp;</td>
					<td id="p29" rowspan="2">&nbsp;</td>
					<td id="p35" rowspan="2">&nbsp;</td>
					<td id="p41" rowspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td class="coursePlanTitle2 coursePlanTitle">第十节</td>
				</tr>
				<tr>
					<td class="coursePlanTitle2 coursePlanTitle">第十一节</td>
					<td id="p6" rowspan="2">&nbsp;</td>
					<td id="p12" rowspan="2">&nbsp;</td>
					<td id="p18" rowspan="2">&nbsp;</td>
					<td id="p24" rowspan="2">&nbsp;</td>
					<td id="p30" rowspan="2">&nbsp;</td>
					<td id="p36" rowspan="2">&nbsp;</td>
					<td id="p42" rowspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td class="coursePlanTitle2 coursePlanTitle">第十二节</td>
				</tr>
			</table>
		</div>
	</div>

	<jsp:include page="include/footer.jsp" />
	<s:if test="#session.usertype == '教师'">
		<script type="text/javascript">
			$("#courseplanCateSearch").ready(function() {
				$.getSelectName($("#sType").val());
			});
		</script>
	</s:if>
	<s:else>
		<script type="text/javascript">
			$.getCoursePlan("sbClass", $("#user").val());
		</script>	
	</s:else>
</body>
</html>