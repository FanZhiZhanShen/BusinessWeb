<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		div{
			width: 100%;
			height: 100%;
			position: fixed;
			display: flex;
            justify-content: center;
			align-items: center;
		}
	</style>

</head>
<body>
	<div >
		<fieldset style="width: 20%;">
			<legend>注册信息输入</legend>
			<form action="login.do" method="get">
				<input type="hidden" name="operation" value="2" />
				<table align="center">
					<tr>
						<td>输用户名</td>
						<td><input type="text" name="username" "/></td>
					</tr>
					<tr>
						<td>输入密码</td>
						<td><input type="text" name="password" /></td>
					</tr>
					<tr>
						<td>输入地址</td>
						<td><input type="text" name="ip" /></td>
					</tr>
					<tr>
						<td>选择性别</td>
						<td><input type="text" list="as" name="sex" />
						 <datalist id="as">
							<option value="男" />
							<option value="女" />
						 </datalist>
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="确认注册" /></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>