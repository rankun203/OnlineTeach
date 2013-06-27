<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
                	<div class="createWorkBox" id="createWorkBox">
                    	<div class="cwbTitIptLabel">
                        	<input type="text" name="" id="cwbTitIpt" class="pullleft inputField sslote cwbTitIpt" onFocus="checkIptPmt('cwbTitIpt', 'cwbTitIptPmt');" onBlur="checkIptPmt('cwbTitIpt', 'cwbTitIptPmt', 'blur');" onKeyUp="checkIptPmt('cwbTitIpt', 'cwbTitIptPmt');" onChange="checkIptPmt('cwbTitIpt', 'cwbTitIptPmt');">
                            <div class="pullleft cwbBtnBox">
                                <input type="submit" class="btn submitBtn" value="保存题目" onClick="submitCreateWork();">
                            </div>
                            <div class="cwbTitIptPmt inputPmt sslote" id="cwbTitIptPmt" onClick="document.getElementById('cwbTitIpt').focus();">在此处输入标题</div>
                        </div>
                    	<div class="cwbCtnIptLabel">
                        	<textarea name="" id="cwbCtnIpt" class="pullleft inputField sslote cwbCtnIpt" onFocus="checkIptPmt('cwbCtnIpt', 'cwbCtnIptPmt');" onBlur="checkIptPmt('cwbCtnIpt', 'cwbCtnIptPmt', 'blur');" onKeyUp="checkIptPmt('cwbCtnIpt', 'cwbCtnIptPmt');" onChange="checkIptPmt('cwbCtnIpt', 'cwbCtnIptPmt');"></textarea>
                            <div class="cwbCtnIptPmt inputPmt sslote" id="cwbCtnIptPmt" onClick="document.getElementById('cwbCtnIpt').focus();">在此处输入内容</div>
                            <div class="cwbCtnTool sslote" onMouseOver="this.style.opacity='1';" onMouseOut="this.style.opacity='0.3';">
                            	<div class="pullleft cwbCtnToolImg">
	                            	<img src="imgs/img.svg" alt="" id="cwbCtnToolImg" onMouseOver="pmt('cwbCtnToolImg', '在当前位置插入一张图片');" onMouseOut="erasePmt();">
                                </div>
                            	<div class="pullleft cwbCtnToolLink">
	                            	<img src="imgs/link.svg" alt="" id="cwbCtnToolLink" onMouseOver="pmt('cwbCtnToolLink', '在当前位置插入一个链接');" onMouseOut="erasePmt();">                            
                                </div>
                            </div>
                        </div>
                    </div>End of createWorkBox
 -->                    

	<div class="createWorkBox" id="createWorkBox">
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
							<div class="submitBtn">保存题目</div>
						</div>
				</div>
			</form>
		</div>
	</div>
