<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<fieldset style="width: 35%;">
			<legend>修改购物单 </legend>
			<form action="CartController" method="get">
				<input type="hidden" name="operation" value="3" />
				<table align="center">
					<tr>
						<td>购物订单id</td>
						<td><input type="text" name="id" value="${cart.id}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>购买商品id</td>
						<td><input type="text" name="productid"
							value="${cart.productid}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>购买商品数量</td>
						<td><input type="text" name="productnum"
							value="${cart.productNum}" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="确认修改" /></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>