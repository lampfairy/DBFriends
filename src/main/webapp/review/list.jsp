<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@page import="model.Review" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>���� ����Ʈ</title>
	<style type="text/css">
		table, td{border:2px solid skyBlue;border-collapse:collapse;}
		table{margin:100px auto 0px auto;text-align:center}
		td{height:40px}
		.image{height:150px}
	</style>
</head>
<body>
	<form>
		<table>
			<tr>
				<td colspan = "3">�˻� ���</td>
			</tr>
			<tr>
				<td width=300>���</td>
				<td width=600>���� ����</td>
				<td width=200>���� ����</td>
			</tr>
			<c:forEach var="review" items="${reviewList}">
				<tr>
					<td style="text-align:left;">��Ҹ�</td>
					<td style="text-align:left;">${review.title}<td>
					<td>
						<a href = "<c:url value='/review/detail'>
							<c:param name = 'reservationId' value='${review.reservationId}' />
							</c:url>">
						���� ����</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>