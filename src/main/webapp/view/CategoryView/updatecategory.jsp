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
			<legend>修改类别</legend>
			<form action="CategoryController" method="get">
				<input type="hidden" name="operation" value="3" /> <input
					type="hidden" name="id" value="${category.id}" />
				<table align="center">
					<tr>
						<td>类别id</td>
						<td><input type="text" name="id" value="${category.id}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>输入parent_id</td>
						<td><input type="text" name="parent_id"
							value="${category.parent_id}" /></td>
					</tr>
					<tr>
						<td>输入名字</td>
						<td><input type="text" name="name" value="${category.name}" /></td>
					</tr>
					<tr>
						<td>输入状态1或2</td>
						<td><input type="text" name="status"
							value="${category.status}" /></td>
					</tr>
					<tr>
						<td>输入排序编号</td>
						<td><input type="text" name="sort_order"
							value="${category.sort_order}" /></td>
					</tr>
					<tr>
						<td>输入创建时间</td>
						<td><input type="datetime-local" name="create_time"
							value="${category.create_time}" /></td>
					</tr>
					<tr>
						<td>输入更新时间</td>
						<td><input type="datetime-local" name="update_time"
							value="${category.update_time}" /></td>
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