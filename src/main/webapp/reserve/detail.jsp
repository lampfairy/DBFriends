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
		<!-- 예약 상세 폼 -->
		<form name="form" method="POST" action="<c:url value='/main/myPage' />">
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">예약상세정보</caption>
				<tr>
					<td>장소</td>
					<td><input type="text" style="width: 230px"
						name="name" value="${reserve.name}"></td>
				</tr>
				<tr>
					<td>예약번호</td>
					<td><input type="text" style="width: 230px"
						name="reservationId" value="${reserve.reservationId}" readonly></td>
				</tr>
				<tr>
					<td>회원ID</td>
					<td><input type="text" style="width: 230px" name="userId"
						value="${user.userId}" readonly></td>
				</tr>
				<tr>
					<td>여행지ID</td>
					<td><input type="text" style="width: 230px" name="productId" value="${reserve.productId}" readonly></td>
				</tr>
				<tr>
					<td>시작날짜</td>
					<td><input type="date" style="width: 230px" name="startDate" value="${reserve.startDate}"></td>
				</tr>
				<tr>
					<td>마지막날짜</td>
					<td><input type="date" style="width: 230px" name="endDate" value="${reserve.endDate}"></td>
				</tr>
				<tr>
					<td>인원수</td>
					<td><input type="text" style="width: 230px" name="headCount" value="${reserve.headCount}"></td>
				</tr>
				<tr>
					<td>예약자명</td>
					<td><input type="text" style="width: 230px" name="name"
						value="${user.name}" readonly></td>
				</tr>
				<tr>
					<td>계좌번호확인</td>
					<td><input type="text" style="width: 230px"
						name="accountNumber" value="${user.accountNumber}" readonly></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" style="width: 230px" name="price"
						value="${reserve.price}" readonly></td>
				</tr>
			</table>
			<div class="btnBox">
				<input type="submit" value="확인" class="btn"> &nbsp;
			</div>
		</form>
	</div>
</body>

</html>