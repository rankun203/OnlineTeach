 // JavaScript Document

// 添加一个回答
function addOneAnswer(){
	var dsiLength = document.getElementsByClassName("dynamicAnswerItem").length;
	var randSub = dsiLength - 1 - (Number)(((Math.random() * 10 / 3) + "").substring(0, 1));
	var insertedNode = document.getElementsByClassName("dynamicAnswerItem").item(randSub).cloneNode(10);
	document.getElementById("daTit").parentNode.insertBefore(insertedNode, document.getElementById("daTit").nextSibling);
}


//generateCoursePlan.html 预正脚本
$(document).ready(function(){
	$("button.apstart").click(function(){
		$("#pbprogress")
			.text("")
			.css("width", "0%");
		var startUrl = "ap/start";
		$.get(startUrl, function(data){
			console.log(data);
			if(data == "start")	progress();
		});
    });
});

function progress(){
	$.extend({
		refreshProgressBar:function(){
			var progressUrl = "ap/ppp";
			$.post(progressUrl, "" , function(data){
				console.log(data);
			});
			window.setTimeout($.refreshProgressBar(), 1000);
		}
	});
}
























































