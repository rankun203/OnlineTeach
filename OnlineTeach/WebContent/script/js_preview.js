 // JavaScript Document

// 添加一个回答
var flag = true;
function addOneAnswer(){
	var dsiLength = document.getElementsByClassName("dynamicAnswerItem").length;
	var randSub = dsiLength - 1 - (Number)(((Math.random() * 10 / 3) + "").substring(0, 1));
	var insertedNode = document.getElementsByClassName("dynamicAnswerItem").item(randSub).cloneNode(10);
	document.getElementById("daTit").parentNode.insertBefore(insertedNode, document.getElementById("daTit").nextSibling);
}
function changeStatus(var1, var2) {
	console.log(var1 + "(((" + var2);
	var v1 = document.getElementById(var1).style.display;
	var v2 = document.getElementById(var2).style.display;
	console.log(v1 + "__" + v2);
	document.getElementById(var1).style.display = v2;
	document.getElementById(var2).style.display = v1;
}
function addInfoToConsole(info) {
	var val = document.getElementById("console").innerHTML;
	val = info + "<br />" + val;
	document.getElementById("console").innerHTML = val;
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
    $("button.evert").click(function() {	
		var con, api, anima;
		if(true == flag) {
			con = "hideAnimation 1s ease";
			api = "showAnimation 1s ease";			
			anima = "evert0_360 2s ease";
			console.log("AAAAAAAAAAAAAA");
			flag = false;
		}  else  {
			con = "showAnimation 1s ease";
			api = "hideAnimation 1s ease";
			anima = "evert360_0 2s ease";
			console.log("BBBBBBBBBB");
			flag = true;
		}
		$("div#console").css("-webkit-animation", con);
		$("div#apiList").css("-webkit-animation", api);			
		$("div#autoPlanInfo").css("-webkit-animation", anima);		
		setTimeout("changeStatus('apiList','console')", 900);
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























































