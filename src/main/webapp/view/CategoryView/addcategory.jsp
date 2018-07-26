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
			<legend>添加类别</legend>
			<form action="CategoryController" method="get">
				<input type="hidden" name="operation" value="1" />

				<table align="center">

					<tr>
						<td>parent_id</td>
						<td><input type="text" name="parent_id" /></td>
					</tr>
					<tr>
						<td>类别名字</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>类别选择</td>
						<td><input type="text" name="status" /></td>
					</tr>
					<tr>
						<td>类别编号</td>
						<td><input type="text" name="sort_order" /></td>
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