<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<form name="form" method="POST" action="<c:url value='/main/myPage' />">
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">���������</caption>
				<tr>
					<td width="150" align="center">���</td>
					<td width="250" style="padding-left: 10px">${reserve.name}</td>
				</tr>
				<tr>
					<td width="150" align="center">�����ȣ</td>
					<td  width="250" style="padding-left: 10px">${reserve.reservationId}</td>
				</tr>
				<tr>
					<td width="150" align="center">ȸ��ID</td>
					<td width="250" style="padding-left: 10px">${user.userId}</td>
				</tr>
				<tr>
					<td width="150" align="center">������ID</td>
					<td width="250" style="padding-left: 10px">${reserve.productId}</td>
				</tr>
				<tr>
					<td width="150" align="center">���۳�¥</td>
					<td width="250" style="padding-left: 10px">${reserve.startDate}</td>
				</tr>
				<tr>
					<td width="150" align="center">��������¥</td>
					<td width="250" style="padding-left: 10px">${reserve.endDate}</td>
				</tr>
				<tr>
					<td width="150" align="center">�ο���</td>
					<td width="250" style="padding-left: 10px">${reserve.headCount}</td>
				</tr>
				<tr>
					<td width="150" align="center">�����ڸ�</td>
					<td width="250" style="padding-left: 10px">${user.nameOnAccount}</td>
				</tr>
				<tr>
					<td width="150" align="center">���¹�ȣȮ��</td>
					<td width="250" style="padding-left: 10px">${user.accountNumber}</td>
				</tr>
				<tr>
					<td width="150" align="center">����</td>
					<td width="250" style="padding-left: 10px">${reserve.price}</td>
				</tr>
			</table>
			<br>
			<div class="btnBox">
				<input type="submit" value="����" class="btn"> &nbsp;
			</div>
		</form>
	</div>
</body>

</html>