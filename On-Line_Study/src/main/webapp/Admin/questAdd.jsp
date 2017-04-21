<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	function checkForm(){
		var subject=$("#subject").val();
		var type=$("#type").val();
		var paperName=$("#paperName").val();
		var joinTime=$("#joinTime").val();
		var optionA=$("#optionA").val();
		var optionB=$("#optionB").val();
		var optionC=$("#optionC").val();
		var optionD=$("#optionD").val();
		var answer=$("#answer").val();
		if(subject==null || subject==""){
			$("#error").html("考试题目不能为空！");
			return false;
		}
		if(type==null || type==""){
			$("#error").html("请选择题目类型！");
			return false;
		}
		if(paperName==null || paperName==""){
			$("#error").html("请选择试卷！");
			return false;
		}
	
		if(optionA==null || optionA==""){
			$("#error").html("选项一不能为空！");
			return false;
		}
		if(optionB==null || optionB==""){
			$("#error").html("选项二不能为空！");
			return false;
		}
		if(optionC==null || optionC==""){
			$("#error").html("选项三不能为空！");
			return false;
		}
		if(optionD==null || optionD==""){
			$("#error").html("选项四不能为空！");
			return false;
		}
		if(answer==null || answer==""){
			$("#error").html("答案不能为空！");
			return false;
		}
		return true;
	}
	function checkForm2(){
	
		var paperName=$("#paperName2").val();
	
		var file=$("#file").val();
		if(paperName==null || paperName==""){
			$("#error2").html("所属试卷不能为空！");
			return false;
		}
		if(file==null || file==""){
			$("#error2").html("上传文件不能为空！");
			return false;
		}
		return true;
		}
</script>
<link href="<%=path%>/User/CSS/exam.css" rel="stylesheet">
<%@include file="public.jsp"%>

<section id="main-content">
	<section class="wrapper">
		<div class="data_list">
			<div class="data_info">
				<p>${title }</p>
			</div>
			方案一
			<div class="data_content">
				<form action='<c:url value="/ExamServlet?method=addPaper"></c:url>'
					method="post" onsubmit="return checkForm()">
					<input type="hidden" name="type" value="1">
					<table width="90%" align="center">
						<tr>
							<td><label>考试题目：</label>
							</td>
							<td><input type="text" id="subject" name="subject"
								value="${question.subject }" class="input-xxlarge" /></td>
						</tr>
						<tr>
							<td><label>题目类型：</label>
							</td>
							<td><select id="type" name="question.type">
									<option value="">请选择题目类型...</option>
									<option value="1" ${question.type==1?'selected':'' }>单选题</option>
									<option value="2" ${question.type==2?'selected':'' }>多选题</option>
							</select></td>
						</tr>
						<tr>
							<td><label>所属试卷：</label>
							</td>
							<td><select id="paperName" name="question.paper.id">
									<option value="">请选择试卷...</option>
									<c:forEach var="paper" items="${list}">
										<option value="${paper.id }" ${paper.id==question.paper.id?'selected':'' }>${paper.paperName
											}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td><label>选项一：</label>
							</td>
							<td><input type="text" id="optionA" name="question.optionA"
								value="${question.optionA }" /></td>
						</tr>
						<tr>
							<td><label>选项二：</label>
							</td>
							<td><input type="text" id="optionB" name="question.optionB"
								value="${question.optionB }" /></td>
						</tr>
						<tr>
							<td><label>选项三：</label>
							</td>
							<td><input type="text" id="optionC" name="question.optionC"
								value="${question.optionC }" /></td>
						</tr>
						<tr>
							<td><label>选项四：</label>
							</td>
							<td><input type="text" id="optionD" name="question.optionD"
								value="${question.optionD }" /></td>
						</tr>
						<tr>
							<td><label>题目答案：</label>
							</td>
							<td><input type="text" id="answer" name="question.answer"
								value="${question.answer }" />&nbsp;&nbsp;(多选题答案用逗号隔开，如"A,D")</td>
						</tr>
						<tr>
							<td><input type="hidden" id="questionId" name="question.id"
								value="${question.id }" />
								<button class="btn btn-primary" type="submit">保存</button></td>
							<td><p id="error" style="color: red"></p></td>
						</tr>
					</table>
				</form>
			</div>
			方案二
			<div class="data_content">
				<form action='<c:url value="/ExamServlet?method=addPaper"></c:url>'
					enctype="multipart/form-data" method="post"
					onsubmit="return checkForm2();">
					<table width="90%" align="center">

						<tr>
							<td><label>模板：</label>
							</td>
							<td><a
								href='<c:url value="/ExamServlet?method=downExam"></c:url>'>点击下载</a>
							</td>
						</tr>
						<tr>

							<p style="color: red;font-size: 20px">请严格使用模板进行录入数据，否则将失败</p>

						</tr>
						<tr>
							<td><label>所属试卷：</label>
							</td>
							<td><select id="paperName2" name="question.paper.id">
									<option value="">请选择试卷...</option>
									<c:forEach var="paper" items="${list}">
										<option value="${paper.id }" ${paper.id==question.paper.id?'selected':'' }>${paper.paperName
											}</option>
									</c:forEach>
							</select></td>
						</tr>

						<tr>
							<td><label>文档：</label>
							</td>
							<td><input type="file" id="file" name="question.answer" />&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td><input type="hidden" id="questionId" name="question.id"
								value="${question.id }" />
								<button class="btn btn-primary" type="submit">上传</button></td>
							<td><p id="error2" style="color: red"></p></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</section>
</section>
<%@include file="footer.jsp"%>

</body>
</html>
