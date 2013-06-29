<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<base href="<%="http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" %>" />
<meta charset="utf-8">
<title>登录界面</title>
<link rel="stylesheet" href="css/style.css" />
</head>

<body>
<jsp:include page="include/header.jsp" />
<div class="container">
	<div class="subMainNav">
		<div class="currentLocation">
			<a href="main.jsp">在线教学</a>> <a href="#">教学排课</a>> <a href="#">学期课表生成</a>
		</div>
		<div class="subMainNavItem" id="subNavA" style="display: block;">
			<ul>
				<li><a href="generateCourseplan.jsp" onClick="return true;"
					class="subMainNavItemActive">学期课表生成</a></li>
				<li><a href="courseplanCateSearch.jsp" onClick="return true;">课表分类查询</a></li>
				<li><a href="courseplanExport.jsp" onClick="return true;">课表分类导出</a></li>
				<li><a href="courseplanUphold.jsp" onClick="return true;">课表分类维护</a></li>
			</ul>
		</div>
		<div class="subMainNavItem" id="subNavB">
			<ul>
				<li><a href="createWork.jsp" onClick="return true;">课堂练习创建</a></li>
				<li><a href="workReply.jsp" onClick="return true;">课堂练习作答</a></li>
				<li><a href="workCheck.jsp" onClick="return true;">训练结果考核</a></li>
				<li><a href="workUphold.jsp" onClick="return true;">课堂练习维护</a></li>
			</ul>
		</div>
		<div class="subMainNavItem" id="subNavC">
			<ul>
				<li><a href="teachplanUphold.jsp" onClick="return true;">教案制作维护</a></li>
				<li><a href="coursewareUp_Down.jsp" onClick="return true;">课件上传下载</a></li>
				<li><a href="homeWork.jsp" onClick="return true;">课外作业管理</a></li>
				<li><a href="teachSchedule.jsp" onClick="return true;">授课计划管理</a></li>
			</ul>
		</div>
		<div class="subMainNavItem" id="subNavD">
			<ul>
				<li><a href="attendance.jsp" onClick="return true;">在线考勤管理</a></li>
				<li><a href="projectReply.jsp" onClick="return true;">项目答辩考核</a></li>
				<li><a href="compositeCheck.jsp" onClick="return true;">课程综合考核</a></li>
			</ul>
		</div>
	</div>
</div>

<div class="container">
	<div class="mainbox login-mainbox">
    	<div class="loginBox">
        	<div class="model-header">
            	<div class="logobox">
                	<span class="logo-a te">在线<span id="logo-a-add">教学</span></span>
                    <div class="logo-b">登录后使用相关功能</div>
                </div>
            	<div class="login-tit"><h3>登录</h3></div>
            </div>
            <form id="login-form" class="login-form" method="post" action="login/login">
            	<input type="hidden" name="role" value="student" id="loginRole"/>
            	<div class="login-student-box pullleft login-img gray" id="sturole"></div>
            	<div class="model-body pullleft">
                	<fieldset class="fieldStyle">
                    	<div class="form-field-group">
                        	<label for="id_username" class="inputLable" id="login-input-unl">学　号</label>
                            <div class="login-inputbox login-iun">
                            	<input type="text" name="username" id="id_username" class="inputField teslowly" />
                            </div>
                        </div>
                    	<div class="form-field-group">
                        	<label for="id_password" class="inputLable">密　码</label>
                            <div class="login-inputbox login-ipw">
                            	<input type="password" name="password" id="id_password" class="inputField teslowly" />
                            </div>
                        </div>
                    </fieldset>
                </div>
            	<div class="login-teacher-box pullleft login-img gray" id="tchrole"></div>
            	<div class="clearboth"></div>
                <div class="model-footer">
                	<a href="help.jsp" class="btn te pullleft">使用帮助</a>
                    <input type="submit" class="btn submitBtn te pullright" value="登录"/>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>