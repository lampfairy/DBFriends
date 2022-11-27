<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>로고와 메뉴</title>
	<style type="text/css">
		 body{margin:0}
		 .layout1{margin:0px auto;width:1180px;height:48px;padding:10px}
		 .logo1{width:110px;height:48px;float:left;margin:5px 10px 10px 0px;background-image:url('./images/logo.jpg')}
		 .logo2{width:240px;height48px;font-size:30px;float:left;margin:5px 0px 4px 0px}
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
  		<div class="logo1"><a href="<c:url value='/' />"></a></div>
  		<div class="logo2"><a href="<c:url value='/' />">먹고 놀자</a></div>
		<div class="navitool">
  			<div class="navi"><a href="<c:url value='/main/top10' />">TOP10</a></div>
  			<div class="navi"><a href="<c:url value='/main/reserve' />">예약/예매</a></div>
  			<div class="navi"><a href="<c:url value='/main/review' />">리뷰</a></div>
  			<div class="navi"><a href="<c:url value='/main/myPage' />">마이페이지</a></div>
		</div>
		<div class="login">
			<c:choose>
				<c:when test = "${userId == null}">
					<a href="<c:url value='/user/loginForm' />">로그인/회원가입</a>
				</c:when>
				<c:otherwise>
					<a href="<c:url value='/user/logout' />">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</div>
		
	</div>
</body>
</html>