<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>课堂练习作答</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<base href='http://<%=request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+request.getServletPath()%>' />
</head>

<body>

<jsp:include page="include/header.jsp" />

<div class="site">
    <div class="container">
		<div class="subMainNav">
        	<div class="currentLocation">
            	<a href="main.html">在线教学</a>&gt;
                <a href="#">课堂练习</a>&gt;
                <a href="#">课堂练习创建</a>
            </div>
 			<jsp:include page="include/menu2.jsp"></jsp:include>
		</div>
      <div class="courseTimeLabel">
        <div class="courseTimeLabelItem pullleft courseTimeLabelItemOne">上一次课：2013-4-12 星期三 上午 3-4节</div>
        <h4 class="courseTimeLabelItem pullleft courseTimeLabelItemTwo">毛泽东思想</h4>
        <div class="courseTimeLabelItem pullright courseTimeLabelItemThree">下一次课：2013-4-14 星期五 下午 7-8节</div>
        </div>         
    </div>   
</div>
<div class="draft" onClick="alert('此功能尚未开放！');">稿<br/>纸</div>
<div class="mainbox container" style="border:1px solid #ccc; margin-top:10px;">
	<div class="topicList">
    	<div class="topicTitle">
        	<div class="tTitle ttNo pullleft">试卷号</div>
        	<div class="tTeacher pullleft">授题老师</div>
        	<div class="tCreateTime pullleft">创建时间</div>
            <div class="clearboth"></div>
        </div>
        <div class="topicNameList">
        	<table id="exList" class="exList"></table>
        </div>
    </div>
    
    <div class="answerNotes">    	
    	<div class="topicTitle">
        	<div class="tTitle">答题记录
            	<select class="select_time" onFocus="return showCoursePlan('selectView_coursePlan');">
                	<option>选择时间</option>
                </select>
            </div>
        </div>
    	<div class="notes">
        	<div class="noteTitle">
            	<div class="noteTitleTime">2013年4月20日 本期第10周 星期一 下午3-4节课</div>
                <div class="noteTitleScore"> 得分：69</div>
            </div>
            <div class="note">
            	<ul style="list-style:disc;">
                	<li><a href="#">为什么金属会有不同的堆积方式？</a></li>
                	<li><a href="#">决定金属堆积方式的因素是什么？</a></li>
                    <li><a href="#">为什么过渡金属（从钪到锌）4s层……</a></li>                    
                </ul>
            </div>
        </div>
    	<div class="notes">
        	<div class="noteTitle">
            	<div class="noteTitleTime">2013年4月20日 本期第10周 星期二 下午7-8节课</div>
                <div class="noteTitleScore"> 得分：86</div>
            </div>
            <div class="note">
            	<ul style="list-style:disc;">
                	<li><a href="#">能否介绍一下诱变育种和秋水仙素育种以及其……</a></li>
                    <li><a href="#">胰岛素是含有51个氨基酸的蛋白质,控制合成……</a></li>
                	<li><a href="#">为什么定时给成年狗注射甲状腺激素出现的现……</a></li>                  
                </ul>
            </div>
        </div>
                
    </div>
    <div class="clearboth"></div>    
</div>

<a name="question_begin" id="question_begin" ></a>
<form method="post" id="daTit">
	<div class="daTit tbHead container" id="daTit">题目列表</div>
</form>

<jsp:include page="include/footer.jsp" />
<script src="script/workreply.js"></script>

</body>
</html>
