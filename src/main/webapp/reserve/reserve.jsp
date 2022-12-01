<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>예약 페이지</title>
	<style type="text/css">
		.layout{margin:0px auto;width:1180px;padding:10px;font-size:18px}
		table, td{border:2px solid powderBlue;border-collapse:collapse;}
		table{margin:100px auto 0px auto}
		td{height:40px}
		.btn{text-align:center;font-size:18px;border-radius:10px;background-color:powderBlue;
		border:1px solid black;width:100px;height:30px}
		.btnBox{width:350px;height:30px;margin:auto;background-color:white;text-align:center}
	</style>
</head>
<body>
	<!-- 로고와 메뉴 -->
	<jsp:include page="../main/menu.jsp" />
	<hr>
	<div class="layout">
		<!-- 예약 폼 -->
		<form method="POST" action="<c:url value='/prod/insert' />">
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">예약폼</caption>
				<tr>
					<td>예약번호</td>
					<td><input type="text" style="width: 230px" name="reservationId"></td>
				</tr>
				<tr>
					<td>회원ID</td>
					<td><input type="text" style="width: 230px" name="userId"></td>
				</tr>
				<tr>
					<td>여행지ID</td>
					<td><input type="text" style="width: 230px" name="productId" value="${product.id}" readonly></td>
				</tr>
				<tr>
					<td>예약 리스트</td>
					<td><input type="text" style="width: 230px" name="reservationList"></td>
				</tr>
				<tr>
					<td>시작날짜</td>
					<td><input type="text" style="width: 230px" name="startDate"
						placeholder="ex.2013-01-01"></td>
				</tr>
				<tr>
					<td>마지막날짜</td>
					<td><input type="text" style="width: 230px" name="endDate"
						placeholder="ex.2013-01-05"></td>
				</tr>
				<tr>
					<td>인원수</td>
					<td><input type="text" style="width: 230px" name="headCount"
						placeholder="2"></td>
				</tr>
				<tr>
					<td>예약자명</td>
					<td><input type="text" style="width: 230px" name="name"
						value="${user.name}"></td>
				</tr>
				<tr>
					<td>계좌번호확인</td>
					<td><input type="text" style="width: 230px"
						name="accountNumber""></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" style="width: 230px" name="price"
						value="${product.price}" readonly></td>
				</tr>
			</table>
			<div class="btnBox">
				<input type="submit" value="예약" class="btn">
			</div>
		</form>
	</div>
</body>
</html>