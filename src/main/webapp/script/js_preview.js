/**
 * 添加一个回答
 */
function addOneAnswer() {
	var dsiLength = document.getElementsByClassName("dynamicAnswerItem").length;
	var randSub = dsiLength - 1
			- (Number)(((Math.random() * 10 / 3) + "").substring(0, 1));
	var toInsert = document.getElementsByClassName("dynamicAnswerItem")
			.item(randSub).cloneNode(10);
	$(".topans").removeClass("topans");
	var toInsertJq = $(toInsert);
	toInsertJq.addClass("topans")/*.css("display", "none")*/;

	var scrollTop = $(document).scrollTop();
	document.getElementById("daTit").parentNode.insertBefore(toInsert, document
					.getElementById("daTit").nextSibling);
	var scrollLimit = $("#daTit").offset().top + $("#daTit").height();
	if (scrollTop >= scrollLimit) {
		var newTop = $(document).scrollTop() + toInsertJq.height() + 17;
		$(document).scrollTop(newTop);
	}
}

function Topic () {
	this.selectionTpl = ""
		+ '    <div class="mainbox container replyItem" id="sel-tpl">'
		+ '    	<div class="daInfo divInfo"> <div class="daInfoName">张丽莉</div> <div class="daInfoTime">14:57</div> <div class="daInfoDate">4月22日</div> </div>'
		+ '        <div class="single_question_answer">'
		+ '            <div class="single_question" id="selQes-tpl">@ctn@</div>'
		+ '        </div>'
		+ '        <div class="sel-select-box">'
		+ '        	<input type="hidden" name="sel-tpl-val" value="" id="sel-tpl-val" />'
		+ '			<div class="sel-sb-opt sel-sb-a sel-opt-tpl pullleft" id="sel-a-tpl">A<div class="sel-tpl-ed" id="sel-a-tpl-ed"></div></div>'
		+ '			<div class="sel-sb-opt sel-sb-b sel-opt-tpl pullleft" id="sel-b-tpl">B<div class="sel-tpl-ed" id="sel-b-tpl-ed"></div></div>'
		+ '			<div class="sel-sb-opt sel-sb-c sel-opt-tpl pullleft" id="sel-c-tpl">C<div class="sel-tpl-ed" id="sel-c-tpl-ed"></div></div>'
		+ '			<div class="sel-sb-opt sel-sb-d sel-opt-tpl pullleft" id="sel-d-tpl">D<div class="sel-tpl-ed" id="sel-d-tpl-ed"></div></div>'
		+ '			<div class="clearboth"></div>' + '        </div>' + '    </div>';
	this.questionTpl = ""
		+ '    <div class="mainbox container replyItem" id="ans-tpl">'
		+ '    	<div class="daInfo divInfo"> <div class="daInfoName">张丽莉</div> <div class="daInfoTime">14:57</div> <div class="daInfoDate">4月22日</div> </div>'
		+ '        <div class="answer_question">'
		+ '            <div class="a_question" id="ans-tpl">@ctn@</div>'
		+ '            <div class="inputArea">'
		+ '                <div class="a_txt">答：</div>'
		+ '                <textarea rows="10" cols="131" class="a_answer inputField sslote" name="answer1" id="ans-tpl-val" ></textarea>';
	this.judgeTpl = ""
		+ '    <div class="mainbox container replyItem" id="jug-tpl">'
		+ '    	<div class="daInfo divInfo"> <div class="daInfoName">张丽莉</div> <div class="daInfoTime">14:57</div> <div class="daInfoDate">4月22日</div> </div>'
		+ '        <div class="judge_question">'
		+ '            <div class="j_question">@ctn@</div>'
		+ '        </div>'
		+ '        <div class="j_answer_box">'
		+ '        	<input type="hidden" name="jug-tpl-val" value="" id="jug-tpl-val" />'
		+ '			<div class="j_true j_answer jug-tpl-opt pullleft" id="jug-tpl-opt-a">√<div class="jug-tpl-ed" id="jug-tpl-opt-a-ed"></div></div>'
		+ '			<div class="j_false j_answer jug-tpl-opt pullleft" id="jug-tpl-opt-b">x<div class="jug-tpl-ed" id="jug-tpl-opt-b-ed"></div></div>';
	this.completionTpl = ""
		+ '    <div class="mainbox container replyItem" id="cpl-tpl" >'
		+ '    	<div class="daInfo divInfo"> <div class="daInfoName">张丽莉</div> <div class="daInfoTime">14:57</div> <div class="daInfoDate">4月22日</div> </div>'
		+ '        <div class="fill_vacant_question">'
		+ '            <div class="fv_question" id="cpl-ctn-tpl">@ctn@</div>'
		+ '        </div>' + '    </div>';
	this.completionSpaceTpl = '<input type="text" name="fv_answer" class="fv_input cpl-tpl-vals" />';

}

var myReady = {
	timer : null,
	delay : 2000,
	autoAddAnswer : function() {
		var LocString = String(window.document.location.href);
		if (LocString.indexOf("debug=true") > 0) {
			this.readyAdd();
		}
	},
	readyAdd : function() {
		this.timer = setTimeout("myReady.addAnswer()", this.delay);
	},
	addAnswer : function() {
		addOneAnswer();
		this.readyAdd();
	},
	toggleTimer : function() {
		if (this.timer == null) {
			this.resumeTimer();
		} else {
			this.clearTimer();
		}
	},
	clearTimer : function() {
		clearTimeout(this.timer);
		this.timer = null;
		$("#toggleUpdateAnswer").text("恢复更新");
	},
	resumeTimer : function() {
		this.timer = setTimeout("myReady.addAnswer()", this.delay);
		$("#toggleUpdateAnswer").text("暂停更新");
	},
	initState : function() {
		if (this.timer == null) {
			$("#toggleUpdateAnswer").text("恢复更新");
		} else {
			$("#toggleUpdateAnswer").text("暂停更新");
		}
	}
};