<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">欢迎登陆电商后台系统</h1>
	<ul class="nav nav-pills nav-stacked">
		<li ><a
			href="view/cartView/CartController?operation=6&pageNo=1">分页显示购物车</a>
		</li>
		<li ><a
			href="view/CategoryView/CategoryController?operation=6&pageNo=1">分页显示类别</a>
		</li>
		<li ><a
			href="view/productView/product?pageNo=1&operation=6">分页显示商品</a></li>
	</ul>

</body>
<script type="text/javascript" src="../js/jquery-3.3.1.slim.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>

</html>