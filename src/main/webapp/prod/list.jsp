<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Product" %>
<%@page import="model.User" %>
<%@page import="java.util.*" %>
<%
	@SuppressWarnings("unchecked") 
	List<Product> prodList = (List<Product>)request.getAttribute("prodList");
	User user = (User)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>��� ����Ʈ</title>
	<style type="text/css">
		table, td{border:2px solid skyBlue;border-collapse:collapse;}
		table{margin:100px auto 0px auto;text-align:center}
		td{height:40px}
		</style>
</head>
<body>
	<form>
		<table>
			<tr>
				<td width=200>����</td>
				<td width=600>�̸� �� ��ġ</td>
				<td width=200>�ٷΰ���</td>
			</tr>
			<c:forEach var="prod" items="${prodList}">
				<tr>
					<td>�̹���</td>
					<td>
						�̸� : ${prod.name}<br>
						��ġ : ${prod.location}<br>
					</td>
					<td>
						<a href="<c:url value='/prod/detail' />">�ٷΰ���</a>
					<td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>