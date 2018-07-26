<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<div align="center">
		<fieldset style="width: 35%;">
			<legend>添加商品</legend>

			<form action="product" method="get">
				<input type="hidden" name="operation" value="1" />
				<table align="center">
					<tr>
						<td>商品的名称</td>
						<td><input type="text" name="pname" "/></td>
					</tr>
					<tr>
						<td>商品的描述</td>
						<td><input type="text" name="pdesc" /></td>
					</tr>
					<tr>
						<td>商品的价格</td>
						<td><input type="text" name="price" /></td>
					</tr>
					<tr>
						<td>商品的图片</td>
						<td><input type="text" name="prule" /></td>
					</tr>
					<tr>
						<td>商品的规格</td>
						<td><input type="text" name="pimage" /></td>
					</tr>
					<tr>
						<td>商品的库存</td>
						<td><input type="text" name="pstock" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="确认添加" /></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>