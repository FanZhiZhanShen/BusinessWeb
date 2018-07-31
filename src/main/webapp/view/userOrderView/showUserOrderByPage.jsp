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
<h1 align="center">已买商品</h1>

<table align="center" class="table-bordered table-striped table-hover table-condensed" >

	<tr>
		<th>下单id</th>
		<th>下单编号</th>
		<th>用户id</th>
		<th>地址id</th>
		<th>付款金额</th>
		<th>支付方式</th>
		<th>快递运费</th>
		<th>订单状态</th>
		<th>支付时间</th>
		<th>发货时间</th>
		<th>完成时间</th>
		<th>关闭时间</th>
		<th>创建时间</th>
		<th>修改时间</th>
		<th style="text-align: center;">操作</th>
	</tr>
	<c:forEach items="${pageModel.data}" var="pageModel">
	  <tr>
		<td align="center">${pageModel.id}</td>
		<td align="center">${pageModel.order_no}</td>
		<td align="center">${pageModel.user_id}</td>
		<td align="center">${pageModel.shipping_id}</td>
		<td align="center">${pageModel.payment}</td>
		<td align="center">${pageModel.payment_type}</td>
		<td align="center">${pageModel.postage}</td>
		<td align="center">${pageModel.status}</td>
		<td align="center">${pageModel.payment_time}</td>
		<td align="center">${pageModel.send_time}</td>
		<td align="center">${pageModel.end_time}</td>
		<td align="center">${pageModel.close_time}</td>
		<td align="center">${pageModel.create_time}</td>
		<td align="center">${pageModel.update_time}</td>
		<td>
			<a href="OrderController?id=${pageModel.id}&operation=3">删除</a>
		</td>
	  <tr>
	</c:forEach>
</table>
<div align="center">
	<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}"
			   step="1">

		<c:choose>
			<c:when test="${pageModel.currentPage==pageNo}">
				<a style="color: red"
				   href="OrderController?pageNo=${pageNo}&operation=1">${pageNo}</a>
			</c:when>
			<c:when test="${pageModel.currentPage!=pageNo}">
				<a href="OrderController?pageNo=${pageNo}&operation=1">${pageNo}</a>
			</c:when>
		</c:choose>
	</c:forEach>
</div>
</body>
<script type="text/javascript" src="../../js/jquery-3.3.1.slim.js"></script>
<script type="text/javascript" src="../../js/bootstrap.js"></script>
</html>