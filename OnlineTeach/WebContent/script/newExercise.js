var createExerciseType = "selectionExercise";
var stdGrade = "sg1";
$("document").ready(function(){
	//获取题目的类型
	$(".et-opt").click(function(){
		$(".et-opt").removeClass("selectedtab");
		$(this).addClass("selectedtab");
		createExerciseType = $(this).attr("id");
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
		} else stdGrade = temp;
	});
});
