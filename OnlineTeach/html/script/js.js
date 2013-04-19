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
	
	document.getElementsByTagName("body").item(0).appendChild(pmtLabel);
	
	var element = document.getElementById(eleId);
	
	var putWidth = document.getElementById("pmt").offsetWidth;
	var eleY = element.offsetTop;
	var eleX = element.offsetLeft;
	var eleHeight = element.offsetHeight;
	var eleWidth = element.offsetWidth;
	var putY = eleY + eleHeight;
	var putX = eleX + ( eleWidth / 2 ) - (putWidth / 2);
	document.getElementById("pmt").style.top = putY + "px";
	document.getElementById("pmt").style.left = putX + "px";
	setTimeout("if (document.getElementById('pmt') != null) document.getElementById('pmt').style.display = 'block'", 1000);
	pmtLabel.style.display = "none";
}
function erasePmt(){
	document.getElementsByTagName("body").item(0).removeChild(document.getElementById("pmt"));
}














