<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


</head>

<body>
	<c:if test="${page.currentPage==1&&page.totalPage==0}">
		<center>暂无数据</center>
	</c:if>
	<c:if test="${page.currentPage==1&&page.totalPage==1}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>
				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+1}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+2}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+3}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li id="next" class="" class="disabled"><a href="#">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>
			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==1&&page.totalPage==2}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>
				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+2}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+3}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>

			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==1&&page.totalPage==3}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>
				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+3}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>

			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==1&&page.totalPage==4}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>
				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+3}">${page.currentPage+3}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>

			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==1&&page.totalPage==5}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>
				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+3}">${page.currentPage+3}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+4}">${page.currentPage+4}</a>
				</li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>

			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==1&&page.totalPage>5}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>
				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+3}">${page.currentPage+3}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+4}">${page.currentPage+4}</a>
				</li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>

			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==2&&page.totalPage==2}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>
				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+1}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+2}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+3}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>

			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==2&&page.totalPage==3}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+2}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+3}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>

			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==2&&page.totalPage==4}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+3}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>

			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==2&&page.totalPage==5}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+3}">${page.currentPage+3}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>

			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==2&&page.totalPage==6}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+3}">${page.currentPage+3}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+4}">${page.currentPage+4}</a>
				</li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>

			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==2&&page.totalPage>6}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+3}">${page.currentPage+3}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+4}">${page.currentPage+4}</a>
				</li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>

			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==3&&page.totalPage==3}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+1}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+2}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+3}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>

				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>
			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==3&&page.totalPage==4}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+2}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+3}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>

				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>
			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==3&&page.totalPage==5}">
		<center>
			<ul class="pagination">
				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+3}</a></li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>

				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>
			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==3&&page.totalPage==6}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+3}">${page.currentPage+3}</a>
				</li>
				<li class="disabled"><a href="#">${page.currentPage+4}</a></li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>

				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>
			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==3&&page.totalPage==7}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+3}">${page.currentPage+3}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+4}">${page.currentPage+4}</a>
				</li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>

				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>
			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==3&&page.totalPage>7}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+3}">${page.currentPage+3}</a>
				</li>
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+4}">${page.currentPage+4}</a>
				</li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>

				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>
			</ul>
		</center>
	</c:if>





	<c:if test="${page.currentPage>3&&page.currentPage<page.totalPage-2}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-2}">${page.currentPage-2}</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">${page.currentPage-1}</a>
				</li>
				<li id="${page.currentPage} " class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>

				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>
			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage>3&&page.currentPage==page.totalPage-2}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-2}">${page.currentPage-2}</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">${page.currentPage-1}</a>
				</li>
				<li id="${page.currentPage} " class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+2}">${page.currentPage+2}</a>
				</li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>

				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>
			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage>3&&page.currentPage==page.totalPage-1}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-2}">${page.currentPage-2}</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">${page.currentPage-1}</a>
				</li>
				<li id="${page.currentPage} " class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">${page.currentPage+1}</a>
				</li>
				<li id="${page.currentPage}" class="disabled"><a href="#">${page.currentPage+2}</a>
				</li>
				<li id="next" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage+1}">&raquo;</a>
				</li>

				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>
			</ul>
		</center>
	</c:if>

	<c:if test="${page.currentPage>3&&page.currentPage==page.totalPage}">
		<center>
			<ul class="pagination">
				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=1">首页</a>
				</li>

				<li id="back" class=""><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">&laquo;</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-2}">${page.currentPage-2}</a>
				</li>
				<li id="${page.currentPage}"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage-1}">${page.currentPage-1}</a>
				</li>
				<li id="${page.currentPage} " class="active"><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.currentPage}">${page.currentPage}</a>
				</li>
				<li id="${page.currentPage}" class="disabled"><a href="#">${page.currentPage+1}</a>
				</li>
				<li id="${page.currentPage}" class="disabled"><a href="#">${page.currentPage+2}</a>
				</li>
				<li id="next" class="disabled"><a href="">&raquo;</a></li>

				<li><a
					href="<%=path %>/${servlet}?method=${method}&other=${other}&current=${page.totalPage}">尾页</a>
				</li>
			</ul>
		</center>
	</c:if>
	<c:if test="${page.currentPage==1}">
		<script>
			$("#back").attr("class", "disabled");
		</script>
	</c:if>
	<c:if test="${page.currentPage==page.totalPage}">
		<script>
			$("#next").attr("class", "disabled");
		</script>
	</c:if>
</body>
</html>
