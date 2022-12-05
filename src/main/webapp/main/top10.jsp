<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>TOP10 페이지</title>
	<style type="text/css">
		body{margin:0}
		.layout{margin:0px auto;width:1180px;padding:10px;text-align:center}
		.new{width:1180px;margin: 0px auto}
		.new div{text-align:center;font-size:18px;width:300px;height:300px;
		background-color:powderBlue;float:left;margin:0px 40px 30px 40px;line-height:300px;border-radius:50%;}
		.key{width:860px;height:40px;background-color:powderBlue;
		border-radius: 10px;font-size:18px;text-align:center;}
		.sub{width:240px;height:40px;background-color:powderBlue;
		border-radius: 10px;font-size:18px;text-align:center;}
	</style>
</head>
<body>
	<!-- 로고와 메뉴 -->
	<jsp:include page = "menu.jsp"/>
	<hr>
	<div class="layout">
		<br><br>
		<!-- 인기 여행지 -->
		<div style="text-align:center;font-size:24px">인기 여행지 TOP3</div><br><br>
		<div class = "new">
			<div>이미지</div>
			<div>이미지</div>
			<div>이미지</div>
		</div><br><br><br><br>
		<!-- 상품 목록 -->
		<jsp:include page = "../prod/list.jsp"/>
	</div>
</body>
</html>