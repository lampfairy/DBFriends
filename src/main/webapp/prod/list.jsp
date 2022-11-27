<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.User" %>
<%@page import="model.Product" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	@SuppressWarnings("unchecked") 
	List<Product> prodList = (List<Product>)request.getAttribute("prodList");
	User user = (User)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>장소 리스트</title>
	<style type="text/css">
		table, td{border:2px solid skyBlue;border-collapse:collapse;}
		table{margin:100px auto 0px auto;text-align:center}
		td{height:40px}
		.image{height:200px}
		</style>
</head>
<body>
	<form>
		<table>
			<tr>
				<td width=200>사진</td>
				<td width=600>이름 및 위치</td>
				<td width=200>바로가기</td>
			</tr>
			<c:forEach var="prod" items="${prodList}">
				<tr>
					<td class = "image">이미지</td>
					<td>
						이름 : ${prod.name}<br>
						가격 : ${prod.price}<br>
						위치 : ${prod.location}<br>
						위치 : ${prod.location}<br>
					</td>
					<td>
						<a href = "<c:url value='/prod/detail' />">바로가기</a>
					<td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>