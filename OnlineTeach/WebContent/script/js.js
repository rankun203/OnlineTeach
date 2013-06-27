 // JavaScript Document
var flag = true;
function mainNavExchange(mainNav, activePane) {
	
    var allSubNavItem = document.getElementsByClassName("subMainNavItem");
    for (var i = 0; i < allSubNavItem.length; i++) {
        allSubNavItem.item(i).style.display = "none";
    }
    document.getElementById(activePane).style.display = "block";

    var allAMainNavItem = document.getElementsByClassName("aMainNavItem");
    for (var i = 0; i < allAMainNavItem.length; i++) {
        allAMainNavItem.item(i).className = "aMainNavItem";
    }
    document.getElementById(mainNav).className = "aMainNavItem aMainNavItemActive";

}
function setSelectActive(id1, id2, id3, id4) {
	
	var dgi1 = document.getElementById(id1);
	var dgi2 = document.getElementById(id2);
	var dgi3 = document.getElementById(id3);
	var dgi4 = document.getElementById(id4);
	
	dgi1.style.display = "block";
	dgi2.style.display = "none";
	dgi3.style.display = "none";
	dgi4.style.display = "none";		
	
	return false;				
}
function setJudgeActive(id1, id2) {
	
	var dgi1 = document.getElementById(id1);
	var dgi2 = document.getElementById(id2);
	
	dgi1.style.display = "block";
	dgi2.style.display = "none";	
	
	return false;				
}
function showCoursePlan(id) {
	document.getElementById(id).style.display="block";
}
function pmt(eleId, pmt) {
	if( document.getElementById("pmt") != null ){
		return ;
	}
	var pmtLabel = document.createElement("div");
	pmtLabel.id = "pmt";
	pmtLabel.innerHTML = pmt;

	var pmtTriangle = document.createElement("div");
	pmtTriangle.id = "pmtTriangle";

	
	document.getElementsByTagName("body").item(0).appendChild(pmtTriangle);
	document.getElementsByTagName("body").item(0).appendChild(pmtLabel);
	
	var element = document.getElementById(eleId);
	
	var putWidth = document.getElementById("pmt").offsetWidth;
	var pmtTriangleWidth = document.getElementById("pmtTriangle").offsetWidth;
	var bodyScolY = document.body.scrollTop == 0 ? document.documentElement.scrollTop : document.body.scrollTop;
	var bodyScolX = document.body.scrollLeft == 0 ? document.documentElement.scrollLeft : document.body.scrollLeft;
	var eleY = element.getBoundingClientRect().top;
	var eleX = element.getBoundingClientRect().left;
	var eleHeight = element.offsetHeight;
	var eleWidth = element.offsetWidth;
	var putY = eleY + eleHeight + bodyScolY;
	var putX = eleX + ( eleWidth / 2 ) - (putWidth / 2) + bodyScolX;
	var pmtTriangleX = eleX + ( eleWidth / 2 ) - (pmtTriangleWidth / 2) + bodyScolX;

	document.getElementById("pmt").style.top = putY + 10 + "px";
	document.getElementById("pmt").style.left = putX + "px";

	document.getElementById("pmtTriangle").style.top = putY + 1 + "px";
	document.getElementById("pmtTriangle").style.left = pmtTriangleX + "px";

	setTimeout("if (document.getElementById('pmt') != null) { document.getElementById('pmt').style.display = 'block'; document.getElementById('pmtTriangle').style.display = 'block'; }", 1000);
	pmtLabel.style.display = "none";
	pmtTriangle.style.display = "none";
}
function erasePmt(){
	document.getElementsByTagName("body").item(0).removeChild(document.getElementById("pmt"));
	document.getElementsByTagName("body").item(0).removeChild(document.getElementById("pmtTriangle"));
}
function slctChange(){
	var checked = document.getElementById("checkAllCheckbox").checked;
	var subNodes = document.getElementsByClassName("wldccb");
	if(checked == true){
		for (var i=0; i<subNodes.length; i++) {
			subNodes.item(i).checked = true;
		}
	} else {
		for (var i=0; i<subNodes.length; i++) {
			subNodes.item(i).checked = false;
		}
	}
}

function checkIptPmt(ipt, iptPmt, state){
	var cwbTitIpt = document.getElementById(ipt);
	if (cwbTitIpt.value.length > 0){
		document.getElementById(iptPmt).style.display = 'none';
	} else {
		document.getElementById(iptPmt).style.display = 'block';
		if(state == 'blur'){
			document.getElementById(iptPmt).style.color = "#aaa";
		} else {
			document.getElementById(iptPmt).style.color = "#ccc";
		}
	}
}

function showCreateWork(){
	document.getElementById("wldcListBox").style.display = "none";
	document.getElementById("createWorkBox").style.display = "block";
	document.getElementById("workLabelDownTit").innerHTML = "创建习题";

	document.getElementById("createCourseButton").style.display = "none";
	document.getElementById("checkAllCheckbox").style.display = "none";
}
function submitCreateWork(){
	document.getElementById("createWorkBox").style.display = "none";
	document.getElementById("wldcListBox").style.display = "block";
	document.getElementById("workLabelDownTit").innerHTML = "我的题库";

	document.getElementById("createCourseButton").style.display = "block";
	document.getElementById("checkAllCheckbox").style.display = "block";
}

function checkCurItem(ele){
	console.log("ele.type:"+ele.type);
	if(ele.type="checkbox"){
		return;
	}
	var eleChk = ele.childNodes.item(1).childNodes.item(1).checked;
	if (eleChk == true){
		ele.childNodes.item(1).childNodes.item(1).checked = false;
	} else {
		ele.childNodes.item(1).childNodes.item(1).checked = true;
	}
}
function lightUpRow(ele){
	ele.style.backgroundColor = "#ddd";
}
function reBg(ele, oe){
	if ( oe == "odd" ){
		ele.style.backgroundColor = "#f5f5f5";
	} else {
		ele.style.backgroundColor = "#fff";
	}
}

//排课进度
$(document).ready(function(){
	$("#sType").change(function(){
		$.getSelectName($("#sType").val());
	});
	$("#sName").change(function(){
		$.getCoursePlan($("#sType").val(), $("#sName").val());
	});
	$("button.apstart").click(function(){
		$("#pbprogress")
			.text("")
			.css("width", "0%")
			.css("background-color", "#4183c4");
		var startUrl = "ap/start";
		$.get(startUrl, function(data){
			if(data == "start")	{
				$("#pkTitle").css("display", "none");
				$.refreshProgressBar();
			}
		});
    });

    $("button.evert").click(function() {	
		var con, api, anima;
		if(true == flag) {
			con = "showAnimation 1s ease";
			api = "hideAnimation 1s ease";
			anima = "evert0_360 2s ease";
			//console.log("AAAAAAAAAAAAAA");
			flag = false;
		}  else  {
			con = "hideAnimation 1s ease";
			api = "showAnimation 1s ease";			
			anima = "evert360_0 2s ease";
			//console.log("BBBBBBBBBB");
			flag = true;
		}
		$("div#console").css("-webkit-animation", con);
		$("div#apiList").css("-webkit-animation", api);			
		$("div#autoPlanInfo").css("-webkit-animation", anima);		
		setTimeout("changeStatus('apiList','console')", 1000);
	});		
});
function getAutoPlanMsg() {
	//console.log("hello");
	var progressUrl = "ap/msg";
	$.post(progressUrl, "" , function(data){
		console.log(data);
		var obj = eval(data);
		for(var i = 0; i < obj.length; i++)
			addInfoToConsole(obj[i]);
	});	
}

$.extend({
	clearCoursePlan:function() {
		for(var i=1; i < 43; i++) {
			$("#p" + i).html("&nbsp;");
		}
	},
	clearSName:function(){
		$("#sName").text("");
	},
	getCoursePlan:function(sType, sName) {
		var url = "ap/getCoursePlan?typeName=" + sType + "&selectName=" + sName;
		$.get(url, function(data){
			if("sbRoom" == sType) {
				//console.log(eval("(" + data + ")"));
				$.showRoomCoursePlan(eval("(" + data + ")").coursePlan);				
			} else if("sbClass" == sType) {
				$.showClassCoursePlan(eval("(" + data + ")").coursePlan);
			} else if("sbTeacher" == sType) {
				$.showTeacherCoursePlan(eval("(" + data + ")").coursePlan);
			}
		});	
	},
	setTeacherCoursePlan:function(data) {
		var obj = eval("(" + data + ")");
		var tmp, str;
		$.clearSName();
		for(var i = 0; i < obj.list.length; i++) {
			tmp = obj.list[i];
			//console.log(tmp.id + "___" + tmp.name);
			str = "<option value=\"" + tmp.id + "\">" + tmp.name + "</div>";
			$("#sName").html($("#sName").html() + str);
		}
		$.showTeacherCoursePlan(obj.coursePlan);
	},
	showTeacherCoursePlan:function(teacherCP) {
		$.clearCoursePlan();
		var tmp, str;
		for(var i = 0; i < teacherCP.length; i++) {
			tmp = teacherCP[i];
			str = "<a href='#' style='color:#1E90FF' class='coursePlanLink'> " + tmp.courseName + "</a><br /><a href='#' style='color:#9932CC' class='coursePlanLink'>" + tmp.majorName + " " + tmp.className +
			"</a><br /><a href='#' style='color:#CD5C5C' class='coursePlanLink'>" + tmp.roomName + "</a>";
			//console.log(str + "  p" + tmp.paragraph);
			$("#p" + tmp.paragraph).html(str);
		}
		$(".coursePlanLink").click(function(){
			console.log(this);
		});
	},	
	showRoomCoursePlan:function(roomCP) {
		$.clearCoursePlan();
		var tmp, str;
		for(var i = 0; i < roomCP.length; i++) {
			tmp = roomCP[i];
			str = "<a href='#' style='color:#9932CC' class='coursePlanLink'>" + tmp.majorName + " " + tmp.className +
			"</a><br /><a href='#' style='color:#1E90FF' class='coursePlanLink'>" + tmp.courseName + "</a><br/><a href='#' style='color:#00CED1' class='coursePlanLink'>" +
			tmp.teacherName + "</a>";
			//console.log(str + "  p" + tmp.paragraph);
			$("#p" + tmp.paragraph).html(str);
		}
		$(".coursePlanLink").click(function(){
			console.log(this);
		});
	},
	showClassCoursePlan:function(classCP) {
		$.clearCoursePlan();
		var tmp, str;
		for(var i = 0; i < classCP.length; i++) {
			tmp = classCP[i];
			str = "<a href='id=" + tmp.courseId + "' style='color:#1E90FF' class='coursePlanLink'>" + tmp.courseName + 	"</a><br /><a href='id=" + tmp.roomId + "' style='color:#CD5C5C' class='coursePlanLink'>" + 
			tmp.roomName + "</a><br/><a href='id=" + tmp.teacherId + "' style='color:#00CED1' class='coursePlanLink'>" + tmp.teacherName + "</a>";
			//console.log(str + "  p" + tmp.paragraph);
			$("#p" + tmp.paragraph).html(str);
		}
		$(".coursePlanLink").click(function(){
			console.log(this.href.substring(37,this.href.length));
			return false;
		});
	},
	setClassCoursePlan:function(data) {
		var obj = eval("(" + data + ")");
		var tmp, str;
		$.clearSName();
		for(var i = 0; i < obj.list.length; i++) {
			tmp = obj.list[i];
			//console.log(tmp.id + "___" + tmp.name);
			str = "<option value=\"" + tmp.id + "\">" + tmp.name + "</div>";
			$("#sName").html($("#sName").html() + str);
		}
		$.showClassCoursePlan(obj.coursePlan);
	},
	setRoomCoursePlan:function(data) {
		var obj = eval("(" + data + ")");
		var tmp, str;
		$.clearSName();
		for(var i = 0; i < obj.list.length; i++) {
			tmp = obj.list[i];
			//console.log(tmp.id + "___" + tmp.name);
			str = "<option value=\"" + tmp.id + "\">" + tmp.name + "</div>";
			$("#sName").html($("#sName").html() + str);
		}
		$.showRoomCoursePlan(obj.coursePlan);
	},
	getSelectName:function(sType) {
		var url = "ap/selectName?typeName=" + sType;
		$.get(url, function(data){
			if("sbRoom" == sType) 
				$.setRoomCoursePlan(data);
			if("sbClass" == sType)
				$.setClassCoursePlan(data);
			if("sbTeacher" == sType) 
				$.setTeacherCoursePlan(data);
		});	
	},
	refreshProgressBar:function(){
		var progressUrl = "ap/ppp";
		$.post(progressUrl, "" , function(data){
			if(data == 100.0)	{
				$("#pbprogress")
				.css("width", "100%");
				getAutoPlanMsg();
				setTimeout("$.refreshProgressBar()", 1000);				
				return;
			} else if(200.0 == data) {
				$("#pbprogress")
				.css("background-color", "#41C44B")
				.text("已完成");
				getAutoPlanMsg();
				return;
			}
			$("#pbprogress")
				.css("width", data+"%");
			getAutoPlanMsg();
			setTimeout("$.refreshProgressBar()", 1000);
		});
	}
});

//-------

function changeStatus(var1, var2) {
	console.log(var1 + "(((" + var2);
	var v1 = document.getElementById(var1).style.display;
	var v2 = document.getElementById(var2).style.display;
	console.log(v1 + "__" + v2);
	document.getElementById(var1).style.display = v2;
	document.getElementById(var2).style.display = v1;
}
function addInfoToConsole(info) {
	var con = document.getElementById("console");
	var val = con.innerHTML;
	val = val + info + "<br />";
	con.innerHTML = val;
	con.scrollTop = con.scrollHeight;
}








