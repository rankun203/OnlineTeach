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
        	<div class="tTitle">本节课题目</div>
            <a href='#question_begin' class="beginAnswer">开始答题</a>
        </div>
        <div class="topicNameList">
        	<ul style="list-style:decimal;">
            	<li><a href="#">告诉 Windows 验证文件是否正确写入磁盘……</a></li>
                <li><a href="#">告诉 Windows 验证文件是否正确写入磁盘……</a></li>  
                <li><a href="#">告诉 Windows 验证文件是否正确写入磁盘……</a></li>
                <li><a href="#">告诉 Windows 验证文件是否正确写入磁盘……</a></li>  
                <li><a href="#">告诉 Windows 验证文件是否正确写入磁盘……</a></li>
                <li><a href="#">告诉 Windows 验证文件是否正确写入磁盘……</a></li>  
                <li><a href="#">告诉 Windows 验证文件是否正确写入磁盘……</a></li>
                <li><a href="#">告诉 Windows 验证文件是否正确写入磁盘……</a></li>     
                <li><a href="#">告诉 Windows 验证文件是否正确写入磁盘……</a></li>     
                <li><a href="#">告诉 Windows 验证文件是否正确写入磁盘……</a></li>     
            </ul>
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
                	<li><a href="#">在交互命令外壳里显示 WMI 信息……</a></li>
                	<li><a href="#">在交互命令外壳里显示 WMI 信息……</a></li>
                    <li><a href="#">终止正在运行的进程或应用程序……</a></li>                    
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
                	<li><a href="#">在交互命令外壳里显示 WMI 信息……</a></li>
                    <li><a href="#">终止正在运行的进程或应用程序……</a></li>
                	<li><a href="#">在交互命令外壳里显示 WMI 信息……</a></li>                  
                </ul>
            </div>
        </div>
                
    </div>
    <div class="clearboth"></div>    
</div>

<a name="question_begin" id="question_begin" ></a>
<form method="post">
	<div class="daTit tbHead container" id="daTit">题目列表</div>

    <div class="mainbox container replyItem" id="sel-tpl">
    	<h3 class="itemCount divInfo" id="itemCount-tpl">1</h3>
        <div class="single_question_answer">
            <div class="single_question" id="selQes-tpl">
            	选择题题目<hr><br>A.你是什么<br>B.我是B<br>C.我是C<br>D.我是D
            </div>
        </div>
        <div class="sel-select-box">
        	<input type="hidden" name="sel-tpl-val" value="" id="sel-tpl-val" />
			<div class="sel-sb-opt sel-sb-a sel-opt-tpl pullleft" id="sel-a-tpl">A<div class="sel-tpl-ed" id="sel-a-tpl-ed"></div></div>
			<div class="sel-sb-opt sel-sb-b sel-opt-tpl pullleft" id="sel-b-tpl">B<div class="sel-tpl-ed" id="sel-b-tpl-ed"></div></div>
			<div class="sel-sb-opt sel-sb-c sel-opt-tpl pullleft" id="sel-c-tpl">C<div class="sel-tpl-ed" id="sel-c-tpl-ed"></div></div>
			<div class="sel-sb-opt sel-sb-d sel-opt-tpl pullleft" id="sel-d-tpl">D<div class="sel-tpl-ed" id="sel-d-tpl-ed"></div></div>
			<div class="clearboth"></div>
        </div>
    </div>

    <div class="mainbox container replyItem" id="ans-tpl">
    	<h3 class="itemCount divInfo" id="itemCount-tpl">2</h3>
        <div class="answer_question">
            <div class="a_question" id="ans-tpl">
                我是问题，我是问题，我就是题噢。你晓得了卜？
            </div>
            <div class="inputArea">
                <div class="a_txt">答：</div>
                <textarea rows="10" cols="131" class="a_answer inputField sslote" name="answer1" id="ans-tpl-val" ></textarea>
            </div>
        </div>
    </div>

    <div class="mainbox container replyItem" id="jug-tpl">
    	<h3 class="itemCount divInfo" id="itemCount-tpl">15</h3>
        <div class="judge_question">
            <div class="j_question">
                我对不对？你说我对不对？你说我到底对不对？？？
            </div>
        </div>
        <div class="j_answer_box">
        	<input type="hidden" name="jug-tpl-val" value="" id="jug-tpl-val" />
			<div class="j_true j_answer jug-tpl-opt pullleft" id="jug-tpl-opt-a">√<div class="jug-tpl-ed" id="jug-tpl-opt-a-ed"></div></div>
			<div class="j_false j_answer jug-tpl-opt pullleft" id="jug-tpl-opt-b">x<div class="jug-tpl-ed" id="jug-tpl-opt-b-ed"></div></div>
			<div class="clearboth"></div>
        </div>
    </div>

    <div class="mainbox container replyItem" id="cpl-tpl" >
    	<h3 class="itemCount divInfo" id="itemCount-tpl">23</h3>
        <div class="fill_vacant_question">
            <div class="fv_question">
	            我是问题，我后面是填空<input type="text" name="fv_answer" class="fv_input cpl-tpl-vals" />前面是填空
	            我是问题，我后面是填空<input type="text" name="fv_answer" class="fv_input cpl-tpl-vals" />前面是填空
	            我是问题，我后面是填空<input type="text" name="fv_answer" class="fv_input cpl-tpl-vals" />前面是填空
            </div>
        </div>
    </div>

</form>

<jsp:include page="include/footer.jsp" />
<script src="script/workreply.js"></script>

</body>
</html>
