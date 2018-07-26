<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
::-webkit-scrollbar {
	display: none;
}

* {
	margin: 0px;
}

div#container {
	height: 100%;
	width: 100%;
	display: flex;
	position: fixed;
	background-color: yellow;
	flex-flow: column;
	justify-content: space-between;
}

div.Sc {
	width: 100%;
	height: 100px;
	border: 1px solid green;
}

div#container-div2 {
	flex: 1;
	display: flex;
	flex-flow: nowrap;
	justify-content: space-between;
}

div.Sc1 {
	width: 200px;
	height: 100%;
	border: 1px solid red;
}

div#container-div2-div2 {
	flex: 1px;
}
</style>

</head>
<body>
	<div id="container">
		<div class="Sc"></div>
		<div class="Sc" id="container-div2">
			<div class="Sc1"></div>
			<div class="Sc1" id="container-div2-div2"></div>
		</div>
		<div class="Sc"></div>
	</div>

</body>

</html>