<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="createWorkBox" id="createWorkBox" style="display:none;">
		<div class="exerciseTypeSelectBox">
			<form action="exercise/create">
				<div class="selectTabBox">
					<div class="et-opt-tit pullleft">题目类别</div>
					<div class="et-opt pullleft selecttab" id="selectionExercise">选择题</div>
					<div class="et-opt pullleft selecttab" id="completionExercise">填空题</div>
					<div class="et-opt pullleft selecttab" id="answerExercise">问答题</div>
					<div class="et-opt pullleft selecttab" id="judgeExercise">判断题</div>
					<div class="clearboth"></div>
				</div>
				<div class="etsb-row2">
					<div class="etsb-row2-column-box">
						<div class="etsb-row2-column-tit pullleft">分值</div>
						<div class="ercb-item etsb-row2-column selecttab pullleft" id="sg1">1分</div>
						<div class="ercb-item etsb-row2-column selecttab pullleft" id="sg2">2分</div>
						<div class="ercb-item etsb-row2-column selecttab pullleft" id="sg5">5分</div>
						<div class="ercb-item etsb-row2-column selecttab pullleft" id="sg10">10分</div>
						<div class="ercb-item etsb-row2-column-input-box selecttab pullleft" id="sgxbox">
							<input type="text" name="" id="sgx" class="etsb-row2-column-input pullleft inputField sslote" />
						 	<label for="etsb-row2-column-input">&nbsp;分</label>
						</div>
						<div class="clearboth"></div>
					</div>
						<div class="etsb-row2-submit pullright">
							<div class="submitBtn te" id="etsb-save">保存题目</div>
						</div>
				</div>
				<!-- 题目框开始 -->
				<div class="etsb-ctnrow">
					<div class="row3" id="seltab">
						<div class="seltab-ctn-box">
							<div class="seltab-ctn-tit pullleft">题目内容</div>
							<div class="pointerdown pullleft"></div>
							<div class="clearboth"></div>
							
							<div class="seltab-ctn-texta pullleft">
								<textarea name="fulltopic" id="seltab-fulltopic" class="inputField sslote" placeholder="有天府之国一称的城市是：                                                                               A.成都                                                                               B.宜宾                                                                               C.泸州                                                                               D.广元"></textarea>
							</div>
							<div class="scb-rightbox pullleft">
								<div class="clearboth"></div>
								<h2 class="scb-rb-tit">参考答案</h2>
								<div class="scb-rb-sb">
									<div class="scb-rb-sb-inbox">
										<div class="scb-rb-sb-item pullleft" id="scbA">A</div>
										<div class="scb-rb-sb-item pullleft" id="scbB">B</div>
										<div class="scb-rb-sb-item pullleft" id="scbC">C</div>
										<div class="scb-rb-sb-item pullleft" id="scbD">D</div>
									</div>
				 				</div>
							</div>
							<div class="clearboth"></div>
						</div>
					</div>
					<div class="row3" id="comtab" style="display: none;">
						<div class="seltab-ctn-box">
							<div class="seltab-ctn-tit pullleft">题目内容</div>
							<div class="pointerdown pullleft"></div>
							<div class="clearboth"></div>
							
							<div class="seltab-ctn-texta pullleft">
								<textarea name="fulltopic" id="cpltopic" class="inputField sslote" placeholder="钓鱼岛是[中国]的"></textarea>
							</div>
							<div class="scb-rightbox pullleft">
								<div class="clearboth"></div>
								<h2 class="scb-rb-tit">参考答案</h2>
								<div class="cplItem-box">
									<ol class="cplItem" id="cpllist">
										<li>自动提取答案</li>
									</ol>
								</div>
							</div>
							<div class="clearboth"></div>
						</div>
					</div>
					<div class="row3" id="anstab" style="display: none;">
						<div class="seltab-ctn-box">
							<div class="seltab-ctn-tit pullleft">题目内容</div>
							<div class="pointerdown pullleft"></div>
							<div class="clearboth"></div>							
							<div class="ansta pullleft">
								<textarea name="anstopic" id="anstopic" class="inputField sslote" placeholder="中国大概有多少人口？"></textarea>
							</div>
							
							<div class="seltab-ctn-tit pullleft">参考答案</div>
							<div class="pointerdown pullleft"></div>
							<div class="clearboth"></div>
							<div class="ansta pullleft">
								<textarea name="anskw" id="anskw" class="inputField sslote" placeholder="14亿"></textarea>
							</div>
							<div class="clearboth"></div>
						</div>
					</div>
					<div class="row3" id="jugtab" style="display: none;">
						<div class="seltab-ctn-box">
							<div class="seltab-ctn-tit pullleft">题目内容</div>
							<div class="pointerdown pullleft"></div>
							<div class="clearboth"></div>							
							<div class="ansta pullleft">
								<textarea name="jgtopic" id="jgtopic" class="inputField sslote" placeholder="钓鱼岛是中国的?"></textarea>
							</div>
							
							<div class="seltab-ctn-tit pullleft">参考答案</div>
							<div class="pointerdown pullleft"></div>
							<div class="clearboth"></div>
							<div class="jgans pullleft">
								<div class="jgans-opt jgans-opt1 pullleft" id="jgans1">√</div>
								<div class="jgans-opt jgans-opt2 pullleft" id="jgans2">x</div>
							</div>
							<div class="clearboth"></div>
						</div>					
					</div>
				</div>
				<!-- 题目框结束 -->
				<div class="etsb-tip">
					<div class="etsb-tip-box">
						<div class="etsb-tip-ctn" id="toggleTip">
							<div class="etsb-tip-ctn-tit pullleft">帮助信息</div>
							<div class="etsb-tip-ctn-more pullleft">
								<div class="etsb-tip-ctn-more-svg"></div>
							</div>
							<div class="clearboth"></div>
							<div class="etsb-tip-ctn-ctn">
								<pre class="etcc" id="pre1">1、选择题目的类别
2、选择或直接输入该题的分值
3、在题目内容输入框中输入题目的内容
*、选择参考答案
5、提交该题</pre>
								<pre class="etcc"  id="pre2" style="display: none;">1、选择题目的类别
2、选择或直接输入该题的分值
3、在题目内容输入框中输入题目的内容
*、答案嵌在问题中:[答案],要输入'['或']'请用"/["和"/]"
5、提交该题</pre>
								<pre class="etcc"  id="pre3" style="display: none;">1、选择题目的类别
2、选择或直接输入该题的分值
3、在题目内容输入框中输入题目的内容
*、输入参考答案
5、提交该题</pre>
								<pre class="etcc"  id="pre4" style="display: none;">1、选择题目的类别
2、选择或直接输入该题的分值
3、在题目内容输入框中输入题目的内容
*、点击“√”或“x”选择答案
5、提交该题</pre>
							</div>
						</div>
						<div class="etsb-tip-toggle"></div>
					</div>
				</div>
			</form>
		</div>
	</div>
