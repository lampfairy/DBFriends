<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>로고와 메뉴</title>
	<style type="text/css">
		 body{margin:0}
		 .layout1{margin:0px auto;width:1180px;height:48px;padding:10px}
		 .logo1{width:100px;height:48px;float:left;margin:5px 10px 10px 0px;font-size:30px;<!--background-image:url(logo3.png)-->}
		 .logo2{width:250px;height48px;font-size:30px;float:left;margin:5px 0px 4px 0px;background-color:white}
		  .navitool{float:left;width:600px;height:40px;padding:0px;margin:0px 0px 10px 0px}
		  .navi{float:left;width:90px;padding:10px;height:20px;font-size:18px;text-align:center;margin:5px 0px 10px 0px}
		  .login{float:right;width:200px;padding:10px;height:20px;font-size:18px;text-align:center;margin:5px 0px 10px 0px}
		  a{display:block}
		  a:link{text-decoration:none;color:black}
		  a:visited{text-decoration:none;color:black}
		  a:active{text-decoration:none;color:black}
		  a:hover{text-decoration:none;color:black}
  </style>
</head>
<body>
	<div class="layout1">
  		<div class="logo1"><a href="index.jsp">로고</a></div>
  		<div class="logo2"><a href="index.jsp">먹고 놀자</a></div>
		<div class="navitool">
  			<div class="navi"><a href="top10.jsp">TOP10</a></div>
  			<div class="navi"><a href="reservation.jsp">예약/예매</a></div>
  			<div class="navi"><a href="review.jsp">리뷰</a></div>
  			<div class="navi"><a href="myPage.jsp">마이페이지</a></div>
		</div>
		<div class="login"><a href="<c:url value='/user/login/form'">로그인/회원가입</a></div>
	</div>
</body>
</html>