<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:if test="${grade!=1&&grade!=0 }"><jsp:forward page="/Admin/isnotnormaladmin.jsp"/></c:if>
      <%@include file="public.jsp" %>

      <section id="main-content">
          <section class="wrapper">
          	<div>
			<p id="ur"><span class="glyphicon glyphicon-home"></span>&nbsp当前位置>>首页>>兴趣管理>>添加兴趣细则</p>
			</div>
			<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
            <div>
         <form class="well form-search" action="AdminManageInterestServlet">
					<table class="table table-striped table-advance table-hover">
                           <tr>
							<td style="line-height: 1;">兴趣名称</td>
							<td class="form-group"><select name="interestname" id="interest"  class="selectpicker span2" data_style="btn_info">
							
									<c:forEach var="inter" items="${interestList }">
										<option value="${inter.getId()}">${inter.getInterestName()}</option>
									</c:forEach>
							</select></td>
						   </tr>
						   <tr>
							<td style="line-height: 5;">目前已经添加的兴趣细则</td>
							<td>
							<textarea rows="3" cols="50" id="text" readonly="readonly"></textarea>
							</td>
						   </tr>
						   <tr>
							<td style="line-height: 5;">您添加的细则</td>
							<td>
							<textarea rows="3" cols="50" id="text" name="interestDetailed" ></textarea><p>细则之间用逗号隔开</p>
							</td>
						   </tr> 
						   <tr>
							<td style="text-align: center;" colspan="2">
									<input type="hidden" name="method" value="addInterestDetailed"/>
									<input type="submit" value="提交" class="btn btn-theme"/>
							</td>
						   </tr>           
                      </table>
                  </form>           
            </div>
      </section>
  </section>
  <%@include file="footer.jsp" %>

  </body>
  <script>
  /*选择浏览器  */
  
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
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.open("GET",
					"<c:url value='/AdminManageInterestServlet?method=AddInterestCategoryReal'/>", true);
			xmlHttp.send(null);
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					var text = xmlHttp.responseText;
					var arr = text.split(",");
					for (var i = 0; i < arr.length; i = i + 2) {
						if(i==0){
						    var op = document.createElement("option");
							op.value = "-10";
							var textNode = document.createTextNode("=请选择=");//设置显示的值
							op.appendChild(textNode);
							document.getElementById("interest").appendChild(op);//添加到下拉框
						}
						var op = document.createElement("option");
						op.value = arr[i+1];//设置op实际值为当前省份名称
						var textNode = document.createTextNode(arr[i]);//设置显示的值
						op.appendChild(textNode);
						document.getElementById("interest").appendChild(op);//添加到下拉框
					}
				}
			};
			var citySelect = document.getElementById("interest");
			citySelect.onchange = function() {
				var xmlHttp = createXMLHttpRequest();
				xmlHttp.open("POST", "<c:url value='/AdminManageInterestServlet'/>", true);
				xmlHttp.setRequestHeader("Content-Type",
						"application/x-www-form-urlencoded");
				xmlHttp.send("method=findInterestCategory&inter=" + citySelect.value);
				xmlHttp.onreadystatechange = function() {			
					if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
						//移除上一次的市
						var text = xmlHttp.responseText;
						var text1 = document.getElementById("text");
						text1.innerHTML=text;
						
				   }
				};
			};
		};
			
  </script>
</html>
