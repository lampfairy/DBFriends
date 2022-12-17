<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>예약 상세 페이지</title>
<style type="text/css">
.layout {
	margin: 0px auto;
	width: 1180px;
	padding: 10px;
	font-size: 18px
}

table, td {
	border: 2px solid powderBlue;
	border-collapse: collapse;
}

table {
	margin: 100px auto 0px auto
}

td {
	height: 40px
}

.btn {
	text-align: center;
	font-size: 18px;
	border-radius: 10px;
	background-color: powderBlue;
	border: 1px solid black;
	width: 100px;
	height: 30px
}

.btnBox {
	width: 350px;
	height: 30px;
	margin: auto;
	background-color: white;
	text-align: center
}
</style>
</head>
<body>
	<!-- 로고와 메뉴 -->
	<jsp:include page="../main/menu.jsp" />
	<hr>
	<div class="layout">
		<form name="form" method="POST" action="<c:url value='/main/myPage' />">
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">예약상세정보</caption>
				<tr>
					<td width="150" align="center">장소</td>
					<td width="250" style="padding-left: 10px">${reserve.name}</td>
				</tr>
				<tr>
					<td width="150" align="center">예약번호</td>
					<td  width="250" style="padding-left: 10px">${reserve.reservationId}</td>
				</tr>
				<tr>
					<td width="150" align="center">회원ID</td>
					<td width="250" style="padding-left: 10px">${user.userId}</td>
				</tr>
				<tr>
					<td width="150" align="center">여행지ID</td>
					<td width="250" style="padding-left: 10px">${reserve.productId}</td>
				</tr>
				<tr>
					<td width="150" align="center">시작날짜</td>
					<td width="250" style="padding-left: 10px">${reserve.startDate}</td>
				</tr>
				<tr>
					<td width="150" align="center">마지막날짜</td>
					<td width="250" style="padding-left: 10px">${reserve.endDate}</td>
				</tr>
				<tr>
					<td width="150" align="center">인원수</td>
					<td width="250" style="padding-left: 10px">${reserve.headCount}</td>
				</tr>
				<tr>
					<td width="150" align="center">예약자명</td>
					<td width="250" style="padding-left: 10px">${user.nameOnAccount}</td>
				</tr>
				<tr>
					<td width="150" align="center">계좌번호확인</td>
					<td width="250" style="padding-left: 10px">${user.accountNumber}</td>
				</tr>
				<tr>
					<td width="150" align="center">가격</td>
					<td width="250" style="padding-left: 10px">${reserve.price}</td>
				</tr>
			</table>
			<br>
			<div class="btnBox">
				<input type="submit" value="이전" class="btn"> &nbsp;
			</div>
		</form>
	</div>
</body>

</html>