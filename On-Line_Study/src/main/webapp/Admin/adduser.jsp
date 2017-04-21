<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${grade!=1&&grade!=0 }"><jsp:forward
		page="/Admin/isnotnormaladmin.jsp" /></c:if>
<%@include file="public.jsp"%>
<section id="main-content">
	<section class="wrapper">
		<div>
			<p id="ur">
				<span class="glyphicon glyphicon-home"></span>&nbsp当前位置>>首页>>用户管理>>添加用户
			</p>
		</div>
		<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
		<center>
			<div id="content" class="form-group">
				<form action='<c:url value="/AdminUpdateUserServlet"></c:url>'
					method="post">
					<table
						class="table table-bordered table-striped table-condensed table-hover"
						style="width: 50%;">
						<tr>
							<td>用户账号：</td>
							<td><input type="text" name="account" class="form-control" /></td>
						</tr>

						<tr>
							<td>用户密码：</td>
							<td><input type="text" name="pwd" class="form-control" /></td>
						</tr>

						<tr>
							<td>昵称：</td>
							<td><input type="text" name="nickname" class="form-control" /></td>
						</tr>

						<tr>
							<td>职业：</td>
							<td><input type="text" name="profession"
								class="form-control" /></td>
						</tr>

						<tr>
							<td>性别：</td>
							<td><select name="sex" class="form-control"
								style="width: 20%;">
									<option value="男">男</option>
									<option value="女">女</option>
									<option value="保密">未</option>
							</select></td>
						</tr>

						<tr>
							<td>省市：</td>
							<td><select name="province" id="province"
								class="form-control" style="width: 40%; float: left;">
									<option>==请选择==</option>
							</select><select name="city" id="city" class="form-control"  style="width: 40%;float: left;">
									<option>==请选择==</option>
							</select></td>
						</tr>

						<!-- <tr>
								<td>市：</td>
								<td><select name="city" id="city"  class="form-control">
		<option>==请选择==</option>
	</select></td>
							</tr> -->

						<tr>
							<td>邮箱：</td>
							<td><input type="text" name="email" class="form-control" /></td>
						</tr>

						<tr>
							<td>兴趣：</td>
							<td><select name="interest" class="form-control"
								style="width: 30%;">
									<c:forEach var="inter" items="${allinterest }">
										<option>${inter.getInterestName() }</option>
									</c:forEach>
							</select></td>
						</tr>



						<tr>
							<td>程度：</td>
							<td><input type="text" name="degree" class="form-control" /></td>



						</tr>
						<tr>
							<td>个人简介：</td>
							<td><input type="text" name="resume" class="form-control" /></td>
						</tr>

						<tr>
							<td>个性签名：</td>
							<td><input type="text" name="signature" class="form-control" /></td>
						</tr>


						<tr>
							<td>头像：</td>
							<td><input type="text" name="picture" class="form-control" /></td>
						</tr>

						<input type="hidden" name="method" value="adduser"
							class="form-control" />

						<tr>
							<td></td>
							<td><input type="submit" value="确认添加"
								class="btn btn-success" /></td>
						</tr>
					</table>
				</form>
			</div>
		</center>
	</section>
</section>
<%@include file="footer.jsp"%>

</body>
<script type="text/javascript">
	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest();//大多数浏览器
		} catch (e) {
			try {
				return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
			} catch (e) {
				try {
					return ActvieXObject("Microsoft.XMLHTTP");
				} catch (e) {
					throw e;
				}
			}
		}
	}
	window.onload = function() {
		//第一件事，加载页面的时候读取省的信息
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.open("GET", "<c:url value='/UserServlet?method=GetProvince'/>",
				true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				var text = xmlHttp.responseText;
				var arr = text.split(",");
				for (var i = 0; i < arr.length; i = i + 2) {
					var op = document.createElement("option");
					op.value = arr[i];//设置op实际值为当前省份名称
					var textNode = document.createTextNode(arr[i + 1]);//设置显示的值
					op.appendChild(textNode);
					document.getElementById("province").appendChild(op);//添加到下拉框
				}
			}
		};
		//第二件事，给name=“province”，添加修改监听器

		var citySelect = document.getElementById("province");
		citySelect.onchange = function() {
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.open("POST", "<c:url value='/UserServlet'/>", true);
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xmlHttp.send("method=GetCity&provinceID=" + citySelect.value);
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					//移除上一次的市
					var citySelect = document.getElementById("city");
					var optionElelist = citySelect
							.getElementsByTagName("option");
					while (optionElelist.length > 1) {//大于1移除，等于1就是“请选择”
						citySelect.removeChild(optionElelist[1]);
					}
					var text = xmlHttp.responseText;
					var arr = text.split(",");
					for (var i = 0; i < arr.length; i = i + 2) {
						var op = document.createElement("option");
						op.value = arr[i];//设置op实际值为当前省份名称
						var textNode = document.createTextNode(arr[i + 1]);//设置显示的值
						op.appendChild(textNode);
						document.getElementById("city").appendChild(op);//添加到下拉框
					}
				}
			};
			//第三件事，设置县的联动

			var areaSelect = document.getElementById("city");
			areaSelect.onchange = function() {
				var xmlHttp = createXMLHttpRequest();
				xmlHttp.open("POST", "<c:url value='/UserServlet'/>", true);
				xmlHttp.setRequestHeader("Content-Type",
						"application/x-www-form-urlencoded");
				xmlHttp.send("method=GetArea&cityID=" + areaSelect.value);
				xmlHttp.onreadystatechange = function() {
					if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
						//移除上一次的县
						var area = document.getElementById("area");
						var optionElelist = area.getElementsByTagName("option");
						while (optionElelist.length > 1) {//大于1移除，等于1就是“请选择”
							area.removeChild(optionElelist[1]);
						}
						var text = xmlHttp.responseText;
						var arr = text.split(",");
						for (var i = 0; i < arr.length; i = i + 2) {
							var op = document.createElement("option");
							op.value = arr[i];//设置op实际值为当前省份名称
							var textNode = document.createTextNode(arr[i + 1]);//设置显示的值
							op.appendChild(textNode);
							document.getElementById("area").appendChild(op);//添加到下拉框
						}
					}
				}
			};
		};
	};
</script>
</html>
