<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>���� �ۼ� ������</title>
	<style type="text/css">
		body{margin:0}
		.layout{margin:0px auto;width:1180px;padding:10px}
		table, td{border:2px solid powderBlue;border-collapse:collapse;text-align:center;}
		table{margin:100px auto 0px auto; width:800px}
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
		<!-- ���� �ۼ� �� -->
		<form name="form" method="POST" action="<c:url value='/review/insert' />">
			<table>
				<caption
					style="text-align: center; font-size: 24px; margin: 0 0 50px 0">���� �ۼ� �� </caption>
				<tr>
					<td>�����ȣ</td>
					<td><input type="text" style="width: 230px" name="reservationId"
						value="${reserve.reservationId}"></td>
				</tr>
				<tr>
					<td width="100px" align="center">����</td>
					<td style="padding-left:10px">
						<input type="text" style="width:600px" name="title" placeholder="���� �Է�â">
					</td>
				</tr>
				<tr>
					<td width="100" align="center">����</td>
					<td style="padding-left:50px;text-align:left">
						<input type="text" style="width:100px" name="rating" placeholder="0.0-5.0">
					</td>
				</tr>
				<tr>
					<td>�����ۼ���</td>
					<td style="padding-left:50px;text-align:left">${user.name}</td>
				</tr>
				<tr>
					<td>���ID</td>
					<td><input type="text" style="width: 230px" name="productId"
						value="${product.productId}"></td>
				</tr>
				<tr>
					<td>��Ҹ�</td>
					<td><input type="text" style="width: 230px" name="productName"
						value="${product.name}"></td>
				</tr>
				<tr>
					<td>�湮����</td>
					<td style="padding-left:50px;text-align:left">${reserve.startDate} ~ ${reserve.endDate}</td>
				</tr>
				<tr>
					<td colspan = "2">
						<textarea name="content" style="width:740px;height:400px" placeholder="���� �Է�â" cols="50" rows="10">
						</textarea>
					</td>
				</tr>
			</table><br>
			<div class = "btnBox">
				<input type="submit" value="���" class = "btn"> &nbsp;
			</div>
		</form>
	</div>
</body>
</html>