 // JavaScript Document

// 添加一个回答
function addOneAnswer(){
	var dsiLength = document.getElementsByClassName("dynamicAnswerItem").length;
	var randSub = dsiLength - 1 - (Number)(((Math.random() * 10 / 3) + "").substring(0, 1));
	var toInsert = document.getElementsByClassName("dynamicAnswerItem").item(randSub).cloneNode(10);
    $(".topans").removeClass("topans");    
    var toInsertJq = $(toInsert);
    toInsertJq.addClass("topans");
    toInsertJq.css("display", "none");
	document.getElementById("daTit").parentNode.insertBefore(toInsert, document.getElementById("daTit").nextSibling);
    toInsertJq.fadeIn();
}




