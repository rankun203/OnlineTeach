<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>学期课表生成</title>
<link rel="stylesheet" href="css/style.css" />
</head>

<body>

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
            onclick="window.location='http://www.pinkbike.com';"
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
            <ul>
                <li class="pullleft"><a class="aMainNavItem" id="mainNavA" href="#" onClick="return false;" onMouseOver="mainNavExchange('mainNavA', 'subNavA');">教学排课</a></li>
                <li class="pullleft"><a class="aMainNavItem aMainNavItemActive" href="#" id="mainNavB" onClick="return false;" onMouseOver="mainNavExchange('mainNavB', 'subNavB');">课堂练习</a></li>
                <li class="pullleft"><a class="aMainNavItem" href="#" id="mainNavC" onClick="return false;" onMouseOver="mainNavExchange('mainNavC', 'subNavC');">教学资料</a></li>
                <li class="pullleft"><a class="aMainNavItem" href="#" id="mainNavD" onClick="return false;" onMouseOver="mainNavExchange('mainNavD', 'subNavD');">课堂考核</a></li>
            </ul>
        </div>
        <div class="headerPaneDivide pullleft"></div>
        <div class="userProfile pullleft">
            <div class="userProfileLeft pullleft">
                <div class="userProfileItem">张世杰</div>
                <div class="userProfileItem">教师</div>
            </div>
            <div class="userProfileRight pullright">
                <div class="userProfileItem">正在上课：计软113-2 Java</div>
                <div class="userProfileItem">2013年 4月 8日</div>
            </div>
        </div>
        <div class="clearboth"></div>
    </div>
</div>
<div class="site">
    <div class="container">
		<div class="subMainNav">
        	<div class="currentLocation">
            	<a href="main.html">在线教学</a>>
                <a href="#">教学排课</a>>
                <a href="#">学期课表生成</a>
            </div>
 			<div class="subMainNavItem" id="subNavA" style="display:block;">
                <ul>
                    <li><a href="generateCourseplan.html" onClick="return true;" class="subMainNavItemActive">学期课表生成</a></li>
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
        </div>
    </div>
</div>

</body>
</html>