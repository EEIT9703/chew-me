<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.attr.model.*"%>
<%
	AttrService attr = new AttrService();
	List<AttrVO> lis = attr.getAll();
	pageContext.setAttribute("list1", lis);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#listtable {
	margin: auto;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>列表</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<div id="listtable">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>名稱</th>
					<th>縣市</th>
					<th>類型</th>
					<th>地址</th>
					<th>聯絡電話</th>
					<th>管理</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="attrVo" items="${list1}">				
				<tr>
					<td>${attrVo.name}</td>
					<td>${attrVo.county}</td>					
					<td>${attrVo.type}</td>
					<td>${attrVo.address}</td>
					<td>${attrVo.tel}</td>
					<td>
						<button class="btn btn-danger">
							<span class="glyphicon glyphicon-remove"></span>
						</button>
						<button class="btn btn-info">
							<span class="glyphicon glyphicon-pencil"></span>
						</button>
					</td>
				</tr>				
				</c:forEach>
			</tbody>

		</table>
	

	</div>
	<div>
	<a href="InsertAttr.jsp" class="btn btn-default">返回</a>
	</div>




	<script src="js/jquery-1.12.3.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>