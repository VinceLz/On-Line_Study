<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<%@include file="public.jsp"%>
	<script type="text/javascript">
	    function check(){
	    var oldpwd=document.getElementById("oldpwd");
	    var newpwd1=document.getElementById("newpwd1");
	    var newpwd2=document.getElementById("newpwd2");
	    
	    if(oldpwd.value==""){
	    alert("请输入原密码");
	    return false;
	    }
	     if(oldpwd.value==newpwd1.value){
	    alert("新密码不能和原来密码 一致");
	    return false;
	    }
	     if(newpwd1.value==""){
	    alert("请输入新密码");
	    return false;
	    }
	     if(newpwd2.value==""){
	    alert("请再次输入新密码");
	    return false;
	    }
	     if(newpwd2.value!=newpwd1.value){
	    alert("两次密码不一致");
	    return false;
	    }
	    }
	</script>
<style>
input{
margin-left: -100px;
}
.content-panel{
background-color: #ffffff;
}
</style>
	<section id="main-content">
		<section class="wrapper">
			<div>
				<p id="ur">
					<span class="glyphicon glyphicon-home"></span>&nbsp
					当前位置>><a href="index.jsp">首页</a>>><a href="#">个人中心</a>>><a href="#">修改密码</a>
				</p>
			</div>
			<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
			</div>
		 <p>当前账号：${admin }</p>
		  <div class="row mt">
                      <div class="content-panel">
				<center><form action="<c:url value='/AdminInfoServlet'></c:url>" method="post">
				<table class="table table-striped table-advance table-hover" style="width: 60%;">
				
				<tr>
					<td><i class="glyphicon glyphicon-th"></i>原始密码：</td>
					<td><input type="password" name="oldpwd" id="oldpwd" class="form-control"   style=""></td>
				</tr>
				<tr>
					<td><i class="glyphicon glyphicon-edit"></i>新密码：</td>
					<td><input type="password" name="newpwd1" id="newpwd1" class="form-control"></td>
				</tr>
				<tr>
					<td><i class="glyphicon glyphicon-saved"></i>再输一遍：</td>
					<td><input type="password" name="newpwd2" id="newpwd2" class="form-control"></td>
				</tr>
				<tr>
					<td  style="text-align: center;"><input type="submit" value="修改" class="btn btn-success" onclick="return check()"></td>
					<td style="text-align: center;"><input type="reset" value="重置" class="btn btn-success"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="hidden" value="YesChangePwd" name="method"></td>
					<td colspan="2"><input type="hidden" value="${admin }" name="account"></td>
				</tr>
				</table>
				</form></center>
		
	</section>
	</section>
	
	<%@include file="footer.jsp"%>
</body>
</html>