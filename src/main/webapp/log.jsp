<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>欢迎登陆电商系统</h1>
	<div align="center">
		<fieldset style="width: 40%;">
			<legend>输入登陆信息 </legend>
			<form action="login.do" method="get">
				<input type="hidden" name="operation" value="1" />
				<table>
					<tr>
						<td class="text-right">用户名</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td class="text-right">密码</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="确定登陆" /></td>
						<td><a href="signIn.jsp" class="text-right">注册用户</a></td>
					</tr>
				</table>
				
			</form>
		</fieldset>
	</div>
</body>
<script type="text/javascript" src="../../js/jquery-3.3.1.slim.js"></script>
<script type="text/javascript" src="../../js/bootstrap.js"></script>
</html>