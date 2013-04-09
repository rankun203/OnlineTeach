// JavaScript Document
function construct(){
	idg("itemboxb").style.display = "block";
	idg("itemboxc").style.display = "block";

	idg("itemboxa").style.opacity = "0";
	idg("itemboxa").style.height = "0";
	idg("itemboxa").style.display = "block";

	
	document.getElementById("itemboxa").className = "navbox-menu-itembox sslote";	
	idg("itemboxa").style.height = "120px";
	document.getElementById("itemboxa").className = "navbox-menu-itembox te showlately";		
	idg("itemboxa").style.opacity = "1";
	
	idg("itemboxb").style.height = "120px";
	idg("itemboxc").style.height = "75px";
}
function changeItema(){
	if( idg("itemboxa").style.display=="block" ){
		idg("itemboxa").style.height = "0";
		idg("itemboxa").style.display = "none";
		return;
	}
	idg("itemboxa").style.height = "120px";
	idg("itemboxa").style.display = "block";		
}
function changeItemb(){
	if( idg("itemboxb").style.display=="block" ){
		idg("itemboxb").style.display = "none";
		return;
	}
	idg("itemboxb").style.display = "block";		
}
function changeItemc(){
	if( idg("itemboxc").style.display=="block" ){
		idg("itemboxc").style.display = "none";
		return;
	}
	idg("itemboxc").style.display = "block";		
}

//id get
function idg(idname){
	return document.getElementById(idname);
}
function cg(classname){
	return document.getElementsByClassName(classname);
}




