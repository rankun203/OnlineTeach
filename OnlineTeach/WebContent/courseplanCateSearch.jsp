<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html id="courseplanCateSearch">
<head>
<meta charset="utf-8">
<title>课表分类查询</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
</head>

<body>
<jsp:include page="include/header.jsp"/>
<div class="site">
    <div class="container">
		<div class="subMainNav">
        	<div class="currentLocation">
            	<a href="main.html">在线教学</a> >
                <a href="#">教学排课</a> >
                <a href="#">课表分类查询</a>
            </div>
             <div class="subMainNavItem" id="subNavA" style="display:block;">
                <ul>
                    <li><a href="generateCourseplan.jsp" onClick="return true;">学期课表生成</a></li>
                    <li><a href="courseplanCateSearch.jsp" onClick="return true;" class="subMainNavItemActive">课表分类查询</a></li>
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
</div>
	<div id="searchType">
		查询类型：<select id="sType">
			<option value="sbClass">班级</option>
			<option value="sbTeacher">教师</option>
			<option value="sbRoom">教室</option>
		</select>
		选项：
		<select id="sName">
		</select>
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
                <td rowspan="4" class="coursePlanTitle3 coursePlanTitle">上<br />午</td>
                <td class="coursePlanTitle2 coursePlanTitle">第一节</td>
                <td id="p1" rowspan="2">&nbsp;</td>
                <td id="p7" rowspan="2">&nbsp;</td>
                <td id="p13" rowspan="2">&nbsp;</td>
                <td id="p19" rowspan="2">&nbsp;</td>
                <td id="p25" rowspan="2">&nbsp;</td>
                <td id="p31" rowspan="2">&nbsp;</td>
                <td id="p37" rowspan="2">&nbsp;</td>
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
                <td rowspan="4" class="coursePlanTitle3 coursePlanTitle">下<br />午</td>
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
                <td rowspan="4" class="coursePlanTitle3 coursePlanTitle">晚<br />上</td>
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

<jsp:include page="include/footer.jsp"/>
<script type="text/javascript">
	$("#courseplanCateSearch").ready(function() {
		$.getSelectName($("#sType").val());
	});
</script>
</body>
</html>