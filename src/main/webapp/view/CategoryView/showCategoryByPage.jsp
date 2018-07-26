<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
</head>
<body>
<h1 align="center">分页显示类别</h1>
	<table align="center" class=" table-bordered table-striped table-hover table-condensed" >
		<tr >
		    <th style="text-align: center;">类别的id</th>
			<th style="text-align: center;">parent_id</th>
			<th style="text-align: center;">类别名字</th>
			<th style="text-align: center;">类别选择</th>
			<th style="text-align: center;">类别编号</th>
			<th style="text-align: center;">创建时间</th>
			<th style="text-align: center;">更改时间</th>
			<th style="text-align: center;" colspan="3">操作</th>
		</tr>
		<c:forEach items="${pageModel.data}" var="catego">
			<tr >
				<td>${catego.id}</td>
				<td>${catego.parent_id}</td>
				<td>${catego.name}</td>
				<td>${catego.status}</td>
				<td>${catego.sort_order}</td>
				<td>${catego.create_time}</td>
				<td>${catego.update_time}</td>
				
				<td>
				  <a href="CategoryController?id=${catego.id}&operation=5">删除</a>
				</td>
				<td>
				  <a href="CategoryController?id=${catego.id}&operation=4">修改</a> 
				 </td>
				 <td>
				  <a href="addcategory.jsp">添加</a><br>
				 </td>	
			</tr>
		</c:forEach>
	</table>
	<div align="center">
		<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}"
			step="1">
			<c:choose>
				<c:when test="${pageModel.currentPage==pageNo}">
					<a style="color: red" href="product?pageNo=${pageNo}&operation=6">${pageNo}</a>
				</c:when>
				<c:when test="${pageModel.currentPage!=pageNo}">
					<a href="CategoryController?pageNo=${pageNo}&operation=6">${pageNo}</a>
				</c:when>
			</c:choose>
		</c:forEach>
	</div>
	
</body>
<script type="text/javascript" src="../../js/jquery-3.3.1.slim.js"></script>
<script type="text/javascript" src="../../js/bootstrap.js"></script>
</html>