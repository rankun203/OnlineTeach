


/*
 * 生成题目的工作流程
 * 每出现一道题，为其生成一个rpl_no，然后根据类型创建该题的div在网页上进行显示
 * 
 * */
 
$("document").ready(function(){
	//学生答题部分
	//选择题，单击设定选择的值
	var rpl_no = "tpl";	//rpl: reply
	var rpl_type = "select";
	$(".sel-opt-"+rpl_no).click(function(){
		var markOpt = $(this).attr("id") + "-ed";
		//先设定选择的结果
		var clkVal = "";
		if(markOpt.indexOf("a")>0)	clkVal = "a";
		else if(markOpt.indexOf("b")>0)	clkVal="b";
		else if(markOpt.indexOf("c")>0)	clkVal="c";
		else if(markOpt.indexOf("d")>0)	clkVal="d";
		else	msgerror("严重错误！系统无法获取你点击的选项！");
		$("#sel-"+rpl_no+"-val").val(clkVal);
		//再显示视觉效果
		$(".sel-"+rpl_no+"-ed").removeClass("sel-sb-opt-ed");
		$("#"+markOpt).addClass("sel-sb-opt-ed");
	});
	
	//判断题
	$(".jug-"+rpl_no+"-opt").click(function(){
		var markOpt = $(this).attr("id") + "-ed";
		var clkVal = "0";
		if(markOpt.indexOf("a")>0)	clkVal = "1";
		else if(markOpt.indexOf("b")>0)	clkVal="2";
		else	msgerror("严重错误！系统无法获取你的判断结果！");
		$("#jug-"+rpl_no+"-val").val(clkVal);
		$(".jug-"+rpl_no+"-ed").removeClass("sel-sb-opt-ed");
		$("#"+markOpt).addClass("sel-sb-opt-ed");
	});
	
	
	
});

//获取指定选择题(rpl_no为rpl_no)答案
//get selection reply answer
function getSelRplAns(rpl_no){
	return $("#sel-"+rpl_no+"-val").val();
}
//获取指定的问答题的答案
function getAnsRplAns(rpl_no){
	return $("#ans-"+rpl_no+"-val").val();
}
//获取指定判断题的答案
function getJugRplAns(rpl_no){
	return $("#jug-"+rpl_no+"-val").val();
}
//获取指定的填空题的答案们
function getCplRplAns(rpl_no){
	var ans = "[";
	$(".cpl-tpl-vals").each(function(){
		ans += '\"'+$(this).val() + '\",';
	});
	ans = ans.substring(0, ans.length-1);
	ans += "]";
	return ans;
}


