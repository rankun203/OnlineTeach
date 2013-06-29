<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>课堂练习作答</title>
<link rel="stylesheet" href="css/style.css" />
<base href='http://<%=request.getServerName()+":"+request.getLocalPort()+request.getContextPath()%>/' />
</head>

<body>

<div id="selectView_coursePlan" class="selectView_coursePlan">
    <div class="absoluteCoursePlanNav coursePlanNav">
        <div class="monthView" onClick="alert('此功能尚未开放！');">月视图</div>
        <div class="coursePlanView" onClick="document.getElementById('coursePlan').style.display='block';" >课程表视图</div>
        <div class="currentDateTime">
            <a class="changeWeek preWeek" href="#"><</a>
            <div class="dateWeek">2012-2013 下期 5/18周</div>
            <a class="changeWeek nextWeek" href="#">></a>
        </div>
    </div>
    <div id="coursePlan" class="absoluteCoursePlan coursePlan">
        <table cellspacing="0">
            <tr class="coursePlanTitle">
                <td class="coursePlanClose" onClick="document.getElementById('selectView_coursePlan').style.display='none';">X</td>
                <td>节数</td>
                <td>星期一</td>
                <td>星期二</td>
                <td>星期三</td>
                <td>星期四</td>
                <td>星期五</td>
            </tr>
            <tr>
                <td rowspan="4" class="coursePlanTitle1">上<br />午</td>
                <td class="coursePlanTitle">第一节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第二节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第三节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第四节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td rowspan="4" class="coursePlanTitle1">下<br />午</td>
                <td class="coursePlanTitle">第五节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第六节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第七节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第八节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td rowspan="4" class="coursePlanTitle1">晚<br />上</td>
                <td class="coursePlanTitle">第九节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第十节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第十一节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>
            <tr>
                <td class="coursePlanTitle">第十二节</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
                <td onMouseMove="this.bgColor='#ACEBA0';" onMouseOut="this.bgColor='#FFFFFF';">&nbsp;</td>
            </tr>                                                                                                        
        </table>
    </div>
</div>

<jsp:include page="include/header.jsp" />

<div class="site">
    <div class="container">
		<div class="subMainNav">
        	<div class="currentLocation">
            	<a href="main.html">在线教学</a>>
                <a href="#">课堂练习</a>>
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
<div class="mainBox container" style="border:1px solid #ccc; margin-top:10px;">
	<div class="topicList">
    	<div class="topicTitle">
        	<div class="tTitle">本节课题目</div>
            <a href="#question_begin" class="beginAnswer">开始答题</a>
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

<a name="question_begin" ></a>
<form method="post">
    <div class="mainBox container" style="border:1px solid #ccc; margin-top:10px;">
        <div class="single_question_answer">
            <div class="single_question">
                1、在交互命令外壳里显示在交互命令外壳里显示 WMI 信息在交互命令外壳里显示 WMI 信息在交互命令外壳里显示 WMI 信息在交互命令外壳里显示 WMI 信息。
            </div>
            <div class="singleSelect">
                <ul style=" list-style:upper-latin;">
                    <li>在交互命令外壳里显外壳里显外壳里显外壳里显外壳里显示在</li>
                    <li>在交互命令外壳里外壳里显外壳里显显示在</li>
                    <li>在交互命令外壳里显外壳里显外壳里显外壳里显外壳里显外壳里显示在</li>
                    <li>在交互命令外壳里外壳里显外壳里显在</li>
                </ul>
            </div>
        </div>
        <div class="select_box">
            <label for="A"><div class="select_btn selectA" onMouseUp="return setSelectActive('s1', 's2', 's3', 's4');" >A<span id="s1" class="selectActive" ></span></div></label>
           <label for="B"><div class="select_btn selectB" onMouseUp="return setSelectActive('s2', 's1', 's3', 's4');">B<span id="s2" class="selectActive" /></div></label>
            <label for="C"><div class="select_btn selectC" onMouseUp="return setSelectActive('s3', 's2', 's1', 's4');">C<span id="s3" class="selectActive" /></div></label>
            <label for="D"><div class="select_btn selectD" onMouseUp="return setSelectActive('s4', 's2', 's3', 's1');">D<span id="s4" class="selectActive" /></div></label>
            
         <input type="radio" id="A" name="selectTopic" value="A"/>
	      <input type="radio" id="B" name="selectTopic" value="B"/>
	       <input type="radio" id="C" name="selectTopic" value="C"/>
	        <input type="radio" id="D" name="selectTopic" value="D"/>  
            
        </div>
    </div>
    <div class="mainBox container" style="border:1px solid #ccc; margin-top:10px;">
        <div class="answer_question">
            <div class="a_question">
                2、在交互命令外壳里显示在交互命令外壳里显示 WMI、在交互命令外壳里显示在交互命令外壳里显示 WMI、在交互命令外壳里显示在交互命令外壳里显示 WMI、在交互命令外壳里显示在交互命令外壳里显示 WMI 信息在交互命令外壳里显示 WMI 信息在交互命令外壳里显示 WMI 信息在交互命令外壳里显示 WMI 信息。
            </div>
            <div class="inputArea">
                <div class="a_txt">答：</div>
                <textarea rows="10" cols="131" class="a_answer" name="answer1" ></textarea>
            </div>
        </div>
    </div>
    <div class="mainBox container" style="border:1px solid #ccc; margin-top:10px;">
        <div class="judge_question">
            <div class="j_question">
                3、在交互命令外壳里显示在交互命令外壳里显示 WMI、在交互命令外壳里显示在交互命令外壳里显示 WMI、在交互命令外壳里显示在交互命令外壳里显示 WMI、在交互命令外壳里显示在交互命令外壳里显示 WMI 信息在交互命令外壳里显示 WMI 信息在交互命令外壳里显示 WMI 信息在交互命令外壳里显示 WMI 信息。
            </div>
        </div>
        <div class="j_answer_box">
            <label for="T1"><div class="j_true j_answer" onMouseUp="return setJudgeActive('j1', 'j2');">√<span id="j1" class="selectActive" /></div></label>
            <label for="F1"><div class="j_false j_answer" onMouseUp="return setJudgeActive('j2', 'j1');">x<span id="j2" class="selectActive" /></div></label>
            <input type="radio" name="judge1" value="T" id="T1" />
            <input type="radio" name="judge1" value="F" id="F1" />            
        </div>
    </div>
    <div class="mainBox container" style="border:1px solid #ccc; margin-top:10px;">
        <div class="fill_vacant_question">
            <div class="fv_question">
                4、在交互命令外壳里显示在交互命令外壳里显示 WMI、在交互命令外壳里显示在交互命令外壳里显示 WMI、在交互命令外壳里显示在交互命令外壳里显示 WMI、在交互命令外壳里显示在交互命令外壳里显示 WMI 信息在<input type="text" name="fv_answer" class="fv_input" />交互命令外壳里显示 WMI 信息在交互命令外壳里显示 WMI 信息在交互命令外壳里显示 WMI 信息。
            </div>
        </div>
    </div>
</form>

<jsp:include page="include/footer.jsp" />

</body>
</html>
