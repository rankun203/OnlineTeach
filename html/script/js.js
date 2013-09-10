 // JavaScript Document

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










