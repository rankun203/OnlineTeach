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
    <base href='${pageContext.request.requestURL}' />
</head>

<body>

<jsp:include page="include/header.jsp" />
<div class="site">
    <div class="container">
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
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />
<script src="script/newExercise.js"></script>
<script src="script/teacherRemark.js"></script>
<script type="text/javascript">
	$.getAllExercise();
</script>

<%--Compat for 1024 resolution--%>
<%--<link rel="stylesheet" href="css/compat.css" id="compatCSS"/>--%>
<script type="text/javascript">
    $(window).resize(function () {
        customScript.checkResolution();
    });
    var customScript = {
        checkResolution : function () {
            var compatCss = $("#compatCSS");
            if($(window).width() < 1158) {
                if(compatCss.length == 0) {
                    $("body").after('<link rel="stylesheet" href="css/compat.css" id="compatCSS"/>');
                }
            } else {
                if(compatCss.length != 0) {
                    compatCss.remove();
                }
            }
        }
    }
    customScript.checkResolution();
</script>
<%--Compat end--%>
</body>
</html>