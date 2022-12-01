<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>���� ������</title>
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
	<!-- �ΰ�� �޴� -->
	<jsp:include page="../main/menu.jsp" />
	<hr>
	<div class="layout">
		<!-- ���� �� -->
		<form method="POST" action="<c:url value='/prod/insert' />">
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">������</caption>
				<tr>
					<td>�����ȣ</td>
					<td><input type="text" style="width: 230px" name="reservationId"></td>
				</tr>
				<tr>
					<td>ȸ��ID</td>
					<td><input type="text" style="width: 230px" name="userId"></td>
				</tr>
				<tr>
					<td>������ID</td>
					<td><input type="text" style="width: 230px" name="productId" value="${product.id}" readonly></td>
				</tr>
				<tr>
					<td>���� ����Ʈ</td>
					<td><input type="text" style="width: 230px" name="reservationList"></td>
				</tr>
				<tr>
					<td>���۳�¥</td>
					<td><input type="text" style="width: 230px" name="startDate"
						placeholder="ex.2013-01-01"></td>
				</tr>
				<tr>
					<td>��������¥</td>
					<td><input type="text" style="width: 230px" name="endDate"
						placeholder="ex.2013-01-05"></td>
				</tr>
				<tr>
					<td>�ο���</td>
					<td><input type="text" style="width: 230px" name="headCount"
						placeholder="2"></td>
				</tr>
				<tr>
					<td>�����ڸ�</td>
					<td><input type="text" style="width: 230px" name="name"
						value="${user.name}"></td>
				</tr>
				<tr>
					<td>���¹�ȣȮ��</td>
					<td><input type="text" style="width: 230px"
						name="accountNumber""></td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" style="width: 230px" name="price"
						value="${product.price}" readonly></td>
				</tr>
			</table>
			<div class="btnBox">
				<input type="submit" value="����" class="btn">
			</div>
		</form>
	</div>
</body>
</html>