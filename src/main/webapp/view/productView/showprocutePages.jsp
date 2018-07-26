<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">显示商品</h1>
	<table align="center" class=" table-bordered table-striped table-hover table-condensed">
		<tr>
			<th>商品的id</th>
			<th>商品的名称</th>
			<th>商品的描述</th>
			<th>商品的价格</th>
			<th>商品的图片</th>
			<th>商品的规格</th>
			<th>商品的库存</th>
			<th style="text-align: center;" colspan="4">操作</th>
		</tr>
		<c:forEach items="${pageModel.data}" var="produc">
			<tr>
				<td>${produc.id}</td>
				<td>${produc.name}</td>
				<td>${produc.desc}</td>
				<td>${produc.price}</td>
				<td>${produc.rule}</td>
				<td>${produc.image}</td>
				<td>${produc.stock}</td>
				<td>
				    <a href="product?operation=5&id=${produc.id}">删除</a> 
				 </td>
				 <td>
				    <a href="product?operation=4&id=${produc.id}">修改</a> 
				 </td>
				  <td>
				    <a href="addproduct.jsp">添加</a>
				  </td>
			    	<td>
					    <a href="href="product?operation=4&id=${produc.id}">添加到购物车</a>
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
					<a href="product?pageNo=${pageNo}&operation=6">${pageNo}</a>
				</c:when>
			</c:choose>
		</c:forEach>
	</div>

</body>
<script type="text/javascript" src="../../js/jquery-3.3.1.slim.js"></script>
<script type="text/javascript" src="../../js/bootstrap.js"></script>

</html>