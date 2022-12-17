<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
		<form name="form" method="POST"
			action="<c:url value='/main/myPage' />">
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">예약상세정보</caption>
				<tr>
					<td>장소</td>
					<td>${reserve.name}</td>
				</tr>
				<tr>
					<td>예약번호</td>
					<td>${reserve.reservationId}</td>
				</tr>
				<tr>
					<td>회원ID</td>
					<td>${user.userId}</td>
				</tr>
				<tr>
					<td>여행지ID</td>
					<td>${reserve.productId}</td>
				</tr>
				<tr>
					<td>시작날짜</td>
					<td>${reserve.startDate}</td>
				</tr>
				<tr>
					<td>마지막날짜</td>
					<td>${reserve.endDate}</td>
				</tr>
				<tr>
					<td>인원수</td>
					<td>${reserve.headCount}</td>
				</tr>
				<tr>
					<td>예약자명</td>
					<td>${user.name}</td>
				</tr>
				<tr>
					<td>계좌번호확인</td>
					<td>${user.accountNumber}</td>
				</tr>
				<tr>
					<td>가격</td>
					<td>${reserve.price}</td>
				</tr>
			</table>
			<br>
			<!--  <div class="btnBox">
				<input type="submit" value="이전" class="btn"> &nbsp;
			</div> -->
		</form>
	</div>
</body>

</html>