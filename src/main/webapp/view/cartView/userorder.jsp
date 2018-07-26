<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UserOrderController" method="get">
		<table align="center">
			<tr>
				<td>订单备注</td>
				<td >
				   <input type="text" name="status" />			   
				</td>
			</tr>
			<tr>
				<td>支付方式</td>
				<td><input type="text" name="payment_type" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认添加" /></td>
			</tr>
		</table>
	</form>
</body>
</html>