<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link ref="../../css/bootstrap.css">
</head>
<body>
	<div align="center">
		<fieldset style="width: 35%;">
			<legend>添加购物车</legend>
			<form action="CartController" method="get">
				<input type="hidden" name="operation" value="1" />
				<table align="center">
					<tr>
						<td>购买商品的id</td>
						<td><input type="text" name="productid" /></td>
					</tr>
					<tr>
						<td>购买商品的数量</td>
						<td><input type="text" name="productnum" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="确认添加" /></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
	<script type="text/javascript" src="../../js/jquery-3.3.1.slim.js"></script>
	<script type="text/javascript" src="../../js/bootstrap.js"></script>
</body>
</html>