 // JavaScript Document

// 添加一个回答

function addOneAnswer(){
	var dsiLength = document.getElementsByClassName("dynamicAnswerItem").length;
	var randSub = dsiLength - 1 - (Number)(((Math.random() * 10 / 3) + "").substring(0, 1));
	var insertedNode = document.getElementsByClassName("dynamicAnswerItem").item(randSub).cloneNode(10);
	document.getElementById("daTit").parentNode.insertBefore(insertedNode, document.getElementById("daTit").nextSibling);
}




