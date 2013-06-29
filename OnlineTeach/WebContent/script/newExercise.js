var createExerciseType = "selectionExercise";
var stdGrade = "sg1";
var selted = "scbA";
var judgeans = false;
var newExerciseSubmit = "";
$("document").ready(function(){	
	//设置默认值，可以从服务器获取
	$("#selectionExercise").addClass("selectedtab");
	$("#sg1").addClass("selectedtab");
	$("#scbA").addClass("scb-rb-sb-item-selected");
	$("#jgans2").addClass("jgans2-selected");
	
	//获取题目的类型
	$(".et-opt").click(function(){
		$(".et-opt").removeClass("selectedtab");
		$(this).addClass("selectedtab");
		createExerciseType = $(this).attr("id");
		$(".row3").css("display", "none");
		$(".etcc").css("display", "none");
		if($(this).attr("id")=="selectionExercise"){
			$("#seltab").css("display", "block");
			$("#pre1").css("display", "block");
		} else if($(this).attr("id")=="completionExercise"){
			$("#comtab").css("display", "block");
			$("#pre2").css("display", "block");
		} else if($(this).attr("id")=="answerExercise"){
			$("#anstab").css("display", "block");
			$("#pre3").css("display", "block");
		} else if($(this).attr("id")=="judgeExercise"){
			$("#jugtab").css("display", "block");
			$("#pre4").css("display", "block");
		}
	});
	
	//获取判断题答案
	$(".jgans-opt").click(function(){
		var temp = $(this).attr("id");
		if(temp=="jgans1") {
			judgeans = true;
			$("#jgans2").removeClass("jgans2-selected").addClass("jgans-opt2");
			$(this).removeClass("jgans-opt1").addClass("jgans1-selected");
		} else {
			judgeans = false;
			$("#jgans1").removeClass("jgans1-selected").addClass("jgans-opt1");
			$(this).removeClass("jgans-opt2").addClass("jgans2-selected");
		}
	});

	//获取题目的分数设置,sg1:stdGrade=1,sgx:stdGrade=input
	$(".ercb-item").click(function(){
		$(".ercb-item").removeClass("selectedtab");
		$(this).addClass("selectedtab");
		var temp = $(this).attr("id");
		if(temp=="sgxbox"){
			$("#sgx").blur(function(){
				sgxTemp = $("#sgx").val();
				if(sgxTemp!="") stdGrade = sgxTemp;
				else {
					$(".ercb-item").removeClass("selectedtab");
					$("#"+stdGrade).addClass("selectedtab");
				}
				$("#sgx").unbind("blur");
			});
		} else {
			if(temp=="sg1")	stdGrade=1;
			else if (temp=="sg2")	stdGrade=2;
			else if (temp=="sg5")	stdGrade=5;
			else if (temp=="sg10")	stdGrade=10;
			else stdGrade = temp;
		}
	});
	
	//设置选择题点击选项的动作
	$(".scb-rb-sb-item").click(function(){
		$(".scb-rb-sb-item").removeClass("scb-rb-sb-item-selected");
		$(this).addClass("scb-rb-sb-item-selected");
		selted = $(this).attr("id");
	});
	
	//设置提示弹出事件
	$(".etsb-tip-ctn-more").click(function(){
		if($("#toggleTip").hasClass("etsb-tip-ctn-flat")){
			$("#toggleTip").removeClass("etsb-tip-ctn-flat").addClass("etsb-tip-ctn-flat-down");
		} else {
			$("#toggleTip").removeClass("etsb-tip-ctn-flat-down").removeClass("etsb-tip-ctn").addClass("etsb-tip-ctn-flat");
		}
	});
	
	//设置自动获取填空题答案事件
	$("#cpltopic").keyup(function(){
		var ctntemp = $("#cpltopic").val();
		var reg = /[^\/]\[[^\[\]\/]*[^\/]\]/g;
		var vals = ctntemp.match(reg);
		if(vals!=null){
			$("#cpllist").empty();
			for(var i=0; i<vals.length; i++){
				var vart = vals[i];
				vart = vart.substring(2,vart.length-1);
				$("#cpllist").append("<li>"+vart+"</li>");
			}
		}
	});
	
	//设置提交题目事件
	$("#etsb-save").click(function(){
		if(createExerciseType=="selectionExercise"){
			var selCtn = $("#seltab-fulltopic").val();
			newExerciseSubmit = "createExerciseType=" + createExerciseType + "&stdGrade=" + stdGrade + "&selCtn=" + selCtn + "&selted=" + selted + ";";
			$.post("ce/newOne",
			{
				createExerciseType:createExerciseType,
				stdGrade:stdGrade,
				selCtn:selCtn,
				selted:selted
			}, function(){
				ss.dd();//!!!!!!!!!!!!!!执行消息函数
			});
		} else if(createExerciseType=="completionExercise") {
			var cplCtn = $("#cpltopic").val();
			newExerciseSubmit = "createExerciseType=" + createExerciseType + "&stdGrade=" + stdGrade + "&cplCtn=" + cplCtn + ";";
		} else if(createExerciseType=="answerExercise") {
			var anstopic = $("#anstopic").val();
			var anskw = $("#anskw").val();
			newExerciseSubmit = "createExerciseType=" + createExerciseType + "&stdGrade=" + stdGrade + "&anstopic=" + anstopic + "&anskw=" + anskw + ";";
		} else if(createExerciseType=="judgeExercise") {
			var jgtopic = $("#jgtopic").val();
			newExerciseSubmit = "createExerciseType=" + createExerciseType + "&stdGrade=" + stdGrade + "&jgtopic=" + jgtopic + "&judgeans=" + judgeans + ";";			
		}
	});
	
	//设置按钮事件
	$("#delButton").click(function(){
		var isCreateMode = $("#createWorkBox").css("display") == "block";
		if(isCreateMode){
			if (createExerciseType=="selectionExercise") $("#seltab-fulltopic").val("");
			else if (createExerciseType=="completionExercise") {
				$("#cpltopic").val("");
				$("#cpllist").empty();
			}
			else if (createExerciseType=="answerExercise") {
				$("#anstopic").val("");
				$("#anskw").val("");
			}
			else if (createExerciseType=="judgeExercise") $("#jgtopic").val("");
		}
	});
});


