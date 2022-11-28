<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>예약/예매 페이지</title>
	<style type="text/css">
		body{margin:0}
		.layout{margin:0px auto;width:1180px;padding:10px}
		.search{background-image:ivory;text-align:center}
		select{width:240px;height:40px;background-color:skyBlue;
		border-radius: 10px;font-size:18px;text-align:center;}
		.splace{margin-right:150px}
		.sdetail{margin-left:150px}
		.key{width:600px;height:40px;background-color:skyBlue;
		border-radius: 10px;font-size:18px;text-align:center;}
		.sub{width:240px;height:40px;background-color:skyBlue;
		border-radius: 10px;font-size:18px;text-align:center;}
	</style>
</head>
<body>
	<!-- 로고와 메뉴 -->
	<jsp:include page = "menu.jsp"/>
	<hr>
	<div class="layout">
		<!-- 검색창 -->
		<div class="search">
			<form class = "sForm" method="POST" action="<c:url value='/prod/list' />">
				<select name="place" class = "splace">
					<option disabled selected>장소</option>
					<option value = "1">서울</option>
					<option value = "2">경기</option>
					<option value = "3">강원</option>
					<option value = "4">충청</option>
					<option value = "5">전라</option>
					<option value = "6">경상</option>
					<option value = "7">제주</option>
				</select>
				<select name= "type" id = "type">
					<option disabled selected>맛집/숙소/액티비티</option>
					<option value = "1">맛집</option>
					<option value = "2">숙소</option>
					<option value = "3">액티비티</option>
				</select>
				<select name="detail" class = "sdetail">
					<option disabled selected>세부사항</option>
					<!--  
					<option value = "한식" <c:if test="${type.type eq 1}"></c:if>></option>
					-->
					</select>
					
					
				<br><br><br><br><br><br><br><br>
				<input type = "text" placeholder="키워드 검색" name = "keySearch" class = "key"/>
				<input type = "submit" value = "검색" class = "sub"/>
			</form><br><br>
		</div>
		<!-- 상품 목록 -->
		<jsp:include page = "../prod/list.jsp"/>
	</div>
</body>
</html>