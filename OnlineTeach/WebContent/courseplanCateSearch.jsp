<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
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

    <div id="coursePlanView">
        <table cellspacing="0" onselectstart="return false;">
            <tr class="coursePlanTitle">
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
                <td rowspan="4" class="coursePlanTitle">上<br />午</td>
                <td class="coursePlanTitle">第一节</td>
                <td id="oneone" onmousedown="return setMouseDown('oneone');" onmouseup="return setMouseUp('oneone');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">语文</td>
                <td id="onetwo" onmousedown="return setMouseDown('onetwo');" onmouseup="return setMouseUp('onetwo');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">英语</td>
                <td id="onethree" onmousedown="return setMouseDown('onethree');" onmouseup="return setMouseUp('onethree');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">英语</td>
                <td id="onefour" onmousedown="return setMouseDown('onefour');" onmouseup="return setMouseUp('onefour');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">语文</td>
                <td id="onefive" onmousedown="return setMouseDown('onefive');" onmouseup="return setMouseUp('onefive');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">英语</td>
                <td id="onesix" onmousedown="return setMouseDown('onesix');" onmouseup="return setMouseUp('onesix');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">语文</td>
                <td id="oneseven" onmousedown="return setMouseDown('oneseven');" onmouseup="return setMouseUp('oneseven');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第二节</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第三节</td>
                <td id="twoone" onmousedown="return setMouseDown('twoone');" onmouseup="return setMouseUp('twoone');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">数学</td>
                <td id="twotwo" onmousedown="return setMouseDown('twotwo');" onmouseup="return setMouseUp('twotwo');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">语文</td>
                <td id="twothree" onmousedown="return setMouseDown('twothree');" onmouseup="return setMouseUp('twothree');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">数学</td>
                <td id="twofour" onmousedown="return setMouseDown('twofour');" onmouseup="return setMouseUp('twofour');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">体育</td>
                <td id="twofive" onmousedown="return setMouseDown('twofive');" onmouseup="return setMouseUp('twofive');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">数学</td>
                <td id="twosix" onmousedown="return setMouseDown('twosix');" onmouseup="return setMouseUp('twosix');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">数学</td>
                <td id="twoseven" onmousedown="return setMouseDown('twoseven');" onmouseup="return setMouseUp('twoseven');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第四节</td>
            </tr>
            <tr>
                <td rowspan="4" class="coursePlanTitle">下<br />午</td>
                <td class="coursePlanTitle">第五节</td>
                <td id="threeone" onmousedown="return setMouseDown('threeone');" onmouseup="return setMouseUp('threeone');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">物理</td>
                <td id="threetwo" onmousedown="return setMouseDown('threetwo');" onmouseup="return setMouseUp('threetwo');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">化学</td>
                <td id="threethree" onmousedown="return setMouseDown('threethree');" onmouseup="return setMouseUp('threethree');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">生物</td>
                <td id="threefour" onmousedown="return setMouseDown('threefour');" onmouseup="return setMouseUp('threefour');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">政治</td>
                <td id="threefive" onmousedown="return setMouseDown('threefive');" onmouseup="return setMouseUp('threefive');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">数学</td>
                <td id="threesix" onmousedown="return setMouseDown('threesix');" onmouseup="return setMouseUp('threesix');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td id="threeseven" onmousedown="return setMouseDown('threeseven');" onmouseup="return setMouseUp('threeseven');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第六节</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第七节</td>
                <td id="fourone" onmousedown="return setMouseDown('fourone');" onmouseup="return setMouseUp('fourone');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">生物</td>
                <td id="fourtwo" onmousedown="return setMouseDown('fourtwo');" onmouseup="return setMouseUp('fourtwo');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">物理</td>
                <td id="fourthree" onmousedown="return setMouseDown('fourthree');" onmouseup="return setMouseUp('fourthree');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">化学</td>
                <td id="fourfour" onmousedown="return setMouseDown('fourfour');" onmouseup="return setMouseUp('fourfour');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">生物</td>
                <td id="fourfive" onmousedown="return setMouseDown('fourfive');" onmouseup="return setMouseUp('fourfive');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">物理</td>
                <td id="foursix" onmousedown="return setMouseDown('foursix');" onmouseup="return setMouseUp('foursix');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td id="fourseven" onmousedown="return setMouseDown('fourseven');" onmouseup="return setMouseUp('fourseven');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第八节</td>
            </tr>
            <tr>
                <td rowspan="4" class="coursePlanTitle">晚<br />上</td>
                <td class="coursePlanTitle">第九节</td>
                <td id="fiveone" onmousedown="return setMouseDown('fiveone');" onmouseup="return setMouseUp('fiveone');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">英语</td>
                <td id="fivetwo" onmousedown="return setMouseDown('fivetwo');" onmouseup="return setMouseUp('fivetwo');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">语文</td>
                <td id="fivethree" onmousedown="return setMouseDown('fivethree');" onmouseup="return setMouseUp('fivethree');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">数学</td>
                <td id="fivefour" onmousedown="return setMouseDown('fivefour');" onmouseup="return setMouseUp('fivefour');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">英语</td>
                <td id="fivefive" onmousedown="return setMouseDown('fivefive');" onmouseup="return setMouseUp('fivefive');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">化学</td>
                <td id="fivesix" onmousedown="return setMouseDown('fivesix');" onmouseup="return setMouseUp('fivesix');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td id="fiveseven" onmousedown="return setMouseDown('fiveseven');" onmouseup="return setMouseUp('fiveseven');" rowspan="2" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第十节</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第十一节</td>
                <td id="sixone" rowspan="2" onmousedown="return setMouseDown('sixone');" onmouseup="return setMouseUp('sixone');" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">语文</td>
                <td id="sixtwo" rowspan="2" onmousedown="return setMouseDown('sixtwo');" onmouseup="return setMouseUp('sixtwo');" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">物理</td>
                <td id="sixthree" rowspan="2" onmousedown="return setMouseDown('sixthree');" onmouseup="return setMouseUp('sixthree');" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">生物</td>
                <td id="sixfour" rowspan="2" onmousedown="return setMouseDown('sixfour');" onmouseup="return setMouseUp('sixfour');" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">英语</td>
                <td id="sixfive" rowspan="2" onmousedown="return setMouseDown('sixfive');" onmouseup="return setMouseUp('sixfive');" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">数学</td>
                <td id="sixsix" rowspan="2" onmousedown="return setMouseDown('sixsix');" onmouseup="return setMouseUp('sixsix');" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td id="sixseven" rowspan="2" onmousedown="return setMouseDown('sixseven');" onmouseup="return setMouseUp('sixseven');" onmousemove="this.bgColor='#ACEBA0';" onmouseout="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第十二节</td>
            </tr>                                                                                                        
        </table>
    </div>
</div>
<script type="text/javascript">
	var isDown = false;
	var curID,tagID;
	function setMouseDown(cid) {
		curID = cid;
		isDown = true;
	}
	function setMouseUp(tid) {
		tagID = tid;
		if(curID != tagID) {
			dragChange();
		}
		isDown = false;
	}
	function dragChange() {
			var curValue = document.getElementById(curID).innerHTML;
			var tagValue = document.getElementById(tagID).innerHTML;
			document.getElementById(curID).innerHTML = tagValue;
			document.getElementById(tagID).innerHTML = curValue;
			console.log(curValue + " ____  " + tagValue);
		}
</script>

<jsp:include page="include/footer.jsp"/>
</body>
</html>