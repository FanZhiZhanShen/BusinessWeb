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
    <style>
        .li-ul{
            display: none;
            text-indent: 20px;
        }
        body{
           background-color: #5e5e5e;
        }
        a:link {color:darkblue;}		/* 未被访问的链接 */
        a:visited {color:#00FF00;}	/* 已被访问的链接 */
        a:hover {color:black;}	/* 鼠标指针移动到链接上 */
        a:active {color:red;}	/* 正在被点击的链接 */
    </style>
</head>
<body>


	<ul class="nav nav-pills nav-stacked">
		<li ><a
				href="cartView/CartController?operation=6&pageNo=1" target="iframe1">分页显示购物车</a>
		</li>
		<li id="li2"><a
				href="CategoryView/CategoryController?operation=6&pageNo=1" target="iframe1"><span class="glyphicon glyphicon-th-list"></span>商品类别</a>
            <ul class="nav nav-pills nav-stacked li-ul" >
                <li><a href="">类别数量统计</a></li>
                <li><a href="">类别销售统计</a></li>
            </ul>
		</li>
		<li id="li3"><a
				href="productView/product?pageNo=1&operation=6" target="iframe1"><span class="glyphicon glyphicon-th-list"></span>商品列表</a>
            <ul class="nav nav-pills nav-stacked li-ul" >
                <li><a href="">商品数量统计</a></li>
                <li><a href="">商品价格统计</a></li>
            </ul>
		</li>
	</ul>

</body>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
</html>
<script>
    $(function(){
        $("#li2").click(function () {
            $("#li2>.li-ul").slideToggle()
        })
        $("#li3").click(function () {
            $("#li3>.li-ul").slideToggle()
        })
    })
</script>