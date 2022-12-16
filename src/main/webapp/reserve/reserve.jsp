<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="model.User"%>
<%@page import="model.Product"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ������</title>
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
		<!-- ���� �� -->
		<form name="form" method="POST" action="<c:url value='/prod/insert' />">
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">������</caption>
				<tr>
					<td>���</td>
					<td><input type="text" style="width: 230px"
						name="name" value="${product.name}"></td>
				</tr>
				<tr>
					<td>ȸ��ID</td>
					<td><input type="text" style="width: 230px" name="userId"
						value="${user.userId}" readonly></td>
				</tr>
				<tr>
					<td>������ID</td>
					<td><input type="text" style="width: 230px" name="productId" value="${product.productId}" readonly></td>
				</tr>
				<tr>
					<td>���۳�¥</td>
					<td><input type="date" style="width: 230px" name="startDate"></td>
				</tr>
				<tr>
					<td>��������¥</td>
					<td><input type="date" style="width: 230px" name="endDate"></td>
				</tr>
				<tr>
					<td>�ο���</td>
					<td><input type="text" style="width: 230px" name="headCount"
						placeholder="ex.1"></td>
				</tr>
				<tr>
					<td>�����ڸ�</td>
					<td><input type="text" style="width: 230px" name="name"
						value="${user.name}" readonly></td>
				</tr>
				<tr>
					<td>���¹�ȣȮ��</td>
					<td><input type="text" style="width: 230px"
						name="accountNumber" value="${user.accountNumber}" readonly></td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" style="width: 230px" name="price"
						value="${product.price}" readonly></td>
				</tr>
			</table>
			<div class="btnBox">
				<input type="submit" value="����" class="btn"> &nbsp;
			</div>
		</form>
	</div>
</body>
</html>