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
var Topic = {
	
};
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