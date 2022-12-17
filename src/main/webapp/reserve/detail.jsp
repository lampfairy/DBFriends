<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �� ������</title>
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
	<!-- �ΰ�� �޴� -->
	<jsp:include page="../main/menu.jsp" />
	<hr>
	<div class="layout">
		<form name="form" method="POST"
			action="<c:url value='/main/myPage' />">
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">���������</caption>
				<tr>
					<td>���</td>
					<td>${reserve.name}</td>
				</tr>
				<tr>
					<td>�����ȣ</td>
					<td>${reserve.reservationId}</td>
				</tr>
				<tr>
					<td>ȸ��ID</td>
					<td>${user.userId}</td>
				</tr>
				<tr>
					<td>������ID</td>
					<td>${reserve.productId}</td>
				</tr>
				<tr>
					<td>���۳�¥</td>
					<td>${reserve.startDate}</td>
				</tr>
				<tr>
					<td>��������¥</td>
					<td>${reserve.endDate}</td>
				</tr>
				<tr>
					<td>�ο���</td>
					<td>${reserve.headCount}</td>
				</tr>
				<tr>
					<td>�����ڸ�</td>
					<td>${user.name}</td>
				</tr>
				<tr>
					<td>���¹�ȣȮ��</td>
					<td>${user.accountNumber}</td>
				</tr>
				<tr>
					<td>����</td>
					<td>${reserve.price}</td>
				</tr>
			</table>
			<br>
			<!--  <div class="btnBox">
				<input type="submit" value="����" class="btn"> &nbsp;
			</div> -->
		</form>
	</div>
</body>

</html>