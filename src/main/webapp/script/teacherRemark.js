//答题动态对象
var replyStatus = {
	postRemark : function (postCallback) {
		postCallback();
	},
	updateStatus : function () {
		$.getJSON("work/getRepliedWork", function (data) {
			$.each(data, function (i, v) {
				var _type = v.type;
				var _topic = v.topic;
				var _stuAnswer = v.stuAnswer;
				var _ansDate = v.ansDate;
				var _stuName = v.stuName;
				var _stdAnswer = v.stdAnswer;
				var _stdScore = v.stdScore;
				var _topicId = v.topicId;
				var _esId = v.esId;
				if(_type == "") return;
				if(_type == "selection") {
					var tp = new Topic.selection(_type, _topic, _stuAnswer, _ansDate, _stuName, _stdAnswer, _stdScore, _topicId, _esId);
					var iNode = myDom.parseDom(tp.getHTML())[0];
					replyStatus.insertNode(iNode);
				} else if (_type == "completion") {
					var tp = new Topic.completion(_type, _topic, _stuAnswer, _ansDate, _stuName, _stdAnswer, _stdScore, _topicId, _esId);
					var iNode = myDom.parseDom(tp.getHTML())[0];
					replyStatus.insertNode(iNode);
				} else if (_type == "judge") {
					var tp = new Topic.judge(_type, _topic, _stuAnswer, _ansDate, _stuName, _stdAnswer, _stdScore, _topicId, _esId);
					var iNode = myDom.parseDom(tp.getHTML())[0];
					replyStatus.insertNode(iNode);
				} else if (_type == "question") {
					var tp = new Topic.qa(_type, _topic, _stuAnswer, _ansDate, _stuName, _stdAnswer, _stdScore, _topicId, _esId);
					var iNode = myDom.parseDom(tp.getHTML())[0];
					replyStatus.insertNode(iNode);
				}
			});
		});
	},
	/**
	 * 添加一个答题动态
	 * <ul>
	 * <li>移除现有的顶动态</li>
	 * <li>将即将插入的动态设为顶动态</li>
	 * <li>将动态插入页面</li>
	 * </ul>
	 * @param {} iNode 要添加的答案节点
	 */
	insertNode : function (iNode) {
		if(document.getElementById("ansHold")) $("#ansHold").remove();
		var iNodeJq = $(iNode);
		$(".topans").removeClass("topans");
		iNodeJq.addClass("topans");
		$("#daTit").after(iNode);
		//添加开关批注卡的事件
		$("#arrow-" + iNodeJq.data("myid")).click(function () {
			var thisPane = $(this).parent();
			if(thisPane.hasClass("closed")) {
				thisPane.removeClass("closed");
				thisPane.addClass("spread");
			} else if (thisPane.hasClass("spread")) {
				replyStatus.postRemark(function () {
					//TODO 提交评论的动作
				});
				thisPane.removeClass("spread");
				thisPane.addClass("closed");
			}
		});
		
		//添加长答案弹出窗口事件
		var longAnsBtns = $("#view-long-ans-" + iNodeJq.data("myid"));
		if(longAnsBtns.size() > 0) {
			longAnsBtns.click(function() {
				$("#long-ans-" + iNodeJq.data("myid")).css("display", "block");
				var txtNode = $("#long-ans-txt-" + iNodeJq.data("myid"));
			});
		}
		var closeLongAnsBtns = $("#close-long-ans-" + iNodeJq.data("myid"));
		if(closeLongAnsBtns.size() > 0) {
			closeLongAnsBtns.click(function () {
				$("#long-ans-" + iNodeJq.data("myid")).css("display", "none");
			});
		}
		//调节滚动以舒适展现动态
		var scrollTop = $(document).scrollTop();
		var scrollLimit = $("#daTit").offset().top + $("#daTit").height();
		if (scrollTop >= scrollLimit) {
			var newTop = $(document).scrollTop() + iNodeJq.height() + 17;
			$(document).scrollTop(newTop);
		}

	},
	/**
	 * 负责轮询，计时器
	 */
	myReady : {
		timer : null, //setInterval对象
		delay : 2000,
		/**
		 * 初始化，初始化添加动态的计时器 和 初始化按钮状态
		 */
		init : function() {
			this.timer = setInterval("replyStatus.updateStatus()", this.delay);
			this.initState();
		},
		/**
		 * 添加动态
		 * <ul>
		 * <li>更新动态</li>
		 * <li>再次调用设定计时器的方法</li>
		 * </ul>
		 */
		toggleTimer : function() {
			if (this.timer == null) {
				this.resumeTimer();
			} else {
				this.clearTimer();
			}
		},
		clearTimer : function() {
			clearTimeout(this.timer);
			this.timer = null;
			$("#toggleUpdateAnswer").text("恢复更新");
		},
		resumeTimer : function() {
			this.timer = setInterval("replyStatus.updateStatus()", this.delay);
			$("#toggleUpdateAnswer").text("暂停更新");
		},
		initState : function() {
			if (this.timer == null) {
				$("#toggleUpdateAnswer").text("恢复更新");
			} else {
				$("#toggleUpdateAnswer").text("暂停更新");
			}
		}
	}
};

/**
 * 
 * @type 可以叫做：动态、题目……
 */
var Topic = {
	selection : function (s1, s2, s3, s4, s5, s6, s7, s8, s9) {
		this.type = s1;
		this.topic = s2;
		this.stuAnswer = s3;
		this.ansDate = s4;
		this.stuName = s5;
		this.stdAnswer = s6;
		this.stdScore = s7;
		this.topicId = s8;
		this.esId = s9;
		this.getTime = function () {
			var date = this.ansDate.split(" ");
			return date[1];
		};
		this.getDate = function () {
			var date = this.ansDate.split(" ");
			return date[0];
		};
		this.getTopic = function () {
			return this.topic.split("@hr@")[0];
		};
		this.getABCD = function (_type) {
			var answer = this.topic.split("@hr@")[1];
			var abcd = answer.split("@br@");
			if(_type == "a") {
				return abcd[0].replace("A.", "");
			} else if (_type == "b") {
				return abcd[1].replace("B.", "");
			} else if (_type == "c") {
				return abcd[2].replace("C.", "");
			} else if (_type == "d") {
				return abcd[3].replace("D.", "");
			}
		};
		this.checkedClass = function (now) {
			var ans = this.stuAnswer;
			if (ans == "") return "";
			var selectedClassName = " sel-sb-opt-ed";
			if(now == "a" && ans == "a" || ans == "A") {
				return selectedClassName;
			} else if (now == "b" && ans == "b" || ans == "B") {
				return selectedClassName;
			} else if (now == "c" && ans == "c" || ans == "C") {
				return selectedClassName;
			} else if (now == "d" && ans == "d" || ans == "D") {
				return selectedClassName;
			} else {
				return "";
			}
		};
		this.getMarkClass = function (curScore) {
			if(this.stuAnswer == "" || this.stdAnswer == "") {
				return "";
			} else if (this.stdScore - curScore == 0) {
				return " selected";
			} else {
				return "";
			}
		};
		this.getHTML = function () {
			Topic.COUNT = Topic.COUNT + 1;
			var rtn = "" +
 "<div class=\"mainbox container dynamicAnswerItem topans\" data-myid=\"tpl\" data-esId=\""+this.esId+"\" data-topicId=\""+this.topicId+"\" id=\"item-tpl\">\r\n" + 
 "    <div class=\"daInfo divInfo\">\r\n" + 
 "      <div class=\"daInfoName\">"+this.stuName+"</div>\r\n" + 
 "      <div class=\"daInfoTime\">"+this.getTime()+"</div>\r\n" + 
 "      <div class=\"daInfoDate\">"+this.getDate()+"</div>\r\n" + 
 "    </div>\r\n" + 
 "    <div class=\"single_question_answer\">\r\n" + 
 "        <div class=\"single_question\">"+this.getTopic()+"</div>\r\n" + 
 "        <div class=\"singleSelect\">\r\n" + 
 "            <ul style=\" list-style:upper-latin;\">\r\n" +
 "                <li>"+this.getABCD("a")+"</li>\r\n" + 
 "                <li>"+this.getABCD("b")+"</li>\r\n" + 
 "                <li>"+this.getABCD("c")+"</li>\r\n" + 
 "                <li>"+this.getABCD("d")+"</li>\r\n" + 
 "            </ul>\r\n" + 
 "        </div>\r\n" + 
 "    </div>\r\n" + 
 "    <div class=\"sel-select-box\">\r\n" + 
 "		<input type=\"hidden\" name=\"sel-tpl-val\" value=\"\" id=\"sel-tpl-val\" />\r\n" + 
 "		<div class=\"sel-sb-opt sel-sb-a sel-opt-tpl pullleft\" id=\"sel-a-tpl\">A<div class=\"sel-tpl-ed"+this.checkedClass("a")+"\" id=\"sel-a-tpl-ed\"></div></div>\r\n" + 
 "		<div class=\"sel-sb-opt sel-sb-b sel-opt-tpl pullleft\" id=\"sel-b-tpl\">B<div class=\"sel-tpl-ed"+this.checkedClass("b")+"\" id=\"sel-b-tpl-ed\"></div></div>\r\n" + 
 "		<div class=\"sel-sb-opt sel-sb-c sel-opt-tpl pullleft\" id=\"sel-c-tpl\">C<div class=\"sel-tpl-ed"+this.checkedClass("c")+"\" id=\"sel-c-tpl-ed\"></div></div>\r\n" + 
 "		<div class=\"sel-sb-opt sel-sb-d sel-opt-tpl pullleft\" id=\"sel-d-tpl\">D<div class=\"sel-tpl-ed"+this.checkedClass("d")+"\" id=\"sel-d-tpl-ed\"></div></div>\r\n" + 
 "		<div class=\"clearboth\"></div>\r\n" + 
 "	</div>\r\n" +
 "	<div class=\"teacherRemark pullright high-remark hsel closed\"><!-- .hsel：high-type-selection -->\r\n" + 
 "    	<div class=\"showtip pullleft\">展开批注卡</div>\r\n" + 
 "    	<div class=\"anspane pullleft\">\r\n" + 
 "			<div class=\"sel-ans\">\r\n" + 
 "				<div class=\"ans-tit pullleft\">参考答案：</div><div class=\"ans-body pullleft\" id=\"ans-body-tpl\">"+this.stdAnswer+"</div>\r\n" + 
 "				<div class=\"clearboth\"></div>\r\n" + 
 "			</div>\r\n" + 
 "			<!-- 每次添加动态后，设置评分按钮的事件，点击即提交信息 -->\r\n" + 
 "			<div class=\"mark\">\r\n" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(0)+"\" id=\"remark-tpl-0\" data-ot-remark=\"0\">0</div>\r\n" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(1)+"\" id=\"remark-tpl-1\" data-ot-remark=\"1\">1</div>\r\n" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(2)+"\" id=\"remark-tpl-2\" data-ot-remark=\"2\">2</div>\r\n" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(5)+"\" id=\"remark-tpl-5\" data-ot-remark=\"5\">5</div>\r\n" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(10)+"\" id=\"remark-tpl-10\" data-ot-remark=\"10\">10</div>\r\n" + 
 "				<div class=\"mark-input\" id=\"sel-remark-tpl-x-box\">\r\n" + 
 "					<input type=\"text\" class=\"ansInputField sslote pullleft\" id=\"sel-remark-tpl-x\" placeholder=\"？\"/>\r\n" + //TODO 把自定义分数填入
 "					<label for=\"sel-remark-tpl-x\" class=\"pullleft\">分</label>\r\n" + 
 "				</div>\r\n" + 
 "				<div class=\"clearboth\"></div>\r\n" + 
 "			</div>\r\n" + 
 "			<div class=\"comment\">\r\n" + 
 "				<textarea class=\"commentbody inputField sslote\" id=\"comment-tpl-body\" placeholder=\"请在这里写下你对该题的批注(可为空)\"></textarea>\r\n" + 
 "			</div>\r\n" + 
 "    	</div>\r\n" + 
 "    	<div class=\"switch-arrow pullleft\" id=\"arrow-tpl\" data-myid=\"tpl\">\r\n" +
 "    		<div class=\"arrow\"></div>\r\n" + 
 "    	</div>\r\n" + 
 "	</div>\r\n" + 
 "  <div class=\"clearboth\"></div>" +
 "</div>";
 			rtn = rtn.replace(/tpl/g, Topic.COUNT);
 			return rtn;
		};
	},
	qa : function (s1, s2, s3, s4, s5, s6, s7, s8, s9) {
		this.type = s1;
		this.topic = s2;
		this.stuAnswer = s3;
		this.ansDate = s4;
		this.stuName = s5;
		this.stdAnswer = s6;
		this.stdScore = s7;
		this.topicId = s8;
		this.esId = s9;
		this.getTime = function () {
			var date = this.ansDate.split(" ");
			return date[1];
		};
		this.getDate = function () {
			var date = this.ansDate.split(" ");
			return date[0];
		};
		this.getAnswer = function (_type) {
			if(_type == "stu") {
				return this.stuAnswer.replace("@br@", "\r\n");
			} else if (_type == "std") {
				return this.stdAnswer.replace("@br@", "\r\n");				
			}
		};
		this.getMarkClass = function (curScore) {
			if(this.stuAnswer == "" || this.stdAnswer == "") {
				return "";
			} else if (this.stdScore - curScore == 0) {
				return " selected";
			}else {
				return "";
			}
		};
		this.getHTML = function () {
			Topic.COUNT = Topic.COUNT + 1;
			var rtn =
 "<div class=\"mainbox container dynamicAnswerItem\" data-myid=\"tpl\" data-esId=\""+this.esId+"\" data-topicId=\""+this.topicId+"\" id=\"item-tpl\">" + 
 "    <div class=\"daInfo divInfo\">" + 
 "      <div class=\"daInfoName\">"+this.stuName+"</div>\r\n" + 
 "      <div class=\"daInfoTime\">"+this.getTime()+"</div>\r\n" + 
 "      <div class=\"daInfoDate\">"+this.getDate()+"</div>\r\n" + 
 "    </div>" + 
 "    <div class=\"answer_question pullleft\">" + 
 "        <div class=\"a_question\">"+this.topic+"</div>" + 
 "        <div class=\"inputArea\">" + 
 "            <div class=\"a_txt\">答：</div>" + 
 "            <textarea rows=\"10\" cols=\"131\" class=\"a_answer inputField sslote disabledIF\" name=\"answer1\" disabled >"+this.getAnswer("stu")+"</textarea>" + 
 "        </div>" + 
 "    </div>" + 
 "	<div class=\"teacherRemark pullright high-remark hqus closed\">" + 
 "    	<div class=\"showtip pullleft\">展开批注卡</div>" + 
 "    	<div class=\"anspane pullleft\">" + 
 "			<div class=\"qus-ans\">" + 
 "				<!-- 点击查看按钮，即打开模态对话框，显示答案 -->" + 
 "				<div class=\"ans-tit pullleft\">参考答案：</div><button class=\"ans-body pullleft flatbtn\" id=\"view-long-ans-tpl\">查看</button>" + 
 "				<div class=\"modalDialog\" id=\"long-ans-tpl\">" + 
 "					<div class=\"mask\"></div>" + 
 "					<div class=\"modalCtn\">" + 
 "						<div class=\"controller\" id=\"close-long-ans-tpl\">+</div>" + 
 "						<div class=\"tit\">简答题答案</div>" + 
 "						<div class=\"txt\" id=\"long-ans-txt-tpl\">"+this.getAnswer("std").replace(/@br@/g, "<br />")+"</div>" + 
 "					</div>" + 
 "				</div>" + 
 "				<div class=\"clearboth\"></div>" + 
 "			</div>" + 
 "			<!-- 每次添加动态后，设置评分按钮的事件，点击即提交信息 -->" + 
 "			<div class=\"mark\">" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(0)+"\" id=\"remark-tpl-0\" data-ot-remark=\"0\">0</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(1)+"\" id=\"remark-tpl-1\" data-ot-remark=\"1\">1</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(2)+"\" id=\"remark-tpl-2\" data-ot-remark=\"2\">2</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(5)+"\" id=\"remark-tpl-5\" data-ot-remark=\"5\">5</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(10)+"\" id=\"remark-tpl-10\" data-ot-remark=\"10\">10</div>" + 
 "				<div class=\"mark-input\" id=\"sel-remark-tpl-x-box\">" + 
 "					<input type=\"text\" class=\"ansInputField sslote pullleft\" id=\"sel-remark-tpl-x\" placeholder=\"？\"/>" + 
 "					<label for=\"sel-remark-tpl-x\" class=\"pullleft\">分</label>" + 
 "				</div>" + 
 "				<div class=\"clearboth\"></div>" + 
 "			</div>" + 
 "			<div class=\"comment\">" + 
 "				<textarea class=\"commentbody inputField sslote\" id=\"comment-tpl-body\" placeholder=\"请在这里写下你对该题的批注(可为空)\"></textarea>" + 
 "			</div>" + 
 "    	</div>" + 
 "    	<div class=\"switch-arrow pullleft\" id=\"arrow-tpl\" data-myid=\"tpl\">" + 
 "    		<div class=\"arrow\"></div>" + 
 "    	</div>" + 
 "    	<div class=\"clearboth\"></div>" + 
 "	</div>" + 
 "  <div class=\"clearboth\"></div>" +
 "</div>";
 			rtn = rtn.replace(/tpl/g, Topic.COUNT);
 			return rtn;
		};
	},
	judge : function (s1, s2, s3, s4, s5, s6, s7, s8, s9) {
		this.type = s1;
		this.topic = s2;
		this.stuAnswer = s3;
		this.ansDate = s4;
		this.stuName = s5;
		this.stdAnswer = s6;
		this.stdScore = s7;
		this.topicId = s8;
		this.esId = s9;
		this.getTime = function () {
			var date = this.ansDate.split(" ");
			return date[1];
		};
		this.getDate = function () {
			var date = this.ansDate.split(" ");
			return date[0];
		};
		this.checkedClass = function (now) {
			var ans = this.stuAnswer;
			if (ans == "") return "";
			var selectedClassName = " sel-sb-opt-ed";
			if(now == "true" && ans == "true") {
				return selectedClassName;
			} else if (now == "false" && ans == "false") {
				return selectedClassName;
			} else {
				return "";
			}
		};
		this.getMarkClass = function (curScore) {
			if(this.stuAnswer == "" || this.stdAnswer == "") {
				return "";
			} else if (this.stdScore - curScore == 0) {
				return " selected";
			} else {
				return "";
			}
		};
		this.getStdAnswer = function () {
			var ans = this.stdAnswer;
			if(ans == "true") {
				return "正确";
			} else if (ans == "false") {
				return "错误";
			} else {
				return "未知";
			}
		};
		this.getHTML = function () {
			Topic.COUNT = Topic.COUNT + 1;
			var rtn = 
 "<div class=\"mainbox container dynamicAnswerItem\" data-myid=\"tpl\" data-esId=\""+this.esId+"\" data-topicId=\""+this.topicId+"\" id=\"item-tpl\">" + 
 "    <div class=\"daInfo divInfo\">" + 
 "      <div class=\"daInfoName\">"+this.stuName+"</div>\r\n" + 
 "      <div class=\"daInfoTime\">"+this.getTime()+"</div>\r\n" + 
 "      <div class=\"daInfoDate\">"+this.getDate()+"</div>\r\n" + 
 "    </div>" + 
 "    <div class=\"judge_question\">" + 
 "        <div class=\"j_question\">"+this.topic+"</div>" + 
 "    </div>" + 
 "	<div class=\"j_answer_box\">" + 
 "		<input type=\"hidden\" name=\"jug-tpl-val\" value=\"\" id=\"jug-tpl-val\" />" + 
 "		<div class=\"j_true j_answer jug-tpl-opt pullleft\" id=\"jug-tpl-opt-a\">√<div class=\"jug-tpl-ed"+this.checkedClass("true")+"\" id=\"jug-tpl-opt-a-ed\"></div></div>" + 
 "		<div class=\"j_false j_answer jug-tpl-opt pullleft\" id=\"jug-tpl-opt-b\">x<div class=\"jug-tpl-ed"+this.checkedClass("false")+"\" id=\"jug-tpl-opt-b-ed\"></div></div>" + 
 "		<div class=\"clearboth\"></div>" + 
 "	</div>" + 
 "" + 
 "    <div class=\"teacherRemark pullright low-remark ljuj closed\">" + 
 "    	<div class=\"showtip pullleft\">展开批注卡</div>" + 
 "    	<div class=\"anspane pullleft\">" + 
 "			<div class=\"judge-ans\">" + 
 "				<div class=\"ans-tit pullleft\">参考答案：</div><div class=\"ans-body pullleft\" id=\"ans-body-tpl\">"+this.getStdAnswer()+"</div>" + 
 "				<div class=\"clearboth\"></div>" + 
 "			</div>" + 
 "			<!-- 每次添加动态后，设置评分按钮的事件，点击即提交信息 -->" + 
 "			<div class=\"mark\">" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(0)+"\" id=\"remark-tpl-0\" data-ot-remark=\"0\">0</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(1)+"\" id=\"remark-tpl-1\" data-ot-remark=\"1\">1</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(2)+"\" id=\"remark-tpl-2\" data-ot-remark=\"2\">2</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(5)+"\" id=\"remark-tpl-5\" data-ot-remark=\"5\">5</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(10)+"\" id=\"remark-tpl-10\" data-ot-remark=\"10\">10</div>" + 
 "				<div class=\"mark-input\" id=\"sel-remark-tpl-x-box\">" + 
 "					<input type=\"text\" class=\"ansInputField sslote pullleft\" id=\"sel-remark-tpl-x\" placeholder=\"？\"/>" + 
 "					<label for=\"sel-remark-tpl-x\" class=\"pullleft\">分</label>" + 
 "				</div>" + 
 "				<div class=\"clearboth\"></div>" + 
 "			</div>" + 
 "			<div class=\"comment\">" + 
 "				<textarea class=\"commentbody inputField sslote pullleft\" id=\"comment-tpl-body\" placeholder=\"您对该题的批注(可为空)\"></textarea>" + 
 "			</div>" + 
 "    	</div>" + 
 "    	<div class=\"switch-arrow pullleft\" id=\"arrow-tpl\" data-myid=\"tpl\">" + 
 "    		<div class=\"arrow\"></div>" + 
 "    	</div>" + 
 "	</div>" + 
 "  <div class=\"clearboth\"></div>" +
 "</div>";
			rtn = rtn.replace(/tpl/g, Topic.COUNT);
 			return rtn;
		};
	},
	completion : function (s1, s2, s3, s4, s5, s6, s7, s8, s9) {
		this.type = s1;
		this.topic = s2;
		this.stuAnswer = s3;
		this.ansDate = s4;
		this.stuName = s5;
		this.stdAnswer = s6;
		this.stdScore = s7;
		this.topicId = s8;
		this.esId = s9;
		this.getTime = function () {
			var date = this.ansDate.split(" ");
			return date[1];
		};
		this.getDate = function () {
			var date = this.ansDate.split(" ");
			return date[0];
		};
		this.getFilledTopic = function () {
			var tp = this.topic;
			var stuAnswers = this.stuAnswer.split(",");
			for(var i = 0; i < stuAnswers.length; i++) {
				tp = tp.replace("@"+i+"@", "<code>" + stuAnswers[i] + "</code>");
			}
			return tp;
		};
		this.getMarkClass = function (curScore) {
			if(this.stuAnswer == "" || this.stdAnswer == "") {
				return "";
			} else if (this.stdScore - curScore == 0) {
				return " selected";
			} else {
				return "";
			}
		};
		this.getHTML = function () {
			Topic.COUNT = Topic.COUNT + 1;
			var rtn = 
 "<div class=\"mainbox container dynamicAnswerItem\" data-myid=\"tpl\" data-esId=\""+this.esId+"\" data-topicId=\""+this.topicId+"\" id=\"item-tpl\">" + 
 "    <div class=\"daInfo divInfo\">" + 
 "      <div class=\"daInfoName\">"+this.stuName+"</div>\r\n" + 
 "      <div class=\"daInfoTime\">"+this.getTime()+"</div>\r\n" + 
 "      <div class=\"daInfoDate\">"+this.getDate()+"</div>\r\n" + 
 "    </div>" + 
 "    <div class=\"fill_vacant_question pullleft\">" + 
 "        <div class=\"fv_question\">"+this.getFilledTopic()+"</div>" + 
 "    </div>" + 
 "    <div class=\"teacherRemark pullright low-remark lcpl closed\">" + 
 "    	<div class=\"showtip pullleft\">展开批注卡</div>" + 
 "    	<div class=\"anspane pullleft\">" + 
 "			<div class=\"cpl-ans\">" + 
 "				<div class=\"ans-tit pullleft\">参考答案：</div><button class=\"ans-body pullleft flatbtn\" id=\"view-long-ans-tpl\">查看</button>" + 
 "				<div class=\"clearboth\"></div>" + 
 "				<div class=\"modalDialog\" id=\"long-ans-tpl\">" + 
 "					<div class=\"mask\"></div>" + 
 "					<div class=\"modalCtn\">" + 
 "						<div class=\"controller\" id=\"close-long-ans-tpl\">+</div>" + 
 "						<div class=\"tit\">简答题答案</div>" + 
 "						<div class=\"txt\" id=\"long-ans-txt-tpl\">"+this.stuAnswer+"</div>" + 
 "					</div>" + 
 "				</div>" + 
 "			</div>" + 
 "			<!-- 每次添加动态后，设置评分按钮的事件，点击即提交信息 -->" + 
 "			<div class=\"mark\">" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(0)+"\" id=\"remark-tpl-0\" data-ot-remark=\"0\">0</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(1)+"\" id=\"remark-tpl-1\" data-ot-remark=\"1\">1</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(2)+"\" id=\"remark-tpl-2\" data-ot-remark=\"2\">2</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(5)+"\" id=\"remark-tpl-5\" data-ot-remark=\"5\">5</div>" + 
 "				<div class=\"mark-x selecttab pullleft"+this.getMarkClass(10)+"\" id=\"remark-tpl-10\" data-ot-remark=\"10\">10</div>" + 
 "				<div class=\"mark-input\" id=\"sel-remark-tpl-x-box\">" + 
 "					<input type=\"text\" class=\"ansInputField sslote pullleft\" id=\"sel-remark-tpl-x\" placeholder=\"？\"/>" + 
 "					<label for=\"sel-remark-tpl-x\" class=\"pullleft\">分</label>" + 
 "				</div>" + 
 "				<div class=\"clearboth\"></div>" + 
 "			</div>" + 
 "			<div class=\"comment\">" + 
 "				<textarea class=\"commentbody inputField sslote pullleft\" id=\"comment-tpl-body\" placeholder=\"您对该题的批注(可为空)\"></textarea>" + 
 "				<div class=\"clearboth\"></div>" + 
 "			</div>" + 
 "    	</div>" + 
 "    	<div class=\"switch-arrow pullleft\" id=\"arrow-tpl\" data-myid=\"tpl\">" + 
 "    		<div class=\"arrow\"></div>" + 
 "    	</div>" + 
 "    	<div class=\"clearboth\"></div>" + 
 "	</div>" + 
 "  <div class=\"clearboth\"></div>" +
 "</div>";
			rtn = rtn.replace(/tpl/g, Topic.COUNT);
 			return rtn;
		};
	},
	"COUNT" : 0
};

//答题动态加载总入口，初始化答题加载
replyStatus.myReady.init();
