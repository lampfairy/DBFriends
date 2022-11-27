<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	@SuppressWarnings("unchecked") 
	List<Product> prodList = (List<Product>)request.getAttribute("prodList");
	User user = (User)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>예약/예매 페이지</title>
	<style type="text/css">
		body{margin:0}
		.layout{margin:0px auto;width:1180px;padding:10px}
		.search{background-image:ivory;text-align:center}
		select,input{width:240px;height:40px;background-color:skyBlue;
		border-radius: 10px;font-size:18px;text-align:center;}
		.splace{margin-right:150px}
		.sdetail{margin-left:150px}
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
					<option value = "1">성북구</option>
					<option value = "2">종로구</option>
					<option value = "3">마포구</option>
				</select>
				<select name="type">
					<option disabled selected>맛집/숙소/액티비티</option>
					<option value = "1">맛집</option>
					<option value = "2">숙소</option>
					<option value = "3">액티비티</option>
				</select>
				<select name="detail" class = "sdetail">
					<option disabled selected>세부사항</option>
					<option value = "1">..</option>
					<option value = "2">...</option>
					<option value = "3">....</option>
				</select><br><br><br><br><br><br><br><br>
				<input type = "submit" value = "검색"/>
			</form><br><br>
		</div>
		<!-- 상품 목록 -->
			<a href = "<c:url value='/prod/list' />">눌러</a>
		<table>
			<tr>
				<td width=200>사진</td>
				<td width=600>이름 및 위치</td>
				<td width=200>바로가기</td>
			</tr>
			<c:forEach var="prod" items="${prodList}">
				<tr>
					<td>이미지</td>
					<td>sdfsdf
						이름 : ${prod.name}
						위치 : ${prod.location}
						위치 : ${prod.location}
					</td>
					<td>
						sdf
					<td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>