<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">显示购物车</h1>
	
	<table align="center" class="table-bordered table-striped table-hover table-condensed" >
	
		<tr>
			<th>购物订单id</th>
			<th>购买商品id</th>
			<th>购买商品数量</th>
			<th style="text-align: center;" colspan="3">操作</th>
		</tr>
		<c:forEach items="${pageModel.data}" var="pageModel">
			<tr>
				<td align="center">${pageModel.id}</td>
				<td align="center">${pageModel.productid}</td>
				<td align="center">${pageModel.productNum}</td>
				<td>
				   <a href="CartController?id=${pageModel.id}&operation=5">删除</a>
				</td>

				<td>
				   <a href="CartController?id=${pageModel.id}&productId=${pageModel.productid}&operation=4">修改</a>
				</td>
				<td>
				   <a href="http://localhost:8080/BusinessWeb/view/userOrderView/OrderController?operation=2&productid=${pageModel.productid}&productNum=${pageModel.productNum}">下单</a>
				</td>
		</c:forEach>
	</table>
	<div align="center">
		<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}"
			step="1">

			<c:choose>
				<c:when test="${pageModel.currentPage==pageNo}">
					<a style="color: red"
						href="CartController?pageNo=${pageNo}&operation=6">${pageNo}</a>
				</c:when>
				<c:when test="${pageModel.currentPage!=pageNo}">
					<a href="CartController?pageNo=${pageNo}&operation=6">${pageNo}</a>
				</c:when>
			</c:choose>
		</c:forEach>
	</div>
</body>
<script type="text/javascript" src="../../js/jquery-3.3.1.slim.js"></script>
<script type="text/javascript" src="../../js/bootstrap.js"></script>

</html>