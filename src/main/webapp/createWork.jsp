<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.teachMng.onlineTeach.model.*" %>

<!DOCTYPE html>
<html id="createWork">
<head>
<meta charset="utf-8">
<title>课堂练习创建</title>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/style.css" />
<base href='http://<%=request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+request.getServletPath()%>' />
</head>

<body>

<jsp:include page="include/header.jsp" />
<div class="container">
	<div class="subMainNav">
		<div class="currentLocation">
			<a href="main.jsp">在线教学</a>&gt; <a href="#">教学排课</a>&gt; <a href="#">学期课表生成</a>
		</div>
		<jsp:include page="include/menu2.jsp"></jsp:include>
	</div>
</div>
<div class="site">
    <div class="container">
        <div class="courseTimeLabel">
            <div class="courseTimeLabelItem pullleft courseTimeLabelItemOne">上一次课：2013-4-12 星期三 上午 3-4节</div>
            <h4 class="courseTimeLabelItem pullleft courseTimeLabelItemTwo">毛泽东思想</h4>
            <div class="courseTimeLabelItem pullright courseTimeLabelItemThree">下一次课：2013-4-14 星期五 下午 7-8节</div>
        </div>
         <div class="quickLook mainbox pullleft">  
		  </div>
		<div class="firstLR">
		  <div class="mainbox LRleft pullleft">
		    <div class="cwCoursingTitle">
            	<div class="cwCoursingTitleTxt">正在进行的课堂练习</div>
            </div>
		    <div class="cwCoursing">
            	<ul id="cwCoursing">
            	</ul>
            </div>
		  </div><!-- End of LRleft -->
		  <div class="mainbox LRRight pullright">
		    <div class="workLabelUp">
            	<div class="pullleft cacbDiv">
	                <input type="checkbox" name="checkAllCheckbox" class="checkAllCheckbox" id="checkAllCheckbox" onMouseOver="pmt('checkAllCheckbox', '全选/取消全选');" onMouseOut="erasePmt();" onChange="slctChange();">
                </div>
                <div class="pullleft flatbtn wluBtn" id="returnToList" style="display:none;">
                	<div class="returnToListImg" id="returnToListImg"></div>
                </div>
                <div class="pullleft flatbtn wluBtn" id="createCourseButton" onMouseOver="pmt('createCourseButton', '创建新的练习');" onMouseOut="erasePmt();" onClick="showCreateWork();">
                	<div class="createCourseButtonImg" onClick="showCreateWork();"></div>
                </div>
                <div class="pullleft flatbtn wluBtn" id="archiveButton" onMouseOver="pmt('archiveButton', '存档');" onMouseOut="erasePmt();">
                	<div class="archiveButtonImg"></div>
                </div>
                <div class="pullleft flatbtn wluBtn" id="delButton" onMouseOver="pmt('delButton', '删除');" onMouseOut="erasePmt();">
                	<div class="delButtonImg"></div>
                </div>
                <div class="pullleft flatbtn wluBtn shareButton" id="shareButton" onMouseOver="pmt('shareButton', '分发题目');" onMouseOut="erasePmt();">
                	<div class="shareButtonImg"></div>
                </div>
                <div id="selectClassPos">
                	<select id="selectClass">
                		<option>将此题目分发给</option>
                	</select>
                </div>	
                <div class="clearboth"></div>
            </div>
            <div class="workLabelDown">
            	<div class="workLabelDownTit" id="workLabelDownTit">我的题库</div>
                <div class="workLabelDownContainer">
 					<jsp:include page="include/newExerciseSnippet.jsp" />
                    <div class="wldcListBox" id="wldcListBox">
                        <ul id="wldcListBoxUl">
                        </ul>
                    </div><!-- End of wldcListBox -->
                </div><!-- End of workLabelDownContainer -->
            </div>
		  </div><!-- End of LRRight -->          
		</div><!-- End of firstLR -->
        <div class="dynamicAnswer" id="dynamicAnswer" style="display:block;">
        	<div class="daTit tbHead" id="daTit">
        		答题动态
        		<a class="playPause pullright" onClick="replyStatus.myReady.toggleTimer();return false;" href="#" id="toggleUpdateAnswer">Loading...</a>
        	</div>
			<div class="mainbox container dynamicAnswerItem" id="ansHold">
				<div class="present">暂无学生答题</div>
			</div>
<!-- 
			<div class="long-ans-modal">
				<h2>简答题答案：</h2>
				<div class="ans-txt">Hey greedy,don’t fret
What you see is what you get<br>You name it,I have it<br>What you see is what you get<br><br>左左 左左 偏左 就用左手<br>生活 就不用 想太多<br>怦怦 怦怦 心动 张开眼睛<br>就记得当下的 强烈<br><br><br>有时灵光一闪而过<br>牛顿也吃苹果<br>我的念头不太罗嗦<br><br>限时间能入座<br><br>请你 不要到处叩叩<br>潮流需要抠抠 不小心就没抠抠<br>用力到处扣扣 花掉所有抠抠<br>钱买不到绝活<br><br>你说 听说 听说 你听谁说<br>跟着 乱走 闹哄哄<br>通通 通通 普通 普通<br>如果不懂 不要 随便 拒绝<br><br>有时灵光一闪而过<br>牛顿也吃苹果<br>我的念头不太罗嗦<br>限时间能入座<br><br>请你 不要到处叩叩<br>潮流需要抠抠 不小心就没抠抠<br>用力到处扣扣 花掉所有抠抠<br>钱买不到绝活<br><br>Little chick having chips on my sofa<br>Bearbricxs take a shit on my sofa<br>Smudge babies lying on my sofa<br>Neighborhxxds and kiks singing “so-fa”<br><br>Little chick having chips on my sofa<br>Bearbricxs take a shit on my sofa<br>Smudge babies lying on my sofa<br><br>Hey greedy,don’t fret<br>What you see is what you get<br>You name it,I have it<br>What you see is what you get<br><br>请你 不要到处叩叩<br>潮流需要抠抠 不小心就没抠抠<br>用力到处扣扣 花掉所有抠抠<br>钱买不到绝活<br><br>Hey greedy,don’t fret(叩叩)<br>What you see is what you get(叩叩)<br>You name it,I have it(不要到处叩叩)<br>What you see is what you get<br><br>Hey greedy,don’t fret(不要到处叩叩)<br>What you see is what you get(叩叩)<br>You name it,I have it(叩叩)<br>What you see is what you get<br><br>叩叩... 叩叩 ...</div>
			</div>
 -->			
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />
<script src="script/newExercise.js"></script>
<script src="script/teacherRemark.js"></script>
<script type="text/javascript">
	$.getAllExercise();
</script>
</body>
</html>