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
			<legend>输入修改商品的信息</legend>
			<form action="product" method="get">
				<input type="hidden" name="operation" value="3" />
				<table align="center">
					<tr>
						<td>商品id号</td>
						<td><input type="text" name="id" value="${produc.id}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>商品名字</td>
						<td><input type="text" name="pname" value="${produc.name}" />
						</td>
					</tr>
					<tr>
						<td>商品描述</td>
						<td><input type="text" name="pdesc" value="${produc.desc}" />
						</td>
					</tr>
					<tr>
						<td>商品价格</td>
						<td><input type="text" name="price" value="${produc.price}" />
						</td>
					</tr>
					<tr>
						<td>商品规格</td>
						<td><input type="text" name="prule" value="${produc.rule}" />
						</td>
					</tr>
					<tr>
						<td>商品图片</td>
						<td><input type="text" name="pimage" value="${produc.image}" />
						</td>
					</tr>
					<tr>
						<td>商品库存</td>
						<td><input type="text" name="pstock" value="${produc.stock}" />
						</td>
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