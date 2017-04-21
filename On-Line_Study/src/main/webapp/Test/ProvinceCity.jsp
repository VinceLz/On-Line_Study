<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ProvinceCity.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
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
<body>
	<h1>省市县联动</h1>
	<select name="province" id="province">
		<option>==请选择==</option>
	</select>
	<select name="city" id="city">
		<option>==请选择==</option>
	</select>
	<select name="area" id="area">
		<option>==请选择==</option>
	</select>
</body>
</html>
